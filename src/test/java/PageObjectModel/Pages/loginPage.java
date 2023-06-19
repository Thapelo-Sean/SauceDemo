package PageObjectModel.Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;
import java.io.IOException;

public class loginPage {

    private Logger logger = LogManager.getLogger("Info");
    public String baseUrl = "https://www.saucedemo.com/";
    WebDriver driver;

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.ID,using = "user-name") @CacheLookup
    static
    WebElement username;
    @FindBy(how = How.ID,using = "password") @CacheLookup
    static
    WebElement password;
    @FindBy(how = How.ID, using = "login-button") @CacheLookup
    static
    WebElement loginButton;

    public static void setUsername(String stringUsername)
    {
        try
        {
            username.clear();
            username.sendKeys(stringUsername);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void setPassword(String stringPassword)
    {
        try
        {
            password.clear();
            password.sendKeys(stringPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clickLoginButton()
    {
        try
        {
            loginButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}