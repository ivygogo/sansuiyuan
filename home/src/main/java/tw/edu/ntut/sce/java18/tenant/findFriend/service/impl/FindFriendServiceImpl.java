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
import tw.edu.ntut.sce.java18.common.dao.CharacterAndFavorDao;
import tw.edu.ntut.sce.java18.common.dao.ChatroomDao;
import tw.edu.ntut.sce.java18.common.dao.MemberDao_Hibernate;
import tw.edu.ntut.sce.java18.common.dao.impl.CharacterAndFavorDaoImpl;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.dao.impl.ChatroomDaoImpl_JDBC.ExistChatroomBean;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_Hibernate;
import tw.edu.ntut.sce.java18.common.model.FriendBean;
import tw.edu.ntut.sce.java18.tenant.findFriend.service.FindFriendService;

// @Transactional
// @Service
public class FindFriendServiceImpl implements FindFriendService {
  private static final Logger log = LoggerFactory.getLogger(FindFriendServiceImpl.class);

  SessionFactory factory;
  CharacterAndFavorDao characterAndFavorDao;
  ChatroomDao chatroomDao;
  MemberDao_Hibernate memberDaoHibernate;
  int num = 1;

  public FindFriendServiceImpl() {
    this.characterAndFavorDao = new CharacterAndFavorDaoImpl();
    this.chatroomDao = new ChatroomDaoImpl_JDBC();
    this.memberDaoHibernate = new MemberDaoImpl_Hibernate();
    this.factory = HibernateUtils.getSessionFactory();
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
    System.out.println(
        "---------------------------------------------------------------------------");
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      if (memberDaoHibernate.queryMemberByUId(userId).getOpen_tag() == 1) {
        return true;
      }
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
      throw new RuntimeException(e.getMessage());
    }
    return false;
  }

  //  @Transactional
  @Override
  public boolean checkLimit(int userId) {
    return chatroomDao.queryExistChatroomByUser(userId).size() <= 5;
  }

  //  @Transactional
  @Override
  public List<Integer> getAllFindingFriendId() {
    return memberDaoHibernate.queryFindingUIdList();
  }

  // 用來隱藏已經配對的那幾個人
  //  @Transactional
  @Override
  public ArrayList<Integer> getExistTarget(int userId) {
    ArrayList<Integer> existID = new ArrayList<>();
    for (ExistChatroomBean existChatroom : chatroomDao.queryExistChatroomByUser(userId)) {
      if (existChatroom.getTargetId() != 0) existID.add(existChatroom.getTargetId());
    }
    return existID;
  }

  //
  //  public List<String> getFlavor(int userId) {
  //    var flavorList = new ArrayList<String>();
  //
  //    flavorList.add(
  //        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
  //            memberDao.queryMemberByUId(userId).getFavor_1()));
  //    flavorList.add(
  //        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
  //            memberDao.queryMemberByUId(userId).getFavor_2()));
  //    flavorList.add(
  //        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
  //            memberDao.queryMemberByUId(userId).getFavor_3()));
  //    return flavorList;
  //  }
  //
  //  public List<String> getSignature(int userId) {
  //    var signatureList = new ArrayList<String>();
  //
  //    signatureList.add(
  //        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
  //            memberDao.queryMemberByUId(userId).getSignature_1()));
  //    signatureList.add(
  //        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
  //            memberDao.queryMemberByUId(userId).getSignature_2()));
  //    signatureList.add(
  //        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
  //            memberDao.queryMemberByUId(userId).getSignature_3()));
  //    return signatureList;
  //  }

  @Override
  public FriendBean getFrindInfo(int userId) {
    FriendBean friendBean = new FriendBean();
    friendBean.setId(userId);
    friendBean.setSignature1(
        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
            memberDaoHibernate.queryMemberByUId(userId).getSignature_1()));
    friendBean.setSignature2(
        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
            memberDaoHibernate.queryMemberByUId(userId).getSignature_2()));
    friendBean.setSignature3(
        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
            memberDaoHibernate.queryMemberByUId(userId).getSignature_3()));
    friendBean.setFavor1(
        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
            memberDaoHibernate.queryMemberByUId(userId).getFavor_1()));
    friendBean.setFavor2(
        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
            memberDaoHibernate.queryMemberByUId(userId).getFavor_2()));
    friendBean.setFavor3(
        characterAndFavorDao.queryCharacterAndFavorNameByPrimaryKey(
            memberDaoHibernate.queryMemberByUId(userId).getFavor_3()));

    return friendBean;
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
    Integer openTag = 0;
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
      e.printStackTrace();
      tx.rollback();
      throw new RuntimeException(e.getMessage());
    }
  }
}
