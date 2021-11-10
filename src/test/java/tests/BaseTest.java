package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import pages.LoginPageFactory;
import pages.ProductsPage;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    LoginPageFactory loginPageFactory;

    @BeforeMethod
    public void initTest() {
        if(System.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (System.getProperty("browser").equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
