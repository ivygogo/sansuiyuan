package tw.edu.ntut.sce.java18.tenant.findFriend.controller;

import java.util.ArrayList;
import java.util.List;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
import tw.edu.ntut.sce.java18.tenant.findFriend.model.FriendBean;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.FindFriendService;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.impl.FindFriendServiceImpl;

public class FindFriendServletConvert {

  FindFriendService friendService;
  ChatroomService chatroomService;

  public FindFriendServletConvert() {
    friendService = new FindFriendServiceImpl();
    chatroomService = new ChatroomService();
  }

  public List<FriendBean> getFriendBeanList(int userId) {
    List<FriendBean> friendBeanList = new ArrayList<>();
    var idList = friendService.getAllFindingFriendId();
    ArrayList<Integer> deleteList = new ArrayList<>();
    deleteList.add(userId);
    chatroomService.getExistChatroom(userId).stream()
        .forEach(
            e -> {
              if (e.getUserId() != userId) {
                deleteList.add(e.getUserId());
              } else deleteList.add(e.getTargetId());
            });
    //    idList.remove(Integer.valueOf(userId));

    System.out.println("------------ deletelist");
    deleteList.forEach(e -> System.out.println(e));
    System.out.println("------------");

    deleteList.forEach(e -> idList.remove(Integer.valueOf(e)));

    System.out.println("------------ idlist");
    idList.forEach(e -> System.out.println(e));
    System.out.println("------------");

    idList.stream().forEach(e -> friendBeanList.add(friendService.getPersonalFriendInfo(e)));
    return friendBeanList;
  }
}
