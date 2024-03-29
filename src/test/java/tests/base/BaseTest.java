package tests.base;

import driver.Browsers;
import driver.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import pageObject.base.BasePage;
import pageObject.rozetka.CatalogMainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static constants.Constants.CLEAR_COOKIES_AND_STORAGE;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;
import static constants.Constants.TimeoutVariable.PAGE_LOAD_WAIT;
import static constants.Constants.Urls.HOST_URL;

public class BaseTest {

    protected WebDriver driver = null;


    @BeforeSuite
    public void setUp(){
        driver = WebDriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
    }

@AfterTest
public void clearCookiesAndLocalStorage(){
    if (CLEAR_COOKIES_AND_STORAGE)
    {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
    }
}


@AfterSuite(alwaysRun = true)
    public void afterSuite(){
    if (driver !=null){
        driver.quit();
    }
}

    public void open(String url){
        driver.navigate().to(url);
    }

    public void docker(){
        ChromeOptions opt = new ChromeOptions();
        opt.setCapability("enableVNC", true); //Activate UI window for docker+selenoid
        opt.setCapability("sessionTimeout", "5m");
        try {
            driver = new RemoteWebDriver(new URL(HOST_URL), opt);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

}
