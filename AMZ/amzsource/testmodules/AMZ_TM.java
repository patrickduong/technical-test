package testmodules;

import java.io.IOException;
import org.testng.annotations.Test;
import base.BaseTest;
import constant.TestConstant;

public class AMZ_TM extends BaseTest {
	public String actualSubcarttotalProduct1 ="";
	public String actualSubcarttotalProduct2 ="";
	
	@Test(description = "TC01: Verify that user can add view deal item to shopping cart")
	public void TC01_AddViewDealItem() throws InterruptedException, IOException {
		mainpage.clickLink(helper.driver, mainpage.TodayDeal_link);
		
		// VP: Today Deal page display
		mainpage.isTextdisplay(helper.driver, mainpage.TodayDeal_link, TestConstant.todayDealtext);

		mainpage.selectItem(helper.driver, TestConstant.sortByorder1);

		// handle if product is hidden.
		mainpage.scrollUntilElementVisible(helper.driver, mainpage.product_1);
		mainpage.clickLink(helper.driver, mainpage.product_1);
	
		detailproductpage.addProductToShoppingCart(helper.driver, 2);
		// VP: Added message display
		mainpage.isTextdisplay(helper.driver, mainpage.addtocardSuccessMSG, TestConstant.addedSuccessMSG);
		// VP: There are 2 items in shopping cart
		mainpage.isTextdisplay(helper.driver, mainpage.shoppingCart_icon, "2");

		// Post condition: go back to home page.
		mainpage.clickLink(helper.driver, mainpage.Main_logo);
	}

	@Test(description = "TC02: Verify that user can a searched item to shopping cart")
	public void TC02_AddSearchItem() throws InterruptedException, IOException {
		mainpage.searchProduct(helper.driver, TestConstant.productName2);

		mainpage.selectFilterSearchPage(helper.driver, TestConstant.sortByorder2);

		// handle if product is hidden.
		mainpage.scrollUntilElementVisible(helper.driver, mainpage.product_2);
		mainpage.clickLink(helper.driver, mainpage.product_2);

		detailproductpage.addProductToShoppingCart(helper.driver, 5);

		// VP: Added message display
		mainpage.isTextdisplay(helper.driver, mainpage.addtocardSuccessMSG, TestConstant.addedSuccessMSG);

		// VP: There are 7 items in shopping cart
		mainpage.isTextdisplay(helper.driver, mainpage.shoppingCart_icon, "7");

		// Postcondition: go to shopping cart
		mainpage.clickLink(helper.driver, mainpage.cartSuccess_button);
	}


}
