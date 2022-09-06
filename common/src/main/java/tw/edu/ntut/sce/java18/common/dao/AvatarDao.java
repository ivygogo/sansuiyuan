package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.AvatarBean;

public interface AvatarDao {

  boolean checkAvatarIdExists(int id);

  int saveAvatar(AvatarBean avatar); // 要修改

  AvatarBean queryAvatarByPrimaryKey(int id); // 要修改

  int queryAvatarIdByName(String avatarName); // queryAvatarIdByName

  List<String> queryAvatarNameByGender(int genderId); // queryAvatarNameByName
}
