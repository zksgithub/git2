package com.helloever.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helloever.bean.CxindexBean;
import com.helloever.db.dbutil.DbUtil;
import com.helloever.db.sqlConst.SqlConst;


public class Dao {
	//向科学家表中增加科学家信息
	public static void insertContent(String name,String content) throws ClassNotFoundException, SQLException{
		
		PreparedStatement pstmt = DbUtil.getJdbcConn().prepareStatement(SqlConst.SQL_I001);
		
		pstmt.setString(1, name);
		
		pstmt.setString(2, content);
		
		pstmt.execute();
	}
	//选择词性的详细说明
	public static String selectContent(String name) throws ClassNotFoundException, SQLException{
		
		String cxsm = "";
		
		PreparedStatement pstmt = DbUtil.getJdbcConn().prepareStatement(SqlConst.SQL_S001);
		
		pstmt.setString(1, name);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) cxsm = rs.getString("CXSM");
		
		return cxsm;
	}
	
	//将词性转换成map，以便快速查找
	public static Map<String,String> selectCxIndexToMap() throws ClassNotFoundException, SQLException{
		
		Map<String,String> map = new HashMap();
		
		PreparedStatement pstmt = DbUtil.getJdbcConn().prepareStatement(SqlConst.SQL_S002);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) 
		
			map.put(rs.getString("CXBZ"),rs.getString("CXSM"));
		
		return map;
	}
	
	//将词性内容转换成map，以便快速查找
	public static Map<String,CxindexBean> selectCxIndexBeanToMap() throws ClassNotFoundException, SQLException{
					
		Map<String,CxindexBean> map = new HashMap<String, CxindexBean>();
		
		PreparedStatement pstmt = DbUtil.getJdbcConn().prepareStatement(SqlConst.SQL_S002);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			CxindexBean bean= new CxindexBean();
			
			bean.setColor(rs.getString("COLOR"));
			
			bean.setSize(rs.getString("SIZE"));
			
			bean.setCxsm(rs.getString("CXSM"));	
			
			bean.setCxbz(rs.getString("CXBZ"));
			
		    map.put(rs.getString("CXBZ"),bean);
		}
		return map;
	}
	
	//选择科学家姓名
	public static List<String> selectScientist() throws ClassNotFoundException, SQLException{
		
		List <String> scientists = new ArrayList();
		
		PreparedStatement pstmt = DbUtil.getJdbcConn().prepareStatement(SqlConst.SQL_S003);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) scientists.add(rs.getString("name"));
		
		return scientists;
	}

}
