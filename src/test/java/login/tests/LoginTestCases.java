package login.tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import login.pages.HomePage;
import login.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import skeleton.MainMenu;

@Epic("Access Management")
@Feature("User Login Functionality")
@Story("User Login - Success and Failure Scenarios")
public class LoginTestCases {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Test(description = "Successful Login with Valid Credentials")
    @Description("As a user, I want to log in using valid credentials so that I can access my account.")
    @Severity(SeverityLevel.CRITICAL)
    public void happyLoginScenario() {
        new HomePage(driver)
                .navigateToHomePage()
                .validateThatWeAreInHomePage();
        new MainMenu(driver)
                .clickOnSignUpLoginButton();
        new LoginPage(driver)
                .validateLoginTextVisibility()
                .enterEmailAddress(testData.getTestData("email"))
                .enterPassword(testData.getTestData("password"))
                .clickOnLoginButton();
    }

    @Test(description = "End to End Login Scenario")
    @Description("As a user, I want to log in using valid credentials so that I can access my account, and then log out to securely end my session.")
    @Severity(SeverityLevel.CRITICAL)
    public void e2eLoginScenario() {
        new HomePage(driver)
                .navigateToHomePage()
                .validateThatWeAreInHomePage();
        new MainMenu(driver)
                .clickOnSignUpLoginButton();
        new LoginPage(driver)
                .validateLoginTextVisibility()
                .enterEmailAddress(testData.getTestData("email"))
                .enterPassword(testData.getTestData("password"))
                .clickOnLoginButton();
        new MainMenu(driver)
                .clickOnLogoutButton();
    }

    @Test(description = "Unsuccessful Login with Invalid Credentials")
    @Description("User should not be able to access the account with invalid credentials.The system must prevent unauthorized access and display an appropriate error message when incorrect login details are entered.")
    @Severity(SeverityLevel.CRITICAL)
    public void negativeLoginScenario() {
        new HomePage(driver)
                .navigateToHomePage()
                .validateThatWeAreInHomePage();
        new MainMenu(driver)
                .clickOnSignUpLoginButton();
        new LoginPage(driver)
                .validateLoginTextVisibility()
                .enterEmailAddress(testData.getTestData("invalidEmail"))
                .enterPassword(testData.getTestData("wrongPassword"))
                .clickOnLoginButton()
                .validateErrorMessageVisibility();
    }


    /////////// Configurations ///////////
    @BeforeClass(description = "Getting Test Data")
    public void DataFileParsing() {
        // as we need to do this only one time (Parsing the file only one time)
        testData = new SHAFT.TestData.JSON("src/test/resources/TestData/TestData.json");

    }

    @BeforeMethod
    public void setUp() {
       driver = new SHAFT.GUI.WebDriver(); //runs with the SHAFT Default configurations
        driver.browser().fullScreenWindow();
    }

    @AfterMethod(description = "Closing Driver")
    public void tearDown() {
        driver.quit();
    }
}
