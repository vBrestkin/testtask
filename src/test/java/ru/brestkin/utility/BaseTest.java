package ru.brestkin.utility;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.brestkin.pages.MarketPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest extends UtilsAndConfig {

    static WebDriver driver = new ChromeDriver();
    public static MarketPage marketPage = new MarketPage(driver);

    @Before
    public void initTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        marketPage.open();
        marketPage.closeGeoConfirm();
        marketPage.verifyPage();
    }


    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
}
