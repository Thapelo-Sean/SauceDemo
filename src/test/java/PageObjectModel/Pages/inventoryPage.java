package PageObjectModel.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class inventoryPage {
    WebDriver driver;

    public inventoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Locate elements
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack") @CacheLookup
    WebElement addTocartBackPackButton;
    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-bike-light") @CacheLookup
    WebElement getAddTocartBikeLightButton;
    @FindBy(how = How.ID, using = "shopping_cart_container") @CacheLookup
    WebElement shoppingCartButton;

    public void addProductsToCart()
    {
        try
        {
            addTocartBackPackButton.click();
            getAddTocartBikeLightButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void shoppingCard()
    {
        try
        {
            shoppingCartButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}