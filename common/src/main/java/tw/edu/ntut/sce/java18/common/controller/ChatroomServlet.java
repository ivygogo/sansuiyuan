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
import tw.edu.ntut.sce.java18.common.model.ChatMessageServiceBean;
import tw.edu.ntut.sce.java18.common.service.ChatMessageService;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;

// @Controller
@WebServlet("/common/ChatroomServlet")
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

    System.out.println("--------------------");

    String callFrom = request.getParameter("callFrom");
    System.out.println(callFrom);

    if (callFrom.equals("loadChatroomList")) {
      loadChatroomList(request, response);
    } else if (callFrom.equals(("loadOldMessage"))) {
      System.out.println("inside the call form loadOldMessage");
      loadOldMessage(request, response);
    }
  }

  public void loadChatroomList(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    System.out.println("begin loadChatroomList()");

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    // 進入畫面就load出左側頁面所需的內容
    ChatroomServletConvert convert = new ChatroomServletConvert();
    String id = request.getParameter("Id"); // from JS loadExistChatroom()  =7

    List chatroomLastMessage = convert.getChatroomLastMessage(Integer.parseInt(id));

    Gson gson = new Gson();
    String lastMessage = gson.toJson(chatroomLastMessage);

    printWriter.print(lastMessage);
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
}
