package tests.registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.base.enums.Language;
import pageObject.base.enums.RandomGenerator;
import pageObject.rozetka.CatalogMainPage;
import tests.base.BaseTest;

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


    @Test
    public void verifySuccessfulCustomerRegistration(){
        catalogMainPage.openRegistrationForm()
                .fillFirstName(randomGenerator(RandomGenerator.FIRST_NAME, 5));
    }

}
