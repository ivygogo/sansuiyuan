package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import tw.edu.ntut.sce.java18.common.model.RefundAccountBean;

public interface RefundAccountDao {

  boolean idExists(int uId);

  int saveRefundAccount(RefundAccountBean rab);

  RefundAccountBean queryRefundAccountId(int uId); // 此uId不是帳號，而是PK

  RefundAccountBean getRefundAccount(int Member_Id);

  void setConnection(Connection con);
}
