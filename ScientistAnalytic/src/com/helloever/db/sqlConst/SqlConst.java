/**
 * 
 */
package com.helloever.db.sqlConst;

/**
 * @author zk
 * SQL 语句
 */
public class SqlConst {
	final public static String SQL_I001=new StringBuffer("")
							.append("INSERT INTO SCIENTISTS(NAME,CONTENT) VALUES(?,?)").toString();
	
    final public static String SQL_S001=new StringBuffer("")
							.append("SELECT CXSM FROM CXINDEX WHERE CXBZ =?").toString();
    
    final public static String SQL_S002=new StringBuffer("")
							.append("SELECT CXBZ,CXSM,COLOR,SIZE FROM CXINDEX").toString();
    final public static String SQL_S003=new StringBuffer("")
							.append("SELECT * FROM SCIENTISTS").toString();
	
	

}
