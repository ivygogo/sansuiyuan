package tw.edu.ntut.sce.java18.common.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.impl.AvatarDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.CharacterAndFavorDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.GuarantorDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_jdbc;
import tw.edu.ntut.sce.java18.common.dao.impl.RefundAccountDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.TenantDaoImpl;
import tw.edu.ntut.sce.java18.common.model.AvatarBean;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.model.TenantBean;
import tw.edu.ntut.sce.java18.common.service.MemberInfoService;

public class MemberInfoServiceImpl implements MemberInfoService {
  MemberDaoImpl_jdbc mbDao = new MemberDaoImpl_jdbc();
  CharacterAndFavorDaoImpl cfDao = new CharacterAndFavorDaoImpl();
  AvatarDaoImpl avaDao = new AvatarDaoImpl();
  TenantDaoImpl tenantDao = new TenantDaoImpl();

  String level = "一般會員";
  String character = "";
  String favor = "";
  String avatarLink = "";
  List<String> contract;

  public MemberInfoServiceImpl() {}

  @Override
  public MemberBean getMemberInfo(int uId) {

    MemberBean member = mbDao.queryMemberByPrimaryKey(uId);
    GuarantorDaoImpl guarantorDao = new GuarantorDaoImpl();
    RefundAccountDaoImpl refundAccountDao = new RefundAccountDaoImpl();
    if (member.getSchool().trim().length() == 0) {
      member.setSchool("無");
    }
    member.setSignatureAll(getSignature(uId));
    member.setFavorStrAll(getFavor(uId));
    member.setLevel(getMemberLevel(uId));
    member.setAvatar(getAvatar(uId));
    member.setContract(getMemberContract(uId));
    member.setGuarantor(guarantorDao.queryGuarantorByMemberId(uId));
    //    member.setGuarantorList(guarantorDao.queryGuarantorByPrimaryKey(uId));
    member.setRefundAccount(refundAccountDao.queryRefundAccountByMemberId(uId));
    return member;
  }

  /*====用memberId來找個性標籤，組成字串後可以秀出字串====*/
  @Override
  public String getSignature(int uId) {

    MemberBean mb = mbDao.queryMemberByPrimaryKey(uId);
    String tab1 = "";
    String tab2 = "";
    String tab3 = "";

    if (mb.getSignature_1() == null || mb.getSignature_1() < 1) {
      tab1 = "無";
    } else {
      tab1 = cfDao.queryCharacterAndFavorNameByPrimaryKey(mb.getSignature_1());
    }

    if (mb.getSignature_2() == null || mb.getSignature_2() < 1) {
      tab2 = "無";
    } else {
      tab2 = cfDao.queryCharacterAndFavorNameByPrimaryKey(mb.getSignature_2());
    }

    if (mb.getSignature_3() == null || mb.getSignature_3() < 1) {
      tab3 = "無";
    } else {
      tab3 = cfDao.queryCharacterAndFavorNameByPrimaryKey(mb.getSignature_3());
    }

    if (tab1.equals("無") && tab2.equals("無") && tab3.equals("無")) {
      character = "無";
    }
    if (!tab1.equals("無") && tab2.equals("無") && tab3.equals("無")) {
      character = tab1;
    }
    if (!tab1.equals("無") && !tab2.equals("無") && tab3.equals("無")) {
      character = tab1 + "、" + tab2;
    }
    if (!tab1.equals("無") && !tab2.equals("無") && !tab3.equals("無")) {
      character = tab1 + "、" + tab2 + "、" + tab3;
    }

    return character;
  }

