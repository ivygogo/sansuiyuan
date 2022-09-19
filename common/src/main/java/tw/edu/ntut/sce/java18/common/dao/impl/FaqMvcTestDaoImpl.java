package tw.edu.ntut.sce.java18.common.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import tw.edu.ntut.sce.java18.common.dao.FaqMvcTestDao;
import tw.edu.ntut.sce.java18.common.model.FaqMvcTest;

@Repository
public class FaqMvcTestDaoImpl implements FaqMvcTestDao {
  private static Logger log = LoggerFactory.getLogger(FaqMvcTestDaoImpl.class);
  SessionFactory factory;

  public FaqMvcTestDaoImpl(SessionFactory factory) {
    this.factory = factory;
  }

  @Override
  public void save(FaqMvcTest faq) {
    log.info("儲存訂單(FaqMvcTestDaoImpl)之Dao:saveFaq ");
    Session session = factory.getCurrentSession();
    session.save(faq);
  }
}
