package actions;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class AbstractTest {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		
	}
	@BeforeClass
	public void beforeClass() {
		
	}
	@BeforeTest
	public void afterTest() {
		
	}
	@BeforeTest
	public void afterClass() {
		
	}
}
