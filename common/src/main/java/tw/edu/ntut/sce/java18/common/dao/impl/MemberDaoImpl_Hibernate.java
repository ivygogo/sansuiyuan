package tw.edu.ntut.sce.java18.common.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.edu.ntut.sce.java18.common.config.HibernateUtils;
import tw.edu.ntut.sce.java18.common.dao.MemberDao_Hibernate;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

@Repository
public class MemberDaoImpl_Hibernate implements Serializable, MemberDao_Hibernate {
  private static final long serialVersionUID = 1L;
  private static Logger log = LoggerFactory.getLogger(MemberDaoImpl_Hibernate.class);

  SessionFactory factory;

  @Autowired
  public MemberDaoImpl_Hibernate(SessionFactory factory) {
    this.factory = factory;
  }

  public MemberDaoImpl_Hibernate() {
    factory = HibernateUtils.getSessionFactory();
  }

  @Override
  public MemberBean queryMemberByUId(Integer userId) {
    log.info("藉由userId搜尋memberBean");
    Session session = factory.getCurrentSession();
    MemberBean memberBean;
    String hql = "FROM MemberBean mb WHERE mb.uId = :uId";

    memberBean =
        session.createQuery(hql, MemberBean.class).setParameter("uId", userId).getSingleResult();

    log.info("會員登入功能之Dao: 取得某個會員的資料, mb=" + memberBean);
    return memberBean;
  }

  @Override
  public void updateOpenStage(int userId, Integer openTag) {
    String hql = "UPDATE MemberBean SET open_tag = :openTag WHERE uId = :uId";
    Session session = factory.getCurrentSession();
    session
        .createQuery(hql)
        .setParameter("openTag", openTag)
        .setParameter("uId", userId)
        .executeUpdate();
  }

  @Override
  public List<Integer> queryFindingUIdList() {
    System.out.println("MemberDaoImpl_Hibernate . queryFindingUIdList  ");
    List friendList;
    Session session = factory.getCurrentSession();
    String hql = "SELECT uId FROM MemberBean WHERE open_tag = 1";
    friendList = session.createQuery(hql).getResultList();
    System.out.println("MemberDaoImpl_Hibernate . queryFindingUIdList");

    log.info("取得開啟標籤的list");
    return friendList;
  }
}
