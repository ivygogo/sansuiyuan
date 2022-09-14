package tw.edu.ntut.sce.java18.common.service;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormServiceBean;

public interface RepairFormService {

  List<RepairFormBean> getReparFormListByApplicant(int memberid);

  List<RepairFormServiceBean> getReparFormConverListByApplicant(int memberid);
}
