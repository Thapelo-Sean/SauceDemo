package PageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class checkoutPage {
    WebDriver driver;
    public checkoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //locate elements
    @FindBy(how = How.ID, using = "first-name") @CacheLookup
    WebElement firstName;
    @FindBy(how = How.ID,using = "last-name") @CacheLookup
    WebElement lastName;
    @FindBy(how = How.ID,using = "postal-code") @CacheLookup
    WebElement postalCode;
    @FindBy(how = How.ID, using = "continue") @CacheLookup
    WebElement continueButton;
    @FindBy(how = How.ID, using = "finish") @CacheLookup
    WebElement finishButton;
    @FindBy(how = How.ID, using = "cancel") @CacheLookup
    WebElement cancelButton;

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
        try
        {
            lastName.sendKeys(stringLastName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPostalCode(String stringPostalCode) {
        try {
            postalCode.sendKeys(stringPostalCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void continueButton()
    {
        try
        {
            continueButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finishButton()
    {
        try
        {
            finishButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelButton()
    {
        try
        {
            cancelButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}