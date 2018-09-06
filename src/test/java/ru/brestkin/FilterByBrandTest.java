package ru.brestkin;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.brestkin.utility.BaseTest;

import java.util.List;

public class FilterByBrandTest extends BaseTest {

    @Test
    public void oneBrandFilterTest(){
        WebElement brand = marketPage.getRandomBrand();
        marketPage.setBrand(brand);
        marketPage.checkBrandFilterWorking(brand);
        marketPage.setBrand(brand);
        marketPage.checkProductListIsNotClear();
    }

    @Test
    public void twoBrandsFilterTest(){
        WebElement brand1 = marketPage.getRandomBrand();
        WebElement brand2 = marketPage.getRandomBrand();
        marketPage.setBrand(brand1);
        marketPage.checkBrandFilterWorking(brand1);
        marketPage.setBrand(brand2);
        marketPage.checkBrandsFilterWorking(brand1, brand2);
        marketPage.checkProductListIsNotClear();

    }

}
