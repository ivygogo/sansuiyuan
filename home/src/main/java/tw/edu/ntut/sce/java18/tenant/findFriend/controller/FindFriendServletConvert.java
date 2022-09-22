package tw.edu.ntut.sce.java18.tenant.findFriend.controller;

import java.util.ArrayList;
import java.util.List;
import tw.edu.ntut.sce.java18.tenant.findFriend.model.FriendBean;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.FindFriendService;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.impl.FindFriendServiceImpl;

public class FindFriendServletConvert {

  FindFriendService friendService;

  public FindFriendServletConvert() {
    friendService = new FindFriendServiceImpl();
  }

  public List<FriendBean> getFriendBeanList(int userId) {
    List<FriendBean> friendBeanList = new ArrayList<>();
    System.out.println("FindFriendServletConvert . convert  begin");
    var idList = friendService.getAllFindingFriendId();
    System.out.println("FindFriendServletConvert . after  friendService.getAllFindingFriendId()");
    idList.remove(Integer.valueOf(userId));
    idList.stream().forEach(e -> friendBeanList.add(friendService.getPersonalFriendInfo(e)));
    System.out.println("FindFriendServletConvert . convert  finish");
    return friendBeanList;
  }
}
