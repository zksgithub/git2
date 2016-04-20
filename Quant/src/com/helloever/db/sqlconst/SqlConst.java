/**
 * 
 */
package com.helloever.db.sqlconst;

/**
 * @author zk
 * SQL 语句
 */
public class SqlConst {
	final public static String SQL_I001=new StringBuffer("")
							.append("INSERT INTO SCIENTISTS(NAME,CONTENT) VALUES(?,?)").toString();
	
	final public static String SQL_I002=new StringBuffer("")
	.append("INSERT INTO LENDLIST2(CERT_ID_F,PROP_NO_F,LOCATION_F,LEND_DATE,RET_DATE,RENEW_DATE,RENEW_TIMES,ASBACK_DATE,ASBACK_TIMES,RULE_NO_F,EXCD_DAYS,RESP_WKR,RET_WKR,MARC_REC_NO_F,CALL_NO,CLS_ID,ATTACHMENT,PREG_FLAG,RELE_FLAG,CODE1,CODE2,CODE3,COPY_FLAG)  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)").toString();
	
	final public static String SQL_I003=new StringBuffer("")
	.append("INSERT INTO READER(CERT_ID,ID_CARD,NAME,SEX,BIRTHDAY,DEPT,OCCUPATION,DUTY,POSITION,ADDRESS,TELE,POSTCODE,EMAIL,TOTAL_LEND_QTY,YEAR_LEND_QTY,VOLT_FLAG,DEBT_FLAG,EDUCATION,PASSWORD,CODE01,CODE02,PORTRAIT,REMARK,REDR_REG_DAY,REDR_DEL_DAY,DEPOSIT,REDR_FLAG,REDR_TYPE_CODE,LEND_GRD,R_DEP_ID,OBLIGATE,MOBILE,PWD_CHECK_FLAG,EMAIL_CHECK_FLAG,LIMIT_FLAG,UNION_CIRC_FLAG,CODE06,CODE07,CODE08)  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)").toString();
	final public static String SQL_S001=new StringBuffer("")
							.append("SELECT CXSM FROM CXINDEX WHERE CXBZ =?").toString();
    
    final public static String SQL_S002=new StringBuffer("")
							.append("SELECT CXBZ,CXSM,COLOR,SIZE FROM CXINDEX").toString();
    final public static String SQL_S003=new StringBuffer("")
							.append("SELECT * FROM scientists").toString();
    
  

	
	

}
