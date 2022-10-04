package tw.edu.ntut.sce.java18.landlord.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tw.edu.ntut.sce.java18.landlord.model.LandlordBeanM;
import tw.edu.ntut.sce.java18.landlord.service.LandlordService_Mvc;

// @RequestMapping(value = {"/"})
@Controller
public class ShowLandlordMvc {
  LandlordService_Mvc landlordService;
  ProcessImg processImg;
  int memberIdForTest = 1;

  @Autowired
  public ShowLandlordMvc(LandlordService_Mvc landlordService, ProcessImg processImg) {
    this.landlordService = landlordService;
    this.processImg = processImg;
  }
  // 導會員資料頁 jsp
  @GetMapping(value = {"/landlord"})
  public String showLandlordInfoView(Model model) {
    return "/landlordInfo";
  }

  // 內嵌:會員資料頁面
  @GetMapping(value = {"showLandlordInfo"})
  public String showLandlordInfoContent() {
    return "landlordMvc/showLandlordInfo";
  }

  // 內嵌:網站Menu
  @GetMapping(value = {"menu_index"})
  public String showMainMenu() {
    return "fragment/menu_index";
  }
  // 內嵌:網站Footer
  @GetMapping(value = {"footer"})
  public String showMainFooter() {
    return "fragment/footer";
  }

  @ResponseBody
  @GetMapping("/getLandlordInfoGson")
  public String getLandlordInfoGson() throws IOException {
    String myimgSrc = null;

    // 1. 取得會員資料
    LandlordBeanM landlordInfo = landlordService.queryLandlordInfoByPrimaryKey(memberIdForTest);
    System.out.println(landlordInfo.getStamp());
    System.out.println(landlordInfo.getName());
    System.out.println(landlordInfo.getCounty());
    // 2. 取得公司章圖片

    String imgPath = null;
    String imgMimeType = null;
    // System.out.println(landlordInfo.getStamp().length()!=0);
    if (landlordInfo.getStamp() == null || landlordInfo.getStamp().length() == 0) {
      landlordInfo.setStampImg(null);
      myimgSrc = "";
      /*
      imgPath = System.getProperty("java.io.tmpdir") + "//images//" + "stamp.png";
      imgMimeType = processImg.getMimeTypeByFileName("stamp.png");
      landlordInfo.setStamp("stamp.png");
      System.out.println("null");
      System.out.println(System.getProperty("java.io.tmpdir") + "\\images\\" + "stamp.png");*/
    } else {
      imgPath = System.getProperty("java.io.tmpdir") + "//images//" + landlordInfo.getStamp();
      imgMimeType = processImg.getMimeTypeByFileName(landlordInfo.getStamp());

      // System.out.println("ivy!!!!"+System.getProperty("java.io.tmpdir"));
      // 3.將圖片處理成 Data URI資料
      String imgBase64 = processImg.getImageEncoderByPath(imgPath);

      myimgSrc = "data:" + imgMimeType + ";" + "base64," + imgBase64;

      landlordInfo.setStampImg(myimgSrc);
    }

    var landlordDataMap = Map.of("resultData", landlordInfo, "resultImg", myimgSrc);

    final Gson gson = new Gson();
    var landlordInfoJson = gson.toJson(landlordDataMap);
    System.out.println(landlordInfoJson);
    return landlordInfoJson;
  }
}
