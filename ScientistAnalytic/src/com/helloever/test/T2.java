package com.helloever.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.jdom2.JDOMException;

import com.helloever.SystemConfig;
import com.helloever.tool.FileTool;
import com.helloever.tool.ScientistFileStructured;

public class T2 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, JDOMException {
		
		ScientistFileStructured.generateHtml("刘振兴");
}
}

