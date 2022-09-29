package tw.edu.ntut.sce.java18.tenant.findFriend.service.impl;

import static java.util.stream.Collectors.toList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
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
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
import tw.edu.ntut.sce.java18.tenant.findFriend.model.FriendBean;
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
    } finally {
      session.close();
    }
    return false;
  }

  @Override
  public boolean isBelowLimit(int userId) {
    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      int result = chatroomDao.queryCountForMakeFriendByUserId(userId);
      tx.commit();
      System.out.println("result = " + result);
      return result < 5;
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    } finally {
      session.close();
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
    } finally {
      session.close();
    }
    return existID;
  }

  @Override
  public Map<String, List<String>> getAllSignatureAndFavor() {
    Map<String, List<String>> signatureAndFavor = new HashMap<>();

    Session session = factory.getCurrentSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
      signatureAndFavor.put("signature", characterAndFavorDao.getAllCharacter());
      signatureAndFavor.put("favor", characterAndFavorDao.getAllFavor());
      tx.commit();
      return signatureAndFavor;
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    } finally {
      session.close();
    }
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
    } finally {
      session.close();
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

      var signatures =
          Stream.of(signature1, signature2, signature3)
              .filter(Objects::nonNull)
              .map(characterAndFavorDao::queryCharacterAndFavorNameByPrimaryKey)
              .collect(toList());

      var favors =
          Stream.of(favor1, favor2, favor3)
              .filter(Objects::nonNull)
              .map(characterAndFavorDao::queryCharacterAndFavorNameByPrimaryKey)
              .collect(toList());

      friendBean.setGender(memberBean.getGender());
      friendBean.setSchool("");
      friendBean.setName(memberBean.getNickname());
      friendBean.setAvatar(avatarDao.queryAvatarByPrimaryKey(memberBean.getPic()).getAvatarName());
      friendBean.setFavors(favors);
      friendBean.setSignatures(signatures);
      if (memberBean.getSchool() != null) friendBean.setSchool(memberBean.getSchool());

      tx.commit();
      return friendBean;
    } catch (Exception e) {
      if (tx != null) tx.rollback();
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    } finally {
      session.close();
    }
  }

  @Override
  public void closeChatroom(int roomID) {
    chatroomDao.updateCloseTime(roomID, 0);
  }

  @Override
  public void createChatroom(int userId, int targetId) {
    ChatroomService chatroomService = new ChatroomService();

    var localDateTime = LocalDateTime.now();
    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    var ldtCloseTime = localDateTime.plusDays(10);
    var createTime = localDateTime.format(dateTimeFormatter);
    var closeTime = ldtCloseTime.format(dateTimeFormatter);

    boolean isExist;

    int member1 = userId;
    int member2 = targetId;

    if (userId > targetId) {
      member1 = targetId;
      member2 = userId;
      System.out.println(targetId + "-----------" + userId);
      isExist = chatroomService.isExist(member1, member2, "F");
    } else {
      System.out.println(userId + "-------" + targetId);
      isExist = chatroomService.isExist(member1, member2, "F");
    }

    if (!isExist) {
      chatroomDao.insertChatroom("F", member1, member2, createTime, closeTime);
      System.out.println("create chatroom");
    } else System.out.println("the chatroom is exist");
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
    } finally {
      session.close();
    }
  }
}
