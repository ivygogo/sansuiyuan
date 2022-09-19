package tw.edu.ntut.sce.java18.common.service.impl;

import java.util.List;
import tw.edu.ntut.sce.java18.common.dao.TenantDao;
import tw.edu.ntut.sce.java18.common.dao.impl.TenantDaoImpl;
import tw.edu.ntut.sce.java18.common.model.TenantBean;
import tw.edu.ntut.sce.java18.common.service.TenantService;

public class TenantServiceImpl implements TenantService {

  TenantDao tenantdao;

  public TenantServiceImpl() {
    tenantdao = new TenantDaoImpl();
  }

  @Override
  public boolean checkTenantIdExists(int memberId) {
    return tenantdao.checkTenantIdExists(memberId);
  }

  @Override
  public int saveTenant(TenantBean tenant) {
    return tenantdao.saveTenant(tenant);
  }

  @Override
  public TenantBean queryTenantByMemberId(int memberId) {
    return tenantdao.queryTenantByMemberId(memberId);
  }

  @Override
  public List<TenantBean> getContractInfo(int memberId) {
    return tenantdao.getContractInfo(memberId);
  }

  @Override
  public String getRoomNumberByMemberId(int memberId) {
    return tenantdao.getRoomNumberByMemberId(memberId);
  }
}
