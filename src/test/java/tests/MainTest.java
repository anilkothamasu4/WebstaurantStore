package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultspage;

public class MainTest extends BaseTest{
	
	WebDriver driver;
	
	HomePage homePage;
	SearchResultspage searchPage;
	CartPage cartPage;
	
	/*
	 * setup will run before the test methods 
	 * This will initialize the driver and navigate to the Webstaurantstore home page 
	 */
	@BeforeClass
	public void setup()
	{
		driver = initDriver();
		homePage = new HomePage(driver);
		searchPage = new SearchResultspage(driver);
		cartPage = new CartPage(driver);
	}
	
	/*
	 * This method will click on the search bar and enter the "stainless steel table" and
	 * submit the search
	 */
	@Test(priority = 1)
	public void searchForProduct()
	{
		homePage.search();
		homePage.clickSubmit();
	}
	
	/*
	 * This methods will verify the items description contains the word "table"
	 * And add the last 5items to the cart
	 * And navigate to the cart page
	 */
	@Test(priority = 2)
	public void verifyItemNameAndAddItemstoCart()
	{
		searchPage.validateItemNameAndaddTocart();
		searchPage.goToCart();
	}

	/*
	 * This method will empty the cart on the cart page
	 */
	@Test(priority = 3)
	public void emptyCart()
	{
		cartPage.emptyCartMethod();
	}
	
	/*
	 * This method will run only once and quit the driver
	 */
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
