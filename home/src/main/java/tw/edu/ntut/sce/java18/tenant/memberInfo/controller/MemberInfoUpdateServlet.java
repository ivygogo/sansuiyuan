package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
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
import tw.edu.ntut.sce.java18.common.service.MemberInfoService;
import tw.edu.ntut.sce.java18.common.service.impl.MemberInfoServiceImpl;

/** 會員資料儲存與驗證會使用到此程式 LoginOK放登入後的資料 memberInfo放修改的資料，如果沒錯誤就讓 LoginOK 會員資料 = memberInfo */
@WebServlet("/MemberInfoUpdate.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024L * 1024 * 500 * 5) // 注意SIZE必須為LONG型態
public class MemberInfoUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 1. 宣告MemberBean欄位，供表單存值使用
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

    // 2. 需要判斷用戶是否有填寫 個性標籤 和 室友喜好 ()，沒填寫payload是空值
    boolean hadCharacter = false;
    boolean hadFavor = false;

    MemberBean member;
    MemberInfoService ms = new MemberInfoServiceImpl();

    // 3.宣告錯誤訊息變數
    Map<String, String> errorMsgs = new HashMap<String, String>();
    request.setAttribute("ErrMsg", errorMsgs);

    HttpSession session = request.getSession();
    if (!session.isNew()) {
      member = (MemberBean) session.getAttribute("memberInfo");
    } else {
      member = new MemberBean();
    }

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    // 4.讀出各性別的圖片檔名供<Valid>驗證頁面使用
    String maleAvatar = ms.getAllAvatarByGender(0);
    String femaleAvatar = ms.getAllAvatarByGender(1);
    String otherAvatar = ms.getAllAvatarByGender(2);
    session.setAttribute("maleAvatar", maleAvatar);
    session.setAttribute("femaleAvatar", femaleAvatar);
    session.setAttribute("otherAvatar", otherAvatar);

    // 5.  關於Part有以下兩個方法
    // 5.1 String getContentType() :獲得上傳文件的MIME類型
    // 5.2 String getName() :獲得表單每個輸入項目的name屬性名

    // 6. 確認用戶是否有填寫個性標籤和室友喜好，以利後續欄位判斷後秀出正確的checkbox
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
        System.out.println("hadCharacter:" + hadCharacter);
        System.out.println("hadFavor:" + hadFavor);
        // System.out.println("表單名稱:" + partList.get(i));
      }
    }

    // =================================================================//
    // 7.開始執行表單資料判斷
    for (Part p : parts) {
      String fldName = p.getName();
      String value = request.getParameter(fldName);
      if (p.getContentType() == null) {

        // ======判斷頭貼======
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

        // ======判斷暱稱======
        else if (fldName.equals("myNickname")) {
          nickname = value;
          // mb.setNickname(nickname);
          if (nickname == null || nickname.trim().length() == 0) {
            errorMsgs.put("errNickname", "必須輸入暱稱");
          } else {
            session.setAttribute("nickname", nickname);
          }
        }

        // ======判斷姓名======
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

        // ======判斷性別======
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

        // ======判斷電話======
        else if (fldName.equals("myPhone")) {
          phone = value.replaceAll("\\s*", "");
          // mb.setPhone(phone);
          Pattern pattern = Pattern.compile("\\d{8}");
          Matcher matcher = pattern.matcher(phone.substring(2));
          if (phone == null || phone.trim().length() == 0) {
            errorMsgs.put("errPhone", "必須輸入手機電話");
          } else if (phone.length() != 10) {
            errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
          } else if (!phone.startsWith("09")) {
            errorMsgs.put("errPhone", "請輸入以「09」為開頭的手機電話");
          } else if (!matcher.matches()) {
            errorMsgs.put("errPhone", "手機電話格式後8碼錯誤"); // str.matches("[0-9]{4}-[0-9]{6}")
          } else {
            session.setAttribute("phone", phone);
          }
        }

        // ======判斷身分證號=======
        else if (fldName.equals("myId")) {
          String errMsg = ""; // 要來接收checkIdNumber的傳回值
          int genderCode = -1;
          idNumber = value.replace("\\s*", "");
          // mb.setIdNumber(idNumber);
          if (gender != 2) {
            genderCode = gender + 1;
          } else {
            genderCode = Integer.parseInt(idNumber.substring(1, 2));
          }
          errMsg = ms.checkIdNumber(idNumber, genderCode);

          if (errMsg != null) {
            errorMsgs.put("errIdNumber", errMsg);
          } else {

            request.setAttribute("idNumber", idNumber);
          }
        }
        // ======判斷縣市======
        else if (fldName.equals("county")) {
          county = value;
          // mb.setCounty(county);
          if (county == null || county.trim().length() == 0) {
            errorMsgs.put("errCounty", "必須輸入縣市");
          } else {
            request.setAttribute("TempCounty", county);
          }
        }
        // ======判斷區域======
        else if (fldName.equals("district")) {
          district = value;
          // mb.setDistrict(district);
          if (district == null || district.trim().length() == 0) {
            errorMsgs.put("errDistrict", "必須輸入區域");
          } else {
            request.setAttribute("TempDistrict", district);
          }
        }
        // ======判斷地址======
        else if (fldName.equals("myAddress")) {
          address = value;
          // mb.setAddress(address);
          if (address == null || address.trim().length() == 0) {
            errorMsgs.put("errAddress", "必須輸入地址");
          } else {
            request.setAttribute("address", address);
          }
        }

        // ======判斷是否開啟找室友功能======
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
        // ======判斷學校資料======
        else if (fldName.equals("mySchool")) {
          school = value;
          if (school == null || school.trim().length() == 0) {
            errorMsgs.put("errSchool", "必須輸入學校");
          } else {
            request.setAttribute("school", school);
          }
        }
        // ======判斷個性標籤資料，如果有資料就將資料寫入暫存變數======
        else if (fldName.length() > 11 && fldName.substring(0, 11).equals("myCharacter")) {
          String character = value;
          signatureList.add(character);
          System.out.println("character value:" + fldName);
          if (signatureList.size() > 3) {
            errorMsgs.put("errCharacter", "ohoh~個性標籤數量上限為3個");
          }
        }
        // ======判斷室友喜好資料，如果有資料就將資料寫入暫存變數======
        else if (fldName.length() > 7 && fldName.substring(0, 7).equals("myFavor")) {
          String favor = value;
          favorList.add(favor);
          if (favorList.size() > 3) {
            errorMsgs.put("errFavor", "ohoh~室友喜好數量上限為3個");
          }
        }
      } else {
        // errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
      }
    }

    // ======判斷找室友功能是否開啟，如果開啟就必須填寫個性標籤和室友喜好======
    if (open_tag == 1 && hadCharacter == false) {
      errorMsgs.put("errCharacter", "您已啟用找室友功能，請輸入個性標籤，讓合租夥伴更了解你/妳");
    } else if (open_tag == 1 && hadFavor == false) {
      errorMsgs.put("errFavor", "您已啟用找室友功能，請輸入室友喜好，讓合租夥伴更了解你/妳");
    }

    // ======組成個性標籤和室友喜好的HTML======
    // 1.如果個性標籤和室友喜好為空值
    // System.out.println("signatureList.size()" + signatureList.size());
    if (signatureList.size() == 0) {
      signatureList.add("無");
    }
    if (favorList.size() == 0) {
      favorList.add("無");
    }

    // 1.如果個性標籤有一個值，需要判斷是不是"無"
    String characterTabs = "";
    if (signatureList.size() == 1) {
      characterTabs += signatureList.get(0) + "、";
      if (signatureList.get(0).equals("無")) {
        signature_1 = null;
        signature_2 = null;
        signature_3 = null;
      } else {
        // signature_1 = getSignatureId(signatureList.get(0));
        signature_1 = ms.getCharacterOrFavorIdByNameAndType(signatureList.get(0), 1);
        signature_2 = null;
        signature_3 = null;
      }
    }

    // 2.如果個性標籤有2個值
    else if (signatureList.size() == 2) {
      characterTabs += signatureList.get(0) + "、" + signatureList.get(1) + "、";
      // signature_1 = ms.getSignatureId(signatureList.get(0));
      // signature_2 = ms.getSignatureId(signatureList.get(1));
      signature_1 = ms.getCharacterOrFavorIdByNameAndType(signatureList.get(0), 1);
      signature_2 = ms.getCharacterOrFavorIdByNameAndType(signatureList.get(1), 1);
      signature_3 = null;
    }

    // 3.如果個性標籤有3個值
    else if (signatureList.size() == 3) {
      characterTabs +=
          signatureList.get(0) + "、" + signatureList.get(1) + "、" + signatureList.get(2) + "、";
      //      signature_1 = ms.getSignatureId(signatureList.get(0));
      //      signature_2 = ms.getSignatureId(signatureList.get(1));
      //      signature_3 = ms.getSignatureId(signatureList.get(2));
      signature_1 = ms.getCharacterOrFavorIdByNameAndType(signatureList.get(0), 1);
      signature_2 = ms.getCharacterOrFavorIdByNameAndType(signatureList.get(1), 1);
      signature_3 = ms.getCharacterOrFavorIdByNameAndType(signatureList.get(2), 1);
    }

    // 3.如果個性標籤超過3個值
    else if (signatureList.size() > 3) {
      for (int i = 0; i < signatureList.size(); i++) {
        characterTabs += signatureList.get(i);
        characterTabs += "、";
      }
    }
    // System.out.println("個性標籤favorList" + characterTabs);

    // 4.如果室友喜好有一個值，需要判斷是不是"無"
    String favorTabs = "";
    if (favorList.size() == 1) {
      favorTabs += favorList.get(0) + "、";
      if (favorList.get(0).equals("無")) {
        favor_1 = null;
        favor_2 = null;
        favor_3 = null;
      } else {
        favor_1 = ms.getCharacterOrFavorIdByNameAndType(favorList.get(0), 2);
        favor_2 = null;
        favor_3 = null;
      }
    }
    // 5.如果室友喜好有2個值，需要判斷是不是"無"
    else if (favorList.size() == 2) {
      favorTabs += favorList.get(0) + "、" + favorList.get(1) + "、";
      favor_1 = ms.getCharacterOrFavorIdByNameAndType(favorList.get(0), 2);
      favor_2 = ms.getCharacterOrFavorIdByNameAndType(favorList.get(1), 2);
      favor_3 = null;
    }
    // 6.如果室友喜好有3個值，需要判斷是不是"無"
    else if (favorList.size() == 3) {
      favorTabs += favorList.get(0) + "、" + favorList.get(1) + "、" + favorList.get(2) + "、";
      favor_1 = ms.getCharacterOrFavorIdByNameAndType(favorList.get(0), 2);
      favor_2 = ms.getCharacterOrFavorIdByNameAndType(favorList.get(1), 2);
      favor_3 = ms.getCharacterOrFavorIdByNameAndType(favorList.get(2), 2);
    }
    // 7.如果室友喜好超過3個值
    else if (favorList.size() > 3) {
      for (int i = 0; i < favorList.size(); i++) {
        favorTabs += favorList.get(i);
        favorTabs += "、";
      }
    }
    // System.out.println("個性標籤characterTabs" + characterTabs);
    // System.out.println("個性標籤favorList" + favorTabs);

    // 因為之前組出來的characterTabs最後一個字元是"、"，所以這裡需再擷取為signatureAll
    // 然後放到getCharacterTempTag來產生HTML的tag
    signatureAll = characterTabs.substring(0, (characterTabs.length() - 1));
    String ansCharacter = ms.getCharacterTempTag(signatureAll);
    session.setAttribute("ansCharacter", ansCharacter);

    // 因為之前組出來的favorTabs最後一個字元是"、"，所以這裡需再擷取為favorStrAll
    // 然後放到getFavorTempTag來產生HTML的tag
    favorStrAll = favorTabs.substring(0, (favorTabs.length() - 1));
    String ansFavor = ms.getFavorTempTag(favorStrAll);
    session.setAttribute("ansFavor", ansFavor);

    // ======組成找室友的HTML======
    String ansRoommate = ms.getFindRoommateTempTag(open_tag);
    session.setAttribute("ansRoommate", ansRoommate);

    // ======組成性別的HTML======
    String ansGender = ms.getGenderTempTag(gender);
    session.setAttribute("ansGender", ansGender);

    // ====== 組成avatar的HTML======
    String ansAvatar = ms.getFindAvatarTempTag(avatar, gender);
    session.setAttribute("ansAvatar", ansAvatar);

    // ======確認errorMsgs是否為空值======
    Set keySet = errorMsgs.keySet();
    Iterator it = keySet.iterator();
    ArrayList<String> errList = new ArrayList<>();
    while (it.hasNext()) {
      String key = (String) it.next();
      // 有了鍵就可以通過map集合的get方法獲取其對應的値 ( key:01, vaule: a  key: 02,vaule: b  key:03, vaule: c)
      String value = errorMsgs.get(key);
      // System.out.println("key: " + key + ", vaule: " + value);
      errList.add(key);
      // System.out.println(errList.get(0));
    }

    // ======如果有錯誤訊息，就導回valid頁面(透過isInvalid變數控制)======
    if (!errList.isEmpty()) {
      session.setAttribute("myPage", "myinfo");
      request.setAttribute("isInvalid", true);
      // System.out.println(errList.get(0));
      RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
      rd.forward(request, response);
      return;
    }
    // ======如果有正確，就導回show頁面(透過isInvalid變數控制)======
    else {
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
      // System.out.println(favor_1);
      newBean.setFavor_2(favor_2);
      newBean.setFavor_3(favor_3);
      newBean.setOpen_tag(open_tag);
      newBean.setSignatureAll(signatureAll);
      newBean.setFavorStrAll(favorStrAll);
      newBean.setAvatar(avatar + ".png");
      newBean.setLevel(oldBean.getLevel());
      newBean.setLast_IP(last_IP);
      // SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      // String datetime = sdFormat.format(new Date());
      // update_time = Timestamp.valueOf(datetime);
      update_time = new Timestamp(System.currentTimeMillis());
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
