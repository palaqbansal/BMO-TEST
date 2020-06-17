package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingpage extends basepage {

	private By FindResturants = By.xpath ("//a[@class='button']");
	private By PostalCode = By.xpath ("//input[@name='postcode']");
	private By ClickSearch = By.xpath ("//button[@class='Form_c-search-btn_2cjDI']");
	
	
	public void SearchRestaurants () {
		getElementAndClick(FindResturants);
	}
	
	public void SearchbyPostalCode () {
		getElementAndEnter(PostalCode, "AR51 1AA");
	}
	
 public void ClickonSearch() {
		getElementAndClick(ClickSearch);
	}
	
	public landingpage(WebDriver driver) {
		super(driver);
		
	}


	

	}


