package tw.edu.ntut.sce.java18.tenant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tw.edu.ntut.sce.java18.common.model.FaqMvcTest;
import tw.edu.ntut.sce.java18.common.service.FaqMvcTestService;

@Controller
public class FaqMvcTestController {
  private static Logger log = LoggerFactory.getLogger(FaqMvcTestController.class);
  FaqMvcTestService fMvcTestService;

  @Autowired
  public FaqMvcTestController(FaqMvcTestService fMvcTestService) {
    this.fMvcTestService = fMvcTestService;
  }

  @GetMapping(value = {"index"})
  public String runIndexView(@ModelAttribute FaqMvcTest faqMvcTest, Model model) {
    model.addAttribute("FaqMvcTest", faqMvcTest);
    log.info("###########ivyivyivyivyivy##############");
    return "/index";
  }

  @GetMapping(value = {"/home/my"})
  public String showIndexView(@ModelAttribute FaqMvcTest faqMvcTest, Model model) {
    model.addAttribute("FaqMvcTest", faqMvcTest);
    log.info("###########ivyivyivyivyivy##############");
    return "/faqMvc";
  }

  @PostMapping(value = {"/home/my"})
  public String editIndexView(@ModelAttribute("FaqMvcTest") FaqMvcTest faqMvcTest, Model model) {
    FaqMvcTest newBean = new FaqMvcTest();

    newBean.setQuestion(faqMvcTest.getQuestion());
    newBean.setAnswer(faqMvcTest.getAnswer());
    System.out.println("faqMvcTest->>" + faqMvcTest.getQuestion() + faqMvcTest.getAnswer());
    fMvcTestService.save(newBean);
    return "redirect:/index";
  }
}
