package Test;

import Pages.loginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class loginTest extends testBase{

    @Test
    public void init()
    {
        loginPage loginPage = PageFactory.initElements(driver,Pages.loginPage.class);
        try
        {


            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T1.pmg"));
            //logger.info("Screenshot for SAUC-T1 test case captured");
            driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //verify login with valid username and invalid password
        try
        {

            loginPage.setUsername("standard_user");
            loginPage.setPassword("Invalid_Password");
            loginPage.clickLoginButton();

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
            loginPage.setUsername("invalid_username");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

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

            loginPage.setUsername("standard_user");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

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
            loginPage.setUsername("");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

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

            loginPage.setUsername("");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

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