  /*====用memberId來找室友喜好，組成字串後可以秀出字串====*/
  @Override
  public String getFavor(int uId) {

    MemberBean mb = mbDao.queryMemberByPrimaryKey(uId);
    String tab1 = "";
    String tab2 = "";
    String tab3 = "";

    if (mb.getFavor_1() == null || mb.getFavor_1() < 1) {
      tab1 = "無";
    } else {
      tab1 = cfDao.queryCharacterAndFavorNameByPrimaryKey(mb.getFavor_1());
    }

    if (mb.getFavor_2() == null || mb.getFavor_2() < 1) {
      tab2 = "無";
    } else {
      tab2 = cfDao.queryCharacterAndFavorNameByPrimaryKey(mb.getFavor_2());
    }

    if (mb.getFavor_3() == null || mb.getFavor_3() < 1) {
      tab3 = "無";
    } else {
      tab3 = cfDao.queryCharacterAndFavorNameByPrimaryKey(mb.getFavor_3());
    }

    if (tab1.equals("無") && tab2.equals("無") && tab3.equals("無")) {
      favor = "無";
    }
    if (!tab1.equals("無") && tab2.equals("無") && tab3.equals("無")) {
      favor = tab1;
    }
    if (!tab1.equals("無") && !tab2.equals("無") && tab3.equals("無")) {
      favor = tab1 + "、" + tab2;
    }
    if (!tab1.equals("無") && !tab2.equals("無") && !tab3.equals("無")) {
      favor = tab1 + "、" + tab2 + "、" + tab3;
    }
    return favor;
  }

  /*====用memberId來找大頭貼====*/
  @Override
  public String getAvatar(int uId) {
    AvatarBean ab = null;

    MemberBean mb = mbDao.queryMemberByPrimaryKey(uId);

    if (avaDao.checkAvatarIdExists(mb.getPic())) {
      ab = avaDao.queryAvatarByPrimaryKey(mb.getPic());
      avatarLink = ab.getAvatarName();
    } else {
      avatarLink = "default.png";
    }

    return avatarLink;
  }

  /*====用memberId來確認會員身分====*/
  @Override
  public String getMemberLevel(int uId) {

    List<TenantBean> memContract = new ArrayList<>();
    memContract = tenantDao.getContractInfo(uId);
    Date date = new Date();
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //    String dateNow = sdf.format(date);
    //    try {
    //      date = sdf.parse(dateNow);
    //    } catch (ParseException e) {
    //      // TODO Auto-generated catch block
    //      e.printStackTrace();
    //    }

    for (int i = 0; i < memContract.size(); i++) {
      Date begin = memContract.get(i).getBegin_Time();
      Date end = memContract.get(i).getEnd_Time();

      if (date.getTime() - begin.getTime() >= 0 && end.getTime() - date.getTime() >= 0) {
        level = "租客";
        break;
      }
    }
    return level;
  }

  /*====用memberId來取得會員合約====*/
  @Override
  public List<String> getMemberContract(int uId) {
    contract = new ArrayList<>();

    List<TenantBean> memContract = new ArrayList<>();
    memContract = tenantDao.getContractInfo(uId);
    if (memContract.size() > 0) {
      for (int i = 0; i < memContract.size(); i++) {
        contract.add(memContract.get(i).getContract_Number());
      }
    } else {
      contract = null;
    }
    return contract;
  }

  /*====查詢會員資料所需用到的Tag====*/
  /*====用memberId來取得會員資料庫所存取"個性標籤"的Tag====*/
  @Override
  public String getCharacterTag(int uId) {
    String ans = "";
    int selected = -1;

    List<String> characterList = cfDao.getAllCharacter(); // 取回所有的tag
    String characterTabs = getSignature(uId);
    if (characterTabs.equals("無")) {
      for (int i = 0; i < characterList.size(); i++) {

        ans +=
            "<div class=\"form-check form-check-inline\">"
                + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myCharacter"
                + (i + 1)
                + "\" id=\"inlineCheckbox\" value=\""
                + characterList.get(i)
                + "\">"
                + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                + characterList.get(i)
                + "</label> </div>";
      }
      // System.out.println("無");
    } else {
      List<String> characterTabsList = Arrays.asList(characterTabs.split("、"));
      for (int i = 0; i < characterList.size(); i++) {
        for (int j = 0; j < characterTabsList.size(); j++) {
          if (characterList.get(i).equals(characterTabsList.get(j))) {
            selected = 1;
            break;
          }
        }
        if (selected > 0) {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myCharacter"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + characterList.get(i)
                  + "\" checked >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + characterList.get(i)
                  + "</label> </div>";
        } else {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myCharacter"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + characterList.get(i)
                  + "\" >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + characterList.get(i)
                  + "</label> </div>";
        }
        selected = -1;
      } // for迴圈
    }

    return ans;
  }

