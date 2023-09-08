package com.saucedemo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

class OrderTest {

    private final WebDriver webDriver = new ChromeDriver();

    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"})
    void shouldPlaceOrderWithOneProduct(String username) {
        login(username);
        addOneProductToCart();
        placeOrder();
    }


    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"})
    void shouldPlaceOrderWithAllProducts(String username) {
        login(username);
        addAllProductsToCart();
        placeOrder();
    }

    private void login(String username) {
        webDriver.get("https://www.saucedemo.com/");
        WebElement usernameInput = webDriver.findElement(By.xpath("//input[@data-test='username']"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = webDriver.findElement(By.xpath("//input[@data-test='password']"));
        passwordInput.sendKeys("secret_sauce");
        WebElement login = webDriver.findElement(By.xpath("//input[@data-test='login-button']"));
        login.click();
    }

    private void addOneProductToCart() {
        WebElement addToCart = webDriver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();
    }

    private void addAllProductsToCart() {
        List<WebElement> addToCarts = webDriver.findElements(By.xpath("//button[contains(@class,'btn_inventory')]"));
        for (WebElement addToCart : addToCarts) {
            addToCart.click();
        }
    }

    private void placeOrder() {
        WebElement shoppingCart = webDriver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
        WebElement checkout = webDriver.findElement(By.xpath("//button[@data-test='checkout']"));
        checkout.click();
        WebElement firstName = webDriver.findElement(By.xpath("//input[@data-test='firstName']"));
        firstName.sendKeys("Jan");
        WebElement lastName = webDriver.findElement(By.xpath("//input[@data-test='lastName']"));
        lastName.sendKeys("Kowalski");
        WebElement zipCode = webDriver.findElement(By.xpath("//input[@data-test='postalCode']"));
        zipCode.sendKeys("77777");
        WebElement continueOrder = webDriver.findElement(By.xpath("//input[@data-test='continue']"));
        continueOrder.click();
        WebElement finishOrder = webDriver.findElement(By.xpath("//button[@data-test='finish']"));
        finishOrder.click();
        webDriver.findElement(By.xpath("//h2[@class='complete-header']"));
    }

}
