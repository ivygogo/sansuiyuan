package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.AvatarDao;
import tw.edu.ntut.sce.java18.common.model.AvatarBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class AvatarDaoImpl implements AvatarDao {
  private DataSource ds = null;

  public AvatarDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("AvatarDaoImpl類別#建構子發生例外: " + ex.getMessage());
    }
  }

  /*======以Id判斷頭像是否存在======*/
  @Override
  public boolean checkAvatarIdExists(int id) {
    boolean exist = false;
    String sql = "SELECT * FROM Avatar WHERE Id = ?";
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
      throw new RuntimeException("AvatarDaoImpl類別#idExists()發生例外: " + ex.getMessage());
    }
    return exist;
  }

  /*======儲存頭像======*/
  @Override
  public int saveAvatar(AvatarBean avatar) {
    String sql =
        " insert into Avatar "
            + " (id, AvatarName, genderType, isShow, createTime, updateTime) "
            + " values(?, ?, ?, ?, ?, ?) ";
    int n = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, avatar.getId());
      ps.setString(2, avatar.getAvatarName());
      ps.setInt(1, avatar.getGenderType());
      ps.setInt(3, avatar.getIsShow());
      ps.setTimestamp(4, avatar.getCreatetime());
      ps.setTimestamp(5, avatar.getUpdatetime());

      n = ps.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("AvatarDaoImpl類別#saveTenant()發生例外: " + ex.getMessage());
    }
    return n;
  }

  /*======以ID尋找頭像======*/
  @Override
  public AvatarBean queryAvatarByPrimaryKey(int id) {
    AvatarBean ab = null;
    String sql = "SELECT * FROM Avatar WHERE ID = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          ab = new AvatarBean();
          ab.setId(rs.getInt("id"));
          ab.setAvatarName(rs.getString("AvatarName"));
          ab.setGenderType(rs.getInt("GenderType"));
          ab.setIsShow(rs.getInt("isShow"));
          ab.setCreatetime(rs.getTimestamp("createtime"));
          ab.setUpdatetime(rs.getTimestamp("Updatetime"));
        }
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("AvatarDaoImpl類別#queryAvata()發生例外: " + ex.getMessage());
    }
    return ab;
  }

  /*======以avatarName尋找頭像======*/
  public int queryAvatarIdByName(String avatarName) {
    int avatarId = -1;
    String sql = "SELECT ID FROM Avatar WHERE avatarName = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, avatarName);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          avatarId = rs.getInt("id");
        }
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("AvatarDaoImpl類別#queryAvata()發生例外: " + ex.getMessage());
    }
    return avatarId;
  }

  /*======以性別取出所有頭像，丟給編輯頁面======*/
  @Override
  public List<String> queryAvatarNameByGender(int genderId) {
    List<String> list = new ArrayList<>();
    String sql = "SELECT avatarName FROM Avatar WHERE GenderType = ? AND IsShow=1";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, genderId);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          String avatarName = rs.getString(1);
          if (avatarName != null) {
            list.add(avatarName.replace(".png", ""));
          }
        }
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
      throw new RuntimeException("AvatarDaoImpl類別#queryAvatarByGender()發生例外: " + ex.getMessage());
    }
    return list;
  }
}
