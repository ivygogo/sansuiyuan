package tw.edu.ntut.sce.java18.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.edu.ntut.sce.java18.common.dao.FaqMvcTestDao;
import tw.edu.ntut.sce.java18.common.model.FaqMvcTest;
import tw.edu.ntut.sce.java18.common.service.FaqMvcTestService;

@Transactional
@Service
public class FaqMvcTestServiceImpl implements FaqMvcTestService {
  FaqMvcTestDao faqMvcTestDao;

  @Autowired
  public FaqMvcTestServiceImpl(FaqMvcTestDao faqMvcTestDao) {
    this.faqMvcTestDao = faqMvcTestDao;
  }

  @Override
  public void save(FaqMvcTest faq) {
    faqMvcTestDao.save(faq);
  }
}
