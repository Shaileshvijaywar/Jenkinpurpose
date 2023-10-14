package com.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	public void dataprovider(String Phone, int Price)
	{
		System.out.println(Phone+"-----------"+Price);
	}
   @DataProvider
   public Object[][] getData()
   {
	  Object[][] data= new Object[3][2];
	  data[0][0]="Samsung";
	  data[0][1]=1200;
	  data[1][0]="I phone";
	  data[1][1]=800;
	  data[2][0]="Nokia";
	  data[2][1]=300;
	  
	  return data;
	  
   }
   
}
