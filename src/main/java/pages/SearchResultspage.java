package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class SearchResultspage {
	
	WebDriver driver;
	String itemsFound = "//div/div[@class='ag-item gtm-product ']";
	String popupClose = "//button[@class='close']";
	String cartButton = "//div/a[@href='/viewcart.cfm']"; 


	public SearchResultspage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateItemNameAndaddTocart()
	{
		List<WebElement> itemsList = driver.findElements(By.xpath(itemsFound));
		
		Actions builder = new Actions(driver);
		for(int i=1;i<=itemsList.size();i++)
		{
			String itemData = driver.findElement(By.xpath("//div/div[@class='ag-item gtm-product ']["+i+"]/div[@class='add-to-cart']")).getText();
			String titleText = driver.findElement(By.xpath("//div/div[@class='ag-item gtm-product ']["+i+"]/div[@id='details']/a[@data-testid='itemDescription']")).getText();
			
			
			//assertion for checking the item name has word 'Table' in it
			Assert.assertTrue("product item didn't have the word 'Table' in title", titleText.contains("Table"));
			
			
			if(!itemData.contains("Notify me"))
			{	
				WebElement addToCart = driver.findElement(By.xpath("//div/div[@class='ag-item gtm-product ']["+i+"]/div[@class='add-to-cart']//input[@data-testid='itemAddCart']"));
				Action action = builder
	                    .moveToElement(addToCart)
	                    .build();
				action.perform();
				if(i>(itemsList.size()-5))
				{
					addToCart.click();
				}
			}

			
		}
	}
	
	public void goToCart()
	{
		Actions builder = new Actions(driver);
		
		List<WebElement> popupItems = driver.findElements(By.xpath(popupClose));
		
		for(int i=popupItems.size()-1;i>=0;i--)
		{
			popupItems.get(i).click();
		}
		WebElement viewCart = driver.findElement(By.xpath(cartButton));
		Action action1 = builder
                .moveToElement(viewCart)
                .build();
		action1.perform();
		viewCart.click();
	}
}
