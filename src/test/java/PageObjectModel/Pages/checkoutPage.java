package PageObjectModel.Pages;

import PageObjectModel.Test.loginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
    WebDriver driver;
    //locate elements
    @FindBy(how = How.ID, using = "first-name") @CacheLookup
    WebElement firstName;
    @FindBy(how = How.ID,using = "last-name") @CacheLookup
    WebElement lastName;
    @FindBy(how = How.ID,using = "postal-code") @CacheLookup
    WebElement postalCode;

    public void setFirstName(String stringFirstName)
    {
        try
        {
            firstName.sendKeys(stringFirstName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setLastName(String stringLastName) {
        try {
            lastName.sendKeys(stringLastName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setpostalCode(String stringPostalCode) {
        try {
            lastName.sendKeys(stringPostalCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}