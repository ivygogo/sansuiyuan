package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;

public interface RepairFormDao {

  List<RepairFormBean> getRepairFormListByApplicant(int memberid);

  RepairFormBean getRepairFormByFormNumber(String formNumber);

  int checkRepairFormAmount(int memberid, String beginTime, String endTime);

  int saveRepairForm(RepairFormBean repairFormBean);

  int updateRepairForm(RepairFormBean repairFormBean);

  int deleteRepairForm(String formNumber);

  List<RepairFormBean> queryAllRepairForm();
}
