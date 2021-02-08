package page;

import org.joda.money.Money;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

public class AMZ_detailProductpage {

	
	public AMZ_detailProductpage(WebDriver driver) {

	}
	
	public String quanlity_listbox = "quantity";
	public String addtocart_button ="add-to-cart-button";
	public String dealPrice = "price_inside_buybox";
	
	@Step("Add {0} quanlity of product")
	public void addProductToShoppingCart(WebDriver driver, int quanlity) {
		if(quanlity!=0 && quanlity<=30) {
			Select dropdown = new Select(driver.findElement(By.id(quanlity_listbox)));
		     dropdown.selectByVisibleText(String.valueOf(quanlity)); 
		     driver.findElement(By.id(addtocart_button)).click();
		}
		else
			System.out.println("invalid quanlity");
	}
	
	//not use
//	public String getSubTotal(WebDriver driver, int quanlity, String path) {
//		Money subTotal = Money.parse(driver.findElement(By.id(path)).getAttribute("text"));
//		subTotal =  subTotal.multipliedBy(quanlity);
//		return "$"+subTotal.toString();	
//	}
}
