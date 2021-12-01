package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class BasePage implements IConstants {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        log.trace("Initializing PageFactory.");
        PageFactory.initElements(driver,this);
    }

    public void openPage(String url) {
        log.info("Open URL: " + url);
        driver.get(url);
    }

    public void clickUsingJS(WebDriver driver, WebElement element) {
        log.warn("Warning: JS click is used!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("" + element, "");
    }
}
