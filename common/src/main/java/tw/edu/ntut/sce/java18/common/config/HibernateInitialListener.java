package tw.edu.ntut.sce.java18.common.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;

public class HibernateInitialListener implements ServletContextListener {
  SessionFactory factory;

  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("#####contextInitialized 準備執行");
    factory = HibernateUtils.getSessionFactory();
    System.out.println("#####contextInitialized 執行完畢");
  }

  public void contextDestroyed(ServletContextEvent sce) {
    factory.close();
  }
}
