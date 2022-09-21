package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/members/register")
public class ProessMemberServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();

    Map<String,String> errorMessage = new HashMap<>();

    request.setCharacterEncoding("UTF-8");

    // 讀取使用者所輸入，由瀏覽器送來的 mail 欄位內的資料
    String mail = request.getParameter("mail");
    // 檢查使用者所輸入的帳號
    if (mail == null || mail.trim().length() == 0) {
      errorMessage.put("mail","信箱欄必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料
    String password = request.getParameter("pswd");
    // 檢查使用者所輸入的密碼
    if (password == null || password.trim().length() == 0){
      errorMessage.put("password","密碼欄必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 mName 欄位內的資料
    String name = request.getParameter("mName");
    // 檢查使用者所輸入的名字
    if (name == null || name.trim().length() == 0) {
      errorMessage.put("name", "姓名欄必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 mAddress 欄位內的資料
    String address = request.getParameter("mAddress");
    // 檢查使用者所輸入的地址
    if (address == null || address.trim().length() == 0) {
      errorMessage.put("address", "地址欄必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 mPhone 欄位內的資料
    String phone = request.getParameter("mPhone");
    // 檢查使用者所輸入的電話
    if (phone == null || phone.trim().length() == 0) {
      errorMessage.put("phone", "電話必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 mIdNumber 欄位內的資料
    String idNumber = request.getParameter("mIdNumber");

    // 檢查使用者所輸入的身分證字號
    if (idNumber == null || idNumber.trim().length() == 0) {
      errorMessage.put("idNumber", "身分證字號必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 mNickName 欄位內的資料
    String nickName = request.getParameter("mNickName");
    // 檢查使用者所輸入的暱稱
    if (nickName == null || nickName.trim().length() == 0) {
      errorMessage.put("nickName", "暱稱必須輸入");
    }
    // 讀取使用者所輸入，由瀏覽器送來的 mGender 欄位內的資料
    String gender = request.getParameter("mGender");
    // 檢查使用者所輸入的性別
    if (gender == null || gender.trim().length() == 0) {
      errorMessage.put("gender", "性別必須輸入");
    }

    // 如果有錯誤，呼叫view元件，送回錯誤訊息
    if (!errorMessage.isEmpty()) {
      RequestDispatcher rd = request.getRequestDispatcher("member/InsertMemberForm.jsp");
      rd.forward(request, response);
      return;
    }

    // MemberBean 扮演封裝輸入資料的角色
    //    MemberBean mb = new MemberBean(name,gender,phone,idNumber,mail,password,address,nickName);
//    try {
//      MemberService service = new MemberService();
//      service.insertMember(mb);
//      session.setAttribute("memberBean",mb);
//      response.sendRedirect(
//          response.encodeRedirectURL(""));
//      return;
//    } catch (SQLException e) {
//      if (e.getMessage().indexOf("重複的索引鍵") != -1
//          || e.getMessage().indexOf("Duplicate entry") != -1) {
//        errorMessage.put("id", "帳號重複，請重新輸入帳號");
//      } else {
//        errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
//      }
//      RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
//      rd.forward(request, response);
//      return;
//    }
  }
}
