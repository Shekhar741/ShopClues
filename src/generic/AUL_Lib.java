package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class AUL_Lib {
	public static String getProperty(String path,String key)
	{
		String v="";
		
		try
		{
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);

		}
		catch(Exception e)
		{
			Reporter.log("error");
		}
		
		return v;
	}

	public static void Takephoto(String folder,String Testname,WebDriver driver)
	{

		String dateTime = new Date().toString().replaceAll(":","_");
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcFile= t.getScreenshotAs(OutputType.FILE);
		String dstPath = folder+Testname+dateTime+".png";
		try
		{

			FileUtils.copyFile(srcFile,new File(dstPath));
		}
		catch(Exception e)
		{
			Reporter.log("error occured");
		}

	}
	
	public static void mouseHover(WebDriver driver,WebElement ele){
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
	public static void clickElement(WebDriver driver,WebElement ele){
		Actions action=new Actions(driver);
		action.moveToElement(ele).click(ele).build().perform();;
	}

}
