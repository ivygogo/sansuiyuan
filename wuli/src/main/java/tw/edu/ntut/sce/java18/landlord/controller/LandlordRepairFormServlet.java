package tw.edu.ntut.sce.java18.landlord.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.service.impl.RepairFormServiceImpl;

/** Servlet implementation class LandlordRepairFormServlet */
@WebServlet("/LandlordRepairFormServlet.do")
public class LandlordRepairFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LandlordRepairFormServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    final Gson gson = new Gson();
    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();
    var printWriter = response.getWriter();
    List<RepairFormBean> repairFormList = new ArrayList<>();
    repairFormList = new RepairFormServiceImpl().queryAllRepairForm();

    var reparFormListJson = gson.toJson(repairFormList);
    printWriter.print(reparFormListJson);
    System.out.println(reparFormListJson);
    printWriter.flush();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8;");

    Map<String, String> errorMsgs = new HashMap<String, String>();
    request.setAttribute("ErrMsg", errorMsgs);

    String fixTimeAjax = request.getParameter("selectTimePick"); // timeConvert
    String amountAjax = request.getParameter("thePrice"); // price
    String landloadNoteAjax = request.getParameter("theNote"); // ?????????
    String formNumberAjax = request.getParameter("theformNumber");
    String formStatusAjax = request.getParameter("theformStatus"); // status

    // 0. ??????formNumber????????????
    boolean hasFormNumber = new RepairFormServiceImpl().checkMemberUidExists(formNumberAjax);
    if (hasFormNumber == false) {
      errorMsgs.put("systemErr", "?????????????????????????????????????????????");
    }
    // 1.??????FixTime

    Timestamp timeConvert = null;

    if (fixTimeAjax == null || fixTimeAjax.trim().length() == 0) {
      errorMsgs.put("fixTimeErr", "???????????????");
    } else {
      RepairFormBean repairForm =
          new RepairFormServiceImpl().getRepairFormByFormNumber(formNumberAjax);
      try {
        timeConvert = Timestamp.valueOf(fixTimeAjax);
        if (timeConvert.after(repairForm.getCreatTime())) {
          session.setAttribute("fixTimeAjax", fixTimeAjax);
        } else {
          errorMsgs.put("fixTimeErr", "????????????:?????????????????????????????????");
        }
      } catch (Exception e) {
        errorMsgs.put("fixTimeErr", "?????????????????????");
        e.printStackTrace();
      }
    }

    // 2.??????Price
    int price = -100;
    if (amountAjax == null || amountAjax.trim().length() == 0) {
      errorMsgs.put("amountErr", "???????????????");
    } else if (isInteger(amountAjax)) {
      try {
        price = Integer.parseInt(amountAjax);
      } catch (Exception ex) {
        errorMsgs.put("amountErr", "???????????????");
        ex.printStackTrace();
      }
    } else {
      errorMsgs.put("amountErr", "???????????????????????????");
    }

    // 3.????????????
    int status = -1;
    try {
      status = Integer.parseInt(formStatusAjax);

    } catch (Exception ex) {
      errorMsgs.put("statusErr", "??????????????????????????????");
    }

    // 4.????????????
    Set keySet = errorMsgs.keySet();
    Iterator it = keySet.iterator();
    ArrayList<String> errList = new ArrayList<>();
    while (it.hasNext()) {
      String key = (String) it.next();
      /*????????????????????????map?????????get??????????????????????????? ( key:01, vaule: a  key: 02,vaule: b  key:03, vaule: c)*/
      String value = errorMsgs.get(key);
      // System.out.println("key: " + key + ", vaule: " + value);
      errList.add(key);
      // System.out.println(errList.get(0));
    }

    if (!errorMsgs.isEmpty()) {
      session.setAttribute("isInvalid", true);
      // session.setAttribute("myPage", "profile");
      // System.out.println(errList.get(0));
      final Gson gson = new Gson();
      var errMsgsJson = gson.toJson(errorMsgs);
      var printWriter = response.getWriter();
      printWriter.print(errMsgsJson);
      // System.out.println(errMsgsJson);
      printWriter.flush();
      session.setAttribute("errMsgsJson", errMsgsJson);
      //      RequestDispatcher rd = request.getRequestDispatcher("/lanlordRepairForm.jsp");
      //      rd.forward(request, response);
      return;
    } else {
      session.setAttribute("isInvalid", false);
      RepairFormBean newBean = new RepairFormBean();
      newBean.setFormNumber(formNumberAjax);
      newBean.setFixTime(timeConvert);
      newBean.setAmount(price);
      newBean.setLandlordNote(landloadNoteAjax);
      newBean.setStatus(status);
      if (status == 3) {
        Timestamp newtime = new Timestamp(System.currentTimeMillis());
        newBean.setFinishTime(newtime);
      } else {
        newBean.setFinishTime(null);
      }

      try {
        int n = new RepairFormServiceImpl().updateRepairFormByLandload(newBean);
        if (n != 1) {
          errorMsgs.put("saveErr", "????????????????????????");
        }
      } catch (Exception e) {
        // System.out.println("n !!!= 1");
        e.printStackTrace();
      }

      final Gson gson = new Gson();

      RepairFormBean sendBean =
          new RepairFormServiceImpl().getRepairFormByFormNumber(formNumberAjax);
      var sendBeanJson = gson.toJson(sendBean);
      // System.out.println(sendBeanJson);
      var printWriter = response.getWriter();

      printWriter.print(sendBeanJson);

      printWriter.flush();
      // session.setAttribute("sendBean", sendBeanJson);
      // response.sendRedirect("/lanlordRepairForm.jsp");
      // RequestDispatcher rd = request.getRequestDispatcher("/lanlordRepairForm.jsp");
      // rd.forward(request, response);
      // return;
    }
  }

  public static boolean isInteger(String value) {
    Pattern pattern = Pattern.compile("^[+]?\\d+$");
    return pattern.matcher(value).matches();
  }
}
