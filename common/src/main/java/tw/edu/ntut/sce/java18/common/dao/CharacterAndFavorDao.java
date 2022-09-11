package tw.edu.ntut.sce.java18.common.dao;

import java.util.List;
import tw.edu.ntut.sce.java18.common.model.CharacterAndFavorBean;

public interface CharacterAndFavorDao {
  boolean checkCharacterAndFavorIdExists(int id); // 改id

  int save(CharacterAndFavorBean characterandfavor); // save

  CharacterAndFavorBean queryCharacterAndFavorByPrimaryKey(int id);

  String queryCharacterAndFavorNameByPrimaryKey(int id); // getCfName

  List<String> getAllCharacter(); // 跟下面合併

  List<String> getAllFavor();

  List<String> getCharacterOrFavorNameByType(int type);

  int getSignatureId(String name); // 跟下面合併

  int getFavorId(String name);

  int getCharacterOrFavorIdByNameAndType(String name, int type);
}
