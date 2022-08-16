package tw.edu.ntut.sce.java18.tenant.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RoomTypeServlet")
public class RoomTypeServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String selectRoomType = request.getQueryString();

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    var printWriter = response.getWriter();
    printWriter.print(roomTypeContent(selectRoomType));
    printWriter.flush();
  }

  private static String roomTypeContent(String selectRoomType) {
    String result;
    switch (selectRoomType) {
      case "A":
        result =
            "{\n"
                + "        \"name\": \"單人房A\",\n"
                + "        \"chair\": \"椅子*1\",\n"
                + "        \"bed\": \"雙人床\",\n"
                + "        \"desk\": \"大桌子\",\n"
                + "        \"sideTable\": \"小床頭櫃\",\n"
                + "        \"wardrobe\": \"衣櫃\",\n"
                + "        \"size\": 5,\n"
                + "        \"price\": 8100,\n"
                + "        \"balcony\": false,\n"
                + "        \"pic\": [\"SingleA1.jpg\", \"SingleA2.jpg\", \"SingleA3.jpg\"],\n"
                + "        \"rest\": 1,\n"
                + "        \"availableFloor\": [1, 3, 8]\n"
                + "      }";
        break;
      case "B":
        result =
            "{\n"
                + "        \"name\": \"單人房B\",\n"
                + "        \"chair\": \"椅子*1\",\n"
                + "        \"bed\": \"雙人床\",\n"
                + "        \"desk\": \"大桌子\",\n"
                + "        \"sideTable\": \"小床頭櫃\",\n"
                + "        \"wardrobe\": \"衣櫃\",\n"
                + "        \"size\": 5.2,\n"
                + "        \"price\": 8200,\n"
                + "        \"balcony\": true,\n"
                + "        \"pic\": [\"SingleB1.jpg\", \"SingleB2.jpg\", \"SingleB3.jpg\"],\n"
                + "        \"rest\": 2,\n"
                + "        \"availableFloor\": [1, 5, 8]\n"
                + "      }";
        break;
      case "C":
        result =
            "{\n"
                + "        \"name\": \"單人房C\",\n"
                + "        \"chair\": \"椅子*2\",\n"
                + "        \"bed\": \"單人床\",\n"
                + "        \"desk\": \"大桌子\",\n"
                + "        \"sideTable\": \"小床頭櫃\",\n"
                + "        \"wardrobe\": \"大衣櫃\",\n"
                + "        \"size\": 5.3,\n"
                + "        \"price\": 8300,\n"
                + "        \"balcony\": true,\n"
                + "        \"pic\": [\"SingleC1.jpg\", \"SingleC2.jpg\", \"SingleC3.jpg\"],\n"
                + "        \"rest\": 3,\n"
                + "        \"availableFloor\": [1, 2]\n"
                + "      }";
        break;
      case "D":
        result =
            "{\n"
                + "        \"name\": \"雙人房A\",\n"
                + "        \"chair\": \"椅子*2\",\n"
                + "        \"bed\": \"單人床\",\n"
                + "        \"desk\": \"大桌子\",\n"
                + "        \"sideTable\": \"小床頭櫃\",\n"
                + "        \"wardrobe\": \"衣櫃\",\n"
                + "        \"size\": 6.1,\n"
                + "        \"price\": 8400,\n"
                + "        \"balcony\": false,\n"
                + "        \"pic\": [\"DoubleA1.jpg\", \"DoubleA2.jpg\", \"DoubleA3.jpg\"],\n"
                + "        \"rest\": 4,\n"
                + "        \"availableFloor\": [4, 5]\n"
                + "      }";
        break;
      case "E":
        result =
            "{\n"
                + "        \"name\": \"雙人房B\",\n"
                + "        \"chair\": \"椅子*2\",\n"
                + "        \"bed\": \"單人床\",\n"
                + "        \"desk\": \"大桌子\",\n"
                + "        \"sideTable\": \"小床頭櫃\",\n"
                + "        \"wardrobe\": \"衣櫃\",\n"
                + "        \"size\": 6.2,\n"
                + "        \"price\": 8500,\n"
                + "        \"balcony\": true,\n"
                + "        \"pic\": [\"DoubleB1.jpg\", \"DoubleB2.jpg\", \"DoubleB3.jpg\"],\n"
                + "        \"rest\": 5,\n"
                + "        \"availableFloor\": [8]\n"
                + "      }";
        break;
      case "F":
        result =
            "{\n"
                + "        \"name\": \"雙人房C\",\n"
                + "        \"chair\": \"椅子*2\",\n"
                + "        \"bed\": \"單人床\",\n"
                + "        \"desk\": \"大桌子\",\n"
                + "        \"sideTable\": \"小床頭櫃\",\n"
                + "        \"wardrobe\": \"衣櫃\",\n"
                + "        \"size\": 6.3,\n"
                + "        \"price\": 8600,\n"
                + "        \"balcony\": true,\n"
                + "        \"pic\": [\"DoubleC1.jpg\", \"DoubleC2.jpg\", \"DoubleC3.jpg\"],\n"
                + "        \"rest\": 0,\n"
                + "        \"availableFloor\": []\n"
                + "      }";
        break;
      default:
        result = null;
    }
    return result;
  }
}
