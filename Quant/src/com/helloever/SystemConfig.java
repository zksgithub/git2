package com.helloever;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class SystemConfig {
	/**
	 * 系统配置参数类
	 */
	private static Properties sysetting_properties = new Properties();
	
	/**
	 * 是否初始化
	 */
	private static boolean isInited = false;
	
	/**
	 * 加载系统配置文件
	 * @param resourceName 系统配置资源文件名
	 */
	public static synchronized void loadSysettingFile() {
		if (!isInited) {
			sysetting_properties.clear();

			ResourceBundle oResourceBundle = ResourceBundle.getBundle("sysetting");
			Enumeration<String> oEnumeration = oResourceBundle.getKeys();

			String oKey = null;
			String oValue = null;
			while (oEnumeration.hasMoreElements()) {
				oKey = oEnumeration.nextElement();
				oValue = oResourceBundle.getString(oKey);
				sysetting_properties.put(oKey, oValue);
			}

			isInited = true;
		}
	}
	
	/**
	 * 获取文件key值
	 * 
	 * @param key key
	 * @return key值
	 */
	public static String getProperty(String key) {
		if(!isInited) {
			loadSysettingFile();
		}
		
		return sysetting_properties.getProperty(key);
	}
}
