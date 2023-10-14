package com.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
          // dataProvider is annotation is provided by jvm & storing data
	@Test(dataProvider="phone")
	public void dataproviderPractice(String Phone, int Price)
	{
	System.out.println(Phone+"---------"+Price);
	}
	@DataProvider(name="phone")
	public Object[][] getData()
	{ 
		                         //row//column
		Object[][] data=new Object[3][2];//3 set of data consist of 2 information
		
		data[0][0]="samsung";
		data[0][1]=1200;
		data[1][0]="iphone";
		data[1][1]=800;
		data[2][0]="Nokia";
		data[2][1]=700;
		
		return data;
		
	}
   @DataProvider(name="Electronics")
   public Object[][] getData1()
	{ 
		                         //row//column
		Object[][] data=new Object[3][2];//3 set of data consist of 2 information
		
		data[0][0]="Rahul";
		data[0][1]=1200;
		data[1][0]="iphone15";
		data[1][1]=800;
		data[2][0]="National";
		data[2][1]=700;
		
		return data;
		
	}
   
   
}
