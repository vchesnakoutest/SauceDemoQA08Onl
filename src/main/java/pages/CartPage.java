package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends HeaderPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";

    public String getProductPrice(String productName) {
        log.info("Get price for product: " + productName);
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Price is: " + productPrice);
        return productPrice;
    }

    public CartPage openPage() {
        openPage(CART_URL);
        return this;
    }
}
