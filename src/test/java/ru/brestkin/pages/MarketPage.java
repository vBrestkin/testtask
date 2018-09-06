package ru.brestkin.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.brestkin.data.Elements;
import ru.brestkin.data.Messages;
import ru.brestkin.utility.Price;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;
import static java.util.Comparator.reverseOrder;

public class MarketPage extends Page{

    private static String currentPageURL = "https://market.yandex.ru/catalog/54544/list";
    private static String regExpPrice = "[^-0-9]";
    private static String regExpBrand = "[^A-Za-z]";

    public MarketPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void open() {
        System.out.println(Messages.LOG_OPEN_PAGE + currentPageURL);
        getWebDriver().get(currentPageURL);
    }

    @Override
    public void verifyPage() {
        System.out.println(Messages.LOG_VERIFY_PAGE);
        this.verifyHeader();
        this.verifyFooter();
    }

    public void closeGeoConfirm(){
        System.out.println(Messages.LOG_GEO_POPUP);
        this.title.click();
    }

    @FindBy(xpath = Elements.MARKET_TITLE_XPATH)
    public WebElement title;
    @FindBy(xpath = Elements.MARKET_SORT_BY_PRICE_BUTTON_PATH)
    public WebElement sortByPriceButton;
    @FindBy(id = Elements.MARKET_MIN_PRICE_FIELD_ID)
    public static WebElement minPriceInputField;
    @FindBy(id = Elements.MARKET_MAX_PRICE_FIELD_ID)
    public static WebElement maxPriceInputField;

    public List<Integer> getPriceList(){
        //Ждем полную загрузку списка продуктов
        this.waitProductLoad();

        List<WebElement> webElementList = getWebDriver().findElements(By.xpath(Elements.MARKET_PRICES_XPATH));

        List<String> priceStringList = webElementList.stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());

        List<String> priceStringModifyList = new ArrayList<>();
        priceStringList
                .stream()
                .map((String) -> String.replaceAll(regExpPrice, "")).forEach(priceStringModifyList::add);

