package com.helloever.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class FileToString {
	
	public static String getDataFromFile(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		StringBuffer buffer = new StringBuffer();
		String data = br.readLine();//读取下一行
		while( data!=null){
		      data = br.readLine();
		      buffer.append(data); //添加数据
		}
		return buffer.toString();
		}
	
	

}
