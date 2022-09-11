package tw.edu.ntut.sce.java18.common.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import tw.edu.ntut.sce.java18.common.dao.impl.AvatarDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.CharacterAndFavorDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_jdbc;
import tw.edu.ntut.sce.java18.common.service.ChatMessageService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;

public class ChatroomServletConvert {

  public ArrayList<LoadChatroom> getChatroomLastInfo(int userId) {

    var chatroomService = new ChatroomService();
    var chatMessageService = new ChatMessageService();
    var chatroomListWithLastMessage = new ArrayList<LoadChatroom>();

    Timestamp currentTime = new Timestamp(System.currentTimeMillis());

    var existChatroomList = chatroomService.getExistChatroom(userId);

    for (ArrayList existChatroom : existChatroomList) {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
      var chatMessageBean = chatMessageService.getLastMessage((int) existChatroom.get(0));

      LoadChatroom loadChatroom = new LoadChatroom();

      var memberInfo = new MemberDaoImpl_jdbc().queryMemberByPrimaryKey((int) existChatroom.get(3));

      loadChatroom.setIdentity("????"); // todo 從contract?tenant?
      loadChatroom.setMoreInfo("");

      if ((int) existChatroom.get(3) != 0) {
        var avatarInfo = new AvatarDaoImpl().queryAvatarByPrimaryKey(memberInfo.getPic());
        loadChatroom.setTargetNickName(memberInfo.getNickname());
        loadChatroom.setAvatarPic(avatarInfo.getAvatarName());

        if (userId != 0) {
          var characterInfo = new CharacterAndFavorDaoImpl();

          if (memberInfo.getOpen_tag() == 1) {
            if ((memberInfo.getFavor_1() == null)
                && (memberInfo.getFavor_2() == null)
                && (memberInfo.getFavor_3() == null)) {
              loadChatroom.setMoreInfo(null);
            } else {
              String character = "";
              if (memberInfo.getFavor_1() != null) {
                character +=
                    "  "
                        + characterInfo.queryCharacterAndFavorNameByPrimaryKey(
                            memberInfo.getFavor_1());
              }
              if (memberInfo.getFavor_2() != null) {
                character +=
                    "/"
                        + characterInfo.queryCharacterAndFavorNameByPrimaryKey(
                            memberInfo.getFavor_2());
              }
              if (memberInfo.getFavor_3() != null) {
                character +=
                    "/"
                        + characterInfo.queryCharacterAndFavorNameByPrimaryKey(
                            memberInfo.getFavor_3());
              }
              loadChatroom.setMoreInfo(character);
            }
          } else {
            loadChatroom.setMoreInfo(null);
          }
        } else {
          if (true) { //  判斷有沒有沒有房號的話
            loadChatroom.setMoreInfo("roomNum"); // todo form tenant or contract
          } else {
            loadChatroom.setMoreInfo(null); // todo form tenant or contract

            //            loadChatroom.setMoreInfo(null);
          }
        }
      } else {
        loadChatroom.setTargetNickName("房東");
        loadChatroom.setAvatarPic("default.png");
        loadChatroom.setIdentity("管理員");
        loadChatroom.setMoreInfo(null);
      }

      loadChatroom.setChatroomId((int) existChatroom.get(0));
      loadChatroom.setChatroomType((String) existChatroom.get(1));
      loadChatroom.setCloseTime(sdf.format(existChatroom.get(2)));
      loadChatroom.setTarget((int) existChatroom.get(3));
      loadChatroom.setContent(chatMessageBean.getContent());
      loadChatroom.setReceiver(chatMessageBean.getReceiver());
      loadChatroom.setSender(chatMessageBean.getSender());
      loadChatroom.setChatroomName(chatroomService.getChatroomName(loadChatroom.getChatroomId()));
      loadChatroom.setOpen(currentTime.before((Timestamp) existChatroom.get(2)));
      loadChatroom.setUnRead(
          chatMessageService.getUnreadCount(loadChatroom.getChatroomId(), userId));
      loadChatroom.setSendTime(chatMessageBean.getSendTime());

      chatroomListWithLastMessage.add(loadChatroom);
    }
    Collections.sort(
        chatroomListWithLastMessage,
        (o1, o2) -> {
          if (o1.getSendTime().before(o2.getSendTime())) return 1;
          else return -1;
        });
    return chatroomListWithLastMessage;
  }

  class LoadChatroom {
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
