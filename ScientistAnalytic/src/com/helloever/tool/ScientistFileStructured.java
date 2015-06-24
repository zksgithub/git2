/**
 * 
 */
package com.helloever.tool;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.helloever.SystemConfig;
import com.helloever.bean.CxindexBean;
import com.helloever.db.dao.Dao;
import com.helloever.www.Java2XML;

/**
 * @author zk
 *
 */
public class ScientistFileStructured {
	
	public  static void generateXML(String name) throws IOException, ClassNotFoundException, SQLException, JDOMException{
       
		new FileTool();
		//按行读取文件
		List<String> listOfFileByLine = FileTool.getOrderDataFromFile(SystemConfig.getProperty("sourceOftxt")+name+".txt");
		//存放每行解析出来的词		
		List<Term> wordList = null;
		//将词性对照表放入内存
		Map<String, String> map = Dao.selectCxIndexToMap();
		
		Java2XML j2x = new Java2XML(); 
		//创建根节点
		Element root = new Element(name+"年表"); 
		 
		Document Doc = new Document(root);
		
		for(int k=0;k<listOfFileByLine.size();k++){			
			
			if(null!=listOfFileByLine.get(k))
			
			wordList = NlpAnalysis.parse(listOfFileByLine.get(k).toString()); else continue;						
			 //创建父节点
			 Element elements = new Element("content");
			 
			 elements.setAttribute("line", "" + k);
			 
			 elements.setText(listOfFileByLine.get(k).toString());
			 
			for(int i=0 ;i<wordList.size();i++)
		    {    	
			    
                //是否做词性过滤		   
				//if(parse.get(i).getNatureStr().substring(0,1).equals("n")||parse.get(i).getNatureStr().substring(0,1).equals("v")||parse.get(i).getNatureStr().substring(0,1).equals("q")||parse.get(i).getNatureStr().substring(0,1).equals("m")||parse.get(i).getNatureStr().equals("wj")){
		       	
		    	//创建子节点		    	
		    	if(null != map.get(wordList.get(i).getNatureStr()))
		    		
		    	elements.addContent(new Element("词").setAttribute("属性",map.get(wordList.get(i).getNatureStr())).setText(wordList.get(i).getName())); 
		        //给根节点添加content节点
		    	root.addContent(elements.detach());
		   // }
		    
		   
		   }
			
	}
		//按输出时间写入
		Date date=new Date();

		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		
		Format format = Format.getPrettyFormat();
		

        XMLOutputter XMLOut = new XMLOutputter(format);
       

        XMLOut.output(Doc, new FileOutputStream(SystemConfig.getProperty("targetOfXml")+name+df.format(date)+".xml"));
        
        j2x.BuildXMLDoc();
	}
	
	
	public static void generateHtml(String name) throws IOException, ClassNotFoundException, SQLException{
		
		new FileTool();
		//按行读取文件
		List<String> listOfFileByLine = FileTool.getOrderDataFromFile(SystemConfig.getProperty("sourceOftxt")+name+".txt");
		//存放每行解析出来的词		
		List<Term> wordList = null;
		//将词性对照表放入内存
		Map<String, CxindexBean> map = Dao.selectCxIndexBeanToMap();
		
		StringBuffer htmlSource = new StringBuffer();
		
		CxindexBean temp;
		
		htmlSource.append(FileTool.getDataFromFile("html/head.html"));
		
		for(int k=0;k<listOfFileByLine.size();k++){
			
			if(null!=listOfFileByLine.get(k))	
				
			wordList = NlpAnalysis.parse(listOfFileByLine.get(k).toString()); else continue;
			
			for(int i=0 ;i<wordList.size();i++)
		    {    
				
				if(null != map.get(wordList.get(i).getNatureStr())){
					
					temp = map.get(wordList.get(i).getNatureStr());
					//System.out.println(temp);
					
					htmlSource.append("<FONT SIZE="+temp.getSize()+" color ='"+temp.getColor()+"'>"+wordList.get(i).getName()+"</FONT>");
				}
		    }
			htmlSource.append("<br>");
			
		}
		htmlSource.append(FileTool.getDataFromFile("html/foot.html"));
		
		//按输出时间写入
		Date date=new Date();

		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		
		Format format = Format.getPrettyFormat();
		
		FileTool.write(SystemConfig.getProperty("targetOfHtml")+name+df.format(date)+".html", htmlSource.toString());
	}

}
