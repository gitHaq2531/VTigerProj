package com.client.Project.packageName;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperties(String Key) throws Throwable {
		FileInputStream fis =  new FileInputStream("./TestData/projcommondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(Key);
		return data;
	
	}
}
