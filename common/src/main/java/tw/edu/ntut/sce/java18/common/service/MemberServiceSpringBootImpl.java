package tw.edu.ntut.sce.java18.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;
import tw.edu.ntut.sce.java18.common.dao.MemberDao;
import tw.edu.ntut.sce.java18.common.dto.MemberRegisterRequest;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

@Service
public class MemberServiceSpringBootImpl implements MemberServiceSpringBoot {

  private final static Logger log = LoggerFactory.getLogger(MemberServiceSpringBootImpl.class);

  @Autowired
  private MemberDao memberDao;

  @Override
  public Integer register(MemberRegisterRequest memberRegisterRequest) {
      // 檢查註冊的 email
      MemberBean memberBean = memberDao.getMemberByEmail(memberRegisterRequest.getMail());

      if (memberBean != null){
        log.warn("該 Email {} 已經被註冊",memberRegisterRequest.getMail());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
      }

    // 使用 MD5 生成密碼的雜湊值
    String hashedPassword = DigestUtils.md5DigestAsHex(memberRegisterRequest.getPassword().getBytes());
    memberRegisterRequest.setPassword(hashedPassword);

    // 創建帳號
    return memberDao.insertMemberS(memberRegisterRequest);
  }

  @Override
  public MemberBean getMemberById(Integer memberId) {
    return null;
  }
}
