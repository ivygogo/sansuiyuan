package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.service.RoomTypeService;

@WebServlet("/common/RoomTypeServlet")
public class RoomTypeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String selectedRoomType = request.getQueryString();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    var printWriter = response.getWriter();
    var serviceRoomType = new RoomTypeService().queryRoomType(selectedRoomType);
    var roomTypeResponse = new RoomTypeServletConverter().convert(serviceRoomType);
    var roomTypeResponseJson = gson.toJson(roomTypeResponse);
    printWriter.print(roomTypeResponseJson);

    printWriter.flush();
  }
}
