package StepDefinitions;

import Pages.AutomationExercises;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class TC04_StepDefs {
    AutomationExercises page = new AutomationExercises();
    @And("Click Logout button")
    public void clickLogoutButton() {
        page.logoutButton.click();
    }

    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        Assert.assertTrue(page.LoginToYourAccTxt.isDisplayed());
    }
}
