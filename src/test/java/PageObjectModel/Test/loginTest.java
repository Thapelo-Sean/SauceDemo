package PageObjectModel.Test;

import PageObjectModel.Pages.checkoutPage;
import PageObjectModel.Pages.inventoryPage;
import PageObjectModel.Pages.loginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class loginTest extends testBase{

    Logger logger = LogManager.getLogger("info");
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    @BeforeTest
    public void report()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Reports/Testcases.html");
        extent.attachReporter(spark);
    }

    public void login()
    {
        loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    //Verify login with valid username and valid password
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
            logger.info("Screenshot for SAUC-T1 test case captured");
            driver.navigate().back();
            logger.info("<<<<<Testcase 1 executed>>>>>");
            extent.createTest("Verify login with valid username and valid password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User successfully logged in");
        } catch (Exception e) {
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("Invalid_Password");
            loginPage.clickLoginButton();

            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T2.png"));
            logger.info("Screenshot for testcase 2 captured");
            extent.createTest("Verify login with valid username and invalid password")
                            .assignAuthor("Thapelo Matji")
                            .log(Status.PASS, "User was unable to login, correct error message displayed");
            driver.navigate().refresh();
            logger.info("<<<<<Testcase 2 executed>>>>>");
        } catch (Exception e) {
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
            extent.createTest("Verify login with invalid username and valid password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to login, correct error message displayed");
        } catch (Exception e) {
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("standard_user");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T4.png"));
            logger.info("<<<<<Test case 4 executed>>>>>");
            extent.createTest("Verify login with valid username and empty password field")
                            .assignAuthor("Thapelo Matji")
                            .log(Status.PASS, "User was unable to login, correct error message displayed");
            driver.navigate().refresh();
        } catch (Exception e) {
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("");
            loginPage.setPassword("secret_sauce");
            loginPage.clickLoginButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T5.png"));
            logger.info("Screenshot for Testcase captured");
            logger.info("<<<<<Testcase 5 executed>>>>>");
            driver.navigate().refresh();
            extent.createTest("Verify login with empty username and valid password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS,"User was unable to login, correct error message displayed");
        } catch (Exception e) {
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
            loginPage.setUsername("");
            loginPage.setPassword("");
            loginPage.clickLoginButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T6.png"));
            logger.info("<<<<<Testcase 6 executed>>>>>");
            driver.navigate().refresh();
            extent.createTest("verify login with empty username field and empty password")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to login, correct error message displayed");
        } catch (IOException e) {
            e.printStackTrace();
        }
        extent.flush();
    }

    //Verify user can access cart page after adding products to cart
    @Test(priority = 7)
    public void testcase7()
    {
        try
        {
            login();
            inventoryPage inventorypage = PageFactory.initElements(driver,inventoryPage.class);
            inventorypage.addProductsToCart();
            inventorypage.shoppingCart();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshot/SAUC-T7.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Verify checkout with empty firstname field
    @Test(priority = 8)
    public void testcase8()
    {
        try
        {
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            checkoutPage.setFirstName("");
            checkoutPage.setLastName("Tester");
            checkoutPage.setpostalCode("12345");
            Thread.sleep(2000);
            checkoutPage.continueButton();
            Thread.sleep(2000);

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T8.png"));
            checkoutPage.cancelButton();
            //checkoutPage.finishButton();
            //Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //verify checkout with empty fields
    @Test(priority = 9)
    public void testCase9()
    {
        try
        {
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            checkoutPage.setFirstName("");
            checkoutPage.setLastName("");
            checkoutPage.setpostalCode("");
            checkoutPage.continueButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T9.png"));
            checkoutPage.cancelButton();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Verify checkout with empty lastname field
    @Test(priority = 10)
    public void testCase10()
    {
        try
        {
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            checkoutPage.setFirstName("Tester");
            checkoutPage.setLastName("");
            checkoutPage.setpostalCode("9876");
            checkoutPage.continueButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T10.png"));
            checkoutPage.cancelButton();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //verify checkout with empty postal field
    @Test(priority = 11)
    public void testCase11()
    {
        try
        {
            checkoutPage checkoutPage = PageFactory.initElements((SearchContext) this,checkoutPage.class);
            checkoutPage.setFirstName("John");
            checkoutPage.setLastName("Doe");
            checkoutPage.setpostalCode("");
            checkoutPage.continueButton();

            //Capture screenshot
            TakesScreenshot screenshot  = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T11.png"));
            checkoutPage.cancelButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Verify checkout
    @Test(priority = 12)
    public void testCase12()
    {
        try
        {
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            checkoutPage.setFirstName("Software");
            checkoutPage.setLastName("Tester");
            checkoutPage.setpostalCode("45667");
            checkoutPage.continueButton();
            checkoutPage.finishButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T12.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}