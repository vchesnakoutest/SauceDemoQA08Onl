package steps;

import objects.Car;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Matchers;

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

    public boolean verifyObjects(Car car1, Car car2) {
        return Matchers.verifyObjects(car1, car2);
    }
}
