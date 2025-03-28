package skeleton;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainMenu {
    private SHAFT.GUI.WebDriver driver;
    private String url = "https://automationexercise.com/";

    public MainMenu(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /// // Locators ///////
    private By SignUporLoginButton = By.partialLinkText("Signup");
    private By HomeButton = By.partialLinkText("Home");
    private By ProductsButton = By.partialLinkText("Products");
    private By CartButton = By.partialLinkText("Cart");
    private By TestCasesButton = By.partialLinkText("Test Cases");
    private By ApiTestingButton = By.partialLinkText("API Testing");
    private By  VideoTutorialsButton = By.partialLinkText("Video Tutorials");
    private By  ContactUsButton = By.partialLinkText("Contact us");
    private By LogoutButton = By.linkText("Logout");

    /// // Action Methods //////
    @Step("Clicking on Sign up or Login Button")
    public void clickOnSignUpLoginButton(){
        // driver.findElement(SignUporLoginButton).click();
         driver.element().click(SignUporLoginButton);
    }
    @Step("Clicking on Logout Button")
    public void clickOnLogoutButton(){
        driver.element().click(LogoutButton);
    }




}
