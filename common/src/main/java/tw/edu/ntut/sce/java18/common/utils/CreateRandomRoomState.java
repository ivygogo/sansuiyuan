package tw.edu.ntut.sce.java18.common.utils;

import java.util.ArrayList;

public class CreateRandomRoomState {

  public ArrayList<String> randomRoomData() {
    String[] build = {"C", "E"};
    String[] position = {"L", "R"};
    String[] type = {"1A", "1B", "1C", "2D", "2E", "2F"};

    ArrayList<String> result = new ArrayList<>();

    int n = 0;
    for (String b : build) {
      for (String p : position) {
        for (var i = 1; i <= 8; i++) {
          for (String t : type) {
            n++;
            System.out.println(
                n + " , " + b + p + "0" + i + "F" + t + " , " + b + " , " + t + " , " + i + " , "
                    + p + " , " + random());
            result.add(b + p + "0" + i + "F" + t);
          }
        }
      }
    }

    return result;
  }

  private static String random() {
    if (((int) (Math.random() * 2)) >= 1) {
      return "AAAAAAAAAAA";
    }
    return null;
  }
}
