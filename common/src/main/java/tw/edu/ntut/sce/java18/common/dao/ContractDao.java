package tw.edu.ntut.sce.java18.common.dao;

import java.sql.SQLException;
import tw.edu.ntut.sce.java18.common.model.ContractBean;

public interface ContractDao {

  ContractBean insertTenant(ContractBean contract) throws SQLException;
}
