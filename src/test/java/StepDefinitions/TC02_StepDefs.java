package StepDefinitions;

import Pages.AutomationExercises;
import Utilities.ConfigReader;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class TC02_StepDefs {
    AutomationExercises page = new AutomationExercises();


    @And("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        Assert.assertTrue(page.LoginToYourAccTxt.isDisplayed());
    }

    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        page.emailBox.sendKeys(ConfigReader.getProperty("mail"), Keys.TAB,ConfigReader.getProperty("password"));
    }

    @And("Click login button")
    public void clickLoginButton() {
        page.loginButton.click();
    }

    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        Assert.assertTrue(page.loggedAs.isDisplayed());
    }

}
