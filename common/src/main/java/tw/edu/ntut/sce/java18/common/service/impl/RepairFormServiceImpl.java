package tw.edu.ntut.sce.java18.common.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.RepairFormDao;
import tw.edu.ntut.sce.java18.common.dao.impl.MemberDaoImpl_jdbc;
import tw.edu.ntut.sce.java18.common.dao.impl.RepairFormDaoImpl_JDBC;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormBean;
import tw.edu.ntut.sce.java18.common.model.RepairFormServiceBean;
import tw.edu.ntut.sce.java18.common.service.RepairFormService;

public class RepairFormServiceImpl implements RepairFormService {
  RepairFormDao repairFormDao;

  public RepairFormServiceImpl() {
    repairFormDao = new RepairFormDaoImpl_JDBC();
  }

  @Override
  public List<RepairFormBean> getReparFormListByApplicant(int memberid) {
    return repairFormDao.getRepairFormListByApplicant(memberid);
  }

  @Override
  public List<RepairFormServiceBean> getReparFormConverListByApplicant(int memberid) {
    List<RepairFormServiceBean> repairFormServiceList = new ArrayList<RepairFormServiceBean>();
    List<RepairFormBean> repairFormList = getReparFormListByApplicant(memberid);
    MemberBean member = new MemberDaoImpl_jdbc().queryMemberByPrimaryKey(memberid);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    String dateToStr = "";
    for (int i = 0; i < repairFormList.size(); i++) {
      RepairFormServiceBean repairFormServiceBean = new RepairFormServiceBean();
      repairFormServiceBean.setId(repairFormList.get(i).getId());
      repairFormServiceBean.setRepairFormNumber(repairFormList.get(i).getFormNumber());
      repairFormServiceBean.setRepairRoomNumber(repairFormList.get(i).getRoomNumber());
      repairFormServiceBean.setApplicantName(member.getName());
      repairFormServiceBean.setApplicantPhone(repairFormList.get(i).getPhone());

      dateToStr = dateFormat.format(repairFormList.get(i).getCreatTime());
      repairFormServiceBean.setRepairFormCreatTime(dateToStr);

      dateToStr = dateFormat.format(repairFormList.get(i).getExpectionTime());
      repairFormServiceBean.setRepairFormExpectionTime(dateToStr);

      dateToStr = dateFormat.format(repairFormList.get(i).getFixTime());
      repairFormServiceBean.setRepairFormFixTime(dateToStr);

      dateToStr = dateFormat.format(repairFormList.get(i).getFinishTime());
      repairFormServiceBean.setRepairFormFinishTime(dateToStr);

      repairFormServiceBean.setProjectAlias(repairFormList.get(i).getProjectNameAlias());
      repairFormServiceBean.setNote(repairFormList.get(i).getNote());
      repairFormServiceBean.setStatus(repairFormList.get(i).getStatus());
      repairFormServiceList.add(repairFormServiceBean);
    }

    return repairFormServiceList;
  }

  @Override
  public int checkRepairFormAmount(int memberid, String beginTime, String endTime) {
    // TODO Auto-generated method stub
    return repairFormDao.checkRepairFormAmount(memberid, beginTime, endTime);
  }
}
