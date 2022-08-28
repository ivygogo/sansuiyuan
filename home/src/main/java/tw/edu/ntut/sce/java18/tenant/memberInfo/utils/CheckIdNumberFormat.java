package tw.edu.ntut.sce.java18.tenant.memberInfo.utils;

import java.util.ArrayList;
import java.util.List;

public class CheckIdNumberFormat {

  public String checkIdNumber(String formValue, int genderId) {
    String errMsg = "";
    String idNumber = "";
    int countyCode = -1;
    idNumber = formValue.replace(" ", "");
    countyCode = (int) (idNumber.substring(0, 1).toUpperCase().charAt(0));
    List<Integer> code = new ArrayList<>();

    if (idNumber == null || idNumber.trim().length() == 0) {
      errMsg = "必須輸入身分證號";

    } else if (idNumber.length() != 10) {
      errMsg = "身分證號格式錯誤";

    } else if (countyCode < 65 || countyCode > 90) {
      errMsg = "身分證號縣市碼不正確";

    } else if (genderId != Character.getNumericValue(idNumber.charAt(1))) {
      errMsg = "身分證號性別碼不正確";

    } else if (!(idNumber.substring(2)).matches("[0-9]{8}")) {
      errMsg = "身分證號格式不正確";

    } else if (idNumber.length() == 10 && (idNumber.substring(2)).matches("[0-9]{8}")) {

      code.add((int) idNumber.substring(0, 1).toUpperCase().charAt(0));
      // System.out.println((int) idNumber.substring(0, 1).toUpperCase().charAt(0));
      for (int i = 1; i < idNumber.length(); i++) {
        int num =
            (Character.getNumericValue(idNumber.substring(i, (i + 1)).toUpperCase().charAt(0)));
        code.add(num);
      }
      int[] weight = {
        10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33
      };
      int firstCode = weight[(code.get(0) - 65)];

      int sum = (firstCode / 10) * 1 + (firstCode % 10) * 9;

      int encode = 8;
      for (int i = 1; i <= (idNumber.length() - 1); i++) {
        sum += code.get(i) * encode;
        // System.out.println("sum" + i + ":" + sum);
        encode--;
      }
      sum += code.get(9);

      if (sum % 10 != 0) {
        errMsg = "身分證號格式不正確";
      } else {
        errMsg = "checkOK";
      }
    }
    return errMsg;
  }
}
