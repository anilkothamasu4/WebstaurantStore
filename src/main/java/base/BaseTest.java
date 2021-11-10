package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	WebDriver driver;
	String url = "https://www.webstaurantstore.com/";
	
	//intializing the driver
	public WebDriver initDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//chromedriver.exe");
		driver =new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
