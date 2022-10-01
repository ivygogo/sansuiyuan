package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormServiceBean;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
import tw.edu.ntut.sce.java18.common.service.impl.FurniturePriceServiceImpl;
import tw.edu.ntut.sce.java18.common.service.impl.MemberInfoServiceImpl;
import tw.edu.ntut.sce.java18.common.service.impl.RepairFormServiceImpl;
import tw.edu.ntut.sce.java18.common.service.impl.TenantServiceImpl;

@WebServlet("/RepairForm.do")
public class RepairFormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    final Gson gson = new Gson();
    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();
    MemberBean memberLogin = (MemberBean) session.getAttribute("LoginOK");
    int memberId = memberLogin.getuId();

    String job = request.getParameter("doJob");

    var printWriter = response.getWriter();
    String roomNumber = new TenantServiceImpl().getRoomNumberByMemberId(memberId);

    switch (job) {
      case "repairFormInfo":
        List<RepairFormServiceBean> repairFormList =
            new RepairFormServiceImpl().getReparFormConverListByApplicant(memberId);
        MemberBean member = new MemberInfoServiceImpl().queryMemberByPrimaryKey(memberId);
        session.setAttribute("member", member);
        var showPageInfo = Map.of("roomNumber", roomNumber, "repairFormList", repairFormList);

        var reparFormListJson = gson.toJson(showPageInfo);
        printWriter.print(reparFormListJson);
        System.out.println(reparFormListJson);
        printWriter.flush();
        break;

      case "getProject":
        List<String> furnitureNameList = new FurniturePriceServiceImpl().getAllFurnitureName();
        member = new MemberInfoServiceImpl().queryMemberByPrimaryKey(memberId);
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

      case "getchat":
        var beforeTime = new Timestamp(System.currentTimeMillis() - (1000 * 60 * 60));
        var afterTime = new Timestamp(System.currentTimeMillis() - (1000 * 60 * 60));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beforeTimeStr = df.format(beforeTime);
        String afterTimeStr = df.format(afterTime);
        int num =
            new RepairFormServiceImpl()
                .checkRepairFormExistBytime(memberId, beforeTimeStr, afterTimeStr);

        // MemberBean member = new MemberInfoServiceImpl().queryMemberByPrimaryKey(memberId);
        List<RepairFormServiceBean> newRepairFormList =
            new RepairFormServiceImpl().getReparFormConverListByApplicant(memberId);

        RepairFormServiceBean repairForm = new RepairFormServiceBean();
        if (Optional.ofNullable(newRepairFormList.get(0)).isPresent()) {
          repairForm = newRepairFormList.get(0);

        } else {
          memberId = -1;
        }
        var showNewFrom = Map.of("toRoom", memberId, "formId", repairForm);
        var showNewFromJson = gson.toJson(showNewFrom);
        printWriter.print(showNewFromJson);
        System.out.println(showNewFromJson);
        printWriter.flush();
        break;
      default:
        System.out.println("i got u");
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8;");

    Map<String, String> errorMsgs = new HashMap<String, String>();
    session.setAttribute("ErrMsg", errorMsgs);
    MemberBean member = (MemberBean) session.getAttribute("member");
    int memberId = member.getuId();

    String job = "";

    if (session.getAttribute("page") == null) {
      job = "deleteRepairForm";
    } else {
      job = (String) session.getAttribute("page");
    }
    System.out.println("jobjob ->" + job);
    switch (job) {
      case "deleteRepairForm":
        String deleteFormNumber = request.getParameter("id");
        System.out.println(deleteFormNumber);
        try {
          int n = new RepairFormServiceImpl().deleteRepairForm(deleteFormNumber);
          if (n != 1) {
            System.out.println("n != 1");
            errorMsgs.put("saveErr", "系統儲存資料異常");
          }
        } catch (Exception e) {
          System.out.println("n !!!= 1");
          e.printStackTrace();
        }

        int formExist = new RepairFormServiceImpl().checkUnFinishedRepairFormAmount(memberId);
        if (formExist <= 0) {
          ChatroomService chatroomService = new ChatroomService();
          int getChatRoomId = chatroomService.getChatroomIdByUserId(memberId, "R");
          chatroomService.changeCloseTime(getChatRoomId, 1);
        }

        response.sendRedirect("/home/repair.jsp");
        return;
        // break;

      default:
        String formNumber = request.getParameter("RepairFormNumber"); // 需要判斷是不是新增
        String roomNumber =
            new TenantServiceImpl().getRoomNumberByMemberId(memberId); // 不用判斷，用member id取出
        String applicant = request.getParameter("repairFormApplicant");
        String project = request.getParameter("project");
        String phone = request.getParameter("repairFormPhone");
        String note = request.getParameter("repairFormNote");
        session.setAttribute("note", note);
        String createTime = request.getParameter("formCreateTime");
        String expectTime = request.getParameter("repairFormExpectTime");

        // System.out.println("formNumber" + formNumber);
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
                new RepairFormServiceImpl()
                    .checkRepairFormAmount(member.getuId(), dateNow, dateNow);
            System.out.println("dateNow" + dateNow);
            formNumber = roomNumber + dateNow + "A" + (num + 1);
            session.setAttribute("formNumber", formNumber);

            // 2. 判斷CreateTime
            createTime = dateNow;
            session.setAttribute("createTime", createTime);
            break;

          case "editForm":
            formNumber = (String) session.getAttribute("RepairFormNumber");
            if (formNumber == null) {
              errorMsgs.put("FormNumber", "系統單號遺失請洽詢系統管理人員，或請重新新增報銷單");
            } else {
              formNumber = (String) session.getAttribute("RepairFormNumber");
              session.setAttribute("RepairFormNumber", formNumber);
            }
        }

        // 判斷申請人不得為空值
        if (applicant == null || applicant.trim().length() == 0) {
          errorMsgs.put("Aapplicant", "必須輸入申請人姓名");
        } else {
          session.setAttribute("Aapplicant", applicant);
        }

        // 判斷手機門號
        String myPhone = phone.replaceAll("\\s*", "");
        Pattern pattern;
        Matcher matcher;
        if (myPhone.length() != 10) {
          errorMsgs.put("errPhone", "手機電話為09開頭且總數為10碼");
        } else {
          pattern = Pattern.compile("\\d{8}");
          matcher = pattern.matcher(myPhone.substring(2));
          if (!matcher.matches()) {
            errorMsgs.put("errPhone", "手機電話格式後8碼錯誤"); // str.matches("[0-9]{4}-[0-9]{6}")
          }
        }

        if (phone.trim().length() == 0) {
          errorMsgs.put("errPhone", "必須輸入手機電話");
        } else if (!phone.startsWith("09")) {
          errorMsgs.put("errPhone", "請輸入以「09」為開頭的手機電話");
        } else {
          session.setAttribute("Phone", myPhone);
        }

        // 判斷project不得為空
        System.out.println("project" + project);
        int projectId = new FurniturePriceServiceImpl().getFurnitureIdByName(project);
        System.out.println("projectId" + projectId);
        if (project.equals("0") || projectId == -1) {
          errorMsgs.put("Project", "報修品項輸入錯誤");
          session.setAttribute("Project", project);
        } else {
          session.setAttribute("Project", project);
        }

        // 3.判斷expectTime
        expectTime = expectTime.replaceAll("\\s*", "");
        Timestamp timeConvert = null;

        if (expectTime == null || expectTime.trim().length() == 0) {
          errorMsgs.put("expectTime", "請輸入日期");
        } else {
          String expectTimeStr = expectTime + " 11:49:45";
          DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

          try {
            LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(expectTimeStr));
            timeConvert = Timestamp.valueOf(localDateTime);
            System.out.println("timeConvert" + timeConvert);
            if (timeConvert.after(currentTime)) {
              session.setAttribute("expectTime", expectTime);
            } else {
              errorMsgs.put("expectTime", "系統查詢:期望時間不能小於申請日");
            }
          } catch (Exception e) {
            errorMsgs.put("expectTime", "請輸入期望時間");
            e.printStackTrace();
          }
        }

        Set keySet = errorMsgs.keySet();
        Iterator it = keySet.iterator();
        ArrayList<String> errList = new ArrayList<>();
        while (it.hasNext()) {
          String key = (String) it.next();
          /*有了鍵就可以通過map集合的get方法獲取其對應的値 ( key:01, vaule: a  key: 02,vaule: b  key:03, vaule: c)*/
          String value = errorMsgs.get(key);
          System.out.println("key: " + key + ", vaule: " + value);
          errList.add(key);
          // System.out.println(errList.get(0));
        }
        if (!errorMsgs.isEmpty()) {
          switch (job) {
            case "newForm":
              session.setAttribute("FormInvalid", "insertRepairForm");
              session.setAttribute("doJob", "getVaildIn");
              // session.setAttribute("myPage", "profile");
              // System.out.println(errList.get(0));
              RequestDispatcher rd = request.getRequestDispatcher("/repair.jsp");
              rd.forward(request, response);
              break;

            case "editForm":
              session.setAttribute("FormStatus", "待處理");
              session.setAttribute("FormInvalid", "editRepairForm");
              session.setAttribute("doJob", "getVaildEd");
              rd = request.getRequestDispatcher("/repair.jsp");
              rd.forward(request, response);
              break;
          }

        } else {

          switch (job) {
            case "newForm":
              RepairFormBean newBean = new RepairFormBean();
              newBean.setFormNumber(formNumber);
              newBean.setRoomNumber(roomNumber);
              newBean.setMemberId(member.getuId());
              newBean.setApplicant(applicant);
              newBean.setPhone(myPhone);
              newBean.setCreatTime(currentTime);
              newBean.setExpectionTime(timeConvert);
              newBean.setProject(projectId);
              newBean.setStatus(0);
              newBean.setNote(note);
              try {
                int n = new RepairFormServiceImpl().saveRepairForm(newBean);
                if (n != 1) {
                  errorMsgs.put("saveErr", "系統儲存資料異常");
                }
              } catch (Exception e) {
                e.printStackTrace();
              }
              // String linkStr = "/home/repair.jsp?rid=" + formNumber;
              // request.setAttribute("FormInvalid", "ok");
              // RequestDispatcher rd = request.getRequestDispatcher("/repair.jsp");
              // rd.forward(request, response);
              session.setAttribute("FormInvalid", "OK");
              response.sendRedirect("/home/repair.jsp?doJob=getchat");
              break;
            case "editForm":
              RepairFormBean editBean = new RepairFormBean();
              editBean.setFormNumber(formNumber);
              editBean.setApplicant(applicant);
              editBean.setPhone(myPhone);
              editBean.setExpectionTime(timeConvert);
              System.out.println("timeConvert->" + timeConvert);
              editBean.setProject(projectId);
              editBean.setNote(note);
              try {
                int n = new RepairFormServiceImpl().updateRepairForm(editBean);
                if (n != 1) {
                  System.out.println("n != 1");
                  errorMsgs.put("saveErr", "系統儲存資料異常");
                }
              } catch (Exception e) {
                System.out.println("n !!!= 1");
                e.printStackTrace();
              }
              session.setAttribute("FormInvalid", "OK");
              response.sendRedirect("/home/repair.jsp?doJob=getchat");

              break;
          }
          break;
        }
    }
  }
}
