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
import tw.edu.ntut.sce.java18.common.service.ChatroomService;
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
      repairFormServiceBean.setApplicantName(repairFormList.get(i).getApplicant());
      repairFormServiceBean.setApplicantPhone(repairFormList.get(i).getPhone());

      if (repairFormList.get(i).getCreatTime() != null) {
        dateToStr = dateFormat.format(repairFormList.get(i).getCreatTime());
        repairFormServiceBean.setRepairFormCreatTime(dateToStr);
      } else {
        repairFormServiceBean.setRepairFormCreatTime(null);
      }

      if (repairFormList.get(i).getExpectionTime() != null) {
        dateToStr = dateFormat.format(repairFormList.get(i).getExpectionTime());
        repairFormServiceBean.setRepairFormExpectionTime(dateToStr);
      } else {
        repairFormServiceBean.setRepairFormExpectionTime(null);
      }

      if (repairFormList.get(i).getFixTime() != null) {
        dateToStr = dateFormat.format(repairFormList.get(i).getFixTime());
        repairFormServiceBean.setRepairFormFixTime(dateToStr);
      } else {
        repairFormServiceBean.setRepairFormFixTime(null);
      }

      if (repairFormList.get(i).getFinishTime() != null) {
        dateToStr = dateFormat.format(repairFormList.get(i).getFinishTime());
        repairFormServiceBean.setRepairFormFinishTime(dateToStr);
      } else {
        repairFormServiceBean.setRepairFormFinishTime(null);
      }

      repairFormServiceBean.setProjectAlias(repairFormList.get(i).getProjectNameAlias());
      repairFormServiceBean.setNote(repairFormList.get(i).getNote());
      repairFormServiceBean.setLandlordNote(repairFormList.get(i).getLandlordNote());
      repairFormServiceBean.setStatus(repairFormList.get(i).getStatus());
      repairFormServiceList.add(repairFormServiceBean);
    }

    return repairFormServiceList;
  }

  @Override
  public int checkRepairFormAmount(int memberid, String beginTime, String endTime) {
    return repairFormDao.checkRepairFormAmount(memberid, beginTime, endTime);
  }

  @Override
  public int saveRepairForm(RepairFormBean repairFormBean) {
    ChatroomService chatroomService = new ChatroomService();
    chatroomService.createChatroom("R", repairFormBean.getMemberId(), 0);
    return repairFormDao.saveRepairForm(repairFormBean);
  }

  @Override
  public int updateRepairForm(RepairFormBean repairFormBean) {
    return repairFormDao.updateRepairForm(repairFormBean);
  }

  @Override
  public int deleteRepairForm(String formNumber) {
    return repairFormDao.deleteRepairForm(formNumber);
  }

  @Override
  public RepairFormBean getRepairFormByFormNumber(String formNumber) {
    return repairFormDao.getRepairFormByFormNumber(formNumber);
  }

  @Override
  public List<RepairFormBean> queryAllRepairForm() {
    return repairFormDao.queryAllRepairForm();
  }

  @Override
  public boolean checkMemberUidExists(String formNumber) {
    return repairFormDao.checkRepairFormNumberIsExist(formNumber);
  }

  @Override
  public int updateRepairFormByLandload(RepairFormBean repairFormBean) {
    return repairFormDao.updateRepairFormByLandload(repairFormBean);
  }
}
