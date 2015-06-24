package com.helloever.db.dbutil;
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
    private static String url = SystemConfig.getProperty("DbUrl");
    private static String user = SystemConfig.getProperty("UserName");
    private static String passwd = SystemConfig.getProperty("Password");
    private static String driver = SystemConfig.getProperty("DbDriver");
    
    private ComboPooledDataSource cpds; 
    private static DbUtil db = new DbUtil();
    
    public static DbUtil getInstance() {
        return db;
    }
    
    public DbUtil() { 
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( driver);
            cpds.setJdbcUrl( url );
            cpds.setUser(user);                                  
            cpds.setPassword(passwd);  
            
            cpds.setMinPoolSize(5);                                     
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(30);
            cpds.setMaxIdleTime(60);
            
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }   
    }
    
    public static Connection getJdbcConn() throws ClassNotFoundException, SQLException{
    	 Class.forName(driver);
    	 return DriverManager.getConnection(url, user, passwd);
    }
    
    public Connection getConn() {  
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
    
    public static void closeConn(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStmt(Connection conn) {

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            return stmt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeStmt(Statement stmt) {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement getPs(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closePs(PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet doQuery(Statement stmt, String sql) {
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeRs(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}