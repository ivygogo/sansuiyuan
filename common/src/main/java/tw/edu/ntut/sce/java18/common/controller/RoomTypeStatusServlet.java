package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.service.RoomTypeStatusService;

@WebServlet("/RoomTypeStatusServlet.do")
public class RoomTypeStatusServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");

    String RoomNumberString = request.getParameter("roomNumber");
    System.out.println(RoomNumberString);

    RoomTypeStatusService service = new RoomTypeStatusService();
    // service.queryRoomTypeStatus(RoomNumberString);
    var result = service.queryRoomTypeStatus(RoomNumberString);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();
    var resultResponseJson = gson.toJson(result);
    printWriter.print(resultResponseJson);
    // System.out.println(result);
    printWriter.flush();
  }
}
