package StepDefinitions;

import Pages.AutomationExercises;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class TC06_StepDefs {
    AutomationExercises page = new AutomationExercises();
    @Then("Click on Contact Us button")
    public void clickOnContactUsButton() {
        page.contactUs.click();
    }
    @And("Verify GET IN TOUCH is visible")
    public void verifyGETINTOUCHIsVisible() {
        Assert.assertTrue(page.getInTouchTXt.isDisplayed());
    }
    @And("Enter name, email, subject and message")
    public void enterNameEmailSubjectAndMessage() {
        page.contactNameBox.sendKeys(ConfigReader.getProperty("name"), Keys.TAB,ConfigReader.getProperty("mail"),Keys.TAB,"Subject",Keys.TAB,"Message");
    }
    @And("Upload file")
    public void uploadFile() {
        page.contactUploadFile.sendKeys(ConfigReader.getProperty("messagePath"));
    }
    @And("Click OK button")
    public void clickOKButton() {
        ReusableMethods.alertAccept();
    }
    @And("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        Assert.assertTrue(page.contactSuccessfulTxt.isDisplayed());
    }
    @And("Click Submit button to submit message")
    public void clickSubmitButtonToSubmitMessage() {
        page.contactSubmitButton.click();
    }
}
