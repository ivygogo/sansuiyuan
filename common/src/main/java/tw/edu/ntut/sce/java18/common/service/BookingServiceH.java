package tw.edu.ntut.sce.java18.common.service;

import java.sql.SQLException;
import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.impl.BookDaoHibernate;
import tw.edu.ntut.sce.java18.common.model.BookerBeanHibernate;

public class BookingServiceH {

  BookDaoHibernate daoBack = null;

  public BookingServiceH() {
    daoBack = new BookDaoHibernate();
  }

  public BookerBeanHibernate select(Integer bookerId) {
    return daoBack.getUser(bookerId);
  }

  public List<BookerBeanHibernate> select() {
    return daoBack.getAllUser();
  }

  public List<BookerBeanHibernate> getAllBookers() {
    return select();
  }

  public BookerBeanHibernate insert(BookerBeanHibernate bean) throws SQLException {

    return daoBack.saveUser(bean);
  }

  public BookingServiceH(Integer bookerId) throws SQLException {
    return;
  }
}
