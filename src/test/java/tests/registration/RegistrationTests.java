package tests.registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.ZAKUPKA_CATALOG_PAGE;

public class RegistrationTests extends BaseTest{

    @BeforeMethod
    public void beforeMethod(){
        basePage.open(ZAKUPKA_CATALOG_PAGE);
    }


    @Test
    public void verifySuccessfulCustomerRegistration(){

    }

}
