package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public String getCellValue(String path,String sheet,int row,int cell) 
	{
		String s="";
		
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			
			s=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		
		return s;
	}
	
	public static int getRowCount(String path,String sheet) 
	{
		int rowCount=0;
		
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			rowCount=wb.getSheet(sheet).getLastRowNum();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return rowCount; 
	}
	

	public static int getCellCount(String path,String sheet,int row) 
	{
		int cellCount=0;
		
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			cellCount=wb.getSheet(sheet).getRow(row).getLastCellNum();
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cellCount; 
	}

}
