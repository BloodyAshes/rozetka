package pageObject.rozetka;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base.BasePage;
import pageObject.base.enums.Alphabets;
import pageObject.base.enums.RandomGenerator;

public class CatalogMainPage extends BasePage {

    public CatalogMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//rz-user[@class='header-actions__component']/button")
    private WebElement userProfile;

    @FindBy(css = ".auth-modal__register-link")
    private WebElement registrationButton;

    @FindBy(id = "registerUserName")
    private WebElement firstName;

    @FindBy(id = "registerUserSurname")
    private WebElement lastName;

    @FindBy(id = "registerUserPhone")
    private WebElement phoneNumber;

    @FindBy(id = "registerUserEmail")
    private WebElement email;

    @FindBy(id = "registerUserPassword")
    private WebElement password;

    @FindBy(css = ".auth-modal__submit")
    private WebElement submitButton;


    @Step("Method opens authForm window")
    public CatalogMainPage openAuthForm(){
        userProfile.click();
        return this;
    }

    @Step("Method opens registration form window")
    public CatalogMainPage openRegistrationForm(){
        userProfile.click();
        waitElementIsVisible(registrationButton).click();
        return this;
    }

    @Step("Used for filling first name input")
    public CatalogMainPage fillFirstName(String first){
        firstName.sendKeys(first);
        return this;
    }

    @Step("Used for filling last name input")
    public CatalogMainPage fillLastName(String last){
        lastName.sendKeys(last);
        return this;
    }

    @Step("Used for filling phone number input")
    public CatalogMainPage fillPhoneNumber(String number){
        phoneNumber.sendKeys(number);
        return this;
    }

    @Step("Used for filling email input")
    public CatalogMainPage fillEmail(String box){
        email.sendKeys(box);
        return this;
    }

    @Step("Used for filling password input")
    public CatalogMainPage fillPassword(String pass){
        password.sendKeys(pass);
        return this;
    }

    public void pressSubmitButton(){
        submitButton.click();
    }

    @Step("Used for filling all registration form inputs valid data")
    public CatalogMainPage fillRegistrationFormWithValidValues(){
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщьъэюя";
        fillFirstName(randomGenerator(RandomGenerator.FIRST_NAME, 6, Alphabets.RU_ALPHABET.getAlphabet()))
                .fillLastName(randomGenerator(RandomGenerator.SECOND_NAME, 5, Alphabets.RU_ALPHABET.getAlphabet()))
                .fillPhoneNumber(randomGenerator(RandomGenerator.PHONE_NUMBER, 7, Alphabets.NUMBERS.getAlphabet()))
                .fillEmail(randomGenerator(RandomGenerator.EMAIL, 8, Alphabets.EN_AND_NUMBERS.getAlphabet()))
                .fillPassword(randomGenerator(RandomGenerator.PASSWORD, 16, Alphabets.EN_AND_NUMBERS.getAlphabet()))
                .pressSubmitButton();
        return this;
    }

}
