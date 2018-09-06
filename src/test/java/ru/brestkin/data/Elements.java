package ru.brestkin.data;

public final class Elements {
    //Селекторы header'а
    public static final String HEADER_LOGO_XPATH = "//div[@class='header2__logo']";
    public static final String HEADER_SEARCH_FIELDS_ID = "header-search";
    public static final String HEADER_SEARCH_BUTTON_XPATH = "//span[text()[contains(.,'Найти')] and @class='button2__text']";
    public static final String HEADER_TOPMENU_XPATH = "//ul[@class='topmenu__list']";

    //Селекторы footer'а
    public static final String FOOTER_AREA_XPATH = "//div[@class='header2__logo']";
    public static final String FOOTER_MENU_ID = "header-search";

    //Селекторы основной страницы
    public static final String MARKET_TITLE_XPATH = "//h1[@title='Ноутбуки']";
    public static final String MARKET_SORT_BY_PRICE_BUTTON_PATH = "//a[text()[contains(.,'по цене')] and parent::div]";
    public static final String MARKET_MIN_PRICE_FIELD_ID = "glpricefrom";
    public static final String MARKET_MAX_PRICE_FIELD_ID = "glpriceto";
    public static final String MARKET_PRODUCT_LIST_EMPTY_TITLE_XPATH = "//div[text()[contains(.,'Нет подходящих товаров')] and @class='title']";
    public static final String MARKET_PRODUCT_LIST_NAME_XPATH = "//div[@class='n-snippet-card2__title']";
    public static final String MARKET_PRICES_XPATH = "//div[@class='price' and parent::a]";


    public static final String MARKET_BRAND_LIST_NAME_XPATH = "//fieldset[@data-autotest-id='7893318']//div";
}
