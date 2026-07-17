package swag.labs.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import swag.labs.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swag.labs.data.LoginTestData;
import swag.labs.message.LoginMessage;
import swag.labs.pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void initLoginPage() {
        loginPage = new LoginPage(driver);

    }

    @DisplayName("Should login with valid credentials")
    @Test
    public void shouldLoginWithValidCredentials() {
        loginPage.login(LoginTestData.STANDARD_USERNAME, LoginTestData.PASSWORD);
        Assertions.assertTrue(loginPage.isProductTitleDisplayed());
    }

    @DisplayName("Should display error for invalid credentials")
    @Test
    public void shouldDisplayErrorForInvalidCredentials(){
        loginPage.login(LoginTestData.INVALID_USERNAME, LoginTestData.INVALID_PASSWORD);
        Assertions.assertEquals(LoginMessage.INVALID_CREDENTIALS_MESSAGE,loginPage.getInvalidCredentialsError());
    }

    @DisplayName("Should display error when credentials are empty")
    @Test
    public void shouldDisplayErrorWhenCredentialsAreEmpty(){
        loginPage.login("", "");
        Assertions.assertEquals(LoginMessage.EMPTY_CREDENTIALS_MESSAGE,loginPage.getEmptyUserNameInputError());
    }

    @DisplayName("Should login as problem user")
    @Test
    public void shouldLoginAsProblemUser(){
       loginPage.login(LoginTestData.PROBLEM_USERNAME, LoginTestData.PASSWORD);
        Assertions.assertTrue(loginPage.isProductTitleDisplayed());
    }

    @DisplayName("Should display error for locked out user")
    @Test
    public void shouldDisplayErrorForLockedOutUser(){
        loginPage.login(LoginTestData.LOCKED_OUT_USERNAME, LoginTestData.PASSWORD);
        Assertions.assertEquals(LoginMessage.LOCKED_USER_MESSAGE, loginPage.getErrorMessageLockedOutUserName());
    }
}
