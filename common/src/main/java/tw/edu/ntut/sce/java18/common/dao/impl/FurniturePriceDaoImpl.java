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
import tw.edu.ntut.sce.java18.common.dao.FurniturePriceDao;
import tw.edu.ntut.sce.java18.common.model.FurniturePriceBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class FurniturePriceDaoImpl implements FurniturePriceDao {
  private DataSource ds = null;

  public FurniturePriceDaoImpl() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("FurniturePriceDaoImpl類別#建構子發生例外:" + ex.getMessage());
    }
  }

  @Override
  public List<FurniturePriceBean> getAllFurniturePrice() {
    FurniturePriceBean furniturePrice;
    List<FurniturePriceBean> furniturePriceList = new ArrayList<FurniturePriceBean>();

    String sql = " SELECT * FROM furniture_price ";

    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rset = ps.executeQuery(); ) {

      while (rset.next()) {
        int id = rset.getInt(1);
        String name = rset.getString(2);
        int price = rset.getInt(3);
        String nameAlias = rset.getString(4);
        furniturePrice = new FurniturePriceBean(id, name, price, nameAlias);
        furniturePriceList.add(furniturePrice);
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      throw new RuntimeException(
          "FurniturePriceDaoImpl類別#getAllFurniturePrice()發生例外: " + ex.getMessage());
    }
    return furniturePriceList;
  }

  @Override
  public List<String> getAllFurnitureName() {
    List<String> nameList = new ArrayList<String>();
    String name;
    String sql = " SELECT alias_name FROM furniture_price ";

    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rset = ps.executeQuery(); ) {

      while (rset.next()) {
        name = rset.getString(1);
        nameList.add(name);
      }

    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      throw new RuntimeException(
          "FurniturePriceDaoImpl類別#getAllFurnitureName()發生例外: " + ex.getMessage());
    }
    return nameList;
  }

  @Override
  public int getFurnitureIdByName(String name) {
    int id = -1;
    String sql = " SELECT ID FROM furniture_price where alias_name = ?";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql); ) {
      ps.setString(1, name);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          id = rs.getInt(1);
        }
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      id = -1;
      throw new RuntimeException(
          "FurniturePriceDaoImpl類別#getFurnitureIdByName()發生例外: " + ex.getMessage());
    }
    return id;
  }
}
