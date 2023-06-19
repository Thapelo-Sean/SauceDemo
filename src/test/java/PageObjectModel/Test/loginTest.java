package PageObjectModel.Test;

import PageObjectModel.Pages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class loginTest extends testBase{

    @Test
    public void test1()
    {
        loginPage loginPage = PageFactory.initElements(driver, PageObjectModel.Pages.loginPage.class);
        try
        {
            Thread.sleep(2000);
            driver.get(baseUrl);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T1.png"));
            driver.navigate().back();
            //logger.info("Screenshot for SAUC-T1 test case captured");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCase2()
    {
        //verify login with valid username and invalid password
        try
        {
            driver.get(baseUrl);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("Invalid_Password");
            loginPage.clickLoginButton();

            //capture screenshot for valid username and invalid password
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCase3()
    {
        //verify login with invalid username and valid password
        try
        {
            driver.get(baseUrl);
            loginPage.setUsername("invalid_username");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T3.png"));
            //driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testCase4()
    {
        //verify login with valid username and empty password field
        try
        {
            loginPage.setUsername("standard_user");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T4.png"));
            //driver.navigate().to(baseUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCase5()
    {
        //verify login with empty username and valid password
        try
        {
            loginPage.setUsername("");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T5.png"));
            //driver.navigate().to(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCase6()
    {
        //verify login with empty username field and empty password
        try
        {
            loginPage.setUsername("");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T6.png"));
            //driver.navigate().to(baseUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}