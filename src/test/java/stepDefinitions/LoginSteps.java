package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import testbase.BaseClass;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.ProductPage;

public class LoginSteps {
	
	LoginPage loginPage;
	AndroidDriver driver;
	ProductPage prodPage;
	
	public void LoginSteps(AndroidDriver driver) {
		this.driver = driver;
		
		
	}
	@Given("User is on login page")
	public void verifyLoginScreen() throws MalformedURLException, URISyntaxException {
		driver = BaseClass.configureAppium();
		loginPage = new LoginPage(driver);
		prodPage = new ProductPage(driver);
		loginPage.verifyLoginPage();
	}
	
	@When("User enters username as {string}")
	public void enterUsername(String username) {
		loginPage.enterUsername(username);
	}
	
	@When("User enters password as {string}")
	public void enterPassword(String password) {
		loginPage.enterPassword(password);
	}
	
	@When("User clicks on Login button")
	public void clickLogin() {
		loginPage.clickOnLogin();
	}
	
	@Then("User verify login successful as {string}")
	public void verifyDashboard(String heading) {
		Assert.assertTrue(prodPage.verifyProdHeading(heading),"Product page not displayed");
		BaseClass.teardown();
	}
	
	@Then("User verify error screen")
	public void verifyErrorScreen() {
		Assert.assertTrue(loginPage.verifyErrorScreen(),"Error message is not displayed");
		BaseClass.teardown();
	}
}
