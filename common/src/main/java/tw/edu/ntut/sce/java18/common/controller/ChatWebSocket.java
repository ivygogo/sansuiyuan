package tw.edu.ntut.sce.java18.common.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;
import tw.edu.ntut.sce.java18.common.service.ChatMessageService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
import tw.edu.ntut.sce.java18.common.utils.MessageDecoder;
import tw.edu.ntut.sce.java18.common.utils.MessageEncoder;

@ServerEndpoint(
    value = "/chat/{chatroomName}",
    decoders = MessageDecoder.class,
    encoders = MessageEncoder.class)
public class ChatWebSocket {
  private Session session;
  private static final Map<String, Map<String, ChatWebSocket>> clients = new HashMap<>();
  private static final Map<String, ChatWebSocket> webSocketMap = new HashMap<>();

  @OnOpen
  public void onOpen(Session session, @PathParam("chatroomName") String chatroomName)
      throws IOException, EncodeException {
    this.session = session;

    System.out.println("WebSocket is Connected!");

    String type = "B"; // TODO 先寫死之後要從登入資料帶

    webSocketMap.put(chatroomName.split("_")[0], this);
    //    clients.computeIfAbsent(chatroomName, k -> new HashSet<>()).add(this);

    var member1 = Integer.parseInt(chatroomName.split("_")[0]);
    var member2 = Integer.parseInt(chatroomName.split("_")[1]);

    int memberS = member1;
    int memberL = member2;

    if (member1 > member2) {
      memberL = member1;
      memberS = member2;
    }

    String username = memberS + "_" + memberL;
    System.out.println(member1);
    System.out.println(member2);

    clients.put(username, webSocketMap);

    var chatroom = new ChatroomService();
    // 這段之後會抽出去
    if (chatroom.isExist(memberS, memberL) != -1) {
      System.out.println("this chatroom is exist");
    } else {
      System.out.println("ready to create new chatroom");
      chatroom.createChatroom(type, memberS, memberL);
      System.out.println("new chatroom " + memberS + "_" + memberL + " is created");
    }
  }

  @OnMessage
  public void onMessage(Session session, ChatMessageServiceBean message) {
    var chatMessageService = new ChatMessageService();
    chatMessageService.createMessage(message);

    String chatroomName;
    if (message.getSender() > message.getReceiver()) {
      chatroomName = message.getReceiver() + "_" + message.getSender();
    } else {
      chatroomName = message.getSender() + "_" + message.getReceiver();
    }
    sendTo(message, chatroomName);
  }

  @OnClose
  public void onClose(Session session) {
    clients.remove("chatroomName"); // TODO 似乎關不起來?
    System.out.println("WebSocket is Closed!");
    System.out.println("WebSocket is Closed!");
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    System.out.println(clients.remove("user")); // TODO 似乎關不起來  但確認?
    System.out.println("WebSocket was disconnect with some error !!!!!!!!!!!!!!!!");
    System.out.println("WebSocket was disconnect with some error !!!!!!!!!!!!!!!!");
    System.out.println("WebSocket was disconnect with some error !!!!!!!!!!!!!!!!");
  }

  private static void sendTo(ChatMessageServiceBean message, String chatroomName) {
    var chatWebSockets = clients.get(chatroomName);

    if (chatWebSockets != null) {
      try {
        if (chatWebSockets.get(chatroomName.split("_")[0]) != null) {
          chatWebSockets
              .get(chatroomName.split("_")[0])
              .session
              .getBasicRemote()
              .sendObject(message);
        }
        if (chatWebSockets.get(chatroomName.split("_")[1]) != null) {
          chatWebSockets
              .get(chatroomName.split("_")[1])
              .session
              .getBasicRemote()
              .sendObject(message);
        }
      } catch (IOException | EncodeException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
