package pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import generic.BaseTest;
import generic.ExcelReader;

public class BasePage extends BaseTest {
	
	@DataProvider(name="buyProduct")
	public Object[][] getData(){
		ExcelReader read=PageFactory.initElements(driver, ExcelReader.class);
		Object[][] obj=new Object[3][3];
		obj[0][0]=read.getCellValue(EXCEL_PATH, "Sheet1", 1, 0);
		obj[0][1]=read.getCellValue(EXCEL_PATH, "Sheet1", 1, 1);
		obj[0][2]=read.getCellValue(EXCEL_PATH, "Sheet1", 1, 2);
		obj[1][0]=read.getCellValue(EXCEL_PATH, "Sheet1", 2, 0);
		obj[1][1]=read.getCellValue(EXCEL_PATH, "Sheet1", 2, 1);
		obj[1][2]=read.getCellValue(EXCEL_PATH, "Sheet1", 2, 2);
		obj[2][0]=read.getCellValue(EXCEL_PATH, "Sheet1", 3, 0);
		obj[2][1]=read.getCellValue(EXCEL_PATH, "Sheet1", 3, 1);
		obj[2][2]=read.getCellValue(EXCEL_PATH, "Sheet1", 3, 2);
		
		return obj;
	}

}
