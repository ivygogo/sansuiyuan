package tw.edu.ntut.sce.java18.landlord.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.utils.DBService;
import tw.edu.ntut.sce.java18.landlord.dao.ContractDao;
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;
import tw.edu.ntut.sce.java18.landlord.model.ContractRoom_TypeItemsBean;

public class ContractDaoImple implements ContractDao {
  private DataSource ds = null;
  private Connection conn = null;

  public ContractDaoImple() {
    try {
      Context ctx = new InitialContext();
      ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //      ---------- 存入合約------------
  @Override
  public int saveContract(ContractBean cb) {
    String sql =
        "insert into"
            + " contract(CID,Name,Room_Number,Room_Type,Payment_Status,Check_Fee,Check_Status,PDF,Signed_Date)"
            + "  values(?,?,?,?,?,?,?,?,?)";
    int updateCount = 0;
    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, cb.getCID());
      ps.setString(2, cb.getName());
      ps.setString(3, cb.getRoom_Number());
      ps.setString(4, cb.getRoom_Type());
      ps.setString(5, cb.getPayment_Status());
      ps.setString(6, cb.getCheck_Fee());
      ps.setString(7, cb.getCheck_Status());
      ps.setString(8, cb.getPDF());
      ps.setString(9, cb.getSigned_Date());
      updateCount = ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updateCount;
  }
  // ------------查詢合約(hide=1)---------------------
  @Override
  public ContractBean contractQuery(int CID) {
    ContractBean cb = null;
    String sql = "SELECT * FROM contract WHERE CID = ? and Hide = 1 ";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, CID);
      try (ResultSet rs = ps.executeQuery(); ) {

        if (rs.next()) {
          cb = new ContractBean();
          cb.setCID(rs.getInt("CID"));
          cb.setStatus(rs.getString("Status"));
          cb.setName(rs.getString("Name"));
          cb.setRoom_Number(rs.getString("Room_Number"));
          cb.setRoom_Type(rs.getString("Room_Type"));
          cb.setPayment_Status(rs.getString("Payment_Status"));
          cb.setCheck_Fee(rs.getString("Check_Fee"));
          cb.setCheck_Status(rs.getString("Check_Status"));
          cb.setPDF(rs.getString("PDF"));
          cb.setSigned_Date(rs.getString("Signed_Date"));
          cb.setHide(rs.getInt("Hide"));
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return cb;
  }
  // ------------查詢合約(hide=1)---------------------
  @Override
  public ContractBean deleteQuery(int CID) {
    ContractBean cb = null;
    String sql = "SELECT * FROM contract WHERE CID = ? and Hide = 0 ";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setInt(1, CID);
      try (ResultSet rs = ps.executeQuery(); ) {

        if (rs.next()) {
          cb = new ContractBean();
          cb.setCID(rs.getInt("CID"));
          cb.setStatus(rs.getString("Status"));
          cb.setName(rs.getString("Name"));
          cb.setRoom_Number(rs.getString("Room_Number"));
          cb.setRoom_Type(rs.getString("Room_Type"));
          cb.setPayment_Status(rs.getString("Payment_Status"));
          cb.setCheck_Fee(rs.getString("Check_Fee"));
          cb.setCheck_Status(rs.getString("Check_Status"));
          cb.setPDF(rs.getString("PDF"));
          cb.setSigned_Date(rs.getString("Signed_Date"));
          cb.setHide(rs.getInt("Hide"));
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return cb;
  }

  //  -----------------修改合約繳費狀態---------------------
  @Override
  public void modifyStatus(
      String status,
      String name,
      String room_Number,
      String payment_status,
      String deposit,
      String check_Fee,
      String check_status,
      int cId) {
    String sql =
        "update contract set Status = ? , Name = ?"
            + ", Room_Number = ?, Payment_Status = ?, Deposit = ?"
            + ", Check_Fee = ? ,Check_Status = ? where CID =?";

    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setString(1, status);
      ps.setString(2, name);
      ps.setString(3, room_Number);
      ps.setString(4, payment_status);
      ps.setString(5, deposit);
      ps.setString(6, check_Fee);
      ps.setString(7, check_status);
      ps.setInt(8, cId);

      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  // -----------------查詢合約狀態---------------------
  @Override
  public ContractBean queryStatus(String Status) {
    String sql = "select status from contract where status = ?";
    ContractBean cb = null;

    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, Status);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          cb = new ContractBean();
          cb.setStatus(rs.getString("Status"));
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return cb;
  }
  // -----------------查詢所有繳費狀態---------------------

  @Override
  public List<ContractBean> queryAllPayment_Status() {
    List<ContractBean> list = new ArrayList<ContractBean>();
    String sql = "select payment_status from contract";
    ContractBean cb = null;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          cb = new ContractBean();
          cb.setPayment_Status(rs.getString("Payment_Status"));
          list.add(cb);
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return list;
  }
  // -----------------------查詢繳費狀態-------------------------
  @Override
  public ContractBean queryPayment_Status(String Payment_Status) {
    String sql = "select payment_status from contract where payment_status = ? ";
    ContractBean cb = null;

    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, Payment_Status);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          cb = new ContractBean();
          cb.setPayment_Status(rs.getString("Payment_Status"));
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return cb;
  }
  // -----------------查詢點交---------------------
  @Override
  public ContractBean queryCheck_Status(String Check_Status) {
    String sql = "select Check_Status from contract where Check_Status = ?";
    ContractBean cb = null;

    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, Check_Status);
      try (ResultSet rs = ps.executeQuery(); ) {
        if (rs.next()) {
          cb = new ContractBean();
          cb.setCheck_Status(rs.getString("Check_Status"));
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return cb;
  }

  @Override
  public void setConnection(Connection con) {
    this.conn = con;
  }

  @Override
  public List<ContractBean> queryAllContract() {
    String sql = "select * from contract where hide = 1";
    List<ContractBean> contract = new ArrayList<>();
    ContractBean cb = null;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {

          cb = new ContractBean();
          cb.setCID(rs.getInt("CID"));
          cb.setStatus(rs.getString("Status"));
          cb.setName(rs.getString("Name"));
          cb.setRoom_Number(rs.getString("Room_Number"));
          cb.setRoom_Type(rs.getString("Room_Type"));
          cb.setPayment_Status(rs.getString("Payment_Status"));
          cb.setCheck_Fee(rs.getString("Check_Fee"));
          cb.setCheck_Status(rs.getString("Check_Status"));
          cb.setPDF(rs.getString("PDF"));
          cb.setSigned_Date(rs.getString("Signed_Date"));
          cb.setDeposit(rs.getString("Deposit"));
          cb.setHide(rs.getInt("Hide"));
          contract.add(cb);
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return contract;
  }
  // ----------查詢隱藏合約---------------
  @Override
  public List<ContractBean> queryAllHideContract() {

    String sql = "select * from contract where Hide = 0";
    List<ContractBean> contract = new ArrayList<>();
    ContractBean cb = null;
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {

          cb = new ContractBean();
          cb.setCID(rs.getInt("CID"));
          cb.setStatus(rs.getString("Status"));
          cb.setName(rs.getString("Name"));
          cb.setRoom_Number(rs.getString("Room_Number"));
          cb.setRoom_Type(rs.getString("Room_Type"));
          cb.setPayment_Status(rs.getString("Payment_Status"));
          cb.setCheck_Fee(rs.getString("Check_Fee"));
          cb.setCheck_Status(rs.getString("Check_Status"));
          cb.setPDF(rs.getString("PDF"));
          cb.setSigned_Date(rs.getString("Signed_Date"));
          cb.setDeposit(rs.getString("Deposit"));
          cb.setHide(rs.getInt("Hide"));
          contract.add(cb);
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return contract;
  }
  // -----------------修改隱藏值---------------------

  @Override
  public void changeHide0(int CID) {
    String sql = "update contract set Hide = 0  where CID = ?";

    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, CID);

      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void changeHide1(int CID) {
    String sql = "update contract set Hide = 1  where CID = ?";

    try (Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
      ps.setInt(1, CID);

      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<ContractRoom_TypeItemsBean> queryRoomType() {
    ContractRoom_TypeItemsBean ctb = null;
    List<ContractRoom_TypeItemsBean> listCtb = new ArrayList<>();
    String sql = "SELECT * FROM ContractRoom_TypeItems";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {
          ctb = new ContractRoom_TypeItemsBean();
          ctb.setRoom_Type(rs.getString("Room_Type"));
          ctb.setTV(rs.getInt("TV"));
          ctb.setWaterHeater(rs.getInt("WaterHeater"));
          ctb.setAirconditioner(rs.getInt("Airconditioner"));
          ctb.setFreezer(rs.getInt("Freezer"));
          ctb.setScreen(rs.getInt("Screen"));
          ctb.setChair(rs.getInt("Chair"));
          ctb.setSingleBed(rs.getInt("SingleBed"));
          ctb.setDoubleBed(rs.getInt("DoubleBed"));
          ctb.setSmallDesk(rs.getInt("SmallDesk"));
          ctb.setBigDesk(rs.getInt("BigDesk"));
          ctb.setSmallSideTable(rs.getInt("SmallSideTable"));
          ctb.setBigSideTable(rs.getInt("BigSideTable"));
          ctb.setWardrobe(rs.getInt("Wardrobe"));
          listCtb.add(ctb);
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return listCtb;
  }

  @Override
  public List<ContractBean> nameSearch(String name) {
    List<ContractBean> contract = new ArrayList<>();
    ContractBean cb = null;
    String sql = "select * from contract where Name = ? and  Hide = 1";
    try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, name);
      try (ResultSet rs = ps.executeQuery(); ) {
        while (rs.next()) {

          cb = new ContractBean();
          cb.setCID(rs.getInt("CID"));
          cb.setStatus(rs.getString("Status"));
          cb.setName(rs.getString("Name"));
          cb.setRoom_Number(rs.getString("Room_Number"));
          cb.setRoom_Type(rs.getString("Room_Type"));
          cb.setPayment_Status(rs.getString("Payment_Status"));
          cb.setCheck_Fee(rs.getString("Check_Fee"));
          cb.setCheck_Status(rs.getString("Check_Status"));
          cb.setPDF(rs.getString("PDF"));
          cb.setSigned_Date(rs.getString("Signed_Date"));
          cb.setDeposit(rs.getString("Deposit"));
          cb.setHide(rs.getInt("Hide"));
          cb.setMemberID(rs.getInt("MemberID"));
          contract.add(cb);
        }
      }

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return contract;
  }
}
