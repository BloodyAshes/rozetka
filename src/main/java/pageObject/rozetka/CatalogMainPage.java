package pageObject.rozetka;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base.BasePage;

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


}
