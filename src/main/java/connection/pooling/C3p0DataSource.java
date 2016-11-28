package connection.pooling;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0DataSource {
  
  private static C3p0DataSource datasource;
  private ComboPooledDataSource cpds;
  
  private C3p0DataSource() throws IOException, SQLException, PropertyVetoException {
    cpds = new ComboPooledDataSource();
    cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
    cpds.setJdbcUrl("jdbc:mysql://localhost/test");
    cpds.setUser("root");
    cpds.setPassword("root");
    
    // the settings below are optional -- c3p0 can work with defaults
    cpds.setMinPoolSize(5);
    cpds.setAcquireIncrement(5);
    cpds.setMaxPoolSize(20);
    cpds.setMaxStatements(180);
    
  }
  
  public static C3p0DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
    if (datasource == null) {
      datasource = new C3p0DataSource();
      return datasource;
    } else {
      return datasource;
    }
  }
  
  public Connection getConnection() throws SQLException {
    return this.cpds.getConnection();
  }
  
}
