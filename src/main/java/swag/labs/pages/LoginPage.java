package swag.labs.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import swag.labs.basepage.BasePage;

@Slf4j
public class LoginPage  extends BasePage {
    private final By userNameInput = AppiumBy.accessibilityId("test-Username");
    private final By passwordInput = AppiumBy.accessibilityId("test-Password");
    private final By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private final By invalidCredentialsError = AppiumBy.xpath(("//android.widget.TextView[contains(@text, 'Username and password')]"));
    private final By userLoginItems = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    private final By emptyUserNameInput = AppiumBy.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private final By errorMessageLockedOutUserName = AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]\n");


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Enter username: {userName}")
    public void enterUserName(String userName) {
        type(userNameInput, userName);
        log.info("Entering user name {}", userName);
    }

    @Step("Enter password : {password}")
    public void enterPassword(String password) {
        type(passwordInput, password);
        log.info("Entering password {}", password);
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        click(loginButton);
        log.info("Clicking login button");
    }

    @Step("Login as user: {username}")
    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
        log.info("Starting login process for user {}", username);
    }

    @Step("Get invalid credentials error message")
    public String getInvalidCredentialsError() {
        String text = driver.findElement(invalidCredentialsError).getText();
        log.info("Invalid credentials error message '{}'",text);
        return text;
    }
    @Step("Verify Products page is displayed")
    public boolean isProductTitleDisplayed() {
        boolean isDisplayed = driver.findElement(userLoginItems).isDisplayed();
        log.info("Product title is displayed {}", isDisplayed);
        return isDisplayed;
    }

    @Step("Get username required error message")
    public String getEmptyUserNameInputError() {
        String text = driver.findElement(emptyUserNameInput).getText();
        log.info("Empty user name input error message {}",text);
        return text;
    }

    @Step("Get locked out user error message")
    public String getErrorMessageLockedOutUserName() {
        String text = driver.findElement(errorMessageLockedOutUserName).getText();
        log.info("User name is locked {}", text);
        return text;
    }
}
