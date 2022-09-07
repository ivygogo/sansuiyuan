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
      throws ServletException, IOException {

    String callFrom = request.getParameter("callFrom");

    if (callFrom.equals("loadChatroomList")) {
      loadChatroomList(request, response);
    } else if (callFrom.equals(("loadOldMessage"))) {
      loadOldMessage(request, response);
    } else if (callFrom.equals(("changeReadCount"))) {
      changeReadCount(request, response);
    } else if (callFrom.equals(("changerClosetime"))) {
      changeCloseTime(request, response);
    }
  }

  public void loadChatroomList(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    // 進入畫面就load出左側頁面所需的內容
    ChatroomServletConvert convert = new ChatroomServletConvert();
    String id = request.getParameter("Id"); // from JS loadExistChatroom()  =7
    List chatroomLastMessage = convert.getChatroomLastMessage(Integer.parseInt(id));

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

  public void changeReadCount(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    ChatMessageService chatMessageService = new ChatMessageService();

    int userId = Integer.parseInt(request.getParameter("userId"));
    int targetId = Integer.parseInt(request.getParameter("targetId"));

    String chatroomName = userId + "_" + targetId;
    if (userId > targetId) {
      chatroomName = targetId + "_" + userId;
    }

    int roomId = new ChatroomService().getChatroomId(chatroomName);

    chatMessageService.changeReadStatus(roomId, userId);
  }

  public void changeCloseTime(HttpServletRequest request, HttpServletResponse response)
      throws IOException {}
}
