package tw.edu.ntut.sce.java18.common.service;

import java.sql.SQLException;
import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.impl.BookingDao;
import tw.edu.ntut.sce.java18.common.model.BookerBean;

public class BookingService {
  BookingDao dao = null;

  public BookingService() {
    dao = new BookingDao();
  }

  public BookerBean select(Integer bookerId) {
    return dao.select(bookerId);
  }

  public List<BookerBean> select() {
    return dao.select();
  }

  public List<BookerBean> getAllBookers() {
    return select();
  }

  public BookerBean insertBooker(BookerBean bean) throws SQLException {
    return dao.insertBooker(bean);
  }

  public int delete(Integer bookerId) {
    return dao.delete(bookerId);
  }
}
