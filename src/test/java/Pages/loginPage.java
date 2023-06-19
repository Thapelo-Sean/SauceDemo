package Pages;

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
    String baseUrl = "https://www.saucedemo.com/";
    WebDriver driver;

    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.ID,using = "user-name") @CacheLookup
    WebElement username;
    @FindBy(how = How.ID,using = "password") @CacheLookup
    WebElement password;
    @FindBy(how = How.ID, using = "login-button") @CacheLookup
    WebElement loginButton;

    public void login()
    {
        //verify login with valid username and valid password
        try
        {
            username.clear();
            username.sendKeys("standard_user");
            password.clear();
            password.sendKeys("secret_sauce");
            loginButton.click();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T1.pmg"));
            logger.info("Screenshot for SAUC-T1 test case captured");
            driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //verify login with valid username and invalid password
        try
        {
            username.clear();
            username.sendKeys("standard_user");
            password.clear();
            password.sendKeys("Invalid_Password");
            loginButton.click();

            //capture screenshot for valid username and invalid password
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T2.png"));
            driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verify login with invalid username and valid password
        try
        {
            username.clear();
            username.sendKeys("invalid_username");
            password.clear();
            password.sendKeys("secret_sauce");
            loginButton.click();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshot/SAUC-T3.png"));
            driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //verify login with valid username and empty password field

        try
        {
            username.clear();
            username.sendKeys("standard_user");
            password.clear();
            password.sendKeys("");
            loginButton.click();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T4"));
            driver.navigate().to(baseUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //verify login with empty username and valid password
        try
        {
            username.clear();
            username.sendKeys("");
            password.clear();
            password.sendKeys("secret_sauce");
            loginButton.click();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T5"));
            driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //verify login with empty username field and empty password

        try
        {
            username.clear();
            username.sendKeys("");
            password.clear();
            password.sendKeys("");
            loginButton.click();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T6"));
            driver.navigate().to(baseUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}