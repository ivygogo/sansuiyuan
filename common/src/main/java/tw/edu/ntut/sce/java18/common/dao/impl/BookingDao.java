package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.model.BookerBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class BookingDao {
  DataSource ds = null;

  public BookingDao() {
    try {
      Context context = new InitialContext();
      ds = (DataSource) context.lookup(DBService.JNDI_DB_NAME);
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  private static final String SELECT_BY_ID =
      "Select book_date, prefer_time, booker_id, booker_name, booker_phone, roomtype, prefer_floor, lead_person from bookingexample where booker_id = ?";

  public BookerBean select(String bookerid) {
    BookerBean result = null;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID); ) {
      stmt.setString(3, bookerid);
      try (ResultSet rset = stmt.executeQuery(); ) {
        if (rset.next()) {
          result = new BookerBean();
          //          result.setId(rset.getInt("id"));
          result.setBookDate(rset.getDate("book_date"));
          result.setPreferTime(rset.getString("prefer_time"));
          result.setBookerId(rset.getString("booker_id"));
          result.setBookerName(rset.getString("booker_name"));
          result.setBookerPhone(rset.getString("booker_phone"));
          result.setRoomtype(rset.getString("roomtype"));
          result.setPreferFloor(rset.getString("prefer_floor"));
          result.setLeadPerson(rset.getString("lead_person"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  private static final String SELECT_ALL =
      "Select book_date, prefer_time, booker_id, booker_name, booker_phone, roomtype, prefer_floor, lead_person from bookingexample order by 1 desc";

  public List<BookerBean> select() {
    List<BookerBean> result = null;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
        ResultSet rset = stmt.executeQuery(); ) {
      result = new Vector<>();
      while (rset.next()) {
        BookerBean temp = new BookerBean();
        //        temp.setId(rset.getInt("id"));
        temp.setBookDate(rset.getDate("book_date"));
        temp.setPreferTime(rset.getString("prefer_time"));
        temp.setBookerId(rset.getString("booker_id"));
        temp.setBookerName(rset.getString("booker_name"));
        temp.setBookerPhone(rset.getString("booker_phone"));
        temp.setRoomtype(rset.getString("roomtype"));
        temp.setPreferFloor(rset.getString("prefer_floor"));
        temp.setLeadPerson(rset.getString("lead_person"));
        result.add(temp);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  private static final String INSERT =
      "Insert into bookingexample (book_date, prefer_time, booker_id, booker_name, booker_phone, roomtype, prefer_floor, lead_person) values (?, ?, ?, ?, ?, ?, ?, ?)";

  public BookerBean insertBooker(BookerBean bean) throws SQLException {
    BookerBean result = null;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(INSERT); ) {
      java.util.Date temp = bean.getBookDate();
      if (temp != null) {
        java.sql.Date someTime = new java.sql.Date(temp.getTime());
        stmt.setDate(1, someTime);
      } else {
        stmt.setDate(1, null);
      }
      stmt.setString(2, bean.getPreferTime());
      stmt.setString(3, bean.getBookerId());
      stmt.setString(4, bean.getBookerName());
      stmt.setString(5, bean.getBookerPhone());
      stmt.setString(6, bean.getRoomtype());
      stmt.setString(7, bean.getPreferFloor());
      stmt.setString(8, bean.getLeadPerson());

      int i = stmt.executeUpdate();
      if (i == 1) {
        result = this.select(bean.getBookerId());
      }
    }
    return result;
  }

  private static final String DELETE = "Delete from bookingexample where booker_id=?";

  public int delete(String bookerId) {
    int result = 0;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(DELETE); ) {
      stmt.setString(3, bookerId);
      result = stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
