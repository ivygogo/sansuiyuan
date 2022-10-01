package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

  private static final String SELECT_ALL = "Select * from bookingexample order by 2 desc";
  private static final String SELECT_BY_ID =
      "Select booker_id, book_date, prefer_time, booker_name, booker_phone, roomtype, prefer_floor,"
          + " lead_person from bookingexample where booker_id = ?";
  private static final String DELETE = "Delete from bookingexample where booker_id=?";
  private static final String INSERT =
      "Insert into bookingexample (booker_id, book_date, prefer_time, booker_name, "
          + "booker_phone, roomtype, prefer_floor, lead_person) values (?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String UPDATE =
      "update bookingexample set booker_id=?, book_date=?, prefer_time=?, booker_name=?,"
          + " booker_phone=?,roomtype=?, prefer_floor=?, lead_person=? where booker_id = ?";

  public BookerBean select(Integer bookerId) {
    BookerBean result = null;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID); ) {
      stmt.setInt(1, bookerId);
      try (ResultSet rset = stmt.executeQuery(); ) {
        if (rset.next()) {
          result = new BookerBean();
          result.setBookerId(rset.getInt("booker_id"));
          result.setBookDate(rset.getDate("book_date"));
          result.setPreferTime(rset.getString("prefer_time"));
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

  public BookerBean insertBooker(BookerBean bean) throws SQLException {
    BookerBean result = null;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(INSERT); ) {
      stmt.setInt(1, bean.getBookerId());
      java.util.Date temp = bean.getBookDate();
      if (temp != null) {
        java.sql.Date someTime = new java.sql.Date(temp.getTime());
        stmt.setDate(2, someTime);
      } else {
        stmt.setDate(2, null);
      }
      stmt.setString(3, bean.getPreferTime());
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

  private void printSQLException(SQLException ex) {
    for (Throwable e : ex) {
      if (e instanceof SQLException) {
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + ((SQLException) e).getSQLState());
        System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable t = ex.getCause();
        while (t != null) {
          System.out.println("Cause: " + t);
          t = t.getCause();
        }
      }
    }
  }
}
