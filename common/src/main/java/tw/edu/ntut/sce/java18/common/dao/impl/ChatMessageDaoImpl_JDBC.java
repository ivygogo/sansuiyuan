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
import tw.edu.ntut.sce.java18.common.dao.ChatMessageDao;
import tw.edu.ntut.sce.java18.common.model.ChatMessageBean;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class ChatMessageDaoImpl_JDBC implements ChatMessageDao {

  private final DataSource ds;

  public ChatMessageDaoImpl_JDBC() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別 #建構子發生例外: " + ex.getMessage());
    }
  }

  @Override
  public void insertMessage(ChatMessageServiceBean message) {

    String sql =
        "INSERT INTO chat_message "
            + "(Chatroom_Id,Sender,Receiver,Content,Send_time,isRead) "
            + "VALUE (?,?,?,?,?,?)";

    var ldtCreateTime = LocalDateTime.now();
    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    var createTime = ldtCreateTime.format(dateTimeFormatter);

    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

      preparedStatement.setInt(1, message.getRoomId());
      preparedStatement.setInt(2, message.getSender());
      preparedStatement.setInt(3, message.getReceiver());
      preparedStatement.setString(4, message.getContent());
      preparedStatement.setString(5, createTime);
      preparedStatement.setBoolean(6, false);

      preparedStatement.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatMessageImpl_JDBC類別#insertMessage()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public ArrayList<ChatMessageBean> queryHistoryMessage(int chatroomId) {
    var chatMessageList = new ArrayList<ChatMessageBean>();
    String sql = "SELECT * FROM chat_message WHERE Chatroom_Id = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, chatroomId);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          ChatMessageBean chatMessageBean = new ChatMessageBean();
          chatMessageBean.setSender(resultSet.getInt("Sender"));
          chatMessageBean.setReceiver(resultSet.getInt("Receiver"));
          chatMessageBean.setContent(resultSet.getString("Content"));
          chatMessageBean.setSendTime(resultSet.getTimestamp("Send_Time"));
          chatMessageBean.setRead(resultSet.getBoolean("isRead"));
          chatMessageList.add(chatMessageBean);
        }
        return chatMessageList;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
  }

  public int queryUnreadCount(int chatroomId, int userId) {
    String sql =
        "SELECT COUNT(*) FROM chat_message WHERE chatroom_Id = ? "
            + "AND isRead = FALSE And Receiver = ?";

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, chatroomId);
      preparedStatement.setInt(2, userId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          int unReadCount = resultSet.getInt("COUNT(*)");
          return unReadCount;
        }
        return 0;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "ChatroomDaoImpl_JDBC類別#queryUnreadCount()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public void updateUnReadStatus(int roomId, int userId) {
    String sql =
        "UPDATE chat_message SET isRead = 1 WHERE chatroom_Id = ? AND isRead = FALSE AND Receiver  = ?";

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, roomId);
      preparedStatement.setInt(2, userId);
      preparedStatement.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "ChatroomDaoImpl_JDBC類別#updateUnReadStatus()發生例外: " + ex.getMessage());
    }
  }

  @Override
  public ChatMessageBean queryLastMessage(int chatroomId) {
    ChatMessageBean chatMessageBean = new ChatMessageBean();

    String sql =
        "SELECT Sender, Receiver, Content, Send_Time FROM  chat_message WHERE Chatroom_Id = ? ORDER BY id DESC LIMIT 1";

    try (Connection connection = ds.getConnection();
        var preparedStatement = connection.prepareStatement(sql)) {

      preparedStatement.setInt(1, chatroomId);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          chatMessageBean.setSender(resultSet.getInt("Sender"));
          chatMessageBean.setReceiver(resultSet.getInt("Receiver"));
          chatMessageBean.setContent(resultSet.getString("Content"));
          chatMessageBean.setSendTime(resultSet.getTimestamp("Send_Time"));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("ChatroomDaoImpl_JDBC類別#queryRoomType()發生例外: " + ex.getMessage());
    }
    return chatMessageBean;
  }
}
