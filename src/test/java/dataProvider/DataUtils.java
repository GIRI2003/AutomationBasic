package dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import readExcelData.ReadExcel;

public class DataUtils {

	@DataProvider(/*name = "loginCredentials" , indices = {0,2} */)
	public String[][] getLoginData() throws IOException {
		
		String[][] excelData = ReadExcel.getExcelData();
		return excelData;	
	
	}
}



//String[][] data = new String[3][2];
//
//data[0][0] = "student";
//data[0][1] = "Password123";
//
//data[1][0] = "student";
//data[1][1] = "Password123";
//
//data[2][0] = "student";
//data[2][1] = "Password123";
//
//return data;