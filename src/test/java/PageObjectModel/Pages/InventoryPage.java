package PageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryPage {
    WebDriver driver;

    //Constructor
    public InventoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements using @FindBy annotation
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack") @CacheLookup
    WebElement addToCartBackPackButton;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bike-light") @CacheLookup
    WebElement addToCartBikeLightButton;
    @FindBy(how = How.CLASS_NAME,using = "shopping_cart_container") @CacheLookup
    WebElement shoppingCardContainer;
    @FindBy(how = How.XPATH, using = "//*[@id=\"react-burger-menu-btn\"]") @CacheLookup
    WebElement menuButton;
    @FindBy(how = How.ID, using = "logout_sidebar_link") @CacheLookup
    WebElement logoutButton;

    //Page methods
    public void addProductsToCart()
    {
        try
        {
            addToCartBackPackButton.click();
            addToCartBikeLightButton.click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void shoppingCart()
    {
        try
        {
            shoppingCardContainer.click();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void menuButton()
    {
        menuButton.click();
    }

    public void logoutButton()
    {
        logoutButton.click();
    }
}