package com.helloever.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.helloever.db.dao.Dao;
import com.helloever.tool.FileTool;
import com.helloever.tool.ScientistFileStructured;
import com.helloever.www.Java2XML;

public class T {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, JDOMException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		List<String> ListOfscientist = Dao.selectScientist();
		
		Date start = new Date();
		
		for(int i =0;i<ListOfscientist.size();i++){
						 
		System.out.println("Generate NO"+i+":"+ListOfscientist.get(i));
		
		ScientistFileStructured.generateHtml(ListOfscientist.get(i));
		
		ScientistFileStructured.generateXML(ListOfscientist.get(i));
		
		}
		Date end = new Date();
		System.out.println(end.getTime()-start.getTime());
		System.out.println("Finish!");

}
}
	
