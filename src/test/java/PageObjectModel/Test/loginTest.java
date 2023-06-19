package PageObjectModel.Test;

import PageObjectModel.Pages.loginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class loginTest extends testBase{

    Logger logger = LogManager.getLogger("info");



    @Test(priority = 1)
    public void testCase1()
    {
        try
        {
            logger.info("<<<<<Executing Testcase 1>>>>>");
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
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
        logger.info("<<<<<Testcase 1 executed>>>>>");
    }

    @Test(priority = 2)
    public void testCase2()
    {
        //verify login with valid username and invalid password
        try
        {
            logger.info("<<<<<Executing Testcase 2>>>>>");
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("Invalid_Password");
            loginPage.clickLoginButton();

            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T2.png"));
            logger.info("Screenshot for testcase 2 captured");
            driver.navigate().refresh();
            logger.info("<<<<<Testcase 2 executed>>>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void testCase3()
    {
        //verify login with invalid username and valid password
        try
        {
            logger.info("<<<<<Executing Testcase 3");
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            driver.get(baseUrl);
            loginPage.setUsername("invalid_username");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T3.png"));
            driver.navigate().refresh();
            logger.info("<<<<<Testcase 3 executed>>>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 4)
    public void testCase4()
    {
        //verify login with valid username and empty password field
        try
        {
            logger.info("<<<<<Executing Testcase 4>>>>>");
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T4.png"));
            logger.info("<<<<<Test case 4 executed>>>>>");
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 5)
    public void testCase5()
    {
        //verify login with empty username and valid password
        try
        {
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T5.png"));
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 6)
    public void testCase6()
    {
        //verify login with empty username field and empty password
        try
        {
            logger.info("<<<<<Executing Test case 6>>>>>");
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T6.png"));
            logger.info("<<<<<Testcase 6 executed>>>>>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}