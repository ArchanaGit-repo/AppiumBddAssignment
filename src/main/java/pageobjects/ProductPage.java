package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ProductPage {

	AndroidDriver driver;
	WebDriverWait wait ;
	
	public ProductPage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(xpath = ProductPageConst.productsTag)
	private String prodHeading;

	public boolean verifyProdHeading(String expHeading) {
		WebElement prodHead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductPageConst.productsTag)));
		String heading = prodHead.getText();
		
		if(heading.toLowerCase().equals(expHeading.toLowerCase())) {
			System.out.println("Products page is displayed after successful login !!");
			return true;
		}
		else {
			System.out.println("Login is unsuccessful");
			return false;
		}
	}
	
	
}
