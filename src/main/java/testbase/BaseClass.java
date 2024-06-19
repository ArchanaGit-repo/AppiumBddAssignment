package testbase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.Before;
import pageobjects.LoginPage;

public class BaseClass {
	
	public static AndroidDriver driver;
	URL url;
	public static AppiumDriverLocalService service;
	public static WebDriverWait webDriverWait;
	
	@BeforeClass
	public static AndroidDriver configureAppium() throws MalformedURLException, URISyntaxException
	{
		try {
			service = new AppiumServiceBuilder().withAppiumJS(new File("c://Users//warule_ar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();  
			service.start();
			 
			UiAutomator2Options caps = new UiAutomator2Options();
			
			caps.setDeviceName("Android814");
			caps.autoGrantPermissions();
			caps.noReset();
			caps.setAutomationName("UiAutomator2");
			caps.setPlatformVersion("14.0");
			caps.setPlatformName("Android");
			caps.setApp("D://eclipse//AppiumBddAssingment//src//test//resources//APK//test.apk");
			caps.setAppPackage("com.swaglabsmobileapp");
			caps.setAppActivity("com.swaglabsmobileapp.MainActivity");
			caps.setAppWaitForLaunch(true);
			caps.setAppWaitActivity("*");
			driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
			webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(50));
			
			System.out.println("Inside configuration class !!");
			return driver;
			
		} catch (Exception e) {
			System.out.println("Failed to instantiate Android driver"+ e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	@AfterClass
    public static void teardown() {
   	 driver.quit();
		 service.stop();
	}
	
	
}