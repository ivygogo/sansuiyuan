package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.service.impl.MemberInfoServiceImpl;

/** 會員資料瀏覽(show)與編輯(edit)頁面，都會用到此程式，因此在本程式需要將這兩個頁面會用到的資料和前台tag準備好 */
@WebServlet("/MemberInfo.do")
public class MemberInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession(false);
    if (session == null) { // 使用逾時
      response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
      return;
    }
    MemberInfoServiceImpl misi = new MemberInfoServiceImpl();

    // 1.依照 MEMBER Uid讀取會員資料
    // 測試資料可以在這邊測試，透過session並運用LoginOK傳遞存進資料庫的會員資料
    MemberBean member = (MemberBean) session.getAttribute("LoginOK");
    MemberBean mb = misi.getMemberInfo(member.getuId());

    // 2.將讀取到的會員資料，以EL方式傳送至瀏覽(show)與編輯(edit)頁面
    session.setAttribute("LoginOK", mb);
    session.setAttribute("memberInfo", mb);

    // 3. 先把3個性別的頭像準備好，供編輯(edit)頁面取用
    String maleAvatar = misi.getAllAvatarByGender(0);
    String femaleAvatar = misi.getAllAvatarByGender(1);
    String otherAvatar = misi.getAllAvatarByGender(2);
    // System.out.println(otherAvatar);
    session.setAttribute("maleAvatar", maleAvatar);
    session.setAttribute("femaleAvatar", femaleAvatar);
    session.setAttribute("otherAvatar", otherAvatar);

    // 4. 大頭貼檔名供瀏覽(show)與編輯(edit)頁面取用
    String avatar = misi.getAvatar(mb.getuId()).replace(".png", "");
    session.setAttribute("Avatar", avatar);

    // 5. 依用戶資料組成正確的<個性標籤的CHECKBOX> 供編輯(edit)頁面取用
    String characterTags = misi.getCharacterTag(mb.getuId());
    session.setAttribute("CharacterTag", characterTags);

    // 6. 依用戶資料組成正確的<室友喜好的CHECKBOX>供編輯(edit)頁面取用
    String favorTags = misi.getFavorTag(mb.getuId());
    session.setAttribute("FavorTag", favorTags);

    // 7. 依用戶資料組成正確的<性別的RADIO BUTTON>供編輯(edit)頁面取用
    String genderTags = misi.getGenderTag(mb.getuId());
    session.setAttribute("GenderTags", genderTags);

    // 8. 依用戶資料組成正確的<找室友功能RADIO BUTTON>供編輯(edit)頁面取用
    String findRoommateTag = misi.getFindRoommateTag(mb.getuId());
    session.setAttribute("FindRoommateTag", findRoommateTag);

    // 9. 依用戶資料組成正確的<大頭貼RADIO BUTTONAG>供編輯(edit)頁面取用
    String findAvatarTag = misi.getFindAvatarTag(mb.getuId());
    session.setAttribute("FindAvatarTag", findAvatarTag);

    RequestDispatcher rd = request.getRequestDispatcher("/memberInfo.jsp");
    rd.forward(request, response);
    return;
  }
}

/*
  private void writeText(HttpServletResponse response, String outText) throws IOException {
  response.setContentType("application/json");
  response.setCharacterEncoding("UTF-8");
  PrintWriter out = response.getWriter();
  out.print(outText);
  // 將輸出資料列印出來除錯用
  // System.out.println("output: " + outText);
 }

  //測試前台所屬頁面用
  String s = (String) session.getAttribute("myPage");
  // System.out.println("我是S:" + s);
*
  //Gson的用法
  var memberResponse = Map.of("result", mb);
  String str = new Gson().toJson(memberResponse);
  request.setAttribute("str", str);
  System.out.println("Get:" + str);
*
* */
