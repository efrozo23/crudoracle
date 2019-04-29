package com.credifamilia.utils;

import java.io.FileInputStream;

import java.util.Properties;

public class UtilCredifamilia {
	
	
	
	public static String getQueryString(String nameQuery,String routeFile) {
		
		try (FileInputStream fileInputStream = new FileInputStream(routeFile)) {
			
			Properties properties = new Properties();
			properties.load(fileInputStream);
			return properties.getProperty(nameQuery);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
