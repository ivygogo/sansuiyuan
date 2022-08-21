package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import java.util.List;
import tw.edu.ntut.sce.java18.common.model.AvatarBean;

public interface AvatarDao {

  boolean idExists(int uid);

  int saveAvatar(AvatarBean ab);

  AvatarBean queryAvatarById(int uid);

  int queryAvatarByName(String avatarName);

  List<String> queryAvatarByGender(int genderId);

  void setConnection(Connection con);
}
