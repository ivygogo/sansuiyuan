package tw.edu.ntut.sce.java18.common.dao;

import java.sql.SQLException;
import tw.edu.ntut.sce.java18.common.model.ContractBean;
import tw.edu.ntut.sce.java18.common.model.ContractStatusBean;

public interface ContractDao {

  ContractBean insertTenant(ContractBean contract) throws SQLException;

  ContractStatusBean insertContract(ContractStatusBean contractStatus) throws SQLException;
}
