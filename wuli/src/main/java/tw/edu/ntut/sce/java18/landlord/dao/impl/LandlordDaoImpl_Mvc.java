package tw.edu.ntut.sce.java18.landlord.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.edu.ntut.sce.java18.landlord.dao.LandlordDao_Mvc;
import tw.edu.ntut.sce.java18.landlord.model.LandlordBeanM;

@Repository
public class LandlordDaoImpl_Mvc implements LandlordDao_Mvc {
  SessionFactory factory;

  @Autowired
  public LandlordDaoImpl_Mvc(SessionFactory factory) {
    this.factory = factory;
  }

  @Override
  public LandlordBeanM queryLandlordInfoByPrimaryKey(int id) {
    return factory.getCurrentSession().get(LandlordBeanM.class, id);
  }

  @Override
  public void updateLandlordInfo(LandlordBeanM landlordInfo) {
    Session session = factory.getCurrentSession();
    session.saveOrUpdate(landlordInfo);
  }

  @Override
  public LandlordBeanM findByPrimaryKey(int key) {
    Session session = factory.getCurrentSession();
    return session.get(LandlordBeanM.class, key);
  }

  @Override
  public LandlordBeanM findByName(String name) {
    return null;
  }

  @Override
  public int saveLandlord(LandlordBeanM landlordInfo) {
    return 0;
  }

  @Override
  public void updateLandlord(LandlordBeanM landlordInfo) {
    Session session = factory.getCurrentSession();
    session.saveOrUpdate(landlordInfo);
  }

  @Override
  public void deleteLandlordByPrimaryKey(int key) {
    Session session = factory.getCurrentSession();
    LandlordBeanM landlordInfo = new LandlordBeanM();
    landlordInfo.setId(key);
    session.delete(landlordInfo);
  }

  @Override
  public List<LandlordBeanM> findAllLandlords() {
    Session session = factory.getCurrentSession();
    String hql = "FROM LandlordBeanM ";
    List<LandlordBeanM> list = session.createQuery(hql).getResultList();
    return list;
  }

  @Override
  public void deleteLandlord() {
    Session session = factory.getCurrentSession();
    String hql = "DELETE FROM LandlordBeanM";
    session.createQuery(hql).executeUpdate();
  }

  @Override
  public boolean isLandlordExist(LandlordBeanM landlordInfo) {
    boolean exist = false;
    Session session = factory.getCurrentSession();
    String hql = "FROM LandlordBeanM e where e.id=:id";
    try {
      session.createQuery(hql).setParameter("id", landlordInfo.getId()).getSingleResult();
      exist = true;
    } catch (NoResultException ex) {
      ex.printStackTrace();
    } catch (NonUniqueResultException ex) {
      ex.printStackTrace();
    }
    return exist;
  }

  @Override
  public String checkLandlordId(String memberId) {
    Session session = factory.getCurrentSession();
    String hql = "FROM LandlordBeanM tb where tb.id=:id";
    String id = "";
    try {
      LandlordBeanM landlordInfo =
          (LandlordBeanM) session.createQuery(hql).setParameter("id", memberId).getSingleResult();
    } catch (NoResultException ex) {
      ex.printStackTrace();
    } catch (Exception ex) {
      ex.printStackTrace();
      System.out.println(ex.getMessage());
      id = "Error: 資料庫異常，請檢查資料庫";
    }
    return id;
  }

  @Override
  public void evictLandlord(LandlordBeanM landlordInfo) {
    Session session = factory.getCurrentSession();
    session.evict(landlordInfo);
  }
}
