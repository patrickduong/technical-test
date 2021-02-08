package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import constant.TestConstant;

public class WebDriverHelper {
	public WebDriver driver;


	public WebDriverHelper(String platform, String browserTest) {
		if (platform.equals("window") && browserTest.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Repo_testing\\Resources\\browserdriver\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (platform.equals("window") && browserTest.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"D:\\Repo_testing\\Resources\\browserdriver\\firefox\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (platform.equals("window") && browserTest.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Repo_testing\\Resources\\browserdriver\\edge\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// platform not window
		else {
			System.setProperty("webdriver." + browserTest + ".driver",
					String.format("/Users/%s/Resources/browserdriver/" + browserTest + "/" + browserTest + "driver",
							TestConstant.systemUser));

			if (browserTest.equals("chrome"))
				driver = new ChromeDriver();
			if (browserTest.equals("firefox"))
				driver = new FirefoxDriver();
			if (browserTest.equals("edge"))
				driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestConstant.longTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestConstant.shortTime, TimeUnit.SECONDS);
		
	}

	public void goToUrl(String url) {
		driver.navigate().to(url);
	}

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}