package net.txeis.unity.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.txeis.unity.model.CustomLogs;
import net.txeis.unity.model.SessionRequest;
import net.txeis.unity.util.LogReqPopulate;

@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("net.txeis.unity.controller"),@ComponentScan("net.txeis.unity.service"),
      @ComponentScan("net.txeis.unity.dao") })
public class AppConfig {

   @Autowired
   private Environment env;

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

      //Gets data source from dataSource
      factoryBean.setDataSource(dataSource());

      //Gets defined hibernate properies object from hibernateProperties function
      factoryBean.setHibernateProperties(hibernateProperties());

      //Defined other packages to be scanned necessary for the local session factory to be aware of
      factoryBean.setPackagesToScan("net.txeis.unity.model");

      //Configure log4j2 properties
      configureLog4j2();

      return factoryBean;
   }

   @Bean
   public DataSource dataSource() { 
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(env.getProperty("sybase.driver"));
      dataSource.setUrl(env.getProperty("sybase.url"));
      dataSource.setUsername(env.getProperty("sybase.user"));
      dataSource.setPassword(env.getProperty("sybase.password"));
 
      return dataSource;
   }
   
   @Bean
   public SessionRequest sessionRequest() {
       return new SessionRequest();
   }
   
   @Bean
   public LogReqPopulate lineItemReqPopulate() {
       return new LogReqPopulate();
   }
   
   @Bean
   public CustomLogs customLogs() {
       return new CustomLogs();
   }
   
   @Bean
   @Autowired
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());

      return transactionManager;
   }

   Properties hibernateProperties() { 
         return new Properties() { 
               private static final long serialVersionUID = -2287861646921544821L;
         {
                     setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
                     setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
                     setProperty("hibernate.c3p0.min_size", env.getProperty("hibernate.c3p0.min_size"));
                     setProperty("hibernate.c3p0.max_size", env.getProperty("hibernate.c3p0.max_size"));
                     setProperty("hibernate.c3p0.acquire_increment", env.getProperty("hibernate.c3p0.acquire_increment"));
                     setProperty("hibernate.c3p0.timeout", env.getProperty("hibernate.c3p0.timeout"));
                     setProperty("hibernate.c3p0.max_statements", env.getProperty("hibernate.c3p0.max_statements"));
                     setProperty("hibernate.c3p0.preferredTestQuery", env.getProperty("hibernate.c3p0.preferredTestQuery"));
                     setProperty("hibernate.c3p0.testConnectionOnCheckout", env.getProperty("hibernate.c3p0.testConnectionOnCheckout"));
               }
         };
   }

   /**
    * Configures dynamic runtime properties for log4j2
    */
   private void configureLog4j2() { 
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
      System.setProperty("current.date.time", dateFormat.format(new Date()));
   }
}
