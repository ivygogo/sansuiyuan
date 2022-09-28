package tw.edu.ntut.sce.java18.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ntut.sce.java18.common.dto.MemberRegisterRequest;
import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.service.MemberServiceSpringBoot;

import javax.validation.Valid;

@RestController
public class MemberRestController {

  @Autowired
  private MemberServiceSpringBoot memberServiceSpringBoot;

  @PostMapping("member/register")
  public ResponseEntity<MemberBean> register(@RequestBody @Valid MemberRegisterRequest memberRegisterRequest){
      Integer memberId = memberServiceSpringBoot.register(memberRegisterRequest);

      MemberBean memberBean = memberServiceSpringBoot.getMemberById(memberId);
      return ResponseEntity.status(HttpStatus.CREATED).body(memberBean);
  }


}
