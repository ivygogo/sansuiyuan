package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import tw.edu.ntut.sce.java18.common.model.RefundAccountBean;

public interface RefundAccountDao {

  boolean checkRefundAccountIdExists(int id);

  boolean checkRefundAccountIdExistsByMemberId(int memberId);

  int saveRefundAccount(RefundAccountBean refundAccount);

  RefundAccountBean queryRefundAccountByPrimaryKey(int id); // 此uId不是帳號，而是PK

  RefundAccountBean queryRefundAccountByMemberId(int memberId);

  int updateRefundAccount(RefundAccountBean refundAccountBean);
}
