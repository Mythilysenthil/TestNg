package com.test;

import org.testng.annotations.DataProvider;

public class DataproviderDemo {
	@DataProvider(name = "valid")
	public String[][] getdata(){
		String [][] data = new String[1][2];
		data[0][0] = "admin";
		data[0][1] = "admin";
		return data;
	}
}