        List<Integer> priceList = priceStringModifyList.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return priceList;
    }

    public List <String> getProductNamesList(){
        //Ждем полную загрузку списка продуктов
        this.waitProductLoad();
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath(Elements.MARKET_PRODUCT_LIST_NAME_XPATH));
        List<String> nameStringList = webElementList.stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
        List<String> nameStringModifyList = new ArrayList<>();
        nameStringList
                .stream()
                .map((String) -> String.replaceAll(regExpBrand, "")).forEach(nameStringModifyList::add);
        return nameStringModifyList;
    }

    public WebElement getRandomBrand(){
        System.out.println(Messages.LOG_GET_RANDOM_BRAND);
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath(Elements.MARKET_BRAND_LIST_NAME_XPATH));
        Integer length = webElementList.size();
        List<WebElement> newWebElementList = new ArrayList<>();
        int c = 0;
        for(int i = 1; i < length; i = i + 2){
            newWebElementList.add(webElementList.get(i));
            c++;
        }
        Integer newLength = newWebElementList.size();
        return newWebElementList.get(getIntRandom(0, (newLength-1)));
    }

    public void checkSortingByPrice(Boolean sortAscending){
        if(sortAscending){
            System.out.println(Messages.LOG_CHECK_SORT_ASCENDING);
        }else {
            System.out.println(Messages.LOG_CHECK_SORT_ASCENDING_REVERS);
        }
        String message;
        List<Integer> currentPriceList = this.getPriceList();
        List<Integer> checkerPriceList = this.getPriceList();
        checkerPriceList.sort(Comparator.naturalOrder());
        if(sortAscending){
            message = Messages.ERROR_SORT_BY_PRICE_FROM_SMALL;
        }else{
            message = Messages.ERROR_SORT_BY_PRICE_FROM_HIGH;
            checkerPriceList.sort(reverseOrder());
        }
        Assert.assertTrue(message, currentPriceList.equals(checkerPriceList));
    }

    public void setBrand(WebElement brand){
       brand.click();
    }

    public void checkPriceFieldIsClear(Price price){
        Assert.assertTrue(String.format(Messages.ERROR_PRICE_FIELD, price.getMessege()), getCurrentValueFromPriceField(price) == null);
    }

    public void checkProductListIsClear(){
        System.out.println(Messages.LOG_PRODUCT_LIST_IS_CLEAR);
        Assert.assertTrue(Messages.ERROR_PRODUCT_LIST_NOT_EMPTY, isProductListEmpty());
    }

    public void checkProductListIsNotClear(){
        System.out.println(Messages.LOG_PRODUCT_LIST_IS_NOT_CLEAR);
        Assert.assertTrue(Messages.ERROR_PRODUCT_LIST_EMPTY, !isProductListEmpty());
    }

    public Integer getPriceRage(Price price){
        System.out.println(String.format((Messages.LOG_GET_PRICE_RAGE), price.getMessege()));
        WebElement element = price.getElement();
        return Integer.parseInt(element.getAttribute("placeholder").replaceAll(regExpPrice,""));
    }

    public Integer getCurrentValueFromPriceField(Price price){
        System.out.println(String.format((Messages.LOG_GET_CURRENT_VALUE), price.getMessege()));
        WebElement element = price.getElement();
        String currentValue = element.getAttribute("value").replaceAll(regExpPrice,"");
        if(currentValue.equals("")){
            System.out.println(Messages.LOG_VALUE_IS_NULL);
            return null;
        } else {
            System.out.println(Messages.LOG_VALUE_IS + Integer.parseInt(currentValue));
            return Integer.parseInt(currentValue);
        }
    }
    public void inputPriceValue(Price price, Integer value, Boolean clearFieldBeforeInput){

        WebElement element = price.getElement();
        if(clearFieldBeforeInput){
            System.out.println(String.format((Messages.LOG_CLEAR_FILTER_VALUE), price.getMessege()));
            element.clear();
        }
        System.out.println(String.format((Messages.LOG_INPUT_VALUE_TO_FILTER), price.getMessege() + value));
        element.sendKeys(value.toString());
        Assert.assertTrue(String.format(Messages.ERROR_PRICE_FIELD, price.getMessege()), this.getCurrentValueFromPriceField(price).equals(value));
    }

    public void inputPriceValue(Price price, Integer value){
        inputPriceValue(price, value, true);
    }

    public Boolean isProductListEmpty(){
        if(getPriceList().stream().count() == 0 ){
            return true;
        } else {
            System.out.println(Messages.LOGO_PRODUCT_LIST_IS_NOT_EMPTY);
            return false;
        }
    }

    public void waitProductLoad() {
        //Данный метод необходим для тех элементов кода, которые содержат ображения к элементам страницы без использования PageFactory.
        //В нашем случае таких мест не очень много, но при большом проекте лучше использьзовать активную инициализацию и обработчики с Explicit Wait ожиданиями
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Elements.MARKET_PRICES_XPATH)));
        //Сначала дожидаемся первого появлениякликабельного элемента из списка продуктов
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath(Elements.MARKET_PRICES_XPATH));
        //Затем нам необходимо дождаться пока прогрузятся все необходимые продукты (нам не известно сколько их будет),
        // поэтому используем данный цикл, чтобы дождатся когда загрузка элементов прекратится.
        int i = 0;
        int c = 0;
        int countOld = webElementList.size();
        while(i < 30 || c == 3){
            int countCurrent = webElementList.size();
            if (countCurrent == countOld){
                c++;
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                countOld = countCurrent;
                c = 0;
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
        }
    }

    public void cleanPriceValue(Price price) {
        System.out.println(String.format((Messages.LOG_CLEAR_VALUE_PRICE), price.getMessege()));
        WebElement element = price.getElement();
        element.clear();
        checkPriceFieldIsClear(price);
    }

    public void checkPriceListPage(Integer rageMin, Integer rageMax){
        System.out.println(Messages.LOG_BORDER);
        System.out.println(Messages.LOG_MAX_VALUE_IN_FILTER + rageMax);
        System.out.println(Messages.LOG_MIN_VALUE_IN_FILTER + rageMin);
        System.out.println(Messages.LOG_MAX_VALUER_IN_PRODUCT_LIST + Collections.max(getPriceList()));
        System.out.println(Messages.LOG_MIN_VALUE_IN_PRODUCT_LIST + Collections.min(getPriceList()));
        System.out.println(Messages.LOG_BORDER);
        Assert.assertTrue(Messages.ERROR_PRICE_VALUE_MAX, (Collections.max(getPriceList()) <= rageMax));
        Assert.assertTrue(Messages.ERROR_PRICE_VALUE_MIN, (Collections.min(getPriceList()) >= rageMin));
    }

    public void checkBrandFilterWorking(WebElement brand){
        System.out.println(Messages.LOG_CHECK_BRAND_FILTER);
        String brandName = brand.getText();
        List<String> newList = this.getProductNamesList();
        System.out.println(Messages.LOG_BRAND_COUNT + brandName);
        List<String> newListControl = shortyList(newList, brandName);
        Integer count = this.countMath(newListControl, brandName);
        Assert.assertTrue(Messages.ERROR_BRAND, newList.size() == count);
    }

    public void checkBrandsFilterWorking(WebElement brand1, WebElement brand2){
        String brand1Name = brand1.getText();
        String brand2Name = brand2.getText();
        List<String> list = this.getProductNamesList();
        Integer summ = 0;
        List<String> newList = shortyList(list, brand1Name);
        Integer count1 = this.countMath(newList, brand1Name);
        System.out.println(String.format((Messages.LOG_BRANDS_CHECK), count1.toString(), brand1Name));
        List<String> newList2 = shortyList(list, brand2Name);
        Integer count2 = this.countMath(newList2, brand2Name);
        System.out.println(String.format((Messages.LOG_BRANDS_CHECK), count2.toString(), brand2Name));
        summ = count1 + count2;
        Assert.assertTrue(Messages.ERROR_BRAND, list.size() == summ);
    }

    public Integer countMath(List<String> list, String str){
        Integer count = 0;
        for(int i = 0; i < (list.size()); i++){
            if(list.get(i).equals(str)){
                count++;
            }
        }
        return count;
    }

}
