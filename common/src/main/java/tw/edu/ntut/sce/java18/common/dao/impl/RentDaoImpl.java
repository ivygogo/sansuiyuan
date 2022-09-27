package tw.edu.ntut.sce.java18.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import tw.edu.ntut.sce.java18.common.dao.RentDao;
import tw.edu.ntut.sce.java18.common.model.RentBean;
import tw.edu.ntut.sce.java18.common.utils.DBService;

public class RentDaoImpl implements RentDao {
  DataSource ds = null;

  public RentDaoImpl() {
    try {
      Context context = new InitialContext();
      ds = (DataSource) context.lookup(DBService.JNDI_DB_NAME);
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  private static final String SELECT_BY_ID =
      "select m.name, m.Idnumber, m.phone, m.address, g.name, g.Idnumber, g.phone, g.address, m.uId"
          + " from member m join guarantor g on m.UId = g.Memberid where m.Idnumber = ?";

  @Override
  public RentBean select(String string) {
    RentBean result = null;
    try (Connection conn = ds.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID); ) {

      stmt.setString(1, string);
      // try (ResultSet rset = stmt.executeQuery(); ) {
      ResultSet rset = stmt.executeQuery();
      while (rset.next()) {
        result = new RentBean();

        result.setuId(rset.getInt("m.uId"));
        result.setRenterName(rset.getString("m.name"));
        result.setRenterPhone(rset.getString("m.phone"));
        result.setRenterIdNumber(rset.getString("m.Idnumber"));
        result.setRenterAddress(rset.getString("m.address"));
        result.setGuarntorName(rset.getString("g.name"));
        result.setGuarntorPhone(rset.getString("g.phone"));
        result.setGuarntorIdNumber(rset.getString("g.Idnumber"));
        result.setGuarntorAddress(rset.getString("g.address"));
        // }
        System.out.println(rset.getInt("m.uId"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
