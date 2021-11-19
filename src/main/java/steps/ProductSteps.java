package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public ProductSteps loginAndAddProductToCart(String username, String password, String productName) {
        loginPage.openPage()
                .login(username, password)
                .addProductToCart(productName);
        return this;
    }
}
