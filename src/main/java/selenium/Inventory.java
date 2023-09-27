package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.PageObjectCommon;

import java.util.List;

public class Inventory extends PageObjectCommon {

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@class,'btn_inventory')]")
    private List<WebElement> addToCartButtons;


    public Inventory(WebDriver driver) {
        super(driver);
    }


    public Inventory addOneProductToCart() {
        addToCartButton.click();
        return this;
    }

    public Cart openShoppingCart() {
        shoppingCartLink.click();
        return new Cart(driver);
    }

    public Inventory addAllProductsToCart() {
        for (WebElement addToCart : addToCartButtons) {
            addToCart.click();
        }
        return this;
    }
}
