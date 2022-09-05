package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class ChatroomDaoImpl_JDBC implements ChatroomDao {
  private final DataSource ds;

  public ChatroomDaoImpl_JDBC() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別 #建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public int queryIdByChatroomName(String chatroomName) {
    String sql = "SELECT Id FROM chatroom WHERE CONCAT(member1,\"_\",member2) = ? ";
    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, chatroomName);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return resultSet.getInt("Id");
        }
        return -1;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public ArrayList<ArrayList> queryExistChatroomBySender(int member) {
    System.out.println("begin ChatroomDaoImpl_JDBC  with member = " + member);
    String sql = "SELECT Id, Chat_type, Close_Time FROM chatroom WHERE member1 = ? OR member2 = ?";
    var existChatrooms = new ArrayList();

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, member);
      preparedStatement.setInt(2, member);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          ArrayList existChatroom = new ArrayList<>();
          existChatroom.add(resultSet.getInt("Id"));
          existChatroom.add(resultSet.getString("Chat_type"));
          existChatroom.add(resultSet.getTimestamp("Close_Time"));
          existChatrooms.add(existChatroom);
        }
        return existChatrooms;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public void insertChatroom(String type, int member1, int member2) {

    String sql =
        "INSERT INTO chatroom "
            + "(Chat_type,Member1,Member2,Create_Time,Close_Time,IsOpen) "
            + "VALUE (?,?,?,?,?,?)";

    var localDateTime = LocalDateTime.now();
    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    int n;
    if (type == "B") {
      n = 14;
    } else {
      n = 365;
    }
    var ldtCloseTime = localDateTime.plusDays(n);

    var createTime = localDateTime.format(dateTimeFormatter);
    var closeTime = ldtCloseTime.format(dateTimeFormatter);

    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

      preparedStatement.setString(1, type);
      preparedStatement.setInt(2, member1);
      preparedStatement.setInt(3, member2);
      preparedStatement.setString(4, createTime);
      preparedStatement.setString(5, closeTime);
      preparedStatement.setBoolean(6, true);

      preparedStatement.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
  }
}
