package swag.labs.basepage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public abstract class BasePage {
    protected final AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}


