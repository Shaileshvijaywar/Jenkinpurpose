package com.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	public String propertyfile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(ContantUtility.propertyFilePath);
		Properties f = new Properties();
		f.load(fis);
		String r = f.getProperty(key);	
		return r;
	}

}