  /*====用memberId來取得會員資料庫所存取"室友喜好"的Tag====*/
  @Override
  public String getFavorTag(int uId) {
    String ans = "";
    int selected = -1;

    List<String> favorList = cfDao.getAllFavor(); // 取回所有的tag
    String favorTabs = getFavor(uId);
    if (favorTabs.equals("無")) {
      for (int i = 0; i < favorList.size(); i++) {

        ans +=
            "<div class=\"form-check form-check-inline\">"
                + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myFavor"
                + (i + 1)
                + "\" id=\"inlineCheckbox\" value=\""
                + favorList.get(i)
                + "\">"
                + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                + favorList.get(i)
                + "</label> </div>";
      }
      // System.out.println("無");
    } else {

      List<String> favorTabsList = Arrays.asList(favorTabs.split("、"));

      for (int i = 0; i < favorList.size(); i++) {
        for (int j = 0; j < favorTabsList.size(); j++) {
          if (favorList.get(i).equals(favorTabsList.get(j))) {
            selected = 1;
            break;
          }
        }
        if (selected > 0) {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myFavor"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + favorList.get(i)
                  + "\" checked >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + favorList.get(i)
                  + "</label> </div>";
        } else {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myFavor"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + favorList.get(i)
                  + "\" >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + favorList.get(i)
                  + "</label> </div>";
        }
        selected = -1;
      } // for迴圈結束
    }

    return ans;
  }

  /*====用memberId來取得會員資料庫所存取"性別"的Tag====*/
  @Override
  public String getGenderTag(int uId) {
    String ans = "";
    String[] genderType = {"male", "female", "nogender"};
    String[] genderStr = {"男生", "女生", "不公開"};
    MemberBean mb = mbDao.queryMemberByPrimaryKey(uId);
    for (int i = 0; i < 3; i++) {
      if (i == mb.getGender()) {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"gender\" name=\"myGender\" value=\""
                + genderType[i]
                + "\" checked>"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + genderStr[i]
                + "</span></label>";
      } else {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"gender\" name=\"myGender\" value=\""
                + genderType[i]
                + "\">"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + genderStr[i]
                + "</span></label>";
      }
    }
    return ans;
  }

  @Override
  public String getFindRoommateTag(int uId) {
    String ans = "";
    String[] openType = {"off", "on"};
    String[] openStr = {"關閉", "開啟"};
    MemberBean mb = mbDao.queryMemberByPrimaryKey(uId);
    for (int i = 0; i < 2; i++) {
      if (i == mb.getOpen_tag()) {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"openTag\" name=\"findRoommate\" value=\""
                + openType[i]
                + "\" checked>"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + openStr[i]
                + "</span></label>";
      } else {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"openTag\" name=\"findRoommate\" value=\""
                + openType[i]
                + "\" >"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + openStr[i]
                + "</span></label>";
      }
    }
    return ans;
  }

