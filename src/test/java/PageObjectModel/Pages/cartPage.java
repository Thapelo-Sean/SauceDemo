package PageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class cartPage {
    public WebDriver driver;
    public cartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "checkout") @CacheLookup
    WebElement checkoutButton;

    public void checkoutButton()
    {
        checkoutButton.click();
    }
}