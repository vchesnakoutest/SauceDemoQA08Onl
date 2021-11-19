package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest{

    @Test(dataProvider = "User data", dataProviderClass = TestDataProvider.class, retryAnalyzer = Retry.class)
    @Description("Add product to cart")
    public void addProductToCartTest(String username, String password, String productName, String expectedPrice) {
        cartSteps.addProductToCartAndGoToCart(username, password, productName);
        Assert.assertEquals(cartPage.getProductPrice(productName), expectedPrice);
    }

    @Test
    public void addProductToCartWithPageFactoryTest() {
        loginPageFactory.openPage("https://www.saucedemo.com/");
        loginPageFactory.login(System.getProperty("username"), System.getProperty("password"));
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
