package com.saucedemo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import selenium.LoginPage;

class OrderTest extends TestCommon {


    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"})
    void shouldPlaceOrderWithOneProduct(String username) {
        new LoginPage(webDriver)
                .login(username, "secret_sauce")
                .addOneProductToCart()
                .openShoppingCart()
                .checkout()
                .setFirstName("Jan")
                .setLastName("Kowalski")
                .setZipCode("77777")
                .continueOrder()
                .assertPriceTotal("$32.39")
                .finishOrder()
                .assertOrderCheckoutedSuccessfully();

    }


    @ParameterizedTest
    @ValueSource(strings = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user"})
    void shouldPlaceOrderWithAllProducts(String username) {
        new LoginPage(webDriver)
                .login(username, "secret_sauce")
                .addAllProductsToCart()
                .openShoppingCart()
                .checkout()
                .setFirstName("Jan")
                .setLastName("Kowalski")
                .setZipCode("77777")
                .continueOrder()
                .assertPriceTotal("$140.34")
                .finishOrder()
                .assertOrderCheckoutedSuccessfully();
    }


}
