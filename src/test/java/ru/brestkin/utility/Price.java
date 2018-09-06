package ru.brestkin.utility;

import org.openqa.selenium.WebElement;
import ru.brestkin.pages.MarketPage;

public enum Price {
    MIN("минимальной", MarketPage.minPriceInputField),
    MAX("максимальной", MarketPage.maxPriceInputField);

    private String message;
    private WebElement element;

    Price(String message, WebElement element) {
        this.message = message;
        this.element = element;
    }

    public String getMessege() {
        return message;
    }
    public WebElement getElement() {
        return element;
    }

    @Override
    public String toString(){
        return message;
    }
}