  @Override
  public String getFindAvatarTag(int uId) {
    String ans = "";
    ans += "<div id=\"avatarBlock\">";
    MemberBean mb = mbDao.queryMemberByPrimaryKey(uId);
    List<String> list = avaDao.queryAvatarNameByGender(mb.getGender()); // 取得所有的頭像(不含副檔名.png)
    String dbAvatar = getAvatar(uId).replace(".png", "");

    int colNum = list.size() / 3;
    int col = 0;

    if (colNum == 0) {
      ans +=
          "<div class=\"row mb-2\">\n"
              + "<div class=\"col\" id=\"avatarId"
              + (col + 1)
              + "\" style=\"display: flex; justify-content: center;\">";
      for (int i = col * 3; i < list.size(); i++) {

        if (list.get(i).equals(dbAvatar)) {
          ans +=
              "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
                  + list.get(i)
                  + "\" "
                  + "id=\"adviceRadio"
                  + (i + 1)
                  + "\" checked hidden />"
                  + "<label for=\"adviceRadio"
                  + (i + 1)
                  + "\" class=\"advice mx-2\" "
                  + " style=\"background-image: url('images/avataricon/"
                  + list.get(i)
                  + ".png'); background-size: 100px 100px;\"></label>";

        } else {
          ans +=
              "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
                  + list.get(i)
                  + "\" "
                  + "id=\"adviceRadio"
                  + (i + 1)
                  + "\"  hidden />"
                  + "<label for=\"adviceRadio"
                  + (i + 1)
                  + "\" class=\"advice mx-2\" "
                  + " style=\"background-image: url('images/avataricon/"
                  + list.get(i)
                  + ".png'); background-size: 100px 100px;\"></label>";
        }
      }
      ans += "</div>\n" + "</div>";
    }

    while (col < colNum) {
      ans +=
          "<div class=\"row mb-2\">\n"
              + "<div class=\"col\" id=\"avatarId"
              + (col + 1)
              + "\" style=\"display: flex; justify-content: center;\">";
      for (int i = col * 3; i < (col + 1) * 3; i++) {

        if (list.get(i).equals(dbAvatar)) {
          ans +=
              "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
                  + list.get(i)
                  + "\" "
                  + "id=\"adviceRadio"
                  + (i + 1)
                  + "\" checked hidden />"
                  + "<label for=\"adviceRadio"
                  + (i + 1)
                  + "\" class=\"advice mx-2\" "
                  + " style=\"background-image: url('images/avataricon/"
                  + list.get(i)
                  + ".png'); background-size: 100px 100px;\"></label>";

        } else {
          ans +=
              "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
                  + list.get(i)
                  + "\" "
                  + "id=\"adviceRadio"
                  + (i + 1)
                  + "\"  hidden />"
                  + "<label for=\"adviceRadio"
                  + (i + 1)
                  + "\" class=\"advice mx-2\" "
                  + " style=\"background-image: url('images/avataricon/"
                  + list.get(i)
                  + ".png'); background-size: 100px 100px;\"></label>";
        }
      }
      ans += "</div>\n" + "</div>";
      col++;
    }
    ans += "</div>";
    return ans;
  }

  /*====修改會員資料所需用到的Tag====*/

  /*====修改會員資料放入臨時選取的"個性標籤"====*/
  @Override
  public String getCharacterTempTag(String characterTabs) {
    String ans = "";
    int selected = -1;

    // List<String> characterList = cfDao.getAllCharacter(); // 取回CF資料庫所有的個性標籤資料放入表單
    List<String> characterList = cfDao.getCharacterOrFavorNameByType(1);
    if (characterTabs.equals("無")) {
      for (int i = 0; i < characterList.size(); i++) {

        ans +=
            "<div class=\"form-check form-check-inline\">"
                + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myCharacter"
                + (i + 1)
                + "\" id=\"inlineCheckbox\" value=\""
                + characterList.get(i)
                + "\">"
                + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                + characterList.get(i)
                + "</label> </div>";
      }
      // System.out.println("無");
    } else {
      List<String> characterTabsList = Arrays.asList(characterTabs.split("、"));
      for (int i = 0; i < characterList.size(); i++) {
        for (int j = 0; j < characterTabsList.size(); j++) {
          if (characterList.get(i).equals(characterTabsList.get(j))) {
            selected = 1;
            break;
          }
        }
        if (selected > 0) {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myCharacter"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + characterList.get(i)
                  + "\" checked >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + characterList.get(i)
                  + "</label> </div>";
        } else {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myCharacter"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + characterList.get(i)
                  + "\" >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + characterList.get(i)
                  + "</label> </div>";
        }
        selected = -1;
      } // for迴圈
    }

    return ans;
  }

