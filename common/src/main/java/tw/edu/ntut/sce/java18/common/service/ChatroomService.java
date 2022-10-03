package tw.edu.ntut.sce.java18.common.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import tw.edu.ntut.sce.java18.common.dao.AvatarDao;
import tw.edu.ntut.sce.java18.common.dao.CharacterAndFavorDao;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.dao.MemberDao;
import tw.edu.ntut.sce.java18.common.dao.TenantDao;
import tw.edu.ntut.sce.java18.common.dao.impl.AvatarDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.CharacterAndFavorDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC.ExistChatroomBean;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_jdbc;
import tw.edu.ntut.sce.java18.common.dao.impl.TenantDaoImpl;

public class ChatroomService {
  ChatroomDao chatroomDao;
  MemberDao memberDao;
  AvatarDao avatarDao;
  CharacterAndFavorDao characterAndFavorDao;

  TenantDao tenantDao;

  public ChatroomService() {
    chatroomDao = new ChatroomDaoImpl_JDBC();
    memberDao = new MemberDaoImpl_jdbc();
    avatarDao = new AvatarDaoImpl();
    characterAndFavorDao = new CharacterAndFavorDaoImpl();
    tenantDao = new TenantDaoImpl();
  }

  public ArrayList<LoadChatroom> getChatroomLastInfo(int userId) {

    var chatMessageService = new ChatMessageService();
    var chatroomListWithLastMessage = new ArrayList<LoadChatroom>();

    var currentTime = new Timestamp(System.currentTimeMillis());
    var existChatroomList = new ChatroomService().getExistChatroom(userId);

    for (var existChatroom : existChatroomList) {
      var sdf = new SimpleDateFormat("MM/dd");

      var chatMessageBean = chatMessageService.getLastMessage(existChatroom.getId());
      var loadChatroom = new LoadChatroom();
      //      var memberInfo = memberDao.queryMemberByPrimaryKey(existChatroom.getUserId());
      var memberInfo = memberDao.queryMemberByPrimaryKey(existChatroom.getTargetId());

      if (existChatroom.getTargetId() != 0) {
        var avatarInfo = avatarDao.queryAvatarByPrimaryKey(memberInfo.getPic());

        loadChatroom.setTargetNickName(memberInfo.getNickname());
        loadChatroom.setAvatarPic(avatarInfo.getAvatarName());

        var tenantString = tenantDao.getRoomNumberByMemberId(memberInfo.getuId());
        if ("非租客".equals(tenantString)) {
          loadChatroom.setIdentity("非租客"); // todo 從contract?tenant?
        } else {
          loadChatroom.setIdentity("租客");
        }

        if (userId != 0) {
          if (memberInfo.getOpen_tag() == 1) {
            if ((memberInfo.getFavor_1() == 0)
                && (memberInfo.getFavor_2() == 0)
                && (memberInfo.getFavor_3() == 0)) {
              loadChatroom.setMoreInfo("無");

            } else {
              String character = "";
              if (memberInfo.getFavor_1() != 0) {
                character +=
                    "  "
                        + characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
                            memberInfo.getFavor_1());
              }
              if (memberInfo.getFavor_2() != 0) {
                character +=
                    "/"
                        + characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
                            memberInfo.getFavor_2());
              }
              if (memberInfo.getFavor_3() != 0) {
                character +=
                    "/"
                        + characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
                            memberInfo.getFavor_3());
              }
              loadChatroom.setMoreInfo(character);
            }
          } else {
            loadChatroom.setMoreInfo("　");
          }
        } else {
          var tenantInfo = tenantDao.getRoomNumberByMemberId((memberInfo.getuId()));
          if ("非租客".equals(tenantString)) {
            loadChatroom.setMoreInfo("無"); // todo 從contract?tenant?
          } else {
            loadChatroom.setIdentity("租客");
            loadChatroom.setMoreInfo(tenantInfo); // todo 從contract?tenant?
          }
        }
      } else {
        loadChatroom.setTargetNickName("房東");
        loadChatroom.setAvatarPic("default.png");
        loadChatroom.setIdentity("管理員");
        loadChatroom.setMoreInfo(null);
      }

      loadChatroom.setChatroomId(existChatroom.getId());
      loadChatroom.setChatroomType(existChatroom.getChatType());
      loadChatroom.setCloseTime(sdf.format(existChatroom.getCloseTime()));
      loadChatroom.setTarget(existChatroom.getTargetId());
      loadChatroom.setContent(chatMessageBean.getContent());
      loadChatroom.setReceiver(chatMessageBean.getReceiver());
      loadChatroom.setSender(chatMessageBean.getSender());
      loadChatroom.setChatroomName(
          new ChatroomService().getChatroomName(loadChatroom.getChatroomId()));
      loadChatroom.setOpen(currentTime.before(existChatroom.getCloseTime()));
      loadChatroom.setUnRead(
          chatMessageService.getUnreadCount(loadChatroom.getChatroomId(), userId));
      loadChatroom.setSendTime(chatMessageBean.getSendTime());
      chatroomListWithLastMessage.add(loadChatroom);
    }

    chatroomListWithLastMessage.forEach(e -> System.out.println(e.chatroomName));
    chatroomListWithLastMessage.forEach(e -> System.out.println(e.content));

    if (chatroomListWithLastMessage != null || chatroomListWithLastMessage.size() > 1) {
      Collections.sort(
          chatroomListWithLastMessage,
          (o1, o2) -> {
            if (o1.getSendTime().before(o2.getSendTime())
                || o1.getSendTime().equals(o2.getSendTime())) return 1;
            else return -1;
          });
    }
    return chatroomListWithLastMessage;
  }

  public boolean isExist(int member1, int member2, String chatroomType) {
    if (chatroomDao.queryIdByChatroomName(member1 + "_" + member2, chatroomType) != -1) {
      return true;
    }
    return false;
  }

  public void createChatroom(String type, int member1, int member2) {
    var localDateTime = LocalDateTime.now();
    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    int n;
    if ("B".equals(type)) {
      n = 14;
    } else {
      n = 365;
    }
    var ldtCloseTime = localDateTime.plusDays(n);
    var createTime = localDateTime.format(dateTimeFormatter);
    var closeTime = ldtCloseTime.format(dateTimeFormatter);

    chatroomDao.insertChatroom(type, member1, member2, createTime, closeTime);
  }

  public int getChatroomId(String chatroomName, String chatType) {
    return chatroomDao.queryIdByChatroomName(chatroomName, chatType);
  }

  public int getChatroomIdByUserId(int userId, String chatType) {
    String chatroomName = "0_" + userId;
    return chatroomDao.queryIdByChatroomName(chatroomName, chatType);
  }

  public int getChatroomId(String chatroomName) {
    return chatroomDao.queryIdByChatroomName(chatroomName);
  }

  public String getChatroomName(int roomId) {
    return chatroomDao.queryChatroomNameById(roomId);
  }

  // TODO 登入時就要連到自己的聊天室???>

  public ArrayList<ExistChatroomBean> getExistChatroom(int id) {
    return chatroomDao.queryExistChatroomByUser(id);
  }

  public void changeCloseTime(int roomId, int time) {
    chatroomDao.updateCloseTime(roomId, time);
  }

  public void checkOpenState() {
    chatroomDao.updateOpenState();
  }

  public class LoadChatroom {
    int chatroomId;
    String chatroomType;
    String chatroomName;
    String closeTime;
    Timestamp sendTime;
    int target;
    int sender;
    int receiver;
    String content;
    int unRead;
    boolean isOpen;
    String targetNickName;
    String avatarPic;
    String identity;
    String moreInfo;

    public Timestamp getSendTime() {
      return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
      this.sendTime = sendTime;
    }

    public String getMoreInfo() {
      return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
      this.moreInfo = moreInfo;
    }

    public String getTargetNickName() {
      return targetNickName;
    }

    public void setTargetNickName(String targetNickName) {
      this.targetNickName = targetNickName;
    }

    public String getAvatarPic() {
      return avatarPic;
    }

    public void setAvatarPic(String avatarPic) {
      this.avatarPic = avatarPic;
    }

    public String getIdentity() {
      return identity;
    }

    public void setIdentity(String identity) {
      this.identity = identity;
    }

    public boolean isOpen() {
      return isOpen;
    }

    public void setOpen(boolean open) {
      isOpen = open;
    }

    public int getChatroomId() {
      return chatroomId;
    }

    public void setChatroomId(int chatroomId) {
      this.chatroomId = chatroomId;
    }

    public String getChatroomName() {
      return chatroomName;
    }

    public void setChatroomName(String chatroomName) {
      this.chatroomName = chatroomName;
    }

    public String getChatroomType() {
      return chatroomType;
    }

    public void setChatroomType(String chatroomType) {
      this.chatroomType = chatroomType;
    }

    public String getCloseTime() {
      return closeTime;
    }

    public void setCloseTime(String closeTime) {
      this.closeTime = closeTime;
    }

    public int getSender() {
      return sender;
    }

    public void setSender(int sender) {
      this.sender = sender;
    }

    public int getReceiver() {
      return receiver;
    }

    public void setReceiver(int receiver) {
      this.receiver = receiver;
    }

    public int getTarget() {
      return target;
    }

    public void setTarget(int target) {
      this.target = target;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public int getUnRead() {
      return unRead;
    }

    public void setUnRead(int unRead) {
      this.unRead = unRead;
    }
  }
}
