package ru.brestkin;

import org.junit.Test;
import ru.brestkin.utility.BaseTest;
import ru.brestkin.utility.Price;

public class PriceRangeFilterTest extends BaseTest {
    @Test
    public void incorrectInputToFieldTest() {
        marketPage.minPriceInputField.sendKeys(getStrRandom(12));
        marketPage.checkPriceFieldIsClear(Price.MIN);
        marketPage.maxPriceInputField.sendKeys(getStrRandom(12));
        marketPage.checkPriceFieldIsClear(Price.MAX);
    }

    @Test
    public void inputNullValueToFieldsTest(){
        marketPage.inputPriceValue(Price.MIN, 0);
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
        marketPage.cleanPriceValue(Price.MIN);
        marketPage.inputPriceValue(Price.MAX, 0);
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
    }

    @Test
    public void inputSubZeroValueToFieldsTest(){
        marketPage.inputPriceValue(Price.MIN, -1);
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
        marketPage.cleanPriceValue(Price.MIN);
        marketPage.inputPriceValue(Price.MAX, -1);
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
    }

    @Test
    public void inputValueToMinFieldTest(){
        marketPage.inputPriceValue(Price.MIN, getIntRandom(0, marketPage.getPriceRage(Price.MIN)));
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
    }

    @Test
    public void inputValueToMaxFieldTest(){
        marketPage.inputPriceValue(Price.MAX, getIntRandom(0, marketPage.getPriceRage(Price.MIN)));
        marketPage.checkProductListIsClear();
    }

    @Test
    public void inputRegularValueToMinFieldTest(){ //Данный тест регулярно падает, судя по всему у яндекса свое особенное представление о том, как должен работать фильтр по нижней границе цены =((
        Integer min = getIntRandom(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
        marketPage.inputPriceValue(Price.MIN, min);
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(min, marketPage.getPriceRage(Price.MAX));
        marketPage.cleanPriceValue(Price.MIN);
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));
    }

    @Test
    public void inputRegularValueToMaxFieldTest(){
        Integer max = getIntRandom(marketPage.getPriceRage(Price.MIN)*2, marketPage.getPriceRage(Price.MIN)*4); //В этом тесте сделаем небольшое допущение, так как большая часть каталога Яндекса по ценам расположена в нижнем сегменте немного сместим генерацию
        marketPage.inputPriceValue(Price.MAX, max);
        marketPage.checkProductListIsNotClear();
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), max);
        marketPage.cleanPriceValue(Price.MAX);
        marketPage.checkPriceListPage(marketPage.getPriceRage(Price.MIN), marketPage.getPriceRage(Price.MAX));

    }

    @Test
    public void inputRegularValueToFieldsTest(){
        Integer min = getIntRandom(marketPage.getPriceRage(Price.MIN)*2, marketPage.getPriceRage(Price.MIN)*4);
        Integer max = getIntRandom(min*2, marketPage.getPriceRage(Price.MAX));
        marketPage.inputPriceValue(Price.MIN, min);
        marketPage.checkPriceListPage(min, marketPage.getPriceRage(Price.MAX));
        marketPage.checkProductListIsNotClear();
        marketPage.inputPriceValue(Price.MAX, max);
        marketPage.checkPriceListPage(min, max);
    }



}
