package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.BookerBean;
import tw.edu.ntut.sce.java18.common.service.BookingService;

@WebServlet("/home/BookTest.do")
public class BookTestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    final Gson gson = new Gson();
    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();

    var printWriter = response.getWriter();
    List<BookerBean> bookerBeans = new BookingService().getAllBookers();
    var reparFormListJson = gson.toJson(bookerBeans);
    printWriter.print(reparFormListJson);
    System.out.println(reparFormListJson);
    printWriter.flush();
  }
}
