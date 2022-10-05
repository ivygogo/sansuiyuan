package tw.edu.ntut.sce.java18.landlord.controller;

import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import tw.edu.ntut.sce.java18.common.utils.GlobalService;
import tw.edu.ntut.sce.java18.landlord.model.LandlordInfo;
import tw.edu.ntut.sce.java18.landlord.service.LandlordInfoService;

@WebServlet("/LandlordInfo.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024L * 1024 * 500 * 5)
public class LandlordInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private final Gson gson = new Gson();
  // int num = 0;
  //  String tempFilename;
  //  String tempFileSrc;
  //  String tempFileBase64;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();
    LandlordInfo landlord = (LandlordInfo) session.getAttribute("LoginOK");
    // 1. 以房東會員ID撈出房東資料
    var landlordInfo = new LandlordInfoService().queryLandlordInfoByPrimaryKey(landlord.getId());
    // var landlordInfo = new LandlordInfoService().queryLandlordInfoByPrimaryKey(1);
    String imgPath = null;
    String imgBase64 = null;
    String imgMimeType = null;
    String myimgSrc = null;

    // 2. 以房東資料的公司章檔名，找到對應圖檔的路徑
    File filePath = new File("C:\\_SpringBoot\\tomcat9\\temp\\images\\");

    // 2.1 如果資料庫欄位不為空值
    if (Optional.ofNullable(landlordInfo.getStamp()).isPresent()
        && landlordInfo.getStamp().trim().length() != 0) {

      // 2.2 先判斷檔案是否存在
      imgPath = filePath + "\\" + landlordInfo.getStamp();
      File file = new File(imgPath);
      if (file.exists()) {
        // 檔案存在，將圖片處理成 Data URI資料
        imgBase64 = getImageEncoderByPath(imgPath);
        imgMimeType = getMimeType(landlordInfo.getStamp());
        myimgSrc = "data:" + imgMimeType + ";" + "base64," + imgBase64;
        System.out.println(file + " Exists");
      } else {
        // 檔案不存在
        myimgSrc = "";
        System.out.println(file + " Does not exists");
      }
    } else {
      myimgSrc = "";
    }
    // System.getProperty("java.io.tmpdir") + "images//"

    // 4.將會員資料轉成兩個Map，一個放會員資料，一個放大小章
    var landlordDataMap = Map.of("resultData", landlordInfo, "resultImg", myimgSrc);
    session.setAttribute("myimgSrc", myimgSrc);
    session.setAttribute("landlordInfo", landlordInfo);

    // 5. 將Map資料轉成gson檔案，往前端送
    var printWriter = response.getWriter();
    var landlordInfoJson = gson.toJson(landlordDataMap);
    printWriter.print(landlordInfoJson);
    printWriter.flush();
    // System.out.println(landlordInfoJson);
  }

  /*============== # doPost方法 # =================*/
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 1. 定義兩個landlordINFO，landlordOld放原有資料庫的房東資料，landlordInfoEdit放用戶輸入的值
    LandlordInfo landlordOld;
    LandlordInfo landlordInfoEdit = new LandlordInfo(); // 此變數存入用戶輸入的值，如有錯誤會產生json送到前台，讓用戶修改
    LandlordInfoService landlordInfoService = new LandlordInfoService();
    Map<String, String> errorMsgs = new HashMap<String, String>();
    int num = -1;
    String tempFilename = "";
    String tempFileSrc = "";
    String tempFileBase64 = "";
    String folder = "C:\\_SpringBoot\\tomcat9\\temp\\images\\";

    HttpSession session = request.getSession();

    if (!session.isNew()) {
      landlordOld = (LandlordInfo) session.getAttribute("landlordInfo");
    } else {
      landlordOld = new LandlordInfo();
    }

    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8;");
    request.setAttribute("ErrMsg", errorMsgs);

    Collection<Part> parts = request.getParts();

    if (parts != null) {

      /* 測試表單是否有正確傳入
      List<String> partList = new ArrayList<>();
      for (Part p : parts) {
        String fldName = p.getName();
        partList.add(fldName);
        // System.out.println(fldName);
      }*/

      for (Part p : parts) {
        String fldName = p.getName();
        String value = request.getParameter(fldName);

        if (p.getContentType() == null) {

          /*=== <判斷 landlordName> ===*/
          if (fldName.equals("landlordName")) {
            var landlordName = value;
            landlordInfoEdit.setName(landlordName);
            if (landlordName == null || landlordName.trim().length() == 0) {
              errorMsgs.put("errLandlordName", "必須輸入公司名稱");
            } else {
              session.setAttribute("landlordName", landlordName);
            }
          }
          /*=== <判斷 landlordPhone> ===*/
          else if (fldName.equals("landlordPhone")) {
            var landlordPhone = value;
            Matcher matcher;
            landlordPhone = value.replaceAll("\\s*", "");
            landlordInfoEdit.setPhone(landlordPhone);

            if (landlordPhone.length() != 10) {
              errorMsgs.put("errLandlordPhone", "手機電話為09開頭且總數為10碼");
            } else if (!landlordPhone.startsWith("09")) {
              errorMsgs.put("errLandlordPhone", "請輸入以「09」為開頭的手機電話");
            } else if (landlordPhone.length() > 10 && landlordPhone.startsWith("09")) {
              Pattern pattern = Pattern.compile("\\d{8}");
              matcher = pattern.matcher(landlordPhone.substring(2));
              if (!matcher.matches()) {
                errorMsgs.put("errLandlordPhone", "手機電話格式後8碼錯誤");
                // str.matches("[0-9]{4}-[0-9]{6}")
              }
            } else {
              session.setAttribute("landlordPhone", landlordPhone);
            }
          }
          /*=== <判斷 county> ===*/
          else if (fldName.equals("county")) {
            var landlordCounty = value;
            landlordInfoEdit.setCounty(landlordCounty);

            if (landlordCounty == null || landlordCounty.trim().length() == 0) {
              errorMsgs.put("errLandlordAddress", "必須輸入縣市");
            } else {
              request.setAttribute("landlordCounty", landlordCounty);
            }
          }

          /*=== <判斷 district> ===*/
          else if (fldName.equals("district")) {
            var landlordDistrict = value;
            landlordInfoEdit.setDistrict(landlordDistrict);
            if (landlordDistrict == null || landlordDistrict.trim().length() == 0) {
              errorMsgs.put("errLandlordAddress", "必須輸入區域");
            } else {
              request.setAttribute("landlordDistrict", landlordDistrict);
            }
          }

          /*=== <判斷 landlordAddress> ===*/
          else if (fldName.equals("landlordAddress")) {
            var landlordAddress = value;
            landlordInfoEdit.setAddress(landlordAddress);
            if (landlordAddress == null || landlordAddress.trim().length() == 0) {
              errorMsgs.put("errLandlordAddress", "必須輸入地址");
            } else {
              request.setAttribute("landlordAddress", landlordAddress);
            }
          }

          /*=== <判斷 landlordMail> ===*/
          else if (fldName.equals("landlordMail")) {
            var landlordMail = value;
            landlordInfoEdit.setMail(landlordMail);
            if (landlordMail == null || landlordMail.trim().length() == 0) {
              errorMsgs.put("errLandlordMail", "必須輸入eMail");
            } else {
              request.setAttribute("landlordMail", landlordMail);
            }
          }
        } // if (p.getContentType() == null)

        /*=== <判斷 landlordStamp> ===*/

        else {
          /*透過getAttribute 來保存num、tempFilename、tempFileSrc、tempFileBase64等區域變數 */
          if (session.getAttribute("num") == null) {
            num = 0;
          } else {
            num = (int) session.getAttribute("num");
          }
          // System.out.println("num:" + num);

          var sizeInBytes = -100L;
          System.out.println("開始" + num);
          var fileName = getFileName(p); // 此為前端上傳圖片檔的檔名
          // System.out.println("fileName:  --->" + fileName);

          // 1. 判斷大小章是否存在，如果不存在則將檔名設為空字串
          if (Optional.ofNullable(landlordOld.getStamp()).isPresent()) {
            String imgPath = folder + landlordOld.getStamp();
            System.out.println(imgPath);
            System.out.println("bug1");
            File imgFile = new File(imgPath);
            if (!imgFile.exists()) {
              landlordOld.setStamp(" ");
              System.out.println("bug2");
              errorMsgs.put("errLandlordPic", "必須輸入大小章");
            }
          }

          // 如果上傳的fileName是空值，且資料庫沒有圖
          if (!Optional.ofNullable(fileName).isPresent()
              || !Optional.ofNullable(landlordOld.getStamp()).isPresent()
              || landlordOld.getStamp().trim().length() == 0) {
            System.out.println("bug3");
            errorMsgs.put("errLandlordPic", "必須輸入大小章");
          }

          // 如果上傳的fileName有值
          if (Optional.ofNullable(fileName).isPresent() && fileName.trim().length() > 0) {
            System.out.println("bug4");
            errorMsgs.remove("errLandlordPic");
            num++;
            session.setAttribute("num", num);
            fileName = GlobalService.getFileName(p); // 由變數 p 中取出檔案名稱
            fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);

            String imgMimeType = getMimeType(fileName);
            System.out.println(p);
            String img64 = getImageEncoderByPart(p);
            String imgSrc = "data:" + imgMimeType + ";" + "base64," + img64;
            // System.out.println(img64);
            tempFilename = fileName;
            tempFileSrc = imgSrc;
            tempFileBase64 = img64;
            session.setAttribute("tempFilename", tempFilename);
            session.setAttribute("tempFileSrc", tempFileSrc);
            session.setAttribute("tempFileBase64", tempFileBase64);
            System.out.println("tempFileBase64 有圖" + tempFileBase64);
            landlordInfoEdit.setStamp(tempFilename);
            session.setAttribute("imgSrc", tempFileSrc);
          }

          if (num == 0
              && (Optional.ofNullable(landlordOld.getStamp()).isPresent()
                  && landlordOld.getStamp().trim().length() != 0)) {
            if (fileName.length() == 0) {

            } else {
              System.out.println(fileName.length() == 0);
              System.out.println(!Optional.ofNullable(fileName).isPresent());
              System.out.println("我是檔名" + fileName);
              sizeInBytes = -1;
              landlordInfoEdit.setStamp(tempFilename);
              // File filePath = new File("C:\\_SpringBoot\\tomcat9\\temp\\images\\");
              String imgPath = "C:\\_SpringBoot\\tomcat9\\temp\\images\\" + tempFilename;
              System.out.println("n=0" + imgPath);
              System.out.println(num);
              System.out.println(tempFilename);
              System.out.println(imgPath);
              String img64 = getImageEncoderByPath(imgPath);
              String imgMimeType = getMimeType(tempFilename);
              String imgSrc = "data:" + imgMimeType + ";" + "base64," + img64;
              session.setAttribute("imgSrc", imgSrc);
              tempFileSrc = imgSrc;
              tempFileBase64 = img64;
              session.setAttribute("tempFilename", tempFilename);
              session.setAttribute("tempFileSrc", tempFileSrc);
              session.setAttribute("tempFileBase64", tempFileBase64);
            }

          } else if (num > 0 && fileName.length() == 0) {
            tempFileBase64 = (String) session.getAttribute("tempFileBase64");
            if (!Optional.ofNullable(tempFileBase64).isPresent()) {
              System.out.println("bug5");
              errorMsgs.put("errLandlordPic", "必須輸入大小章");
            } else {
              tempFilename = (String) session.getAttribute("tempFilename");
              landlordInfoEdit.setStamp(tempFilename);
              tempFileSrc = (String) session.getAttribute("tempFileSrc");
              session.setAttribute("imgSrc", tempFileSrc);
              session.setAttribute("tempFileBase64", tempFileBase64);
              errorMsgs.remove("errLandlordPic");
              System.out.println(tempFileBase64);
              System.out.println("沒傳圖檔");
              System.out.println(num);
            }
          }
        }
        // =============== else end ===============
      }
    } // if (parts != null)
    else {
      errorMsgs.put("errTitle", "表單#parts為空值");
    }

    Set keySet = errorMsgs.keySet();
    Iterator it = keySet.iterator();
    ArrayList<String> errList = new ArrayList<>();
    while (it.hasNext()) {
      String key = (String) it.next();
      /*有了鍵就可以通過map集合的get方法獲取其對應的値 ( key:01, vaule: a  key: 02,vaule: b  key:03, vaule: c)*/
      String value = errorMsgs.get(key);
      // System.out.println("key: " + key + ", vaule: " + value);

      errList.add(key);
      // System.out.println(errList.get(0));

    }

    if (!errList.isEmpty()) {
      session.setAttribute("isInvalid", true);
      // session.setAttribute("landlordInfoEdit", landlordInfoEdit);
      var landlordInfoResponse = Map.of("result", landlordInfoEdit);
      var landlordInfoJson = gson.toJson(landlordInfoResponse);
      var errMsgsJson = gson.toJson(errorMsgs);
      session.setAttribute("landlordInfoJson", landlordInfoJson);
      session.setAttribute("errMsgsJson", errMsgsJson);

      // var printWriter = response.getWriter();
      // printWriter.print(landlordInfoJson);
      // printWriter.flush();
      // response.sendRedirect("memberInfo.jsp");
      RequestDispatcher rd = request.getRequestDispatcher("memberInfo.jsp");
      rd.forward(request, response);
      return;

    } else {
      session.setAttribute("isInvalid", false);
      LandlordInfo newBean = new LandlordInfo();
      newBean.setId(landlordOld.getId());
      newBean.setName(landlordInfoEdit.getName());
      newBean.setCounty(landlordInfoEdit.getCounty());
      newBean.setDistrict(landlordInfoEdit.getDistrict());
      newBean.setAddress(landlordInfoEdit.getAddress());
      newBean.setMail(landlordInfoEdit.getMail());
      newBean.setPhone(landlordInfoEdit.getPhone());
      newBean.setStamp(landlordOld.getStamp());
      tempFileBase64 = (String) session.getAttribute("tempFileBase64"); // 這裡要把區域變數提出來，不然會沒有資料
      System.out.println("我是存檔" + tempFileBase64);
      System.out.println("我是存檔" + landlordInfoEdit.getStamp());
      System.out.println("我是存檔" + landlordOld.getId());

      if (Optional.ofNullable(tempFileBase64).isPresent() && tempFileBase64.length() > 10) {
        System.out.println("進來了1");
        String newFileName =
            saveImage(tempFileBase64, landlordInfoEdit.getStamp(), landlordOld.getId());

        if (!newFileName.isEmpty()) {
          System.out.println("進來了");
          num = -1;
          session.removeAttribute("tempFileBase64");
          session.removeAttribute("tempFilename");
          session.removeAttribute("imgSrc");
          session.removeAttribute("myimgSrc");
          session.removeAttribute("tempFileSrc");
        }
        newBean.setStamp(newFileName);
      }
      landlordInfoService.updateLandlordInfo(newBean); // 儲存方法
      response.sendRedirect("memberInfo.jsp");
      return;
    }
  } // doPost end

  /*================ < 取得檔案名稱 > =====================*/
  private String getFileName(final Part part) {

    for (String content : part.getHeader("content-disposition").split(";")) {
      if (content.trim().startsWith("filename")) {
        return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
      }
    }
    return null;
  }

  public String getMimeType(String filename) {
    String fileType = filename.substring(filename.lastIndexOf("."), filename.length());
    fileType = fileType.substring(1, fileType.length());
    String fileMimeType = "";
    if (fileType.equals("png") || fileType.equals("PNG")) {
      fileMimeType = "image/png";
    } else if (fileType.equals("jpg") || fileType.equals("JPG")) {
      fileMimeType = "image/jpg";
    } else if (fileType.equals("jpeg") || fileType.equals("JPEG")) {
      fileMimeType = "image/jpeg";
    }
    return fileMimeType;
  }

  public String getImageEncoderByPart(final Part part) throws IOException {

    // read image from file
    InputStream stream = part.getInputStream();

    // get byte array from image stream
    int bufLength = 2048;
    byte[] buffer = new byte[2048];
    byte[] data;

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int readLength;
    while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
      out.write(buffer, 0, readLength);
    }

    data = out.toByteArray();
    String imageString = Base64.getEncoder().withoutPadding().encodeToString(data);

    out.close();
    stream.close();
    // System.out.println("Encode Image Result : " + imageString);
    return imageString;
  }

  public String getImageEncoderByPath(final String imgPath) throws IOException {

    // read image from file
    FileInputStream stream = new FileInputStream(imgPath);

    // get byte array from image stream
    int bufLength = 2048;
    byte[] buffer = new byte[2048];
    byte[] data;

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int readLength;
    while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
      out.write(buffer, 0, readLength);
    }

    data = out.toByteArray();
    String imageString = Base64.getEncoder().withoutPadding().encodeToString(data);

    out.close();
    stream.close();

    // System.out.println("Encode Image Result : " + imageString);
    // byte[] decodeImg = Base64.getDecoder().decode(imageString);
    // https://medium.com/javarevisited/encode-and-decode-images-to-base64-in-java-c0b1cd3055b8
    return imageString;
  }

  public String saveImage(final String tempFileBase64, final String fileName, int uid)
      throws IOException {
    String fileNewName = "";

    /*======== 1.建立目錄 ===========*/

    // System.getProperty("java.io.tmpdir") + "images//"
    File filePath = new File("C:\\_SpringBoot\\tomcat9\\temp\\images\\");
    if (!filePath.exists()) {
      filePath.mkdir();
    }

    if (tempFileBase64 == null) { // 影象資料為空
      System.out.println("img64為空值");
    } else {
      try {
        byte[] decodeImg = Base64.getDecoder().decode(tempFileBase64); // Base64解碼
        System.out.println("存檔");
        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date fileNameDate = new Date();
        fileNewName = "mid_" + uid + "_" + sdf.format(fileNameDate) + fileType;
        String imgFilePath = "C:\\_SpringBoot\\tomcat9\\temp\\images\\" + fileNewName; // 新生成的圖片

        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(decodeImg);
        out.flush();
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
        // System.out.println("寫入檔案出錯了...~zZ");
      }
    }
    return fileNewName;
  }
}
