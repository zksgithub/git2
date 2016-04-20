package com.helloever.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.helloever.db.bean.LendBean;
import com.helloever.db.dao.Dao;


public class ImportLendList {

	private InputStreamReader fr = null;
	private BufferedReader br = null;

	public ImportLendList(String f) throws IOException {
		fr = new InputStreamReader(new FileInputStream(f),"gbk");
	}

	/**
	 * 解析csv文件 到一个list中 每个单元个为一个String类型记录，每一行为一个list。 再将所有的行放到一个总list中
	 */
	public List<List<String>> readCSVFile() throws IOException {
		br = new BufferedReader(fr);
		String rec = null;// 一行
		List<List<String>> listFile = new ArrayList<List<String>>();
		List<LendBean> list = new ArrayList<LendBean>();
		String [] strArray ;
		try {
			// 读取一行
			br.readLine();
			while ((rec = br.readLine()) != null) {
				
				rec = rec.replaceAll("\"", "");
				System.out.println(rec);
				strArray= rec.split(",");
				if(strArray.length!=23) continue;
				LendBean lb = new LendBean();
				lb.setCERT_ID_F(strArray[0]);
				lb.setPROP_NO_F(strArray[1]);
				lb.setLOCATION_F(strArray[2]);
				lb.setLEND_DATE(strArray[3]);
				lb.setRET_DATE(strArray[4]);
				lb.setRENEW_DATE(strArray[5]);
				lb.setRENEW_TIMES(strArray[6]);
				lb.setASBACK_DATE(strArray[7]);
				lb.setASBACK_TIMES(strArray[8]);
				lb.setRULE_NO_F(strArray[9]);
				lb.setEXCD_DAYS(strArray[10]);
				lb.setRESP_WKR(strArray[11]);
				lb.setRET_WKR(strArray[12]);
				lb.setMARC_REC_NO_F(strArray[13]);
				lb.setCALL_NO(strArray[14]);
				lb.setCLS_ID(strArray[15]);
				lb.setATTACHMENT(strArray[16]);
				lb.setPREG_FLAG(strArray[17]);
				lb.setRELE_FLAG(strArray[18]);
				lb.setCODE1(strArray[19]);
				lb.setCODE2(strArray[20]);
				lb.setCODE3(strArray[21]);
				lb.setCOPY_FLAG(strArray[22]);
				//list.add(lb);
				Dao.insertBeanToLendList(lb);
				
			}
			System.out.println("总计项目数："+list.size());
			//Dao.insetLendList(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		return listFile;
	}

	public static void main(String[] args) throws Throwable {
		ImportLendList test = new ImportLendList("/Users/kuizhang/Downloads/lend-1.csv");
		test.readCSVFile();		
		
	}

}