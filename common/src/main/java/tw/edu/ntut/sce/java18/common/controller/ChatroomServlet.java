package tw.edu.ntut.sce.java18.common.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.service.ChatMessageService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService.LoadChatroom;

@WebServlet("/ChatroomServlet")
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

    var callFrom = request.getParameter("callFrom");

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
      case ("getSessionId"):
        getSessionId(request, response);
        break;
    }
  }

  private void getSessionId(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    HttpSession session = request.getSession();
    MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
    int userId = mb.getuId();
    var printWriter = response.getWriter();
    response.setContentType("text/plain; charset=UTF-8");
    printWriter.print(userId);
    printWriter.flush();
  }

  private void createChatroom(HttpServletRequest request) {
    HttpSession session = request.getSession();
    MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
    int userId = mb.getuId();

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
                  + " ?????????????????????????????????????????????\n??????????????????????????? : "
                  + selectDate
                  + "  "
                  + timePick
                  + " ???\n???????????????????????? : "
                  + roomType
                  + " ??? "
                  + floor
                  + " ???\n"
                  + "(???????????????????????????????????????????????????????????????)???";
          break;
        case "R":
          message.setSender(0);
          content = "??????????????????????????????????????????";
          break;
        case "F":
          message.setSender(chatTarget);
          content = "????????????????????????????????????(???????????????????????????????????????)";
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

    // todo ???????????????bean??????
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    // ???????????????load??????????????????????????????
    ChatroomService chatroomService = new ChatroomService();
    chatroomService.checkOpenState();

    HttpSession session = request.getSession();
    MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
    int id = mb.getuId();
    //    String id = request.getParameter("Id");
    List<LoadChatroom> chatroomLastMessage = chatroomService.getChatroomLastInfo(id);

    Gson gson = new Gson();
    String chatroomList = gson.toJson(chatroomLastMessage);

    printWriter.print(chatroomList);
    printWriter.flush();
  }

  public void loadOldMessage(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    ChatroomService chatroom = new ChatroomService();
    //    int user = Integer.parseInt(request.getParameter("user"));
    HttpSession session = request.getSession();
    MemberBean mb = (MemberBean) session.getAttribute("LoginOK");

    int userId = mb.getuId();

    int target = Integer.parseInt(request.getParameter("target"));
    String chatroomName;
    if (userId < target) {
      chatroomName = userId + "_" + target;
    } else {
      chatroomName = target + "_" + userId;
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

    //    int userId = Integer.parseInt(request.getParameter("userId"));
    HttpSession session = request.getSession();
    MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
    int userId = mb.getuId();

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
    int additionalTime = Integer.parseInt(request.getParameter("additionalTime"));
    System.out.println("roomId = " + roomId + ";   additionalTime = " + additionalTime);
    new ChatroomService().changeCloseTime(roomId, additionalTime);
  }

  public int getAllUnReadCount(HttpServletRequest request, HttpServletResponse response) {

    HttpSession session = request.getSession();
    MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
    int userId = mb.getuId();

    return new ChatMessageService().getAllUnreadCount(userId);
    // todo  ?????????nav???
  }
}
