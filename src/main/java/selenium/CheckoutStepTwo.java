package selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.PageObjectCommon;

public class CheckoutStepTwo extends PageObjectCommon {

    @FindBy(xpath = "//button[@data-test='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    @FindBy(xpath = "//div[contains(@class,'summary_total_label')]")
    private WebElement totalPrice;

    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepTwo finishOrder() {
        finishButton.click();
        return this;
    }

    public CheckoutStepTwo assertOrderCheckoutedSuccessfully() {
        Assertions.assertEquals("Thank you for your order!",
                completeHeader.getText());
        return this;
    }

    public CheckoutStepTwo assertPriceTotal(String expectedPrice) {
        Assertions.assertEquals("Total: " + expectedPrice,
                totalPrice.getText());
        return this;
    }
}
