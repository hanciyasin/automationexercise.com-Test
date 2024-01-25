package StepDefinitions;

import Pages.AutomationExercises;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.ObjectInputFilter;

public class TC01_StepDefs {
    AutomationExercises page = new AutomationExercises();

    @Given("Navigate to website")
    public void navigateToWebsite() {
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {

    }

    @And("Click on Signup-Login button")
    public void clickOnSignupLoginButton() {
        page.loginButton.click();
    }

    @And("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        Assert.assertTrue(page.newUserSignupTxt.isDisplayed());
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
        page.nameBox.sendKeys(ConfigReader.getProperty("name"), Keys.TAB,ConfigReader.getProperty("mail"));
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        page.signUpButton.click();
    }

    @And("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        Assert.assertTrue(page.enterAccInfTxt.isDisplayed());
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        page.mrTitle.click();
        ReusableMethods.bekle(2);
        page.nameBox2.sendKeys(ConfigReader.getProperty("name"),Keys.TAB,
                ConfigReader.getProperty("password"),Keys.TAB,
                "25",Keys.TAB,
                "march",Keys.TAB,
                "2001");

    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        page.newsletterBox.click();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        page.specialOfferBox.click();
    }

    @And("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber() {
        page.firstNameBox.sendKeys(ConfigReader.getProperty("name"),Keys.TAB,
                ConfigReader.getProperty("lastname"),Keys.TAB,Keys.TAB,
                "Random Adress",Keys.TAB,Keys.TAB,
                "Canada",Keys.TAB,
                "Ontorio",Keys.TAB,
                "Ottawa",Keys.TAB,
                "01000",Keys.TAB,
                "123456789");
    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        page.createAccButton.click();
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
    }

    @And("Click Continue button")
    public void clickContinueButton() {
    }

    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
    }

    @And("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
    }
}

