package tw.edu.ntut.sce.java18.tenant.memberInfo.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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

@WebServlet("/TestServlet.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024 * 1024 * 500 * 5)
public class TestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  MemberBean mb;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    if (!session.isNew()) {
      mb = (MemberBean) session.getAttribute("memberInfo");
      System.out.println(mb.getName());
    } else {
      mb = new MemberBean();
    }

    Map<String, String> errorMsgs = new HashMap<String, String>();
    Map<String, String> successMsgs = new HashMap<String, String>();
    int pass = -1;
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    session.setAttribute("ErrMsg", errorMsgs);
    session.setAttribute("successMsg", successMsgs);
    session.setAttribute("myPage", "contact");

    String name = "";

    Collection<Part> parts = request.getParts();
    if (parts != null) { // 如果這是一個上傳資料的表單
      for (Part p : parts) {
        String fldName = p.getName();
        String value = request.getParameter(fldName);
        System.out.println("表單名稱: " + fldName);

        if (p.getContentType() == null) {
          if (fldName.equals("myName")) {
            name = value;
            System.out.println(name);
            mb.setName(name);
            if (name == null || name.trim().length() == 0) {
              errorMsgs.put("errName", "必須輸入大名");
            } else {
              session.setAttribute("name", name);
            }
          } else {
            // none
          }
        } else {
          // 放上傳圖片
        }
      }
    } // if part end
    else {
      errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
    }
    if (!errorMsgs.isEmpty()) {

      pass = 0;
      session.setAttribute("checkErr", pass);

      RequestDispatcher rd = request.getRequestDispatcher("memberInfo.jsp");
      rd.forward(request, response);
      return;
    } else {
      pass = 1;
      RequestDispatcher rd = request.getRequestDispatcher("memberInfo.jsp");
      session.setAttribute("checkErr", pass);
      rd.forward(request, response);
      return;
    }
  } // doPost end
}
