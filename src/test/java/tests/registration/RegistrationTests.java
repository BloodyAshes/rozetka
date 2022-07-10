package tests.registration;

import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.base.enums.Language;
import pageObject.base.enums.RandomGenerator;
import pageObject.rozetka.CatalogMainPage;
import tests.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static constants.Constants.Urls.ROZETKA_PAGE;
import static pageObject.base.BasePage.randomGenerator;


public class RegistrationTests extends BaseTest{

    CatalogMainPage catalogMainPage;

    @BeforeMethod
    public void beforeMethod(){
    open(ROZETKA_PAGE);
        catalogMainPage = new CatalogMainPage(driver);
        catalogMainPage.changeLanguage(Language.RU);
    }

    @Description(value = "Test to verify that user can be able to create a new account")
    @Test
    public void verifySuccessfulCustomerRegistration(){
        catalogMainPage.openRegistrationForm()
                .fillRegistrationFormWithValidValues();
        Assert.assertEquals(catalogMainPage.getTitle(), "Подтверждение номера телефона");
    }

}
