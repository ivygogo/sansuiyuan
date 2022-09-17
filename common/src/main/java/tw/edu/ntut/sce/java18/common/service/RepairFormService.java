package tw.edu.ntut.sce.java18.common.service;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormServiceBean;

public interface RepairFormService {

  List<RepairFormBean> getReparFormListByApplicant(int memberid);

  List<RepairFormServiceBean> getReparFormConverListByApplicant(int memberid);

  int checkRepairFormAmount(int memberid, String beginTime, String endTime);

  int saveRepairForm(RepairFormBean repairFormBean);

  int updateRepairForm(RepairFormBean repairFormBean);

  int deleteRepairForm(String formNumber);
}
