package tw.edu.ntut.sce.java18.tenant.controller;


import tw.edu.ntut.sce.java18.common.model.MemberBean;
import tw.edu.ntut.sce.java18.common.service.MemberService;
import tw.edu.ntut.sce.java18.common.service.impl.MemberServiceImpl;
import tw.edu.ntut.sce.java18.common.utils.GlobalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/register/register.do")
public class RegisterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  //
  // 設定密碼欄位必須由大寫字母、小寫字母、數字與 !@#$%!^'" 等四組資料組合而成，且長度不能小於八個字元
  //
  private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
  private Pattern pattern = null;
  private Matcher matcher = null;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    // 準備存放錯誤訊息的Map物件
    Map<String, String> errorMsg = new HashMap<>();
    // 準備存放註冊成功之訊息的Map物件
    Map<String, String> msgOK = new HashMap<>();
    // 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
    // session物件來存放共用資料。
    HttpSession session = request.getSession();
    request.setAttribute("MsgMap", errorMsg); // 顯示錯誤訊息
    session.setAttribute("MsgOK", msgOK); // 顯示正常訊息

    String mail = "";
    String name = "";
    int gender = 0;
    String phone = "";
    String Id_Number = "";
    String password = "";
    String password1 = "";
    String address = "";
    String nickname = "";
    String fileName = "";
    long sizeInBytes = 0;
    InputStream is = null;

    // 取出HTTP multipart request內所有的parts
    Collection<Part> parts = request.getParts();
    // GlobalService.exploreParts(parts, request);
    // 由parts != null來判斷此上傳資料是否為HTTP multipart request
    if (parts != null) {  // 如果這是一個上傳資料的表單
      for (Part p : parts) {
        String fldName = p.getName();
        String value = request.getParameter(fldName);

        // 1. 讀取使用者輸入資料
        if (p.getContentType() == null) {
          if (fldName.equals("mail")) {
            mail = value;
          } else if (fldName.equals("name")) {
            name = value;
          } else if (fldName.equals("gender")) {
            gender = Integer.parseInt(value);
          } else if (fldName.equals("phone")) {
            phone = value;
          } else if (fldName.equals("Id_Number")) {
            Id_Number = value;
          } else if (fldName.equals("password")) {
            password = value;
          } else if (fldName.equals("nickname")) {
            nickname = value;
          }

        } else {
          // 取出圖片檔的檔名
          fileName = GlobalService.getFileName(p);
          // 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
          fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
          if (fileName != null && fileName.trim().length() > 0) {
            sizeInBytes = p.getSize();
            is = p.getInputStream();
          }
        }
      }

      // 2. 進行必要的資料轉換
      // (無)
      // 3. 檢查使用者輸入資料
      if (mail == null || mail.trim().length() == 0) {
        errorMsg.put("errorIdEmpty", "帳號欄必須輸入");
      }
      if (password == null || password.trim().length() == 0) {
        errorMsg.put("errorPasswordEmpty", "密碼欄必須輸入");
      }
      if (password1 == null || password1.trim().length() == 0) {
        errorMsg.put("errorPassword1Empty", "密碼確認欄必須輸入");
      }
      if (password.trim().length() > 0 && password1.trim().length() > 0) {
        if (!password.trim().equals(password1.trim())) {
          errorMsg.put("errorPassword1Empty", "密碼欄必須與確認欄一致");
          errorMsg.put("errorPasswordEmpty", "*");
        }
      }
      if (name == null || name.trim().length() == 0) {
        errorMsg.put("errorName", "姓名欄必須輸入");
      }
      if (address == null || address.trim().length() == 0) {
        errorMsg.put("errorAddr", "地址欄必須輸入");
      }
      if (phone == null || phone.trim().length() == 0) {
        errorMsg.put("errorPhone", "電話號碼欄必須輸入");
      }
      if (Id_Number == null || Id_Number.trim().length() == 0) {
        errorMsg.put("errorTel", "身分證欄必須輸入");
      }
      if (nickname == null || nickname.trim().length() == 0) {
        errorMsg.put("errorNickName", "匿名欄必須輸入");
      }

    } else {
      errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
    }
    // 如果有錯誤
    if (errorMsg.isEmpty()) {
      pattern = Pattern.compile(PASSWORD_PATTERN);
      matcher = pattern.matcher(password);
      if ( !matcher.matches() ) {
        errorMsg.put("passwordError", "密碼至少含有一個大寫字母、小寫字母、數字與!@#$%!^'\"等四組資料組合而成，且長度不能小於八個字元");
      }
    }
    if (!errorMsg.isEmpty()) {
//			Set<String> set = errorMsg.keySet();
//			for(String s : set) {
//				System.out.println(s);
//			}
      // 導向原來輸入資料的畫面，這次會顯示錯誤訊息
      RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
      rd.forward(request, response);
      return;
    }
    try {
      // 4. 產生MemberDao物件，以便進行Business Logic運算
      // MemberDaoImpl_Jdbc類別的功能：
      // 1.檢查帳號是否已經存在，已存在的帳號不能使用，回傳相關訊息通知使用者修改
      // 2.若無問題，儲存會員的資料
      MemberService service = new MemberServiceImpl();
      if (service.mailExists(mail)) {
        errorMsg.put("errorMailDup", "此信箱已註冊過");
      } else {
        // 要在此加密，不要在 dao.saveMember(mem)進行加密
        password = GlobalService.getMD5Endocing(
            GlobalService.encryptString(password));
        Timestamp ts = new Timestamp(System.currentTimeMillis());
//      Blob blob = null;
//      if (is != null) {
//        blob = GlobalService.fileToBlob(is, sizeInBytes);
//      }
        MemberBean mem = new MemberBean(name,gender,mail,phone,Id_Number,password,address,nickname,ts);

        // 呼叫MemberDao的saveMember方法
        int n = service.saveMember(mem);
        if (n == 1) {
          msgOK.put("InsertOK", "<Font color='red'>新增成功，請開始使用本系統</Font>");
          response.sendRedirect("../index.jsp");
          return;
        } else {
          errorMsg.put("errorMailDup", "新增此筆資料有誤(RegisterServlet)");
        }
      }
      // 5.依照 Business Logic 運算結果來挑選適當的畫面
      if (!errorMsg.isEmpty()) {
        // 導向原來輸入資料的畫面，這次會顯示錯誤訊息
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        return;
      }
    } catch (Exception e) {
      e.printStackTrace();
      errorMsg.put("errorMailDup", e.getMessage());
      RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
      rd.forward(request, response);
    }
  }
}
