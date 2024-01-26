package StepDefinitions;

import Pages.AutomationExercises;
import Utilities.ConfigReader;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class TC03_StepDefs {
    AutomationExercises page = new AutomationExercises();
    @And("Enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {
        page.emailBox.sendKeys(ConfigReader.getProperty("incorrectMail"), Keys.TAB,ConfigReader.getProperty("password"));
    }

    @And("Verify error Your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        Assert.assertTrue(page.incorrectMailTxt.isDisplayed());
    }
}
