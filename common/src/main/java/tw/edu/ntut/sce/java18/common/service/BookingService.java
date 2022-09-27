package tw.edu.ntut.sce.java18.common.service;

import java.sql.SQLException;
import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.impl.BookDAO;
import tw.edu.ntut.sce.java18.common.dao.impl.BookingDao;
import tw.edu.ntut.sce.java18.common.model.BookerBean;

public class BookingService {
  BookingDao dao = null;
  BookDAO DAO = null;

  public BookingService() {
    DAO = new BookDAO();
  }

  public BookerBean select(Integer bookerId) {
    return DAO.selectUser(bookerId);
  }

  public List<BookerBean> select() {
    return DAO.selectAllUsers();
  }

  public List<BookerBean> getAllBookers() {
    return select();
  }

  public BookerBean insertBooker(BookerBean bean) throws SQLException {
    return dao.insertBooker(bean);
  }

  public BookerBean insert(BookerBean bean) throws SQLException {
    return DAO.insertUser(bean);
  }

  public boolean delete(Integer bookerId) throws SQLException {
    return DAO.deleteUser(bookerId);
  }
}
