package tw.edu.ntut.sce.java18.tenant.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/stores")
public class TopDownController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    var printWriter = resp.getWriter();
    printWriter.print(
        "{\"result\":["
            + "{\"name\":\"派克雞排\",\"image\":\"https://via.placeholder.com/150\"},"
            + "{\"name\":\"Starbugs\",\"image\":\"https://picsum.photos/id/1060/150\"},"
            + "{\"name\":\"芭比Q蛋糕\",\"image\":\"https://picsum.photos/150\"}"
            + "]}");
    printWriter.flush();
  }
}
