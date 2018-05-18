package utility1;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility1 {

	public static XSSFWorkbook wbook1;
	public static XSSFSheet sheet1;
	public static XSSFRow row1;
	public static XSSFCell cell1;
	
	public static void setExcelPath1 (String sheetName1, String Path1) throws Exception
	{
		FileInputStream Fin = new FileInputStream(Path1);
		wbook1 = new XSSFWorkbook(Fin);
		sheet1 = wbook1.getSheet(sheetName1);
				
	}
	
	public static String getCellData(int rowN, int colN)
	{
		row1 = sheet1.getRow(rowN);
		cell1 = row1.getCell(colN);
		String cellData1 = cell1.getStringCellValue();
		return cellData1;
	}
	
}
