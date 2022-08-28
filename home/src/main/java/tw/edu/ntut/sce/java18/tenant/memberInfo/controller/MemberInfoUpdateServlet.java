package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.tenant.memberInfo.service.MemberInfoService;
import tw.edu.ntut.sce.java18.tenant.memberInfo.service.impl.MemberInfoServiceImpl;

@WebServlet("/MemberInfoUpdate.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024 * 1024 * 500 * 5)
public class MemberInfoUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  MemberBean mb; // LoginOK放登入後的資料 memberInfo放修改的資料，如果沒錯誤就讓 LoginOK 會員資料 = memberInfo
  MemberInfoService ms = new MemberInfoServiceImpl();

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (!session.isNew()) {
      mb = (MemberBean) session.getAttribute("memberInfo");
    } else {
      mb = new MemberBean();
    }
    Map<String, String> errorMsgs = new HashMap<String, String>();

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    request.setAttribute("ErrMsg", errorMsgs);

    String name = "";
    int gender = 0;
    String phone = "";

    String idNumber = " ";
    String county = "";
    String district = "";
    String address = "";
    String nickname = "";
    String school = "";
    int pic = 0;
    Integer signature_1 = null;
    Integer signature_2 = null;
    Integer signature_3 = null;
    Integer favor_1 = null;
    Integer favor_2 = null;
    Integer favor_3 = null;

    int open_tag = -1;
    Timestamp update_time = null;
    String last_IP = request.getRemoteAddr();
    String signatureAll = "";
    String favorStrAll = "";
    String avatar = "";

    List<String> signatureList = new ArrayList<>();
    List<String> favorList = new ArrayList<>();
    List<String> partList = new ArrayList<>();
    boolean hadCharacter = false;
    boolean hadFavor = false;

    String maleAvatar = ms.getAllAvatarByGender(0);

    System.out.println(maleAvatar);

    String femaleAvatar = ms.getAllAvatarByGender(1);

    System.out.println(femaleAvatar);

    String otherAvatar = ms.getAllAvatarByGender(2);

    System.out.println(otherAvatar);

    session.setAttribute("maleAvatar", maleAvatar);
    session.setAttribute("femaleAvatar", femaleAvatar);
    session.setAttribute("otherAvatar", otherAvatar);
    /*
    1. String getContentType() :獲得上傳文件的MIME類型
    2. String getName() :獲得表單每個輸入項目的name屬性名

    */
    Collection<Part> parts = request.getParts();
    if (parts != null) {

      for (Part p : parts) {
        String fldName = p.getName();
        partList.add(fldName);
      }

      for (int i = 0; i < partList.size(); i++) {
        if (partList.get(i).length() > 11
            && partList.get(i).substring(0, 11).equals("myCharacter")) {

          hadCharacter = true;
        } else if (partList.get(i).length() > 7
            && partList.get(i).substring(0, 7).equals("myFavor")) {
          hadFavor = true;
        }
        // System.out.println("hadCharacter:" + hadCharacter);
        // System.out.println("hadFavor:" + hadFavor);
        System.out.println("表單名稱:" + partList.get(i));
      }

      for (Part p : parts) {
        String fldName = p.getName();

        String value = request.getParameter(fldName);
        // System.out.println("表單名稱: " + fldName);
        if (p.getContentType() == null) {

          /*===判斷頭貼===*/
          if (fldName.equals("avatarIcon")) {
            avatar = value;
            System.out.println("myAvata:" + avatar);
            // mb.setAvatar(avatar + ".png");
            if (value == null || avatar.trim().length() == 0) {
              errorMsgs.put("avatarIcon", "必須選擇頭貼");
            } else {
              pic = ms.getAvatarId(avatar + ".png");
              session.setAttribute("Avatar", avatar);
              // mb.setPic(pic);
            }
          }

          /*===判斷暱稱===*/
          else if (fldName.equals("myNickname")) {
            nickname = value;
            // mb.setNickname(nickname);
            if (nickname == null || nickname.trim().length() == 0) {
              errorMsgs.put("errNickname", "必須輸入暱稱");
            } else {
              session.setAttribute("nickname", nickname);
            }
          }

          /*===判斷姓名===*/
          else if (fldName.equals("myName")) {
            name = value;
            // mb.setName(name);
            if (name == null || name.trim().length() == 0) {
              errorMsgs.put("errName", "必須輸入大名");
            } else {
              session.setAttribute("name", name);
              // errorMsgs.put("errName", null);
            }
          }

          /*===判斷性別===*/
          else if (fldName.equals("myGender")) {
            String genderStr = value;
            if (genderStr == null || genderStr.trim().length() == 0) {
              errorMsgs.put("errGender", "必須輸入性別");
            } else {
              if (genderStr.equals("male")) {
                gender = 0;
              } else if (genderStr.equals("female")) {
                gender = 1;
              } else {
                gender = 2;
              }
              // mb.setGender(gender);
              session.setAttribute("genderStr", genderStr);
              session.setAttribute("gender", gender);
            }
          }

          /*===判斷電話===*/
          else if (fldName.equals("myPhone")) {
            phone = value.replace(" ", "");
            // mb.setPhone(phone);
            Pattern pattern = Pattern.compile("\\d{8}");
            Matcher matcher = pattern.matcher(phone.substring(2));
            if (phone == null || phone.trim().length() == 0) {
              errorMsgs.put("errPhone", "必須輸入手機電話");
            } else if (phone.length() != 10) {
              errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
            } else if (!(phone.substring(0, 2)).equals("09")) {
              errorMsgs.put("errPhone", "請輸入以「09」為開頭的手機電話");
            } else if (!matcher.matches()) {
              errorMsgs.put("errPhone", "手機電話格式後8碼錯誤"); // str.matches("[0-9]{4}-[0-9]{6}")
            } else {
              session.setAttribute("phone", phone);
            }
          }

          /*===判斷身分證號===*/
          else if (fldName.equals("myId")) {
            String errMsg = ""; // 要來接收checkIdNumber的傳回值
            int genderCode = -1;
            idNumber = value.replace(" ", "");
            // mb.setIdNumber(idNumber);
            if (gender != 2) {
              genderCode = gender + 1;
            } else {
              genderCode = Integer.parseInt(idNumber.substring(1, 2));
            }
            errMsg = ms.checkIdNumber(idNumber, genderCode);

            if (!errMsg.equals("checkOK")) {
              errorMsgs.put("errIdNumber", errMsg);
            } else {

              request.setAttribute("idNumber", idNumber);
            }
          }
          /*===判斷縣市===*/
          else if (fldName.equals("county")) {
            county = value;
            // mb.setCounty(county);
            if (county == null || county.trim().length() == 0) {
              errorMsgs.put("errCounty", "必須輸入縣市");
            } else {
              request.setAttribute("TempCounty", county);
            }
          }
          /*===判斷區域===*/
          else if (fldName.equals("district")) {
            district = value;
            // mb.setDistrict(district);
            if (district == null || district.trim().length() == 0) {
              errorMsgs.put("errDistrict", "必須輸入區域");
            } else {
              request.setAttribute("TempDistrict", district);
            }
          }
          /*===判斷地址===*/
          else if (fldName.equals("myAddress")) {
            address = value;
            // mb.setAddress(address);
            if (address == null || address.trim().length() == 0) {
              errorMsgs.put("errAaddress", "必須輸入地址");
            } else {
              request.setAttribute("address", address);
            }
          }

          /*===判斷是否開啟找室友功能===*/
          else if (fldName.equals("findRoommate")) {
            String openTagStr = value;
            // open_tag
            // mb.setName(address);
            if (openTagStr == null || openTagStr.trim().length() == 0) {
              errorMsgs.put("errOpenTag", "必須選擇是否要開啟找室友功能");
            } else {
              if (openTagStr.equals("on")) {
                open_tag = 1;
                // mb.setOpen_tag(open_tag);
                request.setAttribute("open_tag", open_tag);
                // System.out.println(open_tag);
              } else {
                open_tag = 0;
                // mb.setOpen_tag(open_tag);
                request.setAttribute("open_tag", open_tag);
              }
            }
          }
          /*===判斷學校資料===*/
          else if (fldName.equals("mySchool")) {
            school = value;
            if (school == null || school.trim().length() == 0) {
              errorMsgs.put("errSchool", "必須輸入學校");
            } else {
              request.setAttribute("school", school);
            }
          }
          /*===判斷個性標籤資料===*/
          else if (fldName.length() > 11 && fldName.substring(0, 11).equals("myCharacter")) {
            String character = value;
            signatureList.add(character);
            System.out.println("character value:" + fldName);
            if (signatureList.size() > 3) {
              errorMsgs.put("errCharacter", "ohoh~個性標籤數量上限為3個");
            }
          }
          /*===判斷室友喜好資料===*/
          else if (fldName.length() > 7 && fldName.substring(0, 7).equals("myFavor")) {
            String favor = value;
            favorList.add(favor);
            if (favorList.size() > 3) {
              errorMsgs.put("errFavor", "ohoh~室友喜好數量上限為3個");
            }
          }

        } else {
          // 如果要上傳檔案
          /*
          myId
          zipcode
          county
          district
          myAddress
          findRoommate
          school
          myCharacter
          myCharacter
          myCharacter
          myFavor
          myFavor
          myFavor
          */
        }
        // System.out.println(p);
      } // part end
    } else {
      // errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
    }

    if (open_tag == 1 && hadCharacter == false) {
      errorMsgs.put("errCharacter", "您已啟用找室友功能，請輸入個性標籤，讓合租夥伴更了解你/妳");
    } else if (open_tag == 1 && hadFavor == false) {
      errorMsgs.put("errFavor", "您已啟用找室友功能，請輸入室友喜好，讓合租夥伴更了解你/妳");
    }

    /*組成個性標籤和室友喜好的HTML*/
    if (signatureList.size() == 0) {
      signatureList.add("無");
    }
    if (favorList.size() == 0) {
      favorList.add("無");
    }

    System.out.println("signatureList.size()" + signatureList.size());
    String characterTabs = "";
    if (signatureList.size() == 1) {
      characterTabs += signatureList.get(0) + "、";
      if (signatureList.get(0).equals("無")) {
        signature_1 = null;
        signature_2 = null;
        signature_3 = null;
      } else {
        signature_1 = ms.getSignatureId(signatureList.get(0));
        signature_2 = null;
        signature_3 = null;
      }

    } else if (signatureList.size() == 2) {
      characterTabs += signatureList.get(0) + "、" + signatureList.get(1) + "、";
      signature_1 = ms.getSignatureId(signatureList.get(0));
      signature_2 = ms.getSignatureId(signatureList.get(1));
      signature_3 = null;

    } else if (signatureList.size() == 3) {
      characterTabs +=
          signatureList.get(0) + "、" + signatureList.get(1) + "、" + signatureList.get(2) + "、";
      signature_1 = ms.getSignatureId(signatureList.get(0));
      signature_2 = ms.getSignatureId(signatureList.get(1));
      signature_3 = ms.getSignatureId(signatureList.get(2));
    } else if (signatureList.size() > 3) {
      for (int i = 0; i < signatureList.size(); i++) {
        characterTabs += signatureList.get(i);
        characterTabs += "、";
      }
    }
    // mb.setSignatureAll(characterTabs);

    String favorTabs = "";
    if (favorList.size() == 1) {
      favorTabs += favorList.get(0) + "、";
      if (favorList.get(0).equals("無")) {
        favor_1 = null;
        favor_2 = null;
        favor_3 = null;
      } else {
        favor_1 = ms.getFavorId(favorList.get(0));
        favor_2 = null;
        favor_3 = null;
      }
    } else if (favorList.size() == 2) {
      favorTabs += favorList.get(0) + "、" + favorList.get(1) + "、";
      favor_1 = ms.getFavorId(favorList.get(0));
      favor_2 = ms.getFavorId(favorList.get(1));
      favor_3 = null;
    } else if (favorList.size() == 3) {
      favorTabs += favorList.get(0) + "、" + favorList.get(1) + "、" + favorList.get(2) + "、";
      favor_1 = ms.getFavorId(favorList.get(0));
      favor_2 = ms.getFavorId(favorList.get(1));
      favor_3 = ms.getFavorId(favorList.get(2));
    } else if (favorList.size() > 3) {
      for (int i = 0; i < favorList.size(); i++) {
        favorTabs += favorList.get(i);
        favorTabs += "、";
      }
    }
    // mb.setFavorStrAll(favorTabs);
    // System.out.println("個性標籤characterTabs" + characterTabs);
    System.out.println("個性標籤favorList" + favorTabs);
    signatureAll = characterTabs.substring(0, (characterTabs.length() - 1));
    String ansCharacter = ms.getCharacterTempTag(signatureAll);

    favorStrAll = favorTabs.substring(0, (favorTabs.length() - 1));
    String ansFavor = ms.getFavorTempTag(favorStrAll);

    session.setAttribute("ansCharacter", ansCharacter);
    session.setAttribute("ansFavor", ansFavor);
    // signatureList.removeAll(signatureList);
    // signatureList.removeAll(signatureList);

    /*組成找室友的HTML*/
    String ansRoommate = ms.getFindRoommateTempTag(open_tag);
    session.setAttribute("ansRoommate", ansRoommate);

    /*組成性別的HTML*/
    String ansGender = ms.getGenderTempTag(gender);
    session.setAttribute("ansGender", ansGender);

    /*組成avatar的HTML*/
    String ansAvatar = ms.getFindAvatarTempTag(avatar, gender);
    session.setAttribute("ansAvatar", ansAvatar);
    /*===確認errorMsgs是否為空值===*/
    Set keySet = errorMsgs.keySet();
    Iterator it = keySet.iterator();
    ArrayList<String> errList = new ArrayList<>();
    while (it.hasNext()) {
      String key = (String) it.next();
      /*有了鍵就可以通過map集合的get方法獲取其對應的値 ( key:01, vaule: a  key: 02,vaule: b  key:03, vaule: c)*/
      String value = errorMsgs.get(key);
      // System.out.println("key: " + key + ", vaule: " + value);
      if (value != null) {
        errList.add(key);
        // System.out.println(errList.get(0));
      }
    }

    if (!errList.isEmpty()) {
      session.setAttribute("myPage", "myinfo");
      request.setAttribute("isInvalid", true);
      // System.out.println(errList.get(0));
      RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
      rd.forward(request, response);
      return;
    } else {
      // System.out.println("errorMsgs.isEmpty()");
      session.setAttribute("isInvalid", false);
      MemberBean oldBean = (MemberBean) session.getAttribute("LoginOK");
      MemberBean newBean = new MemberBean();
      newBean.setuId(oldBean.getuId());
      newBean.setName(name);
      newBean.setGender(gender);
      newBean.setPhone(phone);
      newBean.setIdNumber(idNumber);
      newBean.setMail(oldBean.getMail());
      newBean.setCounty(county);
      newBean.setDistrict(district);
      newBean.setAddress(address);
      newBean.setNickname(nickname);
      newBean.setState(oldBean.getState());
      newBean.setSchool(school);
      newBean.setPic(pic);
      newBean.setSignature_1(signature_1);
      newBean.setSignature_2(signature_2);
      newBean.setSignature_3(signature_3);
      newBean.setFavor_1(favor_1);
      System.out.println(favor_1);
      newBean.setFavor_2(favor_2);
      newBean.setFavor_3(favor_3);
      newBean.setOpen_tag(open_tag);
      newBean.setSignatureAll(signatureAll);
      newBean.setFavorStrAll(favorStrAll);
      newBean.setAvatar(avatar + ".png");
      newBean.setLevel(oldBean.getLevel());
      newBean.setLast_IP(last_IP);
      SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String datetime = sdFormat.format(new Date());
      update_time = Timestamp.valueOf(datetime);
      newBean.setUpdate_time(update_time);
      newBean.setContract(oldBean.getContract());
      newBean.setGuarantorList(oldBean.getGuarantorList());
      ms.updateMemberInfo(newBean);
      session.setAttribute("myPage", "myinfo");
      session.setAttribute("memberInfo", newBean);
      session.setAttribute("LoginOK", newBean);
      response.sendRedirect("/home/MemberInfo.do");
      // RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
      // rd.forward(request, response);
      return;
    }
  } // doPost end
}
