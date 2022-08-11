package tw.edu.ntut.sce.java18.tenant.service;

import java.util.List;
import tw.edu.ntut.sce.java18.tenant.model.Store;

public class StoreService {

  public List<Store> getStores() {
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
