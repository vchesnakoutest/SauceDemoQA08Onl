package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public CartSteps addProductToCartAndGoToCart(String username, String password, String productName) {
        loginPage.openPage()
                .login(username, password)
                .addProductToCart(productName);
        cartPage.openPage();
        return this;
    }
}
