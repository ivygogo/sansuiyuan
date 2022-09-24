package tw.edu.ntut.sce.java18.common.service;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormServiceBean;

public interface RepairFormService {

  List<RepairFormBean> getReparFormListByApplicant(int memberid);

  RepairFormBean getRepairFormByFormNumber(String formNumber);

  List<RepairFormServiceBean> getReparFormConverListByApplicant(int memberid);

  int checkRepairFormAmount(int memberid, String beginTime, String endTime);

  int saveRepairForm(RepairFormBean repairFormBean);

  int updateRepairForm(RepairFormBean repairFormBean);

  int deleteRepairForm(String formNumber);

  public List<RepairFormBean> queryAllRepairForm();

  boolean checkMemberUidExists(String formNumber);

  int updateRepairFormByLandload(RepairFormBean repairFormBean);

  int checkRepairFormExistBytime(int memberid, String beginTime, String endTime);

  int checkUnFinishedRepairFormAmount(int memberid);
}
