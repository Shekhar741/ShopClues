package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
//	public void mouseHoverOnMen(WebDriver driver){
//		AUL_Lib.mouseHover(driver, men);
//	}
//	public void mouseHoverOnMobile(WebDriver driver){
//		AUL_Lib.mouseHover(driver, mobiles);
//	}
//	
	public void mouseHoverOnCategory(String category,WebDriver driver){
		Actions action=new Actions(driver);
		String path="//a[.='"+category+"']";
		action.moveToElement(driver.findElement(By.xpath(path))).build().perform();
	}
	
	public void clickOnSubCategory(String subCategory,WebDriver driver){
		String path="//div[@class='ul_menu_block']//*[text()='"+subCategory+"']";
		driver.findElement(By.xpath(path)).click();
	}
	
	public void clickOnProduct(String product,WebDriver driver){
		String path="//div[@class='row']//*[contains(.,'"+product+"')]";
		driver.findElement(By.xpath(path)).click();
	}
	 public void switchWindow(WebDriver driver){
		 Set<String> allWHS = driver.getWindowHandles();
		 for(String s:allWHS){
			 driver.switchTo().window(s);
		 }
	 }
	

}
