package scripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.HomePage;

public class AddToCartTest extends BasePage {
	
	@Test(dataProvider="buyProduct")
	public void buyProduct(String category,String subCategory,String product){
		test.log(LogStatus.INFO, "Mouse Hover on Category and click on sub category");
		HomePage h=new HomePage(driver);
		h.mouseHoverOnCategory(category, driver);
		h.clickOnSubCategory(subCategory, driver);
		h.switchWindow(driver);
	}

}
