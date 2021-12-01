package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By BOT_LOGO = By.xpath("//*[@class='bot_column']");

    @Step("Login as username: '{username}' and password: '{password}'")
    public ProductsPage login(String username, String password) {
        Waiters.waitForElementLocated(driver, USERNAME_INPUT, 10);
        log.info(String.format("Type text: '%s' into username input on Login page", username));
        log.debug("Locator is: " + USERNAME_INPUT);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info(String.format("Type text: '%s' into password input on Login page", password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        clickLoginButton();
        return new ProductsPage(driver);
    }

    @Step("Click 'Login' button on Login page")
    public void clickLoginButton() {
        log.info("Click 'Login' button.");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void waitForPageOpenedExample() {
        Waiters.waitForElementLocated(driver, BOT_LOGO, 10);
    }

    public LoginPage openPage() {
        openPage(BASE_URL);
        waitForPageOpenedExample();
        return this;
    }
}
