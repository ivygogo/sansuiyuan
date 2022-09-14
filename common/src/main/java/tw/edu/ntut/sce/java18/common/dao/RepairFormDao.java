package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;

public interface RepairFormDao {

  List<RepairFormBean> getReparFormListByApplicant(int memberid);
}
