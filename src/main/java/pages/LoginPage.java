package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

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
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        clickLoginButton();
        return new ProductsPage(driver);
    }

    @Step("Click 'Login' button on Login page")
    public void clickLoginButton() {
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
