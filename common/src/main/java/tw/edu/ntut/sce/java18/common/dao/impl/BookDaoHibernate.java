package tw.edu.ntut.sce.java18.common.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tw.edu.ntut.sce.java18.common.model.BookerBeanHibernate;
import tw.edu.ntut.sce.java18.common.utils.HibernateUtil;

public class BookDaoHibernate {

  public BookerBeanHibernate saveUser(BookerBeanHibernate user) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

      transaction = session.beginTransaction();

      session.save(user);

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return user;
  }

  public void updateUser(BookerBeanHibernate user) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

      transaction = session.beginTransaction();

      session.update(user);

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public void deleteUser(int id) {

    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();

      BookerBeanHibernate user = session.get(BookerBeanHibernate.class, id);
      if (user != null) {
        session.delete(user);
        System.out.println(user + " 刪除成功");
      }

    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }

  public BookerBeanHibernate getUser(int id) {

    Transaction transaction = null;
    BookerBeanHibernate user = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

      transaction = session.beginTransaction();

      user = session.get(BookerBeanHibernate.class, id);

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return user;
  }

  @SuppressWarnings("unchecked")
  public List<BookerBeanHibernate> getAllUser() {

    Transaction transaction = null;
    List<BookerBeanHibernate> listOfUser = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {

      transaction = session.beginTransaction();

      listOfUser = session.createQuery("from bookingexample").getResultList();

      transaction.commit();
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    return listOfUser;
  }
}
