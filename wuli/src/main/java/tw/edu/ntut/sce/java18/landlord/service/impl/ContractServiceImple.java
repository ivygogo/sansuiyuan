package tw.edu.ntut.sce.java18.landlord.service.impl;

import java.util.ArrayList;
import java.util.List;
import tw.edu.ntut.sce.java18.landlord.dao.ContractDao;
import tw.edu.ntut.sce.java18.landlord.dao.impl.ContractDaoImple;
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;
import tw.edu.ntut.sce.java18.landlord.model.ContractRoom_TypeItemsBean;
import tw.edu.ntut.sce.java18.landlord.service.ContractService;

public class ContractServiceImple implements ContractService {
  ContractDao cdao = new ContractDaoImple();
  ContractBean cb = null;
  ContractRoom_TypeItemsBean ctb = null;
  List<String> allContract = null;

  @Override
  public ContractBean getContract(int CID) {
    cb = cdao.contractQuery(CID);
    return cb;
  }

  @Override
  public ContractBean getStatus(String Status) {
    cb = cdao.queryStatus(Status);

    return cb;
  }

  @Override
  public List<ContractBean> getAllPayment_Status() {
    List<ContractBean> list = cdao.queryAllPayment_Status();

    return list;
  }

  @Override
  public ContractBean getPayment_Status(String Payment_Status) {
    cb = cdao.queryPayment_Status(Payment_Status);
    return cb;
  }

  @Override
  public ContractBean getCheck_Status(String Check_Status) {
    cb = cdao.queryCheck_Status(Check_Status);
    return cb;
  }

  @Override
  public List<ContractBean> getAllContract() {
    List<ContractBean> contract = new ArrayList<>();
    contract = cdao.queryAllContract();
    System.out.println(contract.size());
    return contract;
  }

  @Override
  public void modifyContract(
      String status,
      String name,
      String room_Number,
      String payment_status,
      String deposit,
      String check_Fee,
      String check_status,
      int cId) {

    cdao.modifyStatus(
        status, name, room_Number, payment_status, deposit, check_Fee, check_status, cId);
  }

  @Override
  public ContractBean deleteContract(int CID) {
    cb = cdao.deleteQuery(CID);
    return cb;
  }

  @Override
  public List<ContractBean> getAllHideContract() {
    List<ContractBean> contract = new ArrayList<>();
    contract = cdao.queryAllHideContract();
    return contract;
  }

  @Override
  public void changeHide0(int CID) {
    cdao.changeHide0(CID);
  }

  @Override
  public void changeHide1(int CID) {
    cdao.changeHide1(CID);
  }

  @Override
  public List<ContractRoom_TypeItemsBean> getRoomType() {
    List<ContractRoom_TypeItemsBean> ctbList = new ArrayList<>();
    ctbList = cdao.queryRoomType();
    return ctbList;
  }

  @Override
  public List<ContractBean> nameSearch(String name) {
    List<ContractBean> nameList = new ArrayList<>();
    nameList = cdao.nameSearch(name);
    return nameList;
  }
}
