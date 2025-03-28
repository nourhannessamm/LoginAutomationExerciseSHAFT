package login.pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.testng.Assert;


public class HomePage {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/";

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /// // Locators //////

    /// // Action methods////
    @Step("Navigate to the Home Page")
    public HomePage navigateToHomePage() {
        driver.browser().navigateToURL(url);
        return this;
    }

    /// // Validations //////
    @Step("Verify that home page is visible successfully")
    public void validateThatWeAreInHomePage() {
        driver.assertThat()
                .browser()
                .url()
                .isEqualTo("https://automationexercise.com/");

    }


}