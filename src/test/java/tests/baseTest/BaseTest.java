package tests.baseTest;

import driver.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import pageObject.base.BasePage;
import pageObject.zakupka.CatalogMainPage;

import java.util.concurrent.TimeUnit;

import static constants.Constants.CLEAR_COOKIES_AND_STORAGE;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;
import static constants.Constants.TimeoutVariable.PAGE_LOAD_WAIT;

public class BaseTest {
protected WebDriver driver = WebDriverFactory.initDriver();
protected BasePage basePage = new BasePage(driver);
protected CatalogMainPage catalogMainPage = new CatalogMainPage(driver);


@AfterTest
public void clearCookiesAndLocalStorage(){
    if (CLEAR_COOKIES_AND_STORAGE)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
    }
}

@BeforeSuite
    public void setUp(){
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
}

@AfterSuite(alwaysRun = true)
    public void afterSuite(){
    if (driver !=null){
        driver.quit();
    }
}



}
