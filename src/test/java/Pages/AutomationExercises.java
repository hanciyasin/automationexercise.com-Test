package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationExercises {
    public AutomationExercises() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLoginButton;
    @FindBy(xpath = "//*[.='New User Signup!']")
    public WebElement newUserSignupTxt;
    @FindBy(xpath = "//*[@name='name']")
    public WebElement nameBox;
    @FindBy(xpath = "//*[.='Signup']")
    public WebElement signUpButton;
    @FindBy(xpath = "//h2[.='Enter Account Information']")
    public WebElement enterAccInfTxt;
    @FindBy(xpath = "//input[@value='Mr']")
    public WebElement mrTitle;
    @FindBy(xpath = "//input[@value='Mrs']")
    public WebElement mrsTitle;
    @FindBy(id = "name")
    public WebElement nameBox2;
    @FindBy(id = "newsletter")
    public WebElement newsletterBox;
    @FindBy(id = "optin")
    public WebElement specialOfferBox;
    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[.='Create Account']")
    public WebElement createAccButton;
    @FindBy(xpath = "//*[.='Login to your account']")
    public WebElement LoginToYourAccTxt;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement emailBox;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//li/a[contains(text(), 'Logged in as')]")
    public WebElement loggedAs;
    @FindBy(xpath = "//p[.='Your email or password is incorrect!']")
    public WebElement incorrectMailTxt;
    @FindBy(xpath = "//*[@href='/logout']")
    public WebElement logoutButton;
    @FindBy(xpath = "//*[@href='/contact_us']")
    public WebElement contactUs;
    @FindBy(xpath = "//*[.='Get In Touch']")
    public WebElement getInTouchTXt;
    @FindBy(xpath = "//*[@name='name']")
    public WebElement contactNameBox;
    @FindBy(xpath = "//*[@name='upload_file']")
    public WebElement contactUploadFile;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement contactSubmitButton;
    @FindBy(xpath = "(//*[.='Success! Your details have been submitted successfully.'])[1]")
    public WebElement contactSuccessfulTxt;
    @FindBy(xpath = "//li/a[@href='/test_cases']")
    public WebElement testCasesButton;
    @FindBy(xpath = "//h2/b[.='Test Cases']")
    public WebElement testCasesTxt;
    @FindBy(xpath = "//*[@href='/products']")
    public WebElement productsButton;
    @FindBy(xpath = "//h2[.='All Products']")
    public WebElement allProductsTxt;
    @FindBy(xpath = "//*[@name='search']")
    public WebElement searchProductBox;
    @FindBy(xpath = "//*[@id='submit_search']")
    public WebElement searchSubmitButton;
    @FindBy(xpath = "//h2[.='Searched Products']")
    public WebElement searchedProductsTxt;
    @FindBy(xpath = "//*[@class='product-image-wrapper']")
    public List<WebElement> searchResults;


}
