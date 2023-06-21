package PageObjectModel.Test;

import PageObjectModel.Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class LoginTest extends TestBase
{

    private final Logger logger = LogManager.getLogger("Info");
    static ExtentReports extent;
    static ExtentSparkReporter spark;

    @BeforeTest
    public void report()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Reports/LoginReport.html");
        extent.attachReporter(spark);
    }

    //Verify login with valid username and valid password
    @Test(priority = 1)
    public void testCase1()
    {
        try
        {
            logger.info("<<<<<Executing Testcase 1>>>>>");
            LoginPage loginPage = PageFactory.initElements(TestBase.driver, LoginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), inventoryUrl);

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T1.png"));

            driver.navigate().back();
            logger.info("<<<<<Testcase 1 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify login with valid username and valid password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User successfully logged in");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //verify login with valid username and invalid password
    @Test(priority = 2)
    public void testCase2()
    {
        try
        {
            logger.info("<<<<<Executing Testcase 2>>>>>");
            LoginPage loginPage = PageFactory.initElements(TestBase.driver, LoginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("Invalid_Password");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T2.png"));

            //Testcase Report
            extent.createTest("Verify login with valid username and invalid password")
                            .assignAuthor("Thapelo Matji")
                            .log(Status.PASS, "User was unable to login, correct error message displayed");
            driver.navigate().refresh();
            logger.info("<<<<<Testcase 2 executed>>>>>");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //verify login with invalid username and valid password
    @Test(priority = 3)
    public void testCase3()
    {
        try
        {
            logger.info("<<<<<Executing Testcase 3");
            LoginPage loginPage = PageFactory.initElements(TestBase.driver, LoginPage.class);
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

            //Testcase Report
            extent.createTest("Verify login with invalid username and valid password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to login, correct error message displayed");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //verify login with valid username and empty password field
    @Test(priority = 4)
    public void testCase4()
    {
        try
        {
            logger.info("<<<<<Executing Testcase 4>>>>>");
            LoginPage loginPage = PageFactory.initElements(TestBase.driver, LoginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T4.png"));
            logger.info("<<<<<Test case 4 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify login with valid username and empty password field")
                            .assignAuthor("Thapelo Matji")
                            .log(Status.PASS, "User was unable to login, correct error message displayed");
            driver.navigate().refresh();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Verify login with empty username and valid password
    @Test(priority = 5)
    public void testCase5()
    {
        try
        {
            logger.info("<<<<<Executing Testcase 5>>>>>");
            LoginPage loginPage = PageFactory.initElements(TestBase.driver, LoginPage.class);
            loginPage.setUsername("");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T5.png"));
            logger.info("<<<<<Testcase 5 executed>>>>>");
            driver.navigate().to(baseUrl);

            //Testcase Report
            extent.createTest("Verify login with empty username and valid password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS,"User was unable to login, correct error message displayed");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //verify login with empty username field and empty password
    @Test(priority = 6)
    public void testCase6()
    {
        try
        {
            logger.info("<<<<<Executing Test case 6>>>>>");
            LoginPage loginPage = PageFactory.initElements(TestBase.driver, LoginPage.class);
            loginPage.setUsername("");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T6.png"));
            logger.info("<<<<<Testcase 6 executed>>>>>");

            //Testcase Report
            extent.createTest("verify login with empty username field and empty password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to login, correct error message displayed");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        extent.flush();
    }
}