package com.helloever.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;











import com.helloever.db.bean.LendBean;
import com.helloever.db.bean.ReaderBean;
import com.helloever.db.dbutils.DbUtil;
import com.helloever.db.sqlconst.SqlConst;



public class Dao {
	private static final DbUtil dbUtil = DbUtil.getInstance();
	//向科学家表中增加科学家信息
	public static void insertContent(String name,String content) throws ClassNotFoundException, SQLException{
		
		PreparedStatement pstmt = DbUtil.getInstance().getConn().prepareStatement(SqlConst.SQL_I001);
		
		pstmt.setString(1, name);
		
		pstmt.setString(2, content);
		
		pstmt.execute();
	}
	//选择词性的详细说明
	public static String selectContent(String name) throws ClassNotFoundException, SQLException{
		
		String cxsm = "";
		
		PreparedStatement pstmt = DbUtil.getInstance().getConn().prepareStatement(SqlConst.SQL_S001);
		
		pstmt.setString(1, name);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) cxsm = rs.getString("CXSM");
		
		return cxsm;
	}
	
	//将词性转换成map，以便快速查找
	public static Map<String,String> selectCxIndexToMap() throws ClassNotFoundException, SQLException{
		
		Map<String,String> map = new HashMap();
		
		PreparedStatement pstmt = DbUtil.getInstance().getConn().prepareStatement(SqlConst.SQL_S002);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) 
		
			map.put(rs.getString("CXBZ"),rs.getString("CXSM"));
		
		return map;
	}
	
	//选择科学家姓名
	public static List<String> selectScientist() throws ClassNotFoundException, SQLException{
		
		List <String> scientists = new ArrayList();
		
		PreparedStatement pstmt = DbUtil.getInstance().getConn().prepareStatement(SqlConst.SQL_S003);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) scientists.add(rs.getString("name"));
		
		return scientists;
	}
	
	//向借书表中增加数据信息
	public static void insertBeanToLendList(LendBean bean) throws ClassNotFoundException, SQLException{
			
		Connection conn = 	dbUtil.getConn();
		PreparedStatement pstmt =conn.prepareStatement(SqlConst.SQL_I002);

			
			pstmt.setString(1, bean.getCERT_ID_F());
			pstmt.setString(2, bean.getPROP_NO_F());
			pstmt.setString(3, bean.getLOCATION_F());
			pstmt.setString(4, bean.getLEND_DATE());
			pstmt.setString(5, bean.getRET_DATE());
			pstmt.setString(6, bean.getRENEW_DATE());
			pstmt.setString(7, bean.getRENEW_TIMES());
			pstmt.setString(8, bean.getASBACK_DATE());
			pstmt.setString(9, bean.getASBACK_TIMES());
			pstmt.setString(10, bean.getRULE_NO_F());
			pstmt.setString(11, bean.getEXCD_DAYS());
			pstmt.setString(12, bean.getRESP_WKR());
			pstmt.setString(13, bean.getRET_WKR());
			pstmt.setString(14, bean.getMARC_REC_NO_F());
			pstmt.setString(15, bean.getCALL_NO());
			pstmt.setString(16, bean.getCLS_ID());
			pstmt.setString(17, bean.getATTACHMENT());
			pstmt.setString(18, bean.getPREG_FLAG());
			pstmt.setString(19, bean.getRELE_FLAG());
			pstmt.setString(20, bean.getCODE1());
			pstmt.setString(21, bean.getCODE2());
			pstmt.setString(22, bean.getCODE3());
			pstmt.setString(23, bean.getCOPY_FLAG());
			
			
			
			pstmt.execute();
			conn.close();
			
		}
	/**
	 * 插入读者信息表
	 * @param bean
	 * @throws SQLException
	 */
	public static void insertReaderBean(ReaderBean bean) throws SQLException{
		Connection conn = 	dbUtil.getConn();
		PreparedStatement pstmt =conn.prepareStatement(SqlConst.SQL_I003);
	
		pstmt.setString(1, bean.getCERT_ID());
		pstmt.setString(2, bean.getID_CARD());
		pstmt.setString(3, bean.getNAME());
		pstmt.setString(4, bean.getSEX());
		pstmt.setString(5, bean.getBIRTHDAY());
		pstmt.setString(6, bean.getDEPT());
		pstmt.setString(7, bean.getOCCUPATION());
		pstmt.setString(8, bean.getDUTY());
		pstmt.setString(9, bean.getPOSITION());
		pstmt.setString(10, bean.getADDRESS());
		pstmt.setString(11, bean.getTELE());
		pstmt.setString(12, bean.getPOSTCODE());
		pstmt.setString(13, bean.getEMAIL());
		pstmt.setString(14, bean.getTOTAL_LEND_QTY());
		pstmt.setString(15, bean.getYEAR_LEND_QTY());
		pstmt.setString(16, bean.getVOLT_FLAG());
		pstmt.setString(17, bean.getDEBT_FLAG());
		pstmt.setString(18, bean.getEDUCATION());
		pstmt.setString(19, bean.getPASSWORD());
		pstmt.setString(20, bean.getCODE01());
		pstmt.setString(21, bean.getCODE02());
		pstmt.setString(22, bean.getPORTRAIT());
		pstmt.setString(23, bean.getREMARK());
		pstmt.setString(24, bean.getREDR_REG_DAY());
		pstmt.setString(25, bean.getREDR_DEL_DAY());
		pstmt.setString(26, bean.getDEPOSIT());
		pstmt.setString(27, bean.getREDR_FLAG());
		pstmt.setString(28, bean.getREDR_TYPE_CODE());
		pstmt.setString(29, bean.getLEND_GRD());
		pstmt.setString(30, bean.getR_DEP_ID());
		pstmt.setString(31, bean.getOBLIGATE());
		pstmt.setString(32, bean.getMOBILE());
		pstmt.setString(33, bean.getPWD_CHECK_FLAG());
		pstmt.setString(34, bean.getEMAIL_CHECK_FLAG());
		pstmt.setString(35, bean.getLIMIT_FLAG());
		pstmt.setString(36, bean.getUNION_CIRC_FLAG());
		pstmt.setString(37, bean.getCODE06());
		pstmt.setString(38, bean.getCODE07());
		pstmt.setString(39, bean.getCODE08());
		
		pstmt.execute();
		conn.close();
		
	}
	public static void insetLendList(List<LendBean> listBean) throws ClassNotFoundException, SQLException{
		for(int i=0;i<listBean.size();i++){
			insertBeanToLendList(listBean.get(i));
		}
		
	}

}
