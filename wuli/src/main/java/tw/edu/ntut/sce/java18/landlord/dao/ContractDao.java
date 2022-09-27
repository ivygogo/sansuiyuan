package tw.edu.ntut.sce.java18.landlord.dao;

import java.sql.Connection;
import java.util.List;
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;

public interface ContractDao {
  int saveContract(ContractBean cb);

  void modifyStatus(
      String status,
      String name,
      String PDF,
      String room_Number,
      String payment_status,
      String deposit,
      String check_Fee,
      String check_status,
      int cId);

  List<ContractBean> queryAllContract();

  List<ContractBean> queryAllHideContract();

  ContractBean queryStatus(String Status);

  ContractBean contractQuery(int CID);

  ContractBean deleteQuery(int CID);

  List<ContractBean> queryAllPayment_Status();

  ContractBean queryPayment_Status(String Payment_Status);

  ContractBean queryCheck_Status(String Check_Status);

  void setConnection(Connection con);

  void changeHide0(int CID);

  void changeHide1(int CID);
}
