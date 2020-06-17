package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchRestaurantsstepdefinitions {
	
	WebDriver driver;

	private By FindResturants = By.xpath ("//a[@class='button']");
	private By PostalCode = By.xpath ("//input[@name='postcode']");
	private By ClickSearch = By.xpath ("//span[@class='Form_c-search-btn-text_6RDDX']");
	
	@Before
	public void initsteps() {
		
	}
	
	@Given("^the user is logged on to \"([^\"]*)\"$")
	public void the_user_is_logged_on_to(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/sumitmittal/Desktop/chromedriver41");
		driver = new ChromeDriver ();
		driver.get("https://www.just-eat.co.uk/#main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user enters the Postal code as AR(\\d+) (\\d+)AA$")
	public void the_user_enters_the_Postal_code_as_AR_AA(int arg1, int arg2) throws Throwable {
	 driver.findElement(PostalCode).sendKeys("AR51 1AA");
	
	}

	@When("^the user clicks on Search$")
	public void the_user_clicks_on_Search() throws Throwable {
		driver.findElement(ClickSearch).click();;
	  
	}

	@Then("^the should see some restaurants in AR(\\d+) (\\d+)AA$")
	public void the_should_see_some_restaurants_in_AR_AA(int arg1, int arg2) throws Throwable {
	  
	}


}
