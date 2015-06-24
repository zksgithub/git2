package com.helloever.tool;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class FileTool {
	
	
	//将文件作为整体读入
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
	//按行读入文件
	public static List<String> getOrderDataFromFile(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		List buffer = new ArrayList();
		String data = br.readLine();//读取下一行
		while( data!=null){
		      data = br.readLine();
		      buffer.add(data); //添加数据
		}
		return buffer;
		}
	
	//写文件
	static void write(String path,String content) throws IOException {
		
		FileOutputStream outSTr = new FileOutputStream(new File(path));
		BufferedOutputStream buffer=new BufferedOutputStream(outSTr);
		buffer.write(content.getBytes());
	}

}
