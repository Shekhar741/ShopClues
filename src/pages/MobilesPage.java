package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AUL_Lib;

public class MobilesPage {
	
	
	@FindBy(xpath="//div[@class='t_brands_list']//li/label[.='Intex']")
	private WebElement intex;
	@FindBy(xpath="//a[.='Karbonn Titanium Frames S7']")
	private WebElement karbon;
	
	public MobilesPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnIntex(WebDriver driver){
		AUL_Lib.clickElement(driver, intex);
	}
	public void clickOnKarbon(WebDriver driver){
		AUL_Lib.clickElement(driver, karbon);
	}

}
