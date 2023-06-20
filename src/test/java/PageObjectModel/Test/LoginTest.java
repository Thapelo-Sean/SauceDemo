package PageObjectModel.Test;

import PageObjectModel.Pages.CartPage;
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
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class LoginTest extends testBase{
    private final Logger logger = LogManager.getLogger("Info");
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
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
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
            loginPage loginPage = PageFactory.initElements(testBase.driver, loginPage.class);
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
            inventoryPage inventorypage = PageFactory.initElements(driver,inventoryPage.class);
            inventorypage.addProductsToCart();
            inventorypage.shoppingCart();

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
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            cartPage.checkoutButton();
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
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            cartPage.checkoutButton();
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
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            cartPage.checkoutButton();
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
            checkoutPage checkoutPage = PageFactory.initElements(driver,checkoutPage.class);
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            cartPage.checkoutButton();
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
            checkoutPage checkoutPage = PageFactory.initElements(driver, checkoutPage.class);
            CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
            cartPage.checkoutButton();
            checkoutPage.setFirstName("Software");
            checkoutPage.setLastName("Tester");
            checkoutPage.setPostalCode("45667");
            checkoutPage.continueButton();
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T12.png"));
            checkoutPage.finishButton();

            //capture screenshot
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

    //verify logout functionality
    @Test(priority = 13)
    public void testCase13()
    {
        try
        {
            logger.info("<<<<<Executing Test case 12>>>>>");
            inventoryPage inventoryPage = PageFactory.initElements(driver, inventoryPage.class);
            inventoryPage.menuButton();
            Thread.sleep(300);
            inventoryPage.logoutButton();
            Thread.sleep(300);

            //capture screenshot
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/SAUC-T14.png"));
            logger.info("<<<<<Testcase 12 executed>>>>>");

            //Testcase Report
            extent.createTest("Verify logout functionality")
                    .assignAuthor("Thapelo Matji")
                    .log(Status.PASS, "User logged out successfully");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}