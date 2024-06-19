package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@test", 
		features = { "src/test/resources" }, 
		glue = {"stepDefinitions" }, 
		monochrome = true)


public class TestRunner extends AbstractTestNGCucumberTests {

}


