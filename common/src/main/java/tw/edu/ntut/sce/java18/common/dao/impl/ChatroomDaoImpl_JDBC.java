package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.utils.DBService;

@Repository
public class ChatroomDaoImpl_JDBC implements ChatroomDao {
  private final DataSource ds;

  public ChatroomDaoImpl_JDBC() {
    try {
      var ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別 #建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public int queryIdByChatroomName(String chatroomName, String chatroomType) {
    String sql = "SELECT Id FROM chatroom WHERE CONCAT(member1,\"_\",member2) = ? And Chat_type =?";

    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, chatroomName);
      preparedStatement.setString(2, chatroomType);

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
  public int queryIdByChatroomName(String chatroomName) {
    String sql = "SELECT Id FROM chatroom WHERE CONCAT(member1,\"_\",member2) = ?";
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
  public ArrayList queryExistChatroomByUser(int member) {
    String sql =
        "SELECT Id, member1, member2, Chat_type, Close_Time "
            + "FROM chatroom WHERE member1 = ? OR member2 = ?";
    var existChatroomList = new ArrayList();

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, member);
      preparedStatement.setInt(2, member);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          var existChatroom = new ExistChatroomBean();
          existChatroom.setId(resultSet.getInt("Id"));
          existChatroom.setChatType(resultSet.getString("Chat_type"));
          existChatroom.setCloseTime(resultSet.getTimestamp("Close_Time"));
          if (resultSet.getInt("member1") == member) {
            existChatroom.setUserId(resultSet.getInt("member2"));
            existChatroom.setTargetId(resultSet.getInt("member1"));
          } else {
            existChatroom.setUserId(resultSet.getInt("member1"));
            existChatroom.setTargetId(resultSet.getInt("member2"));
          }
          existChatroomList.add(existChatroom);
        }
        return existChatroomList;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public int queryCountForMakeFriendByUserId(int member) {
    String sql =
        "SELECT COUNT(Id) " + "FROM chatroom WHERE (member1 = ? OR member2 = ?) AND member1 != 0";

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, member);
      preparedStatement.setInt(2, member);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          System.out.println("counttttttttttt" + resultSet.getInt("COUNT(Id)"));
          return resultSet.getInt("COUNT(Id)");
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "ChatroomDaoImpl_JDBC類別#queryCountForMakeFriendByUserId()發生例外: " + ex.getMessage());
    }
    return 0;
  }

  @Override
  public void insertChatroom(
      String type, int member1, int member2, String createTime, String closeTime) {
    String sql =
        "INSERT INTO chatroom "
            + "(Chat_type,Member1,Member2,Create_Time,Close_Time,IsOpen) "
            + "VALUE (?,?,?,?,?,?)";
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

  public String queryChatroomNameById(int chatroomId) {
    String sql = "SELECT CONCAT(member1,\"_\",member2) chatroomName FROM chatroom WHERE Id = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, chatroomId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return resultSet.getString("chatroomName");
        }
        return "";
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public void updateCloseTime(int roomId, int day) {
    var localDateTime = LocalDateTime.now();
    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    String newCloseTime;
    System.out.println("day ==== " + day);
    newCloseTime = dateTimeFormatter.format(localDateTime.plusDays(day));
    System.out.println(newCloseTime);
    String sql = "UPDATE chatroom SET Close_Time = ?,IsOpen = 0 WHERE Id = ? ";

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, newCloseTime);
      preparedStatement.setInt(2, roomId);
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "ChatroomDaoImpl_JDBC類別#updateCloseTime()發生例外: " + ex.getMessage());
    }
  }

  public class ExistChatroomBean {
    Integer id;
    String chatType;
    Timestamp closeTime;
    Integer userId;
    Integer targetId;

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getChatType() {
      return chatType;
    }

    public void setChatType(String chatType) {
      this.chatType = chatType;
    }

    public Timestamp getCloseTime() {
      return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
      this.closeTime = closeTime;
    }

    public Integer getUserId() {
      return userId;
    }

    public void setUserId(Integer userId) {
      this.userId = userId;
    }

    public Integer getTargetId() {
      return targetId;
    }

    public void setTargetId(Integer targetId) {
      this.targetId = targetId;
    }
  }
}
