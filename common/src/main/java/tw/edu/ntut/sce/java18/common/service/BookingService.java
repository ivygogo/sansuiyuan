package tw.edu.ntut.sce.java18.common.service;

import java.sql.SQLException;
import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.impl.BookDAO;
import tw.edu.ntut.sce.java18.common.dao.impl.BookingDao;
import tw.edu.ntut.sce.java18.common.model.BookerBean;

public class BookingService {
  BookingDao daoFront = null;
  BookDAO daoBack = null;

  public BookingService() {
    daoBack = new BookDAO();
    daoFront = new BookingDao();
  }

  //    public BookingService1() {
  //      BookingDao dao = null;
  //    }

  public BookerBean select(Integer bookerId) {
    return daoBack.selectUser(bookerId);
  }

  public List<BookerBean> select() {
    return daoBack.selectAllUsers();
  }

  public List<BookerBean> getAllBookers() {
    return select();
  }

  public BookerBean insertBooker(BookerBean bean) throws SQLException {
    return daoFront.insertBooker(bean);
  }

  public BookerBean insert(BookerBean bean) throws SQLException {
    return daoBack.insertUser(bean);
  }

  public boolean delete(Integer bookerId) throws SQLException {
    return daoBack.deleteUser(bookerId);
  }
}
