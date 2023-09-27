package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.PageObjectCommon;

public class CheckoutStepOne extends PageObjectCommon {
    @FindBy(xpath = "//input[@data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@data-test='postalCode']")
    private WebElement zipCodeInput;
    @FindBy(xpath = "//input[@data-test='continue']")
    private WebElement continueButton;


    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepOne setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public CheckoutStepOne setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CheckoutStepOne setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }


    public CheckoutStepTwo continueOrder() {
        continueButton.click();
        return new CheckoutStepTwo(driver);
    }

}



