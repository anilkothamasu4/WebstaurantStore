package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;
	String emptyCart = "//div/a[text()='Empty Cart']";
	String confirmEmptyCart = "//button[text()='Empty Cart']";

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void emptyCartMethod() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement emptyCartElement = driver.findElement(By.xpath(emptyCart));
			wait.until(ExpectedConditions.elementToBeClickable(emptyCartElement)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(confirmEmptyCart)).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
