package PageObjectModel.Test;

import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class TestBase
{

    public String baseUrl = "https://www.saucedemo.com/";
    public String inventoryUrl = "https://www.saucedemo.com/inventory.html";
    public String cartPageUrl = "https://www.saucedemo.com/cart.html";
    public String checkoutStep1PageUrl = "https://www.saucedemo.com/checkout-step-one.html";
    public String checkoutStep2PageUrl = "https://www.saucedemo.com/checkout-step-two.html";
    public String checkoutCompletePageUrl = "https://www.saucedemo.com/checkout-complete.html";
    private final Logger logger = LogManager.getLogger("Info");
    static WebDriver driver = null;
    ExtentReports extent;

    @BeforeTest
    @Parameters("browser")
    public void browserSetup(String browser)
    {
        try
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browser.equalsIgnoreCase("safari"))
            {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            else if(browser.equalsIgnoreCase("microsoft edge"))
            {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else
            {
                throw new Exception("Incorrect browser");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @BeforeTest
    public void init()
    {
        try
        {
            logger.info("<<<<<<<<<<Executing Test Cases..............");
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

            //Verify URL
            Assert.assertEquals(driver.getCurrentUrl(),baseUrl);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Close browser
    @AfterSuite
    public void tearDown()
    {
        if(driver!=null)
        {
            extent.flush();
            driver.quit();
        }
        logger.info("<<<<<<<<<<Tests successfully Executed>>>>>>>>>>");
    }
}