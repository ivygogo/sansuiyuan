package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import tw.edu.ntut.sce.java18.common.model.BookerBean;

public class BookDAO {
  private String jdbcURL =
      "jdbc:mysql://127.0.0.1/wulidb"
          + "?useUnicode=yes&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Taipei&allowPublicKeyRetrieval=true";
  private String jdbcUsername = "admin";
  private String jdbcPassword = "admin123";

  private static final String SELECT_ALL = "Select * from bookingexample order by 2 desc";
  private static final String SELECT_BY_ID =
      "Select booker_id, book_date, prefer_time, booker_name, booker_phone, roomtype, prefer_floor,"
          + " lead_person from bookingexample where booker_id = ?";
  private static final String DELETE = "Delete from bookingexample where booker_id=?";
  private static final String INSERT =
      "Insert into bookingexample (booker_id, book_date, prefer_time, booker_name, booker_phone,"
          + " roomtype, prefer_floor, lead_person) values (?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String UPDATE =
      "update bookingexample set booker_id=?, book_date=?, prefer_time=?,booker_name=?,"
          + "booker_phone=?, roomtype=?, prefer_floor=?, lead_person=? where booker_id = ?";

  public BookDAO() {}

  protected Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public BookerBean insertUser(BookerBean bean) throws SQLException {
    System.out.println(INSERT + "-----------------------");
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
      preparedStatement.setInt(1, bean.getBookerId());
      preparedStatement.setDate(2, bean.getBookDate());
      preparedStatement.setString(3, bean.getPreferTime());
      preparedStatement.setString(4, bean.getBookerName());
      preparedStatement.setString(5, bean.getBookerPhone());
      preparedStatement.setString(6, bean.getRoomtype());
      preparedStatement.setString(7, bean.getPreferFloor());
      preparedStatement.setString(8, bean.getLeadPerson());
      System.out.println(preparedStatement + "-----------------------");
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      printSQLException(e);
    }
    return bean;
  }

  public BookerBean selectUser(int id) {
    BookerBean booker = null;
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID); ) {
      preparedStatement.setInt(1, id);
      System.out.println(preparedStatement + "-----------------------");
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        Date bookDate = rs.getDate("book_date");
        String preferTime = rs.getString("prefer_time");
        String bookerName = rs.getString("booker_name");
        String bookerPhone = rs.getString("booker_phone");
        String roomtype = rs.getString("roomtype");
        String preferFloor = rs.getString("prefer_floor");
        String leadPerson = rs.getString("lead_person");
        booker =
            new BookerBean(
                id,
                bookDate,
                preferTime,
                bookerName,
                bookerPhone,
                roomtype,
                preferFloor,
                leadPerson);
      }
    } catch (SQLException e) {
      printSQLException(e);
    }
    return booker;
  }

  public List<BookerBean> selectAllUsers() {
    List<BookerBean> result = null;
    try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        ResultSet rs = preparedStatement.executeQuery(); ) {
      System.out.println(preparedStatement + "-----------------------");
      result = new Vector<>();
      while (rs.next()) {
        BookerBean temp = new BookerBean();
        temp.setBookerId(rs.getInt("booker_id"));
        temp.setBookDate(rs.getDate("book_date"));
        temp.setPreferTime(rs.getString("prefer_time"));
        temp.setBookerName(rs.getString("booker_name"));
        temp.setBookerPhone(rs.getString("booker_phone"));
        temp.setRoomtype(rs.getString("roomtype"));
        temp.setPreferFloor(rs.getString("prefer_floor"));
        temp.setLeadPerson(rs.getString("lead_person"));
        result.add(temp);
      }
    } catch (SQLException e) {
      printSQLException(e);
    }
    return result;
  }

  public boolean deleteUser(Integer id) throws SQLException {
    boolean rowDeleted;
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE); ) {
      statement.setInt(1, id);
      rowDeleted = statement.executeUpdate() > 0;
    }
    return rowDeleted;
  }

  public boolean updateUser(BookerBean booker) throws SQLException {
    boolean rowUpdated;
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE); ) {
      statement.setInt(1, booker.getBookerId());
      statement.setDate(2, booker.getBookDate());
      statement.setString(3, booker.getPreferTime());
      statement.setString(4, booker.getBookerName());
      statement.setString(5, booker.getBookerPhone());
      statement.setString(6, booker.getRoomtype());
      statement.setString(7, booker.getPreferFloor());
      statement.setString(8, booker.getLeadPerson());
      statement.setInt(9, booker.getBookerId());

      rowUpdated = statement.executeUpdate() > 0;
    }
    return rowUpdated;
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
