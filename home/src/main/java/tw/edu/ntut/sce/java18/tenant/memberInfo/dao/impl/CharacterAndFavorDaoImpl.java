package tw.edu.ntut.sce.java18.tenant.memberInfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.model.CharacterAndFavorBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;
import tw.edu.ntut.sce.java18.tenant.memberInfo.dao.CharacterAndFavorDao;

public class CharacterAndFavorDaoImpl implements CharacterAndFavorDao {
  private DataSource ds = null;

  public CharacterAndFavorDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  /*======判斷id是否存在======*/
  @Override
  public boolean checkCharacterAndFavorIdExists(int id) {
    boolean exist = false;
    String sql = "SELECT * FROM Character_Favor WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          exist = true;
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl類別#idExists()發生例外: " + ex.getMessage());
    }
    return exist;
  }

  /*======儲存個性標籤和室友喜好資料======*/
  @Override
  public int save(CharacterAndFavorBean characterandfavor) {
    String sql =
        " insert into Character_Favor "
            + " (TYPE, NAME, isshow, createtime, update_time) "
            + " values(?,?,?,?,?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, characterandfavor.getType());
      ps.setString(2, characterandfavor.getName());
      ps.setInt(3, characterandfavor.getIsShow());
      ps.setTimestamp(4, characterandfavor.getCreatetime());
      ps.setTimestamp(5, characterandfavor.getCreatetime());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl類別#saveCf()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======用id查詢個性標籤和室友喜好資料(回傳物件)======*/
  @Override
  public CharacterAndFavorBean queryCharacterAndFavorByPrimaryKey(int id) {
    CharacterAndFavorBean cfb = null;
    String sql = "SELECT * FROM Character_Favor WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          cfb = new CharacterAndFavorBean();
          cfb.setId(rs.getInt("id"));
          cfb.setType(rs.getInt("type"));
          cfb.setName(rs.getString("name"));
          cfb.setIsShow(rs.getInt("isShow"));
          cfb.setCreatetime(rs.getTimestamp("createtime"));
          cfb.setUpdate_time(rs.getTimestamp("update_time"));
          cfb.setDelete_time(rs.getTimestamp("delete_time"));
        }
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl類別#queryCf()發生例外: " + ex.getMessage());
    }
    return cfb;
  }

  /*======用id查詢個性標籤和室友喜好資料(回傳圖片檔名)======*/
  @Override
  public String queryCharacterAndFavorNameByPrimaryKey(int id) {
    String sql = "SELECT NAME FROM Character_Favor WHERE ID =?";
    String cfName = null;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          cfName = rs.getString("name");
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl類別#getCfContent()發生例外: " + ex.getMessage());
    }
    return cfName;
  }

  /*======撈出個性標籤所有圖片檔名(回傳List)======*/
  @Override
  public List<String> getAllCharacter() {
    String sql = "SELECT DISTINCT NAME FROM CHARACTER_FAVOR WHERE TYPE=1 AND IsShow=1 ";
    List<String> list = new ArrayList<>();
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(); ) {
      while (rs.next()) {
        String character = rs.getString(1);
        if (character != null) {
          list.add(character);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "CharacterAndFavorImpl()#getAllCharacter()發生例外: " + ex.getMessage());
    }
    return list;
  }

  /*======撈出室友喜好所有圖片檔名(回傳List)======*/
  @Override
  public List<String> getAllFavor() {
    String sql = "SELECT DISTINCT NAME FROM CHARACTER_FAVOR WHERE TYPE=2 AND IsShow=1 ";
    List<String> list = new ArrayList<>();
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(); ) {
      while (rs.next()) {
        String favor = rs.getString(1);
        if (favor != null) {
          list.add(favor);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl()#getAllFavor()發生例外: " + ex.getMessage());
    }
    return list;
  }

  /*======合併以上兩個方法======*/

  @Override
  public List<String> getCharacterOrFavorNameByType(int type) {
    List<String> list = new ArrayList<>();
    String sql = "SELECT DISTINCT NAME FROM CHARACTER_FAVOR WHERE TYPE=? AND IsShow=1 ";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.setInt(1, type);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          String favor = rs.getString(1);
          if (favor != null) {
            list.add(favor);
          }
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl()#getAllFavor()發生例外: " + ex.getMessage());
    }

    return list;
  }

  /*======透過個性標籤名稱取回id(回傳int)======*/
  public int getSignatureId(String name) {
    String sql = " SELECT ID FROM CHARACTER_FAVOR WHERE NAME =? AND TYPE=1 ";
    int signatureId = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.setString(1, name);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          signatureId = rs.getInt("ID");
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "CharacterAndFavorImpl類別#getSignatureId()發生例外: " + ex.getMessage());
    }
    return signatureId;
  }

  /*======透過室友喜好名稱取回id(回傳int)======*/
  @Override
  public int getFavorId(String name) {
    String sql = " SELECT ID FROM CHARACTER_FAVOR WHERE NAME =? AND TYPE=2 ";
    int favorId = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.setString(1, name);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          favorId = rs.getInt("ID");
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "CharacterAndFavorImpl類別#getSignatureId()發生例外: " + ex.getMessage());
    }
    // System.out.println("!!!favorId" + favorId);
    return favorId;
  }

  @Override
  public int getCharacterOrFavorIdByNameAndType(String name, int type) {
    String sql = " SELECT ID FROM CHARACTER_FAVOR WHERE NAME =? AND TYPE=? ";
    int CharacterOrFavorId = -1;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.setString(1, name);
      ps.setInt(2, type);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          CharacterOrFavorId = rs.getInt("ID");
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException(
          "CharacterAndFavorImpl類別#getSignatureId()發生例外: " + ex.getMessage());
    }

    return CharacterOrFavorId;
  }
}
