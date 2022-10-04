package tw.edu.ntut.sce.java18.common.service;

import java.sql.SQLException;
import tw.edu.ntut.sce.java18.common.dao.ContractDao;
import tw.edu.ntut.sce.java18.common.dao.impl.ContractDaoImpl;
import tw.edu.ntut.sce.java18.common.model.ContractBean;
import tw.edu.ntut.sce.java18.common.model.ContractStatusBean;

public class ContractService {
  ContractDao dao = null;

  public ContractService() {
    dao = new ContractDaoImpl();
  }

  public ContractBean insertTenant(ContractBean contract) throws SQLException {
    return dao.insertTenant(contract);
  }

  public ContractStatusBean insertContract(ContractStatusBean contractStatus) throws SQLException {
    return dao.insertContract(contractStatus);
  }
}
