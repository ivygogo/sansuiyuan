package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import java.util.List;
import tw.edu.ntut.sce.java18.common.model.TenantBean;

public interface TenantDao {
  boolean idExists(int Member_Id);

  int saveTenant(TenantBean tb);

  TenantBean queryTenant(int Member_Id);

  List<TenantBean> getContractInfo(int Member_Id);

  void setConnection(Connection con);
}
