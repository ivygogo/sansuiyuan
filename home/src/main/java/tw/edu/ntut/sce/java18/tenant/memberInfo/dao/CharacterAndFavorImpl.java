package tw.edu.ntut.sce.java18.tenant.memberInfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.CharacterAndFavorDao;
import tw.edu.ntut.sce.java18.common.model.CharacterAndFavorBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class CharacterAndFavorImpl implements CharacterAndFavorDao {
  private DataSource ds = null;
  private Connection conn = null;

  public CharacterAndFavorImpl() {
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
  public boolean idExists(int id) {
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

  /*======儲存個性標籤等資料======*/
  @Override
  public int saveCf(CharacterAndFavorBean cf) {
    String sql =
        " insert into Character_Favor "
            + " (TYPE, NAME, isshow, createtime, update_time) "
            + " values(?,?,?,?,?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, cf.getType());
      ps.setString(2, cf.getName());
      ps.setInt(3, cf.getIsShow());
      ps.setTimestamp(4, cf.getCreatetime());
      ps.setTimestamp(5, cf.getCreatetime());
      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("CharacterAndFavorImpl類別#saveCf()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======查詢個性標籤等資料======*/
  @Override
  public CharacterAndFavorBean queryCf(int id) {
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

  /*======取得個性標籤等資料======*/
  @Override
  public String getCfContent(int uId) {
    String sql = "SELECT NAME FROM Character_Favor WHERE ID =?";
    String cfName = null;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, uId);
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

  @Override
  public void setConnection(Connection conn) {
    this.conn = conn;
  }
}
