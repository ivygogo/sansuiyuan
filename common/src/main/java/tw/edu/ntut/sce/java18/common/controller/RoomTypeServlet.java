package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.controller.converter.RoomTypeConverter;
import tw.edu.ntut.sce.java18.common.controller.model.RoomTypeControllerBean;
import tw.edu.ntut.sce.java18.common.model.RoomTypeServiceBean;
import tw.edu.ntut.sce.java18.common.service.RoomTypeService;

@WebServlet("/common/RoomTypeServlet")
public class RoomTypeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private final RoomTypeService roomTypeService = new RoomTypeService();
  private Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String selectRoomType = request.getQueryString();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    var printWriter = response.getWriter();
    RoomTypeServiceBean roomType = roomTypeService.queryRoomType(selectRoomType);

    // TODO may extract to another converter for Controller model and Service model conversion
    RoomTypeControllerBean displayRoomType = new RoomTypeConverter().convert(roomType);
    Map<String, RoomTypeControllerBean> roomTypeResponse =
        Map.of(displayRoomType.getType(), displayRoomType);
    var roomTypeResponseJson = gson.toJson(roomTypeResponse);

    printWriter.print(roomTypeResponseJson);

    printWriter.flush();
  }
}
