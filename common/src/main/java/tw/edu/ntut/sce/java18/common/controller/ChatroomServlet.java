package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;
import tw.edu.ntut.sce.java18.common.service.ChatMessageService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService.LoadChatroom;

// @WebServlet("/common/ChatroomServlet")
public class ChatroomServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String callFrom = request.getParameter("callFrom");

    switch (callFrom) {
      case "loadChatroomList":
        loadChatroomList(request, response);
        break;
      case ("loadOldMessage"):
        loadOldMessage(request, response);
        break;
      case ("changeReadCount"):
        changeReadCount(request);
        break;
      case ("changeCloseTime"):
        changeCloseTime(request);
        break;
      case ("createChatroom"):
        createChatroom(request);
        break;
      case ("getAllUnReadCount"):
        getAllUnReadCount(request, response);
        break;
    }
  }

  private void createChatroom(HttpServletRequest request) {
    // todo
    int userId = Integer.parseInt(request.getParameter("Id"));
    int chatTarget = Integer.parseInt(request.getParameter("chatTarget"));
    String chatType = request.getParameter("chatType");

    int memberS = userId;
    int memberL = chatTarget;

    if (userId > chatTarget) {
      memberL = userId;
      memberS = chatTarget;
    }

    var chatroom = new ChatroomService();
    if (chatroom.isExist(memberS, memberL, chatType)) {
      System.out.println("this chatroom is exist");
    } else {
      System.out.println("ready to create new chatroom");
      chatroom.createChatroom(chatType, memberS, memberL);

      var chatMessageService = new ChatMessageService();
      ChatMessageServiceBean message = new ChatMessageServiceBean();
      String content;
      message.setReceiver(userId);

      switch (chatType) {
        case "B":
          message.setSender(0);
          String userName = request.getParameter("userName");
          String timePick = request.getParameter("timePick");
          String floor = request.getParameter("floor");
          String selectDate = request.getParameter("selectDate");
          String roomType = request.getParameter("roomType");
          content =
              userName
                  + " 同學您好，已收到您的預約通知。\n您所預約的時段如下 : "
                  + selectDate
                  + "  "
                  + timePick
                  + " 。\n您所預約的房型為 : "
                  + roomType
                  + " 的 "
                  + floor
                  + " 。\n"
                  + "(備註：本物業可視現場狀況進行調整所帶看房間)。";
          break;
        case "R":
          message.setSender(0);
          content = "同學你好已收到您的報修通知。";
          break;
        case "F":
          message.setSender(chatTarget);
          content = "系統：已為您開啟聊聊功能(僅本訊息為由系統主動發送。)";
          break;
        default:
          content = "";
          break;
      }
      message.setContent(content);
      chatMessageService.createMessage(message);
      System.out.println("new chatroom  : " + memberS + "_" + memberL + " is created");
    }
  }

  public void loadChatroomList(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    // todo 將房號寫到bean裡面
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    // 進入畫面就load出左側頁面所需的內容
    ChatroomService chatroomService = new ChatroomService();
    chatroomService.checkOpenState();
    String id = request.getParameter("Id");
    List<LoadChatroom> chatroomLastMessage =
        chatroomService.getChatroomLastInfo(Integer.parseInt(id));

    Gson gson = new Gson();
    String chatroomList = gson.toJson(chatroomLastMessage);

    printWriter.print(chatroomList);
    printWriter.flush();
  }

  public void loadOldMessage(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    ChatroomService chatroom = new ChatroomService();
    int user = Integer.parseInt(request.getParameter("user"));
    int target = Integer.parseInt(request.getParameter("target"));
    String chatroomName;
    if (user < target) {
      chatroomName = user + "_" + target;
    } else {
      chatroomName = target + "_" + user;
    }
    System.out.println(chatroomName);
    ChatMessageService chatMessageService = new ChatMessageService();
    ArrayList<ChatMessageServiceBean> allMessageList;

    allMessageList = chatMessageService.getAllMessage(chatroom.getChatroomId(chatroomName));

    Gson gson = new Gson();
    String result = gson.toJson(allMessageList);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    printWriter.print(result);
    printWriter.flush();
  }

  public void changeReadCount(HttpServletRequest request) {
    ChatMessageService chatMessageService = new ChatMessageService();

    int userId = Integer.parseInt(request.getParameter("userId"));
    int targetId = Integer.parseInt(request.getParameter("targetId"));
    String chatType = request.getParameter("chatType");

    String chatroomName = userId + "_" + targetId;
    if (userId > targetId) {
      chatroomName = targetId + "_" + userId;
    }

    int roomId = new ChatroomService().getChatroomId(chatroomName, chatType);

    chatMessageService.changeReadStatus(roomId, userId);
  }

  public void changeCloseTime(HttpServletRequest request) {
    int roomId = Integer.parseInt(request.getParameter("roomId"));
    int additionalTime =
        Integer.parseInt(
            request.getParameter("additionalTime")); // todo 型態待確定,手動直接關閉=0  or 延長時間=n>0
    System.out.println("roomId = " + roomId + ";   additionalTime = " + additionalTime);
    new ChatroomService().changeCloseTime(roomId, additionalTime);
  }

  public int getAllUnReadCount(HttpServletRequest request, HttpServletResponse response) {
    int userId = Integer.parseInt(request.getParameter("userId"));
    return new ChatMessageService().getAllUnreadCount(userId);
    // todo  要加到nav上
  }
}
