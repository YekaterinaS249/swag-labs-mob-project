package swag.labs.base;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import swag.labs.core.DriverFactory;

import java.net.MalformedURLException;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.createDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}