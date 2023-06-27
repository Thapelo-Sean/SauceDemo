package PageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage
{
    public WebDriver driver;

    //Constructor
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate element using @FindBy annotation
    @FindBy(how = How.ID, using = "checkout") @CacheLookup
    WebElement checkoutButton;

    //Page Method
    public void checkoutButton()
    {
        checkoutButton.click();
    }
}