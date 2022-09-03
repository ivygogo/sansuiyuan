package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.tenant.memberInfo.service.impl.MemberInfoServiceImpl;

/** Servlet implementation class MemberInfoServlet */
@WebServlet("/MemberInfo.do")
public class MemberInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private final Gson gson = new Gson();

  private void writeText(HttpServletResponse response, String outText) throws IOException {
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    out.print(outText);
    // 將輸出資料列印出來除錯用
    //  System.out.println("output: " + outText);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);
    if (session == null) { // 使用逾時
      response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
      return;
    }
    MemberInfoServiceImpl misi = new MemberInfoServiceImpl();

    /*先把3個性別的頭像準備好*/
    String maleAvatar = misi.getAllAvatarByGender(0);
    String femaleAvatar = misi.getAllAvatarByGender(1);
    String otherAvatar = misi.getAllAvatarByGender(2);
    // System.out.println(otherAvatar);
    session.setAttribute("maleAvatar", maleAvatar);
    session.setAttribute("femaleAvatar", femaleAvatar);
    session.setAttribute("otherAvatar", otherAvatar);

    /*測試資料可以在這邊測試，透過session並運用LoginOK傳遞存進資料庫的會員資料*/
    MemberBean mb = misi.getMemberInfo(1);
    session.setAttribute("LoginOK", mb);
    session.setAttribute("memberInfo", mb);

    String s = (String) session.getAttribute("myPage");
    // System.out.println("我是S:" + s);

    var memberResponse = Map.of("result", mb);
    String str = new Gson().toJson(memberResponse);

    request.setAttribute("str", str);
    System.out.println("Get:" + str);

    /*====下面是傳統 servlet的作法 ====*/

    String avatar = misi.getAvatar(mb.getuId()).replace(".png", "");

    String characterTags = misi.getCharacterTag(mb.getuId());
    String favorTags = misi.getFavorTag(mb.getuId());
    String genderTags = misi.getGenderTag(mb.getuId());
    String findRoommateTag = misi.getFindRoommateTag(mb.getuId());
    String findAvatarTag = misi.getFindAvatarTag(mb.getuId());

    session.setAttribute("CharacterTag", characterTags);
    session.setAttribute("FavorTag", favorTags);
    session.setAttribute("GenderTags", genderTags);
    session.setAttribute("FindRoommateTag", findRoommateTag);
    session.setAttribute("FindAvatarTag", findAvatarTag); // 錯誤...

    session.setAttribute("Avatar", avatar);

    System.out.println(mb.getAvatar());

    RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
    rd.forward(request, response);
    return;
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setAttribute("editPage", "yes");

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    MemberInfoServiceImpl misi = new MemberInfoServiceImpl();
    MemberBean mb = misi.getMemberInfo(1);
    var storesResponse = Map.of("result", mb);
    var printWriter = response.getWriter();
    printWriter.print(gson.toJson(storesResponse));
    printWriter.flush();
    System.out.println(printWriter);
  }
}
