package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
import tw.edu.ntut.sce.java18.common.model.GuarantorBean;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.tenant.memberInfo.dao.impl.GuarantorDaoImpl;
import tw.edu.ntut.sce.java18.tenant.memberInfo.utils.CheckIdNumberFormat;

/** Servlet implementation class MemberContractInfoUpdate */
@WebServlet("/MemberContractInfoUpdate.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024L * 1024 * 500 * 5)
public class MemberContractInfoUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    MemberBean mb; // LoginOK放登入後的資料 memberInfo放修改的資料，如果沒錯誤就讓 LoginOK 會員資料 = memberInfo

    HttpSession session = request.getSession();

    boolean guarantorIsExist = false;
    GuarantorBean guarantor = new GuarantorBean();
    GuarantorDaoImpl guarantorDao = new GuarantorDaoImpl();

    ArrayList<String> partList = new ArrayList<>();
    Map<String, String> errorMsgs = new HashMap<String, String>();

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    request.setAttribute("ErrMsg", errorMsgs);

    if (!session.isNew()) {
      mb = (MemberBean) session.getAttribute("memberInfo");

    } else {
      mb = new MemberBean();
    }

    GuarantorBean oldbean = guarantorDao.queryGuarantorByPrimaryKey(mb.getuId());
    guarantorIsExist = guarantorDao.checkGuarantorIdExists(mb.getuId());

    if (!guarantorIsExist) {
      guarantor.setMember_id(mb.getuId());
    }

    try {
      Collection<Part> parts = request.getParts();

      if (parts != null) {

        /*for (Part p : parts) {
          String fldName = p.getName();
          partList.add(fldName);
        }

        for (int i = 0; i < partList.size(); i++) {
          System.out.println("表單名稱:" + partList.get(i));
        }*/

        for (Part p : parts) {
          String fldName = p.getName();

          String value = request.getParameter(fldName);
          if (p.getContentType() == null) {
            if (fldName.equals("guarantorName")) {
              String guarantorName = value;
              guarantor.setName(guarantorName);
              if (guarantorName == null || guarantorName.trim().length() == 0) {
                errorMsgs.put("errGuarantorName", "必須輸入大名");
              } else {
                request.setAttribute("guarantorName", guarantorName);
                // errorMsgs.put("errName", null);
              }
            }
            //
            else if (fldName.equals("guarantorRelation")) {
              String guarantorRelation = value;
              guarantor.setRelation(guarantorRelation);
              if (guarantorRelation == null || guarantorRelation.trim().length() == 0) {
                errorMsgs.put("errGuarantorRelation", "必須輸入關係");
              } else {
                request.setAttribute("guarantorRelation", guarantorRelation);
                // errorMsgs.put("errName", null);
              }
            }

            //
            else if (fldName.equals("guarantorIdNumber")) {
              String errMsg = ""; // 要來接收checkIdNumber的傳回值
              String idNumber = value;
              idNumber = value.replaceAll("\\s* ", "");
              guarantor.setId_number(idNumber);
              int genderCode = -1;
              if (idNumber.length() < 10) {
                errMsg = "身分證應該為10碼 #outside2";
              } else {
                genderCode = Integer.parseInt(idNumber.substring(1, 2));
                if (genderCode != 1 && genderCode != 2) {
                  errMsg = "身分證號性別碼不正確 #outside";
                  System.out.println("身分證號性別碼 genderCode" + genderCode);
                } else {
                  CheckIdNumberFormat checkIdNumberFormate = new CheckIdNumberFormat();
                  errMsg = checkIdNumberFormate.checkIdNumber(idNumber, genderCode);
                }
              }

              if (errMsg == null) {
                errorMsgs.put("errIdNumber", errMsg);
              } else {
                request.setAttribute("guarantorIdNumber", idNumber);
              }

            }
            //
            else if (fldName.equals("guarantorPhone")) {
              Pattern pattern;
              Matcher matcher;
              String phone = value;
              phone = value.replace(" ", "");
              if (phone.length() != 10) {
                errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
              } else {
                pattern = Pattern.compile("\\d{8}");
                matcher = pattern.matcher(phone.substring(2));
                if (!matcher.matches()) {
                  errorMsgs.put("errPhone", "手機電話格式後8碼錯誤"); // str.matches("[0-9]{4}-[0-9]{6}")
                }
              }
              guarantor.setPhone(phone);

              if (phone.trim().length() == 0) {
                errorMsgs.put("errPhone", "必須輸入手機電話");
              } else if (phone.length() != 10) {
                errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
              } else if (!phone.startsWith("09")) {
                errorMsgs.put("errPhone", "請輸入以「09」為開頭的手機電話");
              } else {
                request.setAttribute("guarantorPhone", phone);
              }
            }
            //
            else if (fldName.equals("county2")) {
              String county = value;
              guarantor.setCounty(county);
              if (county == null || county.trim().length() == 0) {
                errorMsgs.put("errCounty", "必須輸入縣市");
              } else {
                request.setAttribute("TempCounty2", county);
              }

            }

            //
            else if (fldName.equals("district2")) {
              String district = value;
              guarantor.setDistrict(district);
              if (district == null || district.trim().length() == 0) {
                errorMsgs.put("errDistrict", "必須輸入區域");
              } else {
                request.setAttribute("TempDistrict2", district);
              }
            }

            //
            else if (fldName.equals("guarantorAddress")) {
              String address = value;
              guarantor.setAddress(address);
              if (address == null || address.trim().length() == 0) {
                errorMsgs.put("errAddress", "必須輸入地址");
              } else {
                request.setAttribute("guarantorAddress", address);
              }
            }
          }
        }
      } else {
        errorMsgs.put("errForm", "您尚未輸入任何資料");
      }

      /*===確認errorMsgs是否為空值===*/
      Set keySet = errorMsgs.keySet();
      Iterator it = keySet.iterator();
      ArrayList<String> errList = new ArrayList<>();
      while (it.hasNext()) {
        String key = (String) it.next();
        /*有了鍵就可以通過map集合的get方法獲取其對應的値 ( key:01, vaule: a  key: 02,vaule: b  key:03, vaule: c)*/
        String value = errorMsgs.get(key);
        // System.out.println("key: " + key + ", vaule: " + value);
        errList.add(key);
        // System.out.println(errList.get(0));
      }

      if (!errList.isEmpty()) {
        request.setAttribute("guarantorIsInvalid", true);
        session.setAttribute("myPage", "profile");
        // System.out.println(errList.get(0));
        RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
        rd.forward(request, response);
        return;
      } else {
        session.setAttribute("guarantorIsInvalid", false);
        if (guarantorIsExist == false) {
          System.out.println("儲存資料");
          GuarantorBean newBean = new GuarantorBean();
          newBean.setMember_id(mb.getuId());
          newBean.setName(guarantor.getName());
          newBean.setId_number(guarantor.getId_number());
          newBean.setPhone(guarantor.getPhone());
          newBean.setCounty(guarantor.getCounty());
          newBean.setDistrict(guarantor.getDistrict());
          newBean.setAddress(guarantor.getAddress());
          newBean.setRelation(guarantor.getRelation());
          //          SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          //          String datetime = sdFormat.format(new Date());
          //          Timestamp newtime = Timestamp.valueOf(datetime);
          Timestamp newtime = new Timestamp(System.currentTimeMillis());
          newBean.setCreate_time(newtime);
          newBean.setUpdate_time(newtime);
          guarantorDao.saveGuarantor(newBean); // save

          mb.setGuarantor(newBean);
          session.setAttribute("myPage", "profile");
          response.sendRedirect("/home/MemberInfo.do");

        } else if (guarantorIsExist == true) {
          GuarantorBean newBean = new GuarantorBean();

          newBean.setId(oldbean.getId());
          newBean.setMember_id(mb.getuId());
          newBean.setName(guarantor.getName());
          newBean.setId_number(guarantor.getId_number());
          newBean.setPhone(guarantor.getPhone());
          newBean.setCounty(guarantor.getCounty());
          newBean.setDistrict(guarantor.getDistrict());
          newBean.setAddress(guarantor.getAddress());
          newBean.setRelation(guarantor.getRelation());

          // SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          // String datetime = sdFormat.format(new Date());
          // Timestamp newtime = Timestamp.valueOf(datetime);
          Timestamp newtime = new Timestamp(System.currentTimeMillis());
          newBean.setCreate_time(newtime);
          newBean.setUpdate_time(newtime);
          guarantorDao.updateGuarantorInfo(newBean);
          mb.setGuarantor(newBean);
          session.setAttribute("myPage", "profile");
          response.sendRedirect("/home/MemberInfo.do");
        }
        // response.sendRedirect("/home/MemberInfo.do");
      }

    } catch (Exception e) {
      e.printStackTrace();
      errorMsgs.put("errDBMessage", e.getMessage());
      RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
      rd.forward(request, response);
      return;
    }

    // session.setAttribute("myPage", "profile");
  }
}
