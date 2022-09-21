package tw.edu.ntut.sce.java18.common.service;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberInfoService {

  int updateMemberInfo(MemberBean bean);

  MemberBean getMemberInfo(int uId);

  String getAvatar(int uId);

  int getAvatarId(String avatarName);

  String getSignature(int uId);

  String getFavor(int uId);

  String getMemberLevel(int uId);

  List<String> getMemberContract(int uId);

  String getCharacterTag(int uId);

  String getFavorTag(int uId);

  String getGenderTag(int uId);

  String getFindRoommateTag(int uId);

  String getFindAvatarTag(int uId);

  String checkIdNumber(String formValue, int genderId);

  String getAllAvatarByGender(int gender);

  MemberBean queryMemberByPrimaryKey(int uId);

  /*===Temp方法提供修改表單使用===*/

  String getCharacterTempTag(String characterTabs);

  String getFavorTempTag(String favorTabs);

  String getGenderTempTag(int gender);

  String getFindRoommateTempTag(int open_tag);

  String getFindAvatarTempTag(String avarta, int gender);

  int getSignatureId(String name);

  int getFavorId(String name);

  int getCharacterOrFavorIdByNameAndType(String name, int type); // 此方法合併getSignatureId和getFavorId方法
}
