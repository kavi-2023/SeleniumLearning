package marathon3;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SalesforceExcel {
	
	public static String[][] salesforceExcel(String excelname,String Sheet) throws IOException {
		
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+excelname+".xlsx");
		XSSFSheet sheet=wb.getSheet(Sheet);
		
		int rowsNum = sheet.getLastRowNum();
		short colNum = sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[rowsNum][colNum];
		for (int i = 1; i <=rowsNum; i++) {
			
		    XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colNum; j++) {
				String cellValue = row.getCell(j).getStringCellValue();
				System.out.println(cellValue);
				data[i-1][j]=cellValue;
			}
			
		}
	wb.close();
	return data;
		
	}

}
