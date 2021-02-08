package base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import utilities.FileUtils;
import utilities.StringUtils;
import page.AMZ_detailProductpage;
import page.AMZ_mainpage;
import page.AMZ_ShoppingCartpage;

public class BaseTest {
	public String test_platform, test_url, test_browser;
	public WebDriverHelper helper;
	public AMZ_mainpage mainpage;
	public AMZ_detailProductpage detailproductpage;
	public AMZ_ShoppingCartpage shoppingcartpage;

	@Parameters({ "Platform", "Testurl", "Testbrowser" })
	@BeforeSuite
	public void Precondition(String Platform, String Testurl, String Testbrowser) throws IOException {
		this.test_platform = Platform;
		this.test_url = Testurl;
		this.test_browser = Testbrowser;
		helper = new WebDriverHelper(test_platform, test_browser);
		String suiteOutputPath = StringUtils.getsuiteOutputPath();
		String suiteAllureReportOutputPath = StringUtils.getAllureReportOutputPath();
		FileUtils.clearFolder(suiteOutputPath);
		FileUtils.clearFolder(suiteAllureReportOutputPath);
		helper.goToUrl(test_url);
	}

	@BeforeClass
	public void InitilizePageObjects() {
		mainpage = new AMZ_mainpage(helper.driver);
		detailproductpage = new AMZ_detailProductpage(helper.driver);
		shoppingcartpage = new AMZ_ShoppingCartpage(helper.driver);
	}

	@AfterClass
	public void Postcondition() {
		helper.closeBrowser();
	}

	@AfterSuite
	public void StartAllureServer() throws IOException, InterruptedException {
		String suiteAllureReportOutputPath = StringUtils.getAllureReportOutputPath();
		FileUtils.executeCommand("cd D:\\Repo_testing\\Resources\\allure-commandline\\");
		FileUtils.executeCommand("allure serve " + suiteAllureReportOutputPath);
	}

}
