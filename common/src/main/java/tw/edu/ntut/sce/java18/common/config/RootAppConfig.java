package tw.edu.ntut.sce.java18.common.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tw.edu.ntut.sce.java18.common.utils.DBService;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties", ignoreResourceNotFound = true)
// @PropertySource("classpath:db.properties")
public class RootAppConfig {

  private static Logger log = LoggerFactory.getLogger(RootAppConfig.class);

  public RootAppConfig() {
    log.info("已建立RootAppConfig物件");
  }

  @Value("${jdbc.maxPoolSize}")
  Integer maxPoolsize;

  @Value("${jdbc.initPoolSize}")
  Integer initPoolsize;

  @Value("${jdbc.driverClass}")
  String driverClass;

  @Value("admin")
  String user;

  @Value("${jdbc.jdbcUrl}")
  String jdncUrl;

  @Value("admin123")
  String pswd;

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource ds = new ComboPooledDataSource();
    ds.setUser(user);
    ds.setPassword(pswd);
    try {
      ds.setDriverClass(driverClass);
    } catch (PropertyVetoException e) {
      e.printStackTrace();
    }
    ds.setJdbcUrl(jdncUrl);
    ds.setInitialPoolSize(initPoolsize);
    ds.setMaxPoolSize(maxPoolsize);
    log.info("已經建立DataSource物件");
    return ds;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    // 第一次建立本檔案時就要列入所有含永續類別的套件
    factory.setPackagesToScan(
        new String[] {
          "tw.edu.ntut.sce.java18.wuli.model",
          "tw.edu.ntut.sce.java18.common.model",
          "tw.edu.ntut.sce.java18.home.model"
        });
    factory.setDataSource(dataSource());
    factory.setHibernateProperties(additionalProperties());
    log.info("已經建立LocalSessionFactoryBean物件, DatabaseType=" + DBService.DB_TYPE);
    return factory;
  }

  @Bean(name = "transactionManager")
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);
    log.info("已經建立LocalSessionFactoryBean物件, DatabaseType=" + DBService.DB_TYPE);
    return txManager;
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", org.hibernate.dialect.MySQL8Dialect.class);
    properties.put("hibernate.show_sql", Boolean.TRUE);
    properties.put("hibernate.format_sql", Boolean.TRUE);
    properties.put("default_batch_fetch_size", 10);
    properties.put("hibernate.hbm2ddl.auto", "update");
    return properties;
  }
}
