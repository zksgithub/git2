package com.helloever.db.dbutils;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.helloever.SystemConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;


public class DbUtil {

    
    private  ComboPooledDataSource cpds; 
    private static final DbUtil dbUtil = new DbUtil();
    
  
    private  DbUtil() { 
    	System.out.println("初始化Dbutil");
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( SystemConfig.getProperty("DbDriver"));
            cpds.setJdbcUrl( SystemConfig.getProperty("DbUrl") );
            cpds.setUser(SystemConfig.getProperty("UserName"));                                  
            cpds.setPassword(SystemConfig.getProperty("Password"));  
            
            cpds.setMinPoolSize(5);                                     
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(30);
            cpds.setMaxIdleTime(60);
            
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }   
    }
    public static final DbUtil getInstance() {
       
    	return dbUtil;
    }
    
    
    public    Connection getConn() {  
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    protected void finalize() throws Throwable {
          DataSources.destroy(cpds);
          super.finalize();
    }
    
 
}