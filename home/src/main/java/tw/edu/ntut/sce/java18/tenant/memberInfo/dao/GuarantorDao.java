package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.GuarantorBean;

public interface GuarantorDao {

  boolean checkGuarantorIdExists(int memberId);

  int saveGuarantor(GuarantorBean guarantor);

  GuarantorBean queryGuarantorByPrimaryKey(int id); //

  GuarantorBean queryGuarantorByMemberId(int memberId);

  List<GuarantorBean> getGuarantorInfo(int memberId);

  int updateGuarantorInfo(GuarantorBean guarantor);
}
