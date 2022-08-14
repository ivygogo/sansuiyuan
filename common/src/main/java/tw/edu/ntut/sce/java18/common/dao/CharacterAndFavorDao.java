package tw.edu.ntut.sce.java18.common.dao;

import java.sql.Connection;
import tw.edu.ntut.sce.java18.common.model.CharacterAndFavorBean;

public interface CharacterAndFavorDao {
  boolean idExists(int id);

  int saveCf(CharacterAndFavorBean cfb);

  CharacterAndFavorBean queryCf(int id);

  String getCfContent(int uId);

  void setConnection(Connection conn);
}
