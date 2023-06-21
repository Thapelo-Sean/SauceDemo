package PageObjectModel.Test;

import PageObjectModel.Pages.CartPage;
import PageObjectModel.Pages.CheckoutPage;
import PageObjectModel.Pages.InventoryPage;
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

public class CheckoutTest extends TestBase
{

    private final Logger logger = LogManager.getLogger("Info");
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    @BeforeTest
    public void report()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Reports/TestCasesReport.html");
        extent.attachReporter(spark);
    }

    public void login()
    {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    //Verify user can access cart page after adding products to cart
    @Test(priority = 7)
    public void testcase7()
    {
        try
        {
            logger.info("<<<<<Executing Test case 7>>>>>");
            driver.navigate().to(baseUrl);
            login();
            InventoryPage inventorypage = PageFactory.initElements(driver, InventoryPage.class);
            inventorypage.addProductsToCart();
            inventorypage.shoppingCart();
            Assert.assertEquals(driver.getCurrentUrl(),cartPageUrl);

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T7.png"));
            logger.info("<<<<<Testcase 7 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify user can access cart page after adding products to cart")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was able to access cart page after adding products");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Verify checkout with empty firstname field
    @Test(priority = 8)
    public void testcase8()
    {
        try
        {
            logger.info("<<<<<Executing Test case 8>>>>>");
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
            cartPage.checkoutButton();
            Assert.assertEquals(driver.getCurrentUrl(),checkoutStep1PageUrl);
            checkoutPage.setFirstName("");
            checkoutPage.setLastName("Tester");
            checkoutPage.setPostalCode("12345");
            checkoutPage.continueButton();

            //Capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T8.png"));
            checkoutPage.cancelButton();
            logger.info("<<<<<Testcase 8 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify checkout with empty firstname text field")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to checkout, correct error message displayed");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //verify checkout with empty fields
    @Test(priority = 9)
    public void testCase9()
    {
        try
        {
            logger.info("<<<<<Executing Test case 9>>>>>");
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
            cartPage.checkoutButton();
            Assert.assertEquals(driver.getCurrentUrl(),checkoutStep1PageUrl);
            checkoutPage.setFirstName("");
            checkoutPage.setLastName("");
            checkoutPage.setPostalCode("");
            checkoutPage.continueButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T9.png"));
            checkoutPage.cancelButton();
            logger.info("<<<<<Testcase 9 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify checkout with empty text fields")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to checkout, correct error message displayed");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //Verify checkout with empty lastname text field
    @Test(priority = 10)
    public void testCase10()
    {
        try
        {
            logger.info("<<<<<Executing Test case 10>>>>>");
            CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            cartPage.checkoutButton();
            Assert.assertEquals(driver.getCurrentUrl(),checkoutStep1PageUrl);
            checkoutPage.setFirstName("Tester");
            checkoutPage.setLastName("");
            checkoutPage.setPostalCode("9876");
            checkoutPage.continueButton();

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T10.png"));
            checkoutPage.cancelButton();
            logger.info("<<<<<Testcase 10 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify checkout with empty lastname text field")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to checkout, correct error message displayed");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //verify checkout with empty postal field
    @Test(priority = 11)
    public void testCase11()
    {
        try
        {
            logger.info("<<<<<Executing Test case 11>>>>>");
            CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            cartPage.checkoutButton();
            Assert.assertEquals(driver.getCurrentUrl(),checkoutStep1PageUrl);
            checkoutPage.setFirstName("John");
            checkoutPage.setLastName("Doe");
            checkoutPage.setPostalCode("");
            checkoutPage.continueButton();

            //Capture screenshot
            TakesScreenshot screenshot  = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T11.png"));
            checkoutPage.cancelButton();
            logger.info("<<<<<Testcase 11 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify checkout with empty postal code text field")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was unable to checkout, correct error message displayed");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Verify checkout
    @Test(priority = 12)
    public void testCase12()
    {
        try
        {
            logger.info("<<<<<Executing Test case 12>>>>>");
            CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            cartPage.checkoutButton();
            Assert.assertEquals(driver.getCurrentUrl(),checkoutStep1PageUrl);
            checkoutPage.setFirstName("Software");
            checkoutPage.setLastName("Tester");
            checkoutPage.setPostalCode("45667");
            checkoutPage.continueButton();
            Assert.assertEquals(driver.getCurrentUrl(), checkoutStep2PageUrl);

            //Capture screenshot for checkout overview
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T12.png"));
            checkoutPage.finishButton();
            Assert.assertEquals(driver.getCurrentUrl(), checkoutCompletePageUrl);

            //capture screenshot for checkout complete
            TakesScreenshot screenshot1 = (TakesScreenshot)driver;
            File source1 = screenshot1.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source1, new File("./Screenshots/SAUC-T13.png"));
            logger.info("<<<<<Testcase 12 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify checkout with credentials")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User was able to checkout");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        extent.flush();
    }
}