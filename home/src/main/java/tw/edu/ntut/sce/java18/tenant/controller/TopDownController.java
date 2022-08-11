package tw.edu.ntut.sce.java18.tenant.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.tenant.model.Store;

@WebServlet("/api/v1/stores")
public class TopDownController extends HttpServlet {

  // GSON is thread-safe to use.
  private final Gson gson = new Gson();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");

    var stores = getStores();
    var storesResponse = Map.of("result", stores);

    var printWriter = resp.getWriter();
    printWriter.print(gson.toJson(storesResponse));
    printWriter.flush();
  }

  private List<Store> getStores() {
    return List.of(
        mockStore("派克雞排", "https://via.placeholder.com/150"),
        mockStore("Starbugs", "https://picsum.photos/id/1060/150"),
        mockStore("芭比Q蛋糕", "https://picsum.photos/150"));
  }

  private Store mockStore(String name, String image) {
    var store = new Store();
    store.setName(name);
    store.setImage(image);
    return store;
  }
}
