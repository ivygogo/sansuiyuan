package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_jdbc;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormServiceBean;
import tw.edu.ntut.sce.java18.common.service.impl.FurniturePriceServiceImpl;
import tw.edu.ntut.sce.java18.common.service.impl.RepairFormServiceImpl;
import tw.edu.ntut.sce.java18.common.service.impl.TenantServiceImpl;

@WebServlet("/common/RepairForm.do")
public class RepairFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int memberId = 1;
    final Gson gson = new Gson();
    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();

    String job = request.getParameter("doJob");
    var printWriter = response.getWriter();
    String roomNumber = new TenantServiceImpl().getRoomNumberByMemberId(memberId);

    switch (job) {
      case "repairFormInfo":
        List<RepairFormServiceBean> repairFormList =
            new RepairFormServiceImpl().getReparFormConverListByApplicant(memberId);

        var showPageInfo = Map.of("roomNumber", roomNumber, "repairFormList", repairFormList);

        var reparFormListJson = gson.toJson(showPageInfo);
        printWriter.print(reparFormListJson);
        printWriter.flush();
        break;

      case "getProject":
        List<String> furnitureNameList = new FurniturePriceServiceImpl().getAllFurnitureName();
        MemberBean member = new MemberDaoImpl_jdbc().queryMemberByPrimaryKey(memberId);
        String phone = member.getPhone();
        String name = member.getName();
        var insertPageInfo =
            Map.of(
                "furnitureList",
                furnitureNameList,
                "memberPhone",
                phone,
                "memberName",
                name,
                "roomNumber",
                roomNumber);
        session.setAttribute("member", member);
        session.setAttribute("roomNumber", roomNumber);
        var insertPageInfoJson = gson.toJson(insertPageInfo);
        // System.out.println(insertPageInfoJson);
        printWriter.print(insertPageInfoJson);
        printWriter.flush();
        break;

      default:
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8;");

    Map<String, String> errorMsgs = new HashMap<String, String>();
    request.setAttribute("ErrMsg", errorMsgs);
    MemberBean menber = (MemberBean) session.getAttribute("member");

    String job = (String) session.getAttribute("page");
    String formNumber = request.getParameter("RepairFormNumber"); // 需要判斷是不是新增
    String roomNumber =
        new TenantServiceImpl().getRoomNumberByMemberId(menber.getuId()); // 不用判斷，用member id取出

    String applicant = request.getParameter("repairFormApplicant");
    String project = request.getParameter("project");
    String phone = request.getParameter("repairFormPhone");
    String note = request.getParameter("repairFormNote");

    String createTime = request.getParameter("formCreateTime");
    String expectTime = request.getParameter("repairFormExpectTime");

    // 判斷是否為租客，並確定房間號碼
    if (roomNumber.equals("非租客")) {
      errorMsgs.put("RroomNumber", "系統查詢:您尚未有合約啟用，無法使用報修單功能");
    } else {
      session.setAttribute("roomNumber", roomNumber);
    }

    // 1. 判斷是否要產生報修單號
    // 2. 判斷CreateTime，editForm就不要存CreateTime
    // 3. 判斷expectTime
    // Date date = new Date();
    // new Timestamp(System.currentTimeMillis());

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // 可以用這個做為CreateTime
    String dateNow = format.format(currentTime);
    switch (job) {
      case "newForm":
        // 1. 判斷是否要產生報修單號
        int num =
            new RepairFormServiceImpl().checkRepairFormAmount(menber.getuId(), dateNow, dateNow);
        formNumber = roomNumber + dateNow + "A" + (num + 1);
        session.setAttribute("formNumber", formNumber);

        // 2. 判斷CreateTime
        createTime = dateNow;

        break;
      case "editForm":
        if (formNumber == null) {
          errorMsgs.put("FormNumber", "系統單號遺失請洽詢系統管理人員，或請重新新增報銷單");
        } else {
          formNumber = request.getParameter("RepairFormNumber");
          session.setAttribute("RepairFormNumber", formNumber);
        }

        break;
    }

    // 判斷申請人不得為空值
    if (applicant == null || applicant.trim().length() == 0) {
      errorMsgs.put("Aapplicant", "必須輸入申請人姓名");
    } else {
      session.setAttribute("Aapplicant", applicant);
    }

    // 判斷手機門號
    String myPhone = phone.replaceAll("\\s*", "");
    Pattern pattern = Pattern.compile("\\d{8}");
    Matcher matcher = pattern.matcher(myPhone.substring(2));
    if (myPhone == null || myPhone.trim().length() == 0) {
      errorMsgs.put("errPhone", "必須輸入手機電話");
    } else if (myPhone.length() != 10) {
      errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
    } else if (!myPhone.startsWith("09")) {
      errorMsgs.put("errPhone", "請輸入以「09」為開頭的手機電話");
    } else if (!matcher.matches()) {
      errorMsgs.put("errPhone", "手機電話格式後8碼錯誤"); // str.matches("[0-9]{4}-[0-9]{6}")
    } else {
      session.setAttribute("Phone", myPhone);
    }

    // 判斷project不得為空
    int projectId = new FurniturePriceServiceImpl().getFurnitureIdByName(project);
    if (projectId == -1 || projectId == 0) {
      errorMsgs.put("Project", "報修品項輸入錯誤");
    } else {
      session.setAttribute("Project", project);
    }

    // 3.判斷expectTime

    String expectTimeStr = expectTime + " 11:49:45";
    try {
      Timestamp timeConvert = Timestamp.valueOf(expectTimeStr);
      System.out.println(timeConvert);
      if (timeConvert.after(currentTime)) {
        session.setAttribute("expectTime", expectTime);
      } else {
        errorMsgs.put("expectTime", "系統查詢:期望時間不能小於申請日");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (!errorMsgs.isEmpty()) {
      request.setAttribute("FormInvalid", "insertRepairForm");
      // session.setAttribute("myPage", "profile");
      // System.out.println(errList.get(0));
      RequestDispatcher rd = request.getRequestDispatcher("/repair.jsp");
      rd.forward(request, response);
      return;
    }
    System.out.println(request.getParameter("formCreateTime"));
  }
}
