package ru.brestkin;

import org.junit.Assert;
import org.junit.Test;
import ru.brestkin.pages.MarketPage;
import ru.brestkin.utility.BaseTest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Thread.sleep;

public class SortByPriceTest extends BaseTest {

    @Test
    public void sortingFromSmallToHighTest() {
        marketPage.sortByPriceButton.click();
        marketPage.checkSortingByPrice(true);
    }

    @Test
    public void sortingFromHighToSmallTest() {
        marketPage.sortByPriceButton.click();
        marketPage.sortByPriceButton.click();
        marketPage.checkSortingByPrice(false);
    }
}
