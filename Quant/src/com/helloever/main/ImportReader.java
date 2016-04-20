/**
 * 
 */
package com.helloever.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.helloever.db.bean.LendBean;
import com.helloever.db.bean.ReaderBean;
import com.helloever.db.dao.Dao;

/**
 * @author kuizhang
 *
 */
public class ImportReader {
	private InputStreamReader fr = null;
	private BufferedReader br = null;

	public  ImportReader(String f) throws IOException {
		fr = new InputStreamReader(new FileInputStream(f),"gbk");
	}

	/**
	 * 解析csv文件 到一个list中 每个单元个为一个String类型记录，每一行为一个list。 再将所有的行放到一个总list中
	 */
	public void readCSVFile() throws IOException {
		br = new BufferedReader(fr);
		String rec = null;// 一行
	
		String [] strArray ;
		try {
			// 读取一行
			br.readLine();
			while ((rec = br.readLine()) != null) {
				
				rec = rec.replaceAll("\"", "");
				rec+="T4B";
				//rec = new String(rec.getBytes("gbk"), "utf8"); 
				System.out.println(rec);
				strArray= rec.split(",");
				
				if(strArray.length<39) {
					System.out.println("长度为："+strArray.length);
					continue;
				}
				
				ReaderBean bean = new ReaderBean();
				bean.setCERT_ID(strArray[0]);
				bean.setID_CARD(strArray[1]);
				bean.setNAME(strArray[2]);
				bean.setSEX(strArray[3]);
				bean.setBIRTHDAY(strArray[4]);
				bean.setDEPT(strArray[5]);
				bean.setOCCUPATION(strArray[6]);
				bean.setDUTY(strArray[7]);
				bean.setPOSITION(strArray[8]);
				bean.setADDRESS(strArray[9]);
				bean.setTELE(strArray[10]);
				bean.setPOSTCODE(strArray[11]);
				bean.setEMAIL(strArray[12]);
				bean.setTOTAL_LEND_QTY(strArray[13]);
				bean.setYEAR_LEND_QTY(strArray[14]);
				bean.setVOLT_FLAG(strArray[15]);
				bean.setDEBT_FLAG(strArray[16]);
				bean.setEDUCATION(strArray[17]);
				bean.setPASSWORD(strArray[18]);
				bean.setCODE01(strArray[19]);
				bean.setCODE02(strArray[20]);
				bean.setPORTRAIT(strArray[21]);
				bean.setREMARK(strArray[22]);
				bean.setREDR_REG_DAY(strArray[23]);
				bean.setREDR_DEL_DAY(strArray[24]);
				bean.setDEPOSIT(strArray[25]);
				bean.setREDR_FLAG(strArray[26]);
				bean.setREDR_TYPE_CODE(strArray[27]);
				bean.setLEND_GRD(strArray[28]);
				bean.setR_DEP_ID(strArray[29]);
				bean.setOBLIGATE(strArray[30]);
				bean.setMOBILE(strArray[31]);
				bean.setPWD_CHECK_FLAG(strArray[32]);
				bean.setEMAIL_CHECK_FLAG(strArray[33]);
				bean.setLIMIT_FLAG(strArray[34]);
				bean.setUNION_CIRC_FLAG(strArray[35]);
				bean.setCODE06(strArray[36]);
				bean.setCODE07(strArray[37]);
				bean.setCODE08(strArray[38]);
				//list.add(lb);
				Dao.insertReaderBean(bean);
				
			}	
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

	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ImportReader test = new ImportReader("/Users/kuizhang/Downloads/reader-1.csv");
		test.readCSVFile();		

	}

}
