package StepDefinitions;

import Pages.AutomationExercises;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TC09_StepDefs {
    AutomationExercises page = new AutomationExercises();
    @Then("Click on Products button")
    public void clickOnProductsButton() {
        page.productsButton.click();
    }
    @And("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        Assert.assertTrue(page.allProductsTxt.isDisplayed());
    }
    @And("Enter product name in search input and click search button")
    public void enterProductNameInSearchInputAndClickSearchButton() {
        page.searchProductBox.sendKeys("Blue");
        page.searchSubmitButton.click();
    }
    @And("Verify SEARCHED PRODUCTS is visible")
    public void verifySEARCHEDPRODUCTSIsVisible() {
        Assert.assertTrue(page.searchedProductsTxt.isDisplayed());
    }
    @And("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
        for (WebElement result : page.searchResults){
            Assert.assertTrue(result.isDisplayed());
        }

    }
}
