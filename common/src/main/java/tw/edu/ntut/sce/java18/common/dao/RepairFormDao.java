package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;

public interface RepairFormDao {

  List<RepairFormBean> getRepairFormListByApplicant(int memberid);

  int checkRepairFormAmount(int memberid, String beginTime, String endTime);
}
