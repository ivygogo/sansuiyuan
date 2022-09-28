package tw.edu.ntut.sce.java18.common.service;

import tw.edu.ntut.sce.java18.common.dto.MemberRegisterRequest;
import tw.edu.ntut.sce.java18.common.model.MemberBean;

public interface MemberServiceSpringBoot {

    Integer register(MemberRegisterRequest memberRegisterRequest);

    MemberBean getMemberById(Integer memberId);
}
