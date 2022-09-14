package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
      throws ServletException, IOException {}
}
