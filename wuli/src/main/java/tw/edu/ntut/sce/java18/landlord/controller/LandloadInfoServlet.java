package tw.edu.ntut.sce.java18.landlord.controller;

import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
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

@WebServlet("/LandloadInfo.do")
@MultipartConfig(
    location = "",
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 500,
    maxRequestSize = 1024L * 1024 * 500 * 5)
public class LandloadInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private final Gson gson = new Gson();
  // int num = 0;
  //  String tampFilename;
  //  String tampFileSrc;
  //  String tampFileBase64;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html; charset=UTF-8;");
    response.setCharacterEncoding("UTF-8");
    HttpSession session = request.getSession();

    // 1. 以房東會員ID撈出房東資料
    var landloadInfo = new LandlordInfoService().queryLandlordInfoByPrimaryKey(1);
    // 2. 以房東資料的公司章檔名，找到對應圖檔的路徑
    String imgPath = System.getProperty("java.io.tmpdir") + "images//" + landloadInfo.getStamp();

    // var file = new File(new File(System.getProperty("java.io.tmpdir")), landloadInfo.getStamp());
    // System.out.println("!!!!imgPath!!!!" + imgPath);

    // 3.將圖片處理成 Data URI資料
    String imgBase64 = getImageEncoderByPath(imgPath);
    String imgMimeType = getMimeType(landloadInfo.getStamp());
    String myimgSrc = "data:" + imgMimeType + ";" + "base64," + imgBase64;

    // 4.將會員資料轉成兩個Map，一個放會員資料，一個放大小章
    var landloadDataMap = Map.of("resultData", landloadInfo, "resultImg", myimgSrc);
    session.setAttribute("myimgSrc", myimgSrc);
    session.setAttribute("landloadInfo", landloadInfo);

    // 5. 將Map資料轉成gson檔案，往前端送
    var printWriter = response.getWriter();
    var landloadInfoJson = gson.toJson(landloadDataMap);
    printWriter.print(landloadInfoJson);
    printWriter.flush();
    // System.out.println(landloadInfoJson);
  }

  /*============== # doPost方法 # =================*/
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 1. 定義兩個landlordINFO，landlordOld放原有資料庫的房東資料，landlordInfoEdit放用戶輸入的值
    LandlordInfo landlordOld;
    LandlordInfo landlordInfoEdit = new LandlordInfo(); // 此變數存入用戶輸入的值，如有錯誤會產生json送到前台，讓用戶修改
    LandlordInfoService landlordInfoService = new LandlordInfoService();
    Map<String, String> errorMsgs = new HashMap<String, String>();
    int num = -1;
    String tampFilename = "";
    String tampFileSrc = "";
    String tampFileBase64 = "";

    HttpSession session = request.getSession();

    if (!session.isNew()) {
      landlordOld = (LandlordInfo) session.getAttribute("landloadInfo");
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

          /*=== <判斷 landloadName> ===*/
          if (fldName.equals("landloadName")) {
            var landloadName = value;
            landlordInfoEdit.setName(landloadName);
            if (landloadName == null || landloadName.trim().length() == 0) {
              errorMsgs.put("errLandloadName", "必須輸入公司名稱");
            } else {
              session.setAttribute("landloadName", landloadName);
            }
          }
          /*=== <判斷 landloadPhone> ===*/
          else if (fldName.equals("landloadPhone")) {
            var landloadPhone = value;
            Matcher matcher;
            landloadPhone = value.replaceAll("\\s*", "");
            landlordInfoEdit.setPhone(landloadPhone);

            if (landloadPhone.length() != 10) {
              errorMsgs.put("errLandloadPhone", "手機電話為09開頭且總數為10碼");
            } else if (!landloadPhone.startsWith("09")) {
              errorMsgs.put("errLandloadPhone", "請輸入以「09」為開頭的手機電話");
            } else if (landloadPhone.length() > 10 && landloadPhone.startsWith("09")) {
              Pattern pattern = Pattern.compile("\\d{8}");
              matcher = pattern.matcher(landloadPhone.substring(2));
              if (!matcher.matches()) {
                errorMsgs.put("errLandloadPhone", "手機電話格式後8碼錯誤");
                // str.matches("[0-9]{4}-[0-9]{6}")
              }
            } else {
              session.setAttribute("landloadPhone", landloadPhone);
            }
          }
          /*=== <判斷 county> ===*/
          else if (fldName.equals("county")) {
            var landloadCounty = value;
            landlordInfoEdit.setCounty(landloadCounty);

            if (landloadCounty == null || landloadCounty.trim().length() == 0) {
              errorMsgs.put("errLandloadAddress", "必須輸入縣市");
            } else {
              request.setAttribute("landloadCounty", landloadCounty);
            }
          }

          /*=== <判斷 district> ===*/
          else if (fldName.equals("district")) {
            var landloadDistrict = value;
            landlordInfoEdit.setDistrict(landloadDistrict);
            if (landloadDistrict == null || landloadDistrict.trim().length() == 0) {
              errorMsgs.put("errLandloadAddress", "必須輸入區域");
            } else {
              request.setAttribute("landloadDistrict", landloadDistrict);
            }
          }

          /*=== <判斷 landloadAddress> ===*/
          else if (fldName.equals("landloadAddress")) {
            var landloadAddress = value;
            landlordInfoEdit.setAddress(landloadAddress);
            if (landloadAddress == null || landloadAddress.trim().length() == 0) {
              errorMsgs.put("errLandloadAddress", "必須輸入地址");
            } else {
              request.setAttribute("landloadAddress", landloadAddress);
            }
          }

          /*=== <判斷 landloadMail> ===*/
          else if (fldName.equals("landloadMail")) {
            var landloadMail = value;
            landlordInfoEdit.setMail(landloadMail);
            if (landloadMail == null || landloadMail.trim().length() == 0) {
              errorMsgs.put("errLandloadMail", "必須輸入eMail");
            } else {
              request.setAttribute("landloadMail", landloadMail);
            }
          }
        } // if (p.getContentType() == null)

        /*=== <判斷 landloadStamp> ===*/

        else {
          /*透過getAttribute 來保存num、tampFilename、tampFileSrc、tampFileBase64等區域變數 */
          if (session.getAttribute("num") == null) {
            num = 0;
          } else {
            num = (int) session.getAttribute("num");
          }
          // System.out.println("num:" + num);

          var sizeInBytes = -100L;
          var fileName = getFileName(p); // 此為圖片檔的檔名
          // System.out.println("fileName:  --->" + fileName);

          if (num == 0) {
            tampFilename = landlordOld.getStamp();
            sizeInBytes = -1;
            landlordInfoEdit.setStamp(tampFilename);
            String imgPath = System.getProperty("java.io.tmpdir") + "images//" + tampFilename;
            // "C:\\_SpringBoot\\workspace\\sansuiyuan\\wuli\\src\\main\\webapp\\file\\temp\\"
            //   + tampFilename;
            String img64 = getImageEncoderByPath(imgPath);
            String imgMimeType = getMimeType(tampFilename);
            String imgSrc = "data:" + imgMimeType + ";" + "base64," + img64;
            session.setAttribute("imgSrc", imgSrc);
            tampFileSrc = imgSrc;
            tampFileBase64 = img64;
            session.setAttribute("tampFilename", tampFilename);
            session.setAttribute("tampFileSrc", tampFileSrc);
            session.setAttribute("tampFileBase64", tampFileBase64);

          } else if (num > 0 && fileName.length() == 0) {
            tampFilename = (String) session.getAttribute("tampFilename");
            landlordInfoEdit.setStamp(tampFilename);
            tampFileSrc = (String) session.getAttribute("tampFileSrc");
            session.setAttribute("imgSrc", tampFileSrc);

            // System.out.println("沒傳圖檔");
          }

          if (fileName != null && fileName.trim().length() > 0 && num >= 0) {
            num++;
            session.setAttribute("num", num);
            fileName = GlobalService.getFileName(p); // 由變數 p 中取出檔案名稱
            fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);

            String imgMimeType = getMimeType(fileName);
            String img64 = getImageEncoderByPart(p);
            String imgSrc = "data:" + imgMimeType + ";" + "base64," + img64;
            // System.out.println(img64);
            tampFilename = fileName;
            tampFileSrc = imgSrc;
            tampFileBase64 = img64;
            session.setAttribute("tampFilename", tampFilename);
            session.setAttribute("tampFileSrc", tampFileSrc);
            session.setAttribute("tampFileBase64", tampFileBase64);
            landlordInfoEdit.setStamp(tampFilename);
            session.setAttribute("imgSrc", tampFileSrc);
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
      // session.setAttribute("landloadInfoEdit", landlordInfoEdit);
      var landlordInfoResponse = Map.of("result", landlordInfoEdit);
      var landloadInfoJson = gson.toJson(landlordInfoResponse);
      var errMsgsJson = gson.toJson(errorMsgs);
      session.setAttribute("landloadInfoJson", landloadInfoJson);
      session.setAttribute("errMsgsJson", errMsgsJson);

      // var printWriter = response.getWriter();
      // printWriter.print(landloadInfoJson);
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
      tampFileBase64 = (String) session.getAttribute("tampFileBase64"); // 這裡要把區域變數提出來，不然會沒有資料
      String newFileName =
          saveImage(tampFileBase64, landlordInfoEdit.getStamp(), landlordOld.getId());
      newBean.setStamp(newFileName);
      landlordInfoService.updateLandlordInfo(newBean);
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

  public String saveImage(final String tampFileBase64, final String fileName, int uid)
      throws IOException {
    String fileNewName = "";

    /*======== 1.建立目錄 ===========*/
    //    File filePath =
    //        new
    // File("C:\\_SpringBoot\\workspace\\sansuiyuan\\wuli\\src\\main\\webapp\\file\\stamps");
    //    if (!filePath.exists()) {
    //      filePath.mkdir();
    //    }

    if (tampFileBase64 == null) { // 影象資料為空
      // System.out.println("img64為空值");
    } else {
      try {
        byte[] decodeImg = Base64.getDecoder().decode(tampFileBase64); // Base64解碼

        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date fileNameDate = new Date();
        fileNewName = "mid_" + uid + "_" + sdf.format(fileNameDate) + fileType;
        String imgFilePath =
            System.getProperty("java.io.tmpdir") + "images//" + fileNewName; // 新生成的圖片

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
