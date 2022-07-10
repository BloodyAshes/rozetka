package tests.registration;

import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.base.enums.Alphabets;
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



    @DataProvider(name = "validation")
    public Object[][] validation(){
        return new Object[][]{
                {Alphabets.EN_ALPHABET.getAlphabet()},
                {Alphabets.NUMBERS.getAlphabet()},
                {Alphabets.SPECIAL_SYMBOLS.getAlphabet()},
                {" "}
        };
    }

    @Description(value = "Verify that the first name input validation is working")
    @Test(dataProvider = "validation")
    public void checkValidationForFirstNameInput(String symbolsSet){
        catalogMainPage.openRegistrationForm()
                .fillFirstName(randomGenerator(RandomGenerator.FIRST_NAME, 5, symbolsSet));
        Assert.assertNotNull(catalogMainPage.getValidationError());
    }

    @Description(value = "Verify that the last name input validation is working")
    @Test(dataProvider = "validation")
    public void checkValidationForLastNameInput(String symbolsSet){
        catalogMainPage.openRegistrationForm()
                .fillLastName(randomGenerator(RandomGenerator.SECOND_NAME, 6, symbolsSet));
        Assert.assertNotNull(catalogMainPage.getValidationError());
    }

}
