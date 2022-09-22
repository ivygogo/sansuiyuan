package tw.edu.ntut.sce.java18.tenant.findFriend.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tw.edu.ntut.sce.java18.tenant.findFriend.model.FriendBean;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.FindFriendService;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.impl.FindFriendServiceImpl;

@WebServlet("/FindFriendServlet")
public class FindFriendServlet extends HttpServlet {
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
    System.out.println("callFrom --- " + callFrom + " ---");
    switch (callFrom) {
      case "checkOpen":
        System.out.println("aaaaaaaaaaaaa");
        boolean result = checkOpen(request, response);
        response.setContentType("text/plain; charset=UTF-8");
        var printWriter = response.getWriter();
        printWriter.print(result);
        printWriter.flush();
        break;
      case "changeStage":
        changeStage(request, response);
        break;
      case "loadSelectedList":
        System.out.println("++++++");
        loadSelectedList(request, response);
        break;
      case "loadAllList":
        loadAllList(request, response);
        break;
      case "makePair":
        System.out.println("inside the Make");
        makePair(request, response);
        break;
    }
  }

  public boolean checkOpen(HttpServletRequest request, HttpServletResponse response) {
    int userId = Integer.parseInt(request.getParameter("userId"));
    //    ServletContext sc = getServletContext();
    //    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
    //    var findFriendService = ctx.getBean(FindFriendServiceImpl.class);
    FindFriendService findFriendService = new FindFriendServiceImpl();
    return findFriendService.checkOpen(userId);
  }

  public FriendBean loadSelectedList(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    FindFriendService findFriendService = new FindFriendServiceImpl();

    Gson gson = new Gson();
    String result = gson.toJson(findFriendService.getAllSignatureAndFavor());

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    printWriter.print(result);
    printWriter.flush();

    return null;
  }

  public void changeStage(HttpServletRequest request, HttpServletResponse response) {
    int userId = Integer.parseInt(request.getParameter("userId"));
    boolean stage = Boolean.parseBoolean(request.getParameter("stage"));
    FindFriendServiceImpl findFriendService = new FindFriendServiceImpl();
    findFriendService.updateOpenStage(userId, stage);
    // todo 所有已開啟的F聊天室關閉
  }

  public void loadAllList(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    FindFriendServletConvert convert = new FindFriendServletConvert();
    int userId = Integer.parseInt(request.getParameter("userId"));

    Gson gson = new Gson();
    String result = gson.toJson(convert.getFriendBeanList(userId));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    var printWriter = response.getWriter();

    printWriter.print(result);
    printWriter.flush();
  }

  public boolean makePair(HttpServletRequest request, HttpServletResponse response) {

    int userId = Integer.parseInt(request.getParameter("userId"));
    int targetId = Integer.parseInt(request.getParameter("targetId"));
    FindFriendServiceImpl findFriendService = new FindFriendServiceImpl();

    if (findFriendService.isbelowLimit(userId)) {
      findFriendService.createChatroom(userId, targetId);
      return true;
    } else {
      return false; // todo 要去call list給人刪除
    }
  }
}
