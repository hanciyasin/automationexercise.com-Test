package StepDefinitions;

import Pages.AutomationExercises;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TC07_StepDefs {
    AutomationExercises page = new AutomationExercises();
    @Then("Click on Test Cases button")
    public void clickOnTestCasesButton() {
        page.testCasesButton.click();
    }

    @And("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        Assert.assertTrue(page.testCasesTxt.isDisplayed());
    }
}
