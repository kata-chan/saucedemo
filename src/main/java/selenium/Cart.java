package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.common.PageObjectCommon;

public class Cart extends PageObjectCommon {

    @FindBy(xpath = "//button[@data-test='checkout']")
    private WebElement checkoutButton;

    public Cart(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepOne checkout() {
        checkoutButton.click();
        wait(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-test='continue']")));
        return new CheckoutStepOne(driver);
    }

}
