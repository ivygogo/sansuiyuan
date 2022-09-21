package tw.edu.ntut.sce.java18.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

  @GetMapping("/insertMember")
  public String insert(){
    return "insertMember";
  }
}
