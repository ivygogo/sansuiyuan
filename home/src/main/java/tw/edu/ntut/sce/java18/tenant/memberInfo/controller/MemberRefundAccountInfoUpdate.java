package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import tw.edu.ntut.sce.java18.common.dao.impl.RefundAccountDaoImpl;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.model.RefundAccountBean;

/** Servlet implementation class MemberContractInfoUpdate */
@WebServlet("/MemberRefundAccountUpdate.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024L * 1024 * 500 * 5)
public class MemberRefundAccountInfoUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  MemberBean mb; // LoginOK放登入後的資料 memberInfo放修改的資料，如果沒錯誤就讓 LoginOK 會員資料 = memberInfo

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();

    boolean refundAccountIsExist = false;
    RefundAccountBean refundAccount = new RefundAccountBean();
    RefundAccountDaoImpl refundAccountDao = new RefundAccountDaoImpl();

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

    RefundAccountBean oldbean = mb.getRefundAccount();
    refundAccountIsExist = refundAccountDao.checkRefundAccountIdExistsByMemberId(mb.getuId());

    if (refundAccountIsExist == false) {
      refundAccount.setMember_id(mb.getuId());
    }
    try {
      Collection<Part> parts = request.getParts();

      if (parts != null) {

        for (Part p : parts) {
          String fldName = p.getName();
          partList.add(fldName);
        }

        for (int i = 0; i < partList.size(); i++) {
          System.out.println("表單名稱:" + partList.get(i));
        }

        for (Part p : parts) {
          String fldName = p.getName();

          String value = request.getParameter(fldName);
          if (p.getContentType() == null) {

            if (fldName.equals("refundBank")) {
              String refundBank = value;
              refundAccount.setRefundBank(refundBank);
              if (refundBank == null || refundBank.trim().length() == 0) {
                errorMsgs.put("errRefundBank", "必須輸銀行名稱");
              } else {
                session.setAttribute("RefundBank", refundBank);
              }
            }

            //
            else if (fldName.equals("refundBankstore")) {
              String refundBankstore = value;
              refundAccount.setBankStore(refundBankstore);
              if (refundBankstore == null || refundBankstore.trim().length() == 0) {
                errorMsgs.put("errRefundBankstore", "必須輸入關係");
              } else {
                session.setAttribute("RefundBankstore", refundBankstore);
                // errorMsgs.put("errName", null);
              }
            }

            //
            else if (fldName.equals("refundName")) {
              String refundName = value;
              refundAccount.setRefundName(refundName);
              if (refundName == null || refundName.trim().length() == 0) {
                errorMsgs.put("errRefundName", "必須輸入關係");
              } else {
                session.setAttribute("RefundName", refundName);
                // errorMsgs.put("errName", null);
              }

            }
            //
            else if (fldName.equals("bankAccount")) {
              String bankAccount = value;
              refundAccount.setBankAccount(bankAccount);

              boolean isNumeric = bankAccount.matches("[0-9]*");
              System.out.println(isNumeric);
              if (bankAccount == null || bankAccount.trim().length() == 0) {
                errorMsgs.put("errBankAccount", "必須輸入銀行帳戶");
              } else if (isNumeric == false) {
                errorMsgs.put("errBankAccount", "銀行帳戶格式錯誤");
              } else {
                session.setAttribute("BankAccount", bankAccount);
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
        request.setAttribute("RefundIsInvalid", true);
        session.setAttribute("myPage", "profile");
        // System.out.println(errList.get(0));
        RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
        rd.forward(request, response);
        return;
      } else {
        session.setAttribute("RefundIsInvalid", false);
        if (refundAccountIsExist == false) {
          System.out.println("儲存資料");
          RefundAccountBean newBean = new RefundAccountBean();
          newBean.setMember_id(mb.getuId());
          newBean.setRefundBank(refundAccount.getRefundBank());
          newBean.setBankStore(refundAccount.getBankStore());
          newBean.setRefundName(refundAccount.getRefundName());
          newBean.setBankAccount(refundAccount.getBankAccount());
          Timestamp newtime = new Timestamp(System.currentTimeMillis());
          newBean.setCreate_time(newtime);
          newBean.setUpdate_time(newtime);
          refundAccountDao.saveRefundAccount(newBean); // save
          mb.setRefundAccount(newBean); // -------------------------->
          session.setAttribute("myPage", "profile");
          response.sendRedirect("/home/MemberInfo.do");

        } else if (refundAccountIsExist == true) {
          RefundAccountBean newBean = new RefundAccountBean();

          newBean.setId(oldbean.getId());
          newBean.setMember_id(mb.getuId());
          newBean.setRefundBank(refundAccount.getRefundBank());
          newBean.setBankStore(refundAccount.getBankStore());
          newBean.setRefundName(refundAccount.getRefundName());
          newBean.setBankAccount(refundAccount.getBankAccount());
          Timestamp newtime = new Timestamp(System.currentTimeMillis());
          newBean.setUpdate_time(newtime);
          refundAccountDao.updateRefundAccount(newBean);

          session.setAttribute("myPage", "profile");
          mb.setRefundAccount(newBean); // -------------------------->

          session.setAttribute("myPage", "profile");
          response.sendRedirect("/home/MemberInfo.do");
        }
        // response.sendRedirect("/home/MemberInfo.do");
      }

    } catch (Exception e) {
      e.printStackTrace();
      errorMsgs.put("errDBMessage", e.getMessage());
      RequestDispatcher rd = request.getRequestDispatcher("/MemberInfo.do");
      rd.forward(request, response);
    }

    // session.setAttribute("myPage", "profile");
  }
}
