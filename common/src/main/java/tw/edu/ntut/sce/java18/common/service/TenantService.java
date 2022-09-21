package tw.edu.ntut.sce.java18.common.service;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.TenantBean;

public interface TenantService {

  boolean checkTenantIdExists(int memberId);

  int saveTenant(TenantBean tenant);

  TenantBean queryTenantByMemberId(int memberId);

  List<TenantBean> getContractInfo(int memberId);

  String getRoomNumberByMemberId(int memberId);
}
