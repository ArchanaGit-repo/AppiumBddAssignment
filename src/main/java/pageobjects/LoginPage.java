package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	AndroidDriver driver;
	WebDriverWait wait ;
	
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(xpath = LoginPageConst.userName)
	private String userName;
	
	@FindBy(xpath = LoginPageConst.password)
	private String pass;
	
	@FindBy(xpath = LoginPageConst.loginBtn)
	private String loginBtn;
	
	public void verifyLoginPage() {
		
		WebElement userBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageConst.userName)));
		Assert.assertTrue(userBox.isDisplayed(),"Login page is not dispalyed");
	}
	
	public void enterUsername(String username) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageConst.userName)));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPageConst.userName))).sendKeys(username);
		System.out.println("This is working !");
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPageConst.password))).sendKeys(password);
		
	}

	public void clickOnLogin() {
		WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPageConst.loginBtn)));
		btnLogin.click();
	}

	public boolean verifyErrorScreen() {
		String expError = LoginPageConst.errorString;
		WebElement errorEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageConst.errorMsg)));
		String actError = errorEle.getText();
		
		if(actError.equals(expError)) {
			System.out.println("Error message : " + actError +"is displayed after unsuccessful login !!");
			return true;
		}
		else {
			System.out.println("Login is unsuccessful");
			return false;
		}
	}

	

}
