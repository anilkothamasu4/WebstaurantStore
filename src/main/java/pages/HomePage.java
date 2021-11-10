package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	String searchBar = "searchval";
	String searchButton = "//button[text()='Search']";
	String item = "stainless steel table";
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void navigateToUrl(String url)
	{
		driver.get(url);
	}
	
	public void search() {
		
		WebElement searchBarElement = driver.findElement(By.id(searchBar));
		searchBarElement.sendKeys(item);
	}
	
	public void clickSubmit()
	{
		WebElement searchButtonElement = driver.findElement(By.xpath(searchButton));
		searchButtonElement.click();
		
	}
	
}
