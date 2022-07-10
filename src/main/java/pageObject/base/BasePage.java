package pageObject.base;

import io.qameta.allure.Step;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.base.enums.Alphabets;
import pageObject.base.enums.Language;
import pageObject.base.enums.RandomGenerator;


import java.security.SecureRandom;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    @FindBy(css = ".lang__link--active")
    private WebElement activeLanguage;

    @FindBy(css = "a.lang__link")
    private WebElement inActiveLanguage;

    @FindBy(xpath = "//h1")
    private WebElement titleOfPage;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    @Step("The method is used for changing site language")
    public void changeLanguage(Language lang){
        switch (lang){
            case RU:{
                if (activeLanguage.getText().equalsIgnoreCase("UA")){
                    inActiveLanguage.click();
                }
                break;
            }
            case UA:{
                if (activeLanguage.getText().equalsIgnoreCase("RU")){
                    inActiveLanguage.click();
                }
            }
            break;
        }
    }

    @Step("Generated random data for registration form")
    public static String randomGenerator(RandomGenerator option, int symbols, String alphabet) {
        String random = "";
        switch (option) {
            case FIRST_NAME:
            case SECOND_NAME:
            case PASSWORD:{
                return random = getRandomWord(symbols, alphabet);
            }
            case EMAIL: {
                return random = getRandomWord(symbols, alphabet) + "@gmail.com";
            }
            case PHONE_NUMBER: {
                return random = "96" + getRandomWord(symbols, alphabet);
            }
        }
        return null;
    }

    @Step("Method is used for generate random string")
    public static String getRandomWord(int length, String alphabet) {
        StringBuilder sb = new StringBuilder(Math.max(length, 16));
        SecureRandom RND = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int len = alphabet.length();
            int random = RND.nextInt(len);
            char c = alphabet.charAt(random);
            sb.append(c);
        }
        return sb.toString();
    }

    @Step("Get current page's title")
    public String getTitle(){
        return titleOfPage.getText();
    }
}
