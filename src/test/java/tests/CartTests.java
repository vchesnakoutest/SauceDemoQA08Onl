package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{

    @Test
    public void addProductToCartTest() {
        loginPage.openPage()
                 .login("standard_user", "secret_sauce")
                 .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addProductToCartWithPageFactoryTest() {
        loginPageFactory.openPage("https://www.saucedemo.com/");
        loginPageFactory.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void demoWithoutPageFactoryTest() {
        loginPageFactory.openPage("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButtonElement = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
        addButtonElement.click();
        WebElement deleteButtonElement = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
        deleteButtonElement.click();
        addButtonElement.click();
        deleteButtonElement.click();
    }
}
