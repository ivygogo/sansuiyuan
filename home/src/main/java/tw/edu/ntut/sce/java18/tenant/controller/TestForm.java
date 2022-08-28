package tw.edu.ntut.sce.java18.tenant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestForm {

  int genderCode;
  String idNumber;

  public TestForm() {}

  public static void main(String[] args) {
    TestForm tf = new TestForm();
    String value = "A200215844";
    tf.genderCode = 2;
    int countyCode = -1;
    Map<String, String> errorMsgs = new HashMap<String, String>();

    tf.idNumber = value.replace(" ", "");
    countyCode = (int) (tf.idNumber.substring(0, 1).toUpperCase().charAt(0));
    ArrayList<Integer> code = null;

    if (tf.idNumber == null || tf.idNumber.trim().length() == 0) {
      errorMsgs.put("erridNumber", "必須輸入身分證號");
      System.out.println("必須輸入身分證號");
    } else if (tf.idNumber.length() != 10) {
      errorMsgs.put("erridNumber", "身分證號格式錯誤");
      System.out.println("身分證號格式錯誤");
    } else if (countyCode < 65 || countyCode > 90) {
      errorMsgs.put("erridNumber", "身分證號縣市碼不正確");
      System.out.println("身分證號縣市碼不正確");
    } else if ((char) tf.genderCode != tf.idNumber.charAt(1)) {
      errorMsgs.put("erridNumber", "身分證號性別碼不正確");
      System.out.println("身分證號性別碼不正確" + (tf.idNumber.charAt(1)));
    } else if (!(tf.idNumber.substring(2)).matches("[0-9]{8}")) {
      errorMsgs.put("erridNumber", "身分證號格式不正確");
      System.out.println("身分證號格式不正確");
    } else if (tf.idNumber.length() == 10 && (tf.idNumber.substring(2)).matches("[0-9]{8}")) {

      for (int i = 0; i <= tf.idNumber.length(); i++) {
        int num = (int) (tf.idNumber.substring(i, (i + 1)).toUpperCase().charAt(0));
        code.add(num);
      }

      int[] weight = {
        10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 30,
        31, 32, 33
      };

      // {A=10 B=11 C=12 D=13 E=14 F=15 G=16 H=17 J=18 K=19 L=20 M=21 N=22 P=23 Q=24 R=25
      // S=26
      // T=27 U=28 V=29 W=30 X=31 Y=32 Z=33 I=34 O=35};
      int firstCode = weight[(code.get(0) - 65)];

      int sum = (firstCode / 10) * 1 + (firstCode % 10) * 9;
      int encode = 8;
      for (int i = 1; i <= (tf.idNumber.length() - 1); i++) {
        sum += code.get(i) * encode;
        encode--;
      }
      int end = (int) (Integer.toString(sum).charAt((Integer.toString(sum).length() - 1)));

      if (end != code.get(9)) {
        errorMsgs.put("erridNumber", "身分證號格式不正確");
        System.out.println("身分證號格式不正確");
      }
    } else {
      System.out.println(tf.idNumber);
    }
  }
}
