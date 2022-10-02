package tw.edu.ntut.sce.java18.landlord.service;

import java.util.List;
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;
import tw.edu.ntut.sce.java18.landlord.model.ContractRoom_TypeItemsBean;

public interface ContractService {
  ContractBean getContract(int CID);

  ContractBean deleteContract(int CID);

  void modifyContract(
      String status,
      String name,
      String PDF,
      String room_Number,
      String payment_status,
      String deposit,
      String check_Fee,
      String check_status,
      int cId);

  ContractBean getStatus(String Status);

  List<ContractBean> getAllPayment_Status();

  ContractBean getPayment_Status(String Payment_Status);

  ContractBean getCheck_Status(String Check_Status);

  List<ContractBean> getAllContract();

  List<ContractBean> getAllHideContract();

  void changeHide0(int CID);

  void changeHide1(int CID);

  List<ContractRoom_TypeItemsBean> getRoomType();

  List<ContractBean> nameSearch(String Name);
}
