package Utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ReusableMethods {

    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //Tüm Sayfa ScreenShot
    public static String tumSayfaResmi(String name) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/target/Screenshots/" + name + tarih + ".png";
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dosyaYolu;
    }

    //WebElement ScreenShot
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SetAttributeValue
    public static void setAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }

    //File Upload Robot Class
    public static void uploadFile(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        } catch (Exception ignored) {

        }
    }

    public static String randomPassword(int lower, int upper, int numeric) {
        String lowercharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String uppercharacters = "abcdefghijklmnopqrstuvwxyz";
        String numericcharacters = "0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < lower; i++) {
            int randomIndex1 = random.nextInt(lowercharacters.length());
            char randomLowerChar = lowercharacters.charAt(randomIndex1);
            password.append(randomLowerChar);
        }
        for (int i = 0; i < upper; i++) {
            int randomIndex2 = random.nextInt(uppercharacters.length());
            char randomUpperChar = uppercharacters.charAt(randomIndex2);
            password.append(randomUpperChar);
        }
        for (int i = 0; i < numeric; i++) {
            int randomIndex3 = random.nextInt(numericcharacters.length());
            char randomNumericChar = numericcharacters.charAt(randomIndex3);
            password.append(randomNumericChar);

        }
        return password.toString();
    }

    //verilen sayı aralıgındaki uzunluga sahip user name olusturan metot
    public static String generatelessonNema(int minLength, int maxLength) {
        Faker faker = new Faker();
        String userName;
        do {
            userName = faker.programmingLanguage().name();
        } while (userName.length() < minLength || userName.length() > maxLength);
        return userName;
    }

    //verilen uzunluga gore fake name olusturan metot
    public static String generateName(int minLength, int maxLength) {
        Faker faker = new Faker();
        String fakeName;
        do {
            fakeName = faker.name().firstName();
        } while (fakeName.length() < minLength || fakeName.length() > maxLength);
        return fakeName;
    }

    //verilen uzunluga gore fake surname olusturan metot
    public static String generateSurname(int minLength, int maxLength) {
        Faker faker = new Faker();
        String fakeSurname;
        do {
            fakeSurname = faker.name().firstName();
        } while (fakeSurname.length() < minLength || fakeSurname.length() > maxLength);
        return fakeSurname;
    }

    //İstenilen formatta gelecekte tarih olusturma
    public static String generateDateFuture(int yıl, String newFormat) {
        Faker faker = new Faker();
        Date date = faker.date().future(360 * yıl, TimeUnit.DAYS);
        SimpleDateFormat sdf = new SimpleDateFormat(newFormat);
        String formattedDate = sdf.format(date);
        return formattedDate;
    }


    //İstenilen aralıkta Name ,surname birthplace olusturma methodu
    public static String nameSurnameBirthPlace(int arg1, int arg2, Boolean includeUpperCase, Boolean includeDigit) {
        Faker faker = new Faker();
        String arg = faker.lorem().characters(arg1, arg2, includeUpperCase, includeDigit);
        return arg;
    }

    //fake dogum tarihi olusturan metot
    public static String fakeBirthDate(String format) {
        Faker faker = new Faker();
        Date fakeBirthdate = faker.date().birthday();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(fakeBirthdate);

    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static Faker faker;
    public static int oneDigitNumber(){
        faker = new Faker();
        return faker.number().numberBetween(1,9);
    }
    public static int twoDigitNumber(){
        faker = new Faker();
        return faker.number().numberBetween(10, 99);
    }
    public static int threeDigitNumber(){
        faker = new Faker();
        return faker.number().numberBetween(100, 899);
    }
    public static int fourDigitNumber(){
        faker = new Faker();
        return faker.number().numberBetween(1000, 9999);
    }

    public static void scrollUpJs(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,-500)", "");
    }

    public static void scrollDownJs(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,200)", "");
    }

    public static void clearJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value = ''", element);
    }

    public static String generateUserName(int minLength, int maxLength) {
        Faker faker = new Faker();
        String userName;
        do {
            userName = faker.name().username();
        } while (userName.length() < minLength || userName.length() > maxLength);
        return userName;
    }

    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }
    public static String generatebirthPlace(int minLength, int maxLength) {
        Faker faker = new Faker();
        String birthPlace;
        do {
            birthPlace = faker.address().city();
        } while (birthPlace.length() < minLength || birthPlace.length() > maxLength);
        return birthPlace;
    }

    public static String randomPhone() {
        Random random = new Random();
        String sayi1 = Integer.toString(random.nextInt(899) + 100);
        String sayi2 = Integer.toString(random.nextInt(899) + 100);
        String sayi3 = Integer.toString(random.nextInt(8999) + 1000);
        String phone = sayi1 + "-" + sayi2 + "-" + sayi3;
        return phone;

    }
    public static String randomSsn() {
        Random random = new Random();
        String sayi1 = Integer.toString(random.nextInt(899) + 100);
        String sayi2 = Integer.toString(random.nextInt(89) + 10);
        String sayi3 = Integer.toString(random.nextInt(8999) + 1000);
        String ssn = sayi1 + "-" + sayi2 + "-" + sayi3;
        return ssn;

    }
}





