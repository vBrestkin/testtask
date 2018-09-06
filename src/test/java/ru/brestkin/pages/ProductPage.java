package ru.brestkin.pages;

import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

    private String currentPageURL;

    public ProductPage(WebDriver driver, String productID){
        super(driver);
        currentPageURL = "https://market.yandex.ru/product/" + productID;
    }

    @Override
    public void open() {
        getWebDriver().get(currentPageURL);
    }

    @Override
    public void verifyPage() {
        this.verifyHeader();
        this.verifyFooter();
    }
}
