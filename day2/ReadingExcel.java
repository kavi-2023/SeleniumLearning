package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	
	public static String[][] excelNameMthd(String excelName) throws IOException {
	
	XSSFWorkbook wb=new XSSFWorkbook("./data/"+excelName+".xlsx");	
	XSSFSheet Sheet=wb.getSheet("Sheet1");
	int rowCount = Sheet.getLastRowNum();
	System.out.println("Total rows:"+rowCount);
	short colCount = Sheet.getRow(0).getLastCellNum();
	System.out.println("Total columns:"+colCount);
	String[][] data=new String[rowCount][colCount];
	for (int i = 1; i <= rowCount; i++) {
  		 XSSFRow eachRow=Sheet.getRow(i);
		for (int j = 0; j < colCount; j++) {
			String cellVal = eachRow.getCell(j).getStringCellValue();
			System.out.println(cellVal);
			data[i-1][j]=cellVal;
		}
		
	}
	
	wb.close();
	return data;
	
	

}
}