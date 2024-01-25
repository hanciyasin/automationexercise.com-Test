package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationExercises {
    public AutomationExercises() {PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;
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
}
