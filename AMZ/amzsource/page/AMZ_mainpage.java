package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.qameta.allure.Step;

public class AMZ_mainpage {

	public AMZ_mainpage(WebDriver driver) {

	}
	
	public String TodayDeal_link = "//*[@id=\"nav-xshop\"]/a[contains(text(),\"Today's Deals\")]";
	public String Search_textbox = "twotabsearchtextbox";
	public String Search_button = "nav-search-submit-button";
	public String sortby_dropdown = "//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/span/span/span/span";
	public String product_1 = "(//a[contains(text(),\"View Deal\")])[1]/../..";//view deal 2 not available
	public String addtocardSuccessMSG = "//h1[contains(text(),\"Added to Cart\")]";
	public String cartSuccess_button ="//*[@id=\"hlb-view-cart-announce\"]";
	public String proceedToCheckout_button ="//*[@id=\"hlb-ptc-btn-native\"]";
	public String shoppingCart_icon ="//*[@id=\"nav-cart-count\"]";
	public String Main_logo = "//*[@id=\"nav-logo\"]";
	public String product_2 = "//span[contains(text(),\"Jupio JRB-AAA\")]";
	public String firstProduct2Pack ="//span[@class=\"a-size-base\" and contains(text(),\"Pack of 20\")]";
	public String searchResult_dropdown ="//*[@id=\"s-result-sort-select\"]";
	public String subcartTotalPrice_label ="//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]";

	@Step("Click on Today's Deal")
	public AMZ_mainpage clickLink(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		return new AMZ_mainpage(driver);
	}

	@Step("Search a product: {0}")
	public AMZ_mainpage searchProduct( WebDriver driver,String input) {
		driver.findElement(By.id(Search_textbox)).sendKeys(input);
		driver.findElement(By.id(Search_button)).click();
		return new AMZ_mainpage(driver);
	}

	@Step("Verify '{0}' text is existed")
	public void isTextdisplay(WebDriver driver, String bypath, String expectedText) {
		Assert.assertEquals(driver.findElement(By.xpath(bypath)).getText(), expectedText);
	}

	@Step("Select '{0}' item ")
	public  void selectItem(WebDriver driver, String item) throws InterruptedException {
		String option = "";
		driver.findElement(By.xpath(sortby_dropdown)).click();
//		Thread.sleep(1500);
//		driver.findElement(By.xpath("//*[@class=\"a-popover-inner\"]/ul/li/a[contains(text(),\""+item+"\")]")).click();
		switch (item) {
		case "Featured":
			option = "//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/select/option[@value=\"BY_SCORE\"]";
			break;
		case "Price - Low to High":
			option = "//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/select/option[@value=\"BY_PRICE_ASCENDING\"]";
			driver.findElement(By.xpath(option)).click();
			break;
		case "Price - High to Low":
			option = "//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/select/option[@value=\"BY_PRICE_DESCENDING\"]";
			driver.findElement(By.xpath(option)).click();
			break;
		case "Discount - Low to High":
			option = "//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/select/option[@value=\"BY_DISCOUNT_ASCENDING\"]";
			driver.findElement(By.xpath(option)).click();
			break;
		case "Discount - High to Low":
			option = "//*[@id=\"FilterItemView_sortOrder_dropdown\"]/div/span[2]/span/select/option[@value=\"BY_DISCOUNT_DESCENDING\"]";
			driver.findElement(By.xpath(option)).click();
			break;
		default: 
		}
		
	}
	
	@Step("Scroll to '{0}' element ")
	public void scrollUntilElementVisible(WebDriver driver, String xpath)
    {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath(xpath)));
    }
	
	
	@Step("Scroll page to {0} position")
	 public void scrollPage(WebDriver driver, String position)
     {
		 JavascriptExecutor js = (JavascriptExecutor)driver;

         switch (position)
         {
             case "top":
                 js.executeScript("window.scrollTo(0,0)");
                 break;
             case "middle":
                 js.executeScript("window.scrollTo(0,600)");
                 break;
             case "bottom":
                 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                 break;
         }
     }
	@Step("Select {0} filter at search result page")
	public void selectFilterSearchPage(WebDriver driver, String filter) {
		 Select dropdown = new Select(driver.findElement(By.xpath(searchResult_dropdown)));
	     dropdown.selectByVisibleText(filter); 
	}
	
}
