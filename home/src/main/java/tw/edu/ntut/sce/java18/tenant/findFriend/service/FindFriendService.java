package tw.edu.ntut.sce.java18.tenant.findFriend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tw.edu.ntut.sce.java18.tenant.findFriend.model.FriendBean;

public interface FindFriendService {

  boolean checkOpen(int userId);

  boolean isBelowLimit(int userId);

  Map<String, List<String>> getAllSignatureAndFavor();

  List<Integer> getAllFindingFriendId();

  // 用來隱藏已經配對的那幾個人
  ArrayList<Integer> getExistTarget(int userId);

  FriendBean getPersonalFriendInfo(int userId);

  void closeChatroom(int roomID);

  void createChatroom(int userId, int targetId);

  void updateOpenStage(int userId, boolean isOpen);
}
