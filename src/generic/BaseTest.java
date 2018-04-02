package generic;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class BaseTest implements Auto_const {
	public WebDriver driver;
	ExtentReports report;
	protected ExtentTest test;

	static {
		System.setProperty(Chrome_key, Chrome_Value);
		System.setProperty(Gecko_key, Gecko_Value);
	}

	@BeforeSuite
	public void init() {
		String path = "./Reports/extentReport.html";
		report = new ExtentReports(path);
	}

	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void open_application(@Optional("chrome")String browser, Method testname) {
		
//		String browserName=System.getProperty("browser");
		String name = testname.getName();
		test = report.startTest(name);
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			test.log(LogStatus.PASS, "Chrome Browser is opened");
		}
		else if(browser.equals("IE")){
			driver = new InternetExplorerDriver();
			test.log(LogStatus.PASS, "IE Browser is opened");
		}
		else {
			driver = new FirefoxDriver();
			test.log(LogStatus.PASS, "Firefox browser is opened");
		}

		String aut = AUL_Lib.getProperty(SETTING_PATH, "AUT");

		driver.get(aut);
		String strITO = AUL_Lib.getProperty(SETTING_PATH, "ITO");

		long ITO = Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		// Extent report

	}

	@AfterMethod(alwaysRun = true)
	public void close_application(ITestResult result) {

		String testname = result.getName();
		if (result.getStatus() == 2) {
			test.log(LogStatus.FAIL, "Fail");
			AUL_Lib.Takephoto(SCREENSHOTS_PATH, testname, driver);
		}
		report.endTest(test);
//		driver.quit();
	}

	@AfterSuite
	public void end() {
		report.flush();
	}

}
