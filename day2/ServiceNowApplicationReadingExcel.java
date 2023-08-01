package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNowApplicationReadingExcel {
	
	public static String[][] readExcelData(String excelName,String inputsheet) throws IOException {
		
	XSSFWorkbook wb=new XSSFWorkbook("./data/"+excelName+".xlsx");
	XSSFSheet sheet=wb.getSheet(inputsheet);
	
	int rowNum = sheet.getLastRowNum();
	short colNum = sheet.getRow(0).getLastCellNum();
	String[][] data=new String[rowNum][colNum];
	for (int i = 1; i <= rowNum; i++) {
		XSSFRow eachRow=sheet.getRow(i);
		for (int j = 0; j < colNum; j++) {
			String cellValue = eachRow.getCell(j).getStringCellValue();
			System.out.println(cellValue);
			data[i-1][j]=cellValue;
			
		}
		
	}
wb.close();
return data;
	
}

}