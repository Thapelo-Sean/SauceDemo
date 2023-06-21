package PageObjectModel.Test;

import PageObjectModel.Pages.InventoryPage;
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

public class LogoutTest extends TestBase
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

    //verify logout functionality
    @Test(priority = 13)
    public void testCase13()
    {
        try
        {
            logger.info("<<<<<Executing Test case 12>>>>>");
            InventoryPage inventoryPage = PageFactory.initElements(driver, InventoryPage.class);
            inventoryPage.menuButton();
            Thread.sleep(300);
            inventoryPage.logoutButton();
            Thread.sleep(300);
            Assert.assertEquals(baseUrl,driver.getCurrentUrl());

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
        extent.flush();
    }

}
