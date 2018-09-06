package ru.brestkin.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.brestkin.data.Elements;
import ru.brestkin.data.Messages;
import ru.brestkin.utility.UtilsAndConfig;

public abstract class Page extends UtilsAndConfig {

    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebDriver getWebDriver(){
        return driver;
    }

    private WebDriver driver;
    public abstract void open();
    public abstract void verifyPage();

    //Блок элементов header страницы
    @FindBy(xpath = Elements.HEADER_LOGO_XPATH)
    public WebElement logo;
    @FindBy(id = Elements.HEADER_SEARCH_FIELDS_ID)
    public WebElement searchInputField;
    @FindBy(xpath = Elements.HEADER_SEARCH_BUTTON_XPATH )
    public WebElement searchButton;
    @FindBy(xpath = Elements.HEADER_TOPMENU_XPATH )
    public WebElement topMenu;

    //Блок элементов footer страницы
    @FindBy(xpath = Elements.FOOTER_AREA_XPATH )
    public WebElement footerArea;
    @FindBy(id = Elements.FOOTER_MENU_ID)
    public WebElement footerMenu;

    public void verifyHeader(){
        System.out.println(Messages.LOG_VERIFY_HEADER);
        Assert.assertTrue(Messages.ERROR_HEADER_LOGO, this.logo.isDisplayed());
        Assert.assertTrue(Messages.ERROR_HEADER_SEARCH_FIELS, this.searchInputField.isDisplayed());
        Assert.assertTrue(Messages.ERROR_HEADER_SEARCH_BUTTON, this.searchButton.isDisplayed());
        Assert.assertTrue(Messages.ERROR_HEADER_TOPMENU, this.topMenu.isDisplayed());
    }

    public void verifyFooter(){
        System.out.println(Messages.LOG_VERIFY_FOOTER);
        Assert.assertTrue(Messages.ERROR_FOOTER_AREA, this.footerArea.isDisplayed());
        Assert.assertTrue(Messages.ERROR_FOOTER_MENU, this.footerMenu.isDisplayed());
    }



}
