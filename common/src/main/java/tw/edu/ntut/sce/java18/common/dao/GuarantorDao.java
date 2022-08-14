package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import tw.edu.ntut.sce.java18.common.model.GuarantorBean;

public interface GuarantorDao {

  boolean uIdExists(int uId);

  int saveGuarantor(GuarantorBean gb);

  GuarantorBean queryGuarantorId(int uId);

  GuarantorBean getGuarantorInfo(int member_id);

  void setConnection(Connection con);
}