  /*====修改會員資料放入臨時選取的"室友喜好"====*/
  @Override
  public String getFavorTempTag(String favorTabs) {
    String ans = "";
    int selected = -1;

    // List<String> favorList = cfDao.getAllFavor(); // 取回所有的tag
    List<String> favorList = cfDao.getCharacterOrFavorNameByType(2);
    if (favorTabs.equals("無")) {
      for (int i = 0; i < favorList.size(); i++) {
        ans +=
            "<div class=\"form-check form-check-inline\">"
                + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myFavor"
                + (i + 1)
                + "\" id=\"inlineCheckbox\" value=\""
                + favorList.get(i)
                + "\">"
                + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                + favorList.get(i)
                + "</label> </div>";
      }
      // System.out.println("無");
    } else {
      List<String> favorTabsList = Arrays.asList(favorTabs.split("、"));
      for (int i = 0; i < favorList.size(); i++) {
        for (int j = 0; j < favorTabsList.size(); j++) {
          if (favorList.get(i).equals(favorTabsList.get(j))) {
            selected = 1;
            break;
          }
        }
        if (selected > 0) {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myFavor"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + favorList.get(i)
                  + "\" checked >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + favorList.get(i)
                  + "</label> </div>";
        } else {
          ans +=
              "<div class=\"form-check form-check-inline\">"
                  + "<input class=\"form-check-input\" type=\"checkbox\" name=\"myFavor"
                  + (i + 1)
                  + "\" id=\"inlineCheckbox\" value=\""
                  + favorList.get(i)
                  + "\" >"
                  + "<label class=\"form-check-label mx-2\" for=\"inlineCheckbox\">"
                  + favorList.get(i)
                  + "</label> </div>";
        }
        selected = -1;
      } // for迴圈結束
    }

    return ans;
  }

  /*====修改會員資料放入臨時選取的"性別"====*/
  @Override
  public String getGenderTempTag(int gender) {
    String ans = "";
    String[] genderType = {"male", "female", "nogender"};
    String[] genderStr = {"男生", "女生", "不公開"};

    for (int i = 0; i < 3; i++) {
      if (i == gender) {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"gender\" name=\"myGender\" value=\""
                + genderType[i]
                + "\" checked>"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + genderStr[i]
                + "</span></label>";
      } else {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"gender\" name=\"myGender\" value=\""
                + genderType[i]
                + "\">"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + genderStr[i]
                + "</span></label>";
      }
    }
    return ans;
  }

  /*====修改會員資料放入臨時選取的"室友功能"====*/
  @Override
  public String getFindRoommateTempTag(int open_tag) {
    String ans = "";
    String[] openType = {"off", "on"};
    String[] openStr = {"關閉", "開啟"};

    for (int i = 0; i < 2; i++) {
      if (i == open_tag) {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"openTag\" name=\"findRoommate\" value=\""
                + openType[i]
                + "\" checked>"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + openStr[i]
                + "</span></label>";
      } else {
        ans +=
            "<input type=\"radio\" class=\"mr-2\" id=\"openTag\" name=\"findRoommate\" value=\""
                + openType[i]
                + "\" >"
                + "<label class=\"text-black\" for=\"r1\"><span>"
                + openStr[i]
                + "</span></label>";
      }
    }
    return ans;
  }

  /*====修改會員資料放入臨時選取的"Avatar"====*/
  @Override
  public String getFindAvatarTempTag(String avartar, int gender) {
    String ans = "";
    ans += "<div id=\"avatarBlock\">";
    List<String> list = avaDao.queryAvatarNameByGender(gender); // 取得所有的頭像(不含副檔名.png)

    int colNum = list.size() / 3;
    int col = 0;
    while (col < colNum) {
      ans +=
          "<div class=\"row mb-2\">\n"
              + "<div class=\"col\" id=\"avatarId"
              + (col + 1)
              + "\" style=\"display: flex; justify-content: center;\">";
      for (int i = col * 3; i < (col + 1) * 3; i++) {

        if (list.get(i).equals(avartar)) {
          ans +=
              "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
                  + list.get(i)
                  + "\" "
                  + "id=\"adviceRadio"
                  + (i + 1)
                  + "\" checked hidden />"
                  + "<label for=\"adviceRadio"
                  + (i + 1)
                  + "\" class=\"advice mx-2\" "
                  + " style=\"background-image: url('images/avataricon/"
                  + list.get(i)
                  + ".png'); background-size: 100px 100px;\"></label>";

        } else {
          ans +=
              "<input type=\"radio\" name=\"avatarIcon\" class=\"advice\" value=\""
                  + list.get(i)
                  + "\" "
                  + "id=\"adviceRadio"
                  + (i + 1)
                  + "\"  hidden />"
                  + "<label for=\"adviceRadio"
                  + (i + 1)
                  + "\" class=\"advice mx-2\" "
                  + " style=\"background-image: url('images/avataricon/"
                  + list.get(i)
                  + ".png'); background-size: 100px 100px;\"></label>";
        }
      }
      ans += "</div>\n" + "</div>";
      col++;
    }
    ans += "</div>";
    return ans;
  }

