package tw.edu.ntut.sce.java18.tenant.findFriend.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.edu.ntut.sce.java18.common.config.HibernateUtils;
import tw.edu.ntut.sce.java18.common.dao.AvatarDao;
import tw.edu.ntut.sce.java18.common.dao.CharacterAndFavorDao;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.dao.MemberDao_Hibernate;
import tw.edu.ntut.sce.java18.common.dao.impl.AvatarDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.CharacterAndFavorDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC.ExistChatroomBean;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_Hibernate;
import tw.edu.ntut.sce.java18.common.model.FriendBean;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.FindFriendService;

// @Transactional
// @Service
public class FindFriendServiceImpl implements FindFriendService {
  private static final Logger log = LoggerFactory.getLogger(FindFriendServiceImpl.class);

  SessionFactory factory;
  CharacterAndFavorDao characterAndFavorDao;
  ChatroomDao chatroomDao;
  MemberDao_Hibernate memberDaoHibernate;

  AvatarDao avatarDao;

  public FindFriendServiceImpl() {
    characterAndFavorDao = new CharacterAndFavorDaoImpl();
    chatroomDao = new ChatroomDaoImpl_JDBC();
    memberDaoHibernate = new MemberDaoImpl_Hibernate();
    avatarDao = new AvatarDaoImpl();
    factory = HibernateUtils.getSessionFactory();
  }

  //  @Autowired
  //  public FindFriendServiceImpl(
  //      CharacterAndFavorDao characterAndFavorDao,
  //      ChatroomDao chatroomDao,
  //      MemberDao_Hibernate memberDaoHibernate) {
  //    this.characterAndFavorDao = characterAndFavorDao;
  //    this.chatroomDao = chatroomDao;
  //    this.memberDaoHibernate = memberDaoHibernate;
  //  }

  //  @Transactional
  @Override
  public boolean checkOpen(int userId) {
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      if (memberDaoHibernate.queryMemberByUId(userId).getOpen_tag() == 1) {
        return true;
      }
      tx.commit();
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return false;
  }

  @Override
  public boolean isbelowLimit(int userId) {
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      int result = chatroomDao.queryExistChatroomByUser(userId).size();
      tx.commit();
      return result < 5;
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override // 用來尋找那些人的聊天室要隱藏起來
  public ArrayList<Integer> getExistTarget(int userId) {
    ArrayList<Integer> existID = new ArrayList<>();
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      for (ExistChatroomBean existChatroom : chatroomDao.queryExistChatroomByUser(userId)) {
        if (existChatroom.getTargetId() != 0) existID.add(existChatroom.getTargetId());
      }
      tx.commit();
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return existID;
  }

  @Override
  public List<Integer> getAllFindingFriendId() {
    Session session = factory.getCurrentSession();
    List<Integer> allFindingIdList;
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      allFindingIdList = memberDaoHibernate.queryFindingUIdList();
      tx.commit();
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    return allFindingIdList;
  }

  @Override
  public FriendBean getPersonalFriendInfo(int userId) {
    FriendBean friendBean = new FriendBean();
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    friendBean.setId(userId);
    try {
      tx = session.beginTransaction();
      MemberBean memberBean = memberDaoHibernate.queryMemberByUId(userId);

      Integer signature1 = memberBean.getSignature_1();
      Integer signature2 = memberBean.getSignature_2();
      Integer signature3 = memberBean.getSignature_3();
      Integer favor1 = memberBean.getFavor_1();
      Integer favor2 = memberBean.getFavor_2();
      Integer favor3 = memberBean.getFavor_3();

      friendBean.setSchool("");
      friendBean.setSignature1("");
      friendBean.setSignature2("");
      friendBean.setSignature3("");
      friendBean.setFavor1("");
      friendBean.setFavor2("");
      friendBean.setFavor3("");

      friendBean.setName(memberBean.getNickname());
      System.out.println(
          "pic ===== "
              + memberBean.getPic()
              + "=====  "
              + avatarDao.queryAvatarByPrimaryKey(memberBean.getPic())
              + "=====  "
              + avatarDao.queryAvatarByPrimaryKey(memberBean.getPic()).getAvatarName()
              + "======");
      friendBean.setAvatar(avatarDao.queryAvatarByPrimaryKey(memberBean.getPic()).getAvatarName());

      if (memberBean.getSchool() != null) friendBean.setSchool(memberBean.getSchool());
      if (signature1 != null)
        friendBean.setSignature1(
            characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(signature1));
      if (signature2 != null)
        friendBean.setSignature1(
            characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(signature2));
      if (signature3 != null)
        friendBean.setSignature1(
            characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(signature3));
      if (favor1 != null)
        friendBean.setFavor1(characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(favor1));
      if (favor2 != null)
        friendBean.setFavor1(characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(favor2));
      if (favor3 != null)
        friendBean.setFavor1(characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(favor3));

      tx.commit();
      return friendBean;
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public void closeChatroom(int roomID) {
    chatroomDao.updateCloseTime(roomID, 0);
  }

  @Override
  public void createChatroom(int userId, int targetId) {
    var localDateTime = LocalDateTime.now();
    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    var ldtCloseTime = localDateTime.plusDays(10);
    var createTime = localDateTime.format(dateTimeFormatter);
    var closeTime = ldtCloseTime.format(dateTimeFormatter);

    chatroomDao.insertChatroom("F", userId, targetId, createTime, closeTime);
  }

  @Override
  public void updateOpenStage(int userId, boolean isOpen) {
    int openTag = 0;
    if (isOpen) {
      openTag = 1;
    }
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      memberDaoHibernate.updateOpenStage(userId, openTag);
      tx.commit();
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }
}
