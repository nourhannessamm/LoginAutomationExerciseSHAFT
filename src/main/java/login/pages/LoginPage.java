package login.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/login";

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /// /// Locators //////
    private By EmailAddress = By.xpath("//input[@data-qa='login-email']");
    private By Password = By.xpath("//input[@data-qa='login-password']");
    private By LoginButton = By.xpath("//button[@data-qa='login-button']");
    private By LoginText = By.xpath("//h2[text()='Login to your account']");
    private By ErrorMessage = By.xpath("//p[@style='color: red;']");

    /// /// Action Methods /////
    @Step("Navigate to Login Page")
    public void navigateToLoginPage() {
        driver.browser().navigateToURL(url);
    }

    @Step("Entering the Email Address {email}")
    public LoginPage enterEmailAddress(String email) {
       driver.element().type(EmailAddress,email);
        return this;
    }

    @Step("Entering the Password {password}")
    public LoginPage enterPassword(String password) {
        driver.element().typeSecure(Password,password); // to hide the password
        return this;
    }

    @Step("Clicking on Login Button")
    public LoginPage clickOnLoginButton() {
        driver.element().click(LoginButton);
        return this;
    }

    /// // Validations //////
    @Step("Verify 'Login to your account' is visible")
    public LoginPage validateLoginTextVisibility() {
         driver.assertThat()
                 .element(LoginText)
                 .text()
                 .isEqualTo("Login to your account");
        return this;
    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    public void validateErrorMessageVisibility() {
        driver.assertThat()
                .element(ErrorMessage)
                .text()
                .isEqualTo("Your email or password is incorrect!");
    }

}