  @Override
  public int getAvatarId(String avatarName) {
    int avatarUid = avaDao.queryAvatarIdByName(avatarName);
    return avatarUid;
  }

  /*===確認身分證號是否正確===*/
  @Override
  public String checkIdNumber(String formValue, int genderId) {
    String errMsg = "";
    String idNumber = "";
    int countyCode = -1;
    idNumber = formValue.replaceAll("\\s*", "");
    countyCode = (int) (idNumber.substring(0, 1).toUpperCase().charAt(0));
    List<Integer> code = new ArrayList<>();

    if (idNumber == null || idNumber.trim().length() == 0) {
      errMsg = "必須輸入身分證號";

    } else if (idNumber.length() != 10) {
      errMsg = "身分證號格式錯誤";

    } else if (countyCode < 65 || countyCode > 90) {
      errMsg = "身分證號縣市碼不正確";

    } else if (genderId != Character.getNumericValue(idNumber.charAt(1))) {
      errMsg = "身分證號性別碼不正確";

    } else if (!(idNumber.substring(2)).matches("[0-9]{8}")) {
      errMsg = "身分證號格式不正確";

    } else if (idNumber.length() == 10 && (idNumber.substring(2)).matches("[0-9]{8}")) {

      code.add((int) idNumber.substring(0, 1).toUpperCase().charAt(0));
      // System.out.println((int) idNumber.substring(0, 1).toUpperCase().charAt(0));
      for (int i = 1; i < idNumber.length(); i++) {
        int num =
            (Character.getNumericValue(idNumber.substring(i, (i + 1)).toUpperCase().charAt(0)));
        code.add(num);
      }
      int[] weight = {
        10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33
      };
      int firstCode = weight[(code.get(0) - 65)];

      int sum = (firstCode / 10) * 1 + (firstCode % 10) * 9;

      int encode = 8;
      for (int i = 1; i <= (idNumber.length() - 1); i++) {
        sum += code.get(i) * encode;
        // System.out.println("sum" + i + ":" + sum);
        encode--;
      }
      sum += code.get(9);

      if (sum % 10 != 0) {
        errMsg = "身分證號格式不正確";
      } else {
        errMsg = null;
      }
    }
    return errMsg;
  }

  public String getAllAvatarByGender(int gender) {
    List<String> list = avaDao.queryAvatarNameByGender(gender);
    String ans = "";
    for (int i = 0; i < list.size(); i++) {
      ans += list.get(i) + ",";
    }
    return ans;
  }

  @Override
  public int getCharacterOrFavorIdByNameAndType(String name, int type) {
    int characterOrFavorId = cfDao.getCharacterOrFavorIdByNameAndType(name, type);
    return characterOrFavorId;
  }

  @Override
  public MemberBean checkIdPassword(String mail, String password) {
    MemberBean mb = mbDao.checkIdPassword(mail, password);
    return mb;
  }

  @Override
  public int getSignatureId(String name) {
    int signatureId = cfDao.getSignatureId(name);
    return signatureId;
  }

  @Override
  public int getFavorId(String name) {
    int favorId = cfDao.getFavorId(name);
    return favorId;
  }

  @Override
  public int updateMemberInfo(MemberBean bean) {
    int n = mbDao.updateMemberInfo(bean);
    return n;
  }

  @Override
  public MemberBean queryMemberByPrimaryKey(int uId) {
    return mbDao.queryMemberByPrimaryKey(uId);
  }
}
