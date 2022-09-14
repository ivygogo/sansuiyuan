package tw.edu.ntut.sce.java18.common.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

  private static SessionFactory sessionFactory = buildSessionFactory();

  // 建立Session工廠
  private static SessionFactory buildSessionFactory() {
    try {
      StandardServiceRegistry standardServiceRegistry =
          new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
      Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
      SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
      return sessionFactory;
    } catch (Throwable e) {
      System.out.println("新建連線失敗" + e.getMessage());
      throw new ExceptionInInitializerError(e);
    }
  }

  // 外界呼叫此靜態方法來取得 SessionFactory物件
  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  // 外界呼叫此靜態方法來關閉 SessionFactory物件
  public static void close() {
    getSessionFactory().close();
  }
}
