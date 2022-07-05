package pageObject.base;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.base.enums.Language;
import pageObject.base.enums.RandomGenerator;


import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    @FindBy(css = ".lang__link--active")
    private WebElement activeLanguage;

    @FindBy(css = "a.lang__link")
    private WebElement inActiveLanguage;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

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

    public static String randomGenerator(RandomGenerator option, int symbols) {
        String random = "";
        switch (option) {
            case FIRST_NAME:
            case SECOND_NAME: {
                return random = RandomStringUtils.randomAlphabetic(symbols);
            }
            case EMAIL: {
                return random = RandomStringUtils.randomAlphanumeric(symbols) + "@gmail.com";
            }
            case PASSWORD: {
                return random = RandomStringUtils.randomAlphanumeric(symbols);
            }
            case PHONE_NUMBER: {
                return random = "96" + RandomStringUtils.randomNumeric(symbols);
            }
        }
        return null;
    }
}
