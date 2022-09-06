package tw.edu.ntut.sce.java18.tenant.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.tenant.service.StoreService;

@WebServlet("/api/v1/stores")
public class TopDownController extends HttpServlet {

  // GSON is thread-safe to use.
  private final Gson gson = new Gson();
  private final StoreService storeService = new StoreService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");

    var stores = storeService.getStores();
    var storesResponse = Map.of("result", stores);

    var printWriter = resp.getWriter();
    printWriter.print(gson.toJson(storesResponse));
    printWriter.flush();
  }
}
