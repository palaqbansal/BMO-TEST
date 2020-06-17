package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basepage {
	

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    protected WebDriver driver;
    private WebDriverWait wait;
    
    public basepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

/**
 * This method waits for the element to load on the page
 * 
 */

protected void waitForElementToAppear(By locator) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

/**
 * This method waits for the element to load on the page and then click
 * 
 */
protected void getElementAndClick(By locator)  {
	WebElement element;
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	element.click();
}

/**
 * This method waits for the element to appear and then enters text into text
 * field
 * 
 * 
 */
protected void getElementAndEnter(By locator, String text)  {
	WebElement element;
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	element.sendKeys(text);
}

/**
 * This method waits for the element to disappear from the page
 * 
 */
protected void waitForElementToDisappear(By locator)  {
	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
}

/**
 * This method waits for the text to disappear from the page
 * 
 */

protected void waitForTextToDisappear(By locator, String text)  {
	wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
}

/**
 * This method waits for the text to appear on the page
 * 
 */
protected void waitForTextAppear(By locator, String text)  {
	wait.until(ExpectedConditions.textToBe(locator, text));
}


//handle Alert in test methods
public boolean isAlertPresent() {

    boolean presentFlag = false;

    try {

        // Check the presence of alert
        Alert alert = driver.switchTo().alert();
        // Alert present; set the flag
        presentFlag = true;
        // if present consume the alert
        alert.accept();
        //( Now, click on ok or cancel button )

    } catch (NoAlertPresentException ex) {
        // Alert not present
        ex.printStackTrace();
    }

    return presentFlag;
}


}
