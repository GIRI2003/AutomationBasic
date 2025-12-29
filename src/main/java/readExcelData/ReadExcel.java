package readExcelData;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcelData() throws IOException {
		
		String fileLocation = "./loginData/LoginData.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowSize = sheet.getLastRowNum();
		short columnSize = sheet.getRow(0).getLastCellNum();
		
		String[][] excelData = new String[rowSize][columnSize];
		
		for (int i = 1; i <= rowSize; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnSize; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String formattedValue = formatter.formatCellValue(cell);
//				System.out.println(formattedValue);
				excelData[i-1][j] = formattedValue;
			}
		}
		workbook.close();
		return excelData;
		

	}

}
