package tw.edu.ntut.sce.java18.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import tw.edu.ntut.sce.java18.common.utils.GlobalService;

/** Application Lifecycle Listener implementation class SystemInializationLinstener */
@WebListener
public class SystemInializationLinstener implements ServletContextListener {

  public SystemInializationLinstener() {}

  public void contextDestroyed(ServletContextEvent sce) {}

  public void contextInitialized(ServletContextEvent sce) {
    GlobalService gs = new GlobalService();
    ServletContext sc = sce.getServletContext();
    sc.setAttribute("SYSTEM", gs);
  }
}
