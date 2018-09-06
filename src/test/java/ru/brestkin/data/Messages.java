package ru.brestkin.data;

public final class Messages {

    //Сщщбщения об ошибках при проверках наличия элементов
    public static final String ERROR_HEADER_LOGO = "Не отобразился логотип";
    public static final String ERROR_HEADER_SEARCH_FIELS = "Не отобразилось поле поиска";
    public static final String ERROR_HEADER_SEARCH_BUTTON = "Не отобразилась кнопка 'Найти'";
    public static final String ERROR_HEADER_TOPMENU = "Не отобразилось главное меню";
    public static final String ERROR_FOOTER_AREA = "Не отобразилась область footer'а";
    public static final String ERROR_FOOTER_MENU = "Не отобразилось нижнее меню footer'а";
    public static final String ERROR_SORT_BY_PRICE_FROM_SMALL = "Сортировка по возрастанию работает не корректно";
    public static final String ERROR_SORT_BY_PRICE_FROM_HIGH = "Сортировка по убыванию работает не корректно";
    public static final String ERROR_PRICE_FIELD = "В поле %s цены попало что-то не то";
    public static final String ERROR_PRODUCT_LIST_NOT_EMPTY = "Список продуктов не пуст";
    public static final String ERROR_PRODUCT_LIST_EMPTY = "Список продуктов пуст";
    public static final String ERROR_PRICE_VALUE_MAX = "Значение цены в списке продуктов превышает заданные значение в фильтре";
    public static final String ERROR_PRICE_VALUE_MIN = "Значение цены в списке продуктов меньше заданного значение в фильтре";
    public static final String ERROR_BRAND = "В всписке продуктов оказалась позиция с отсутствующем в фильтре брэндом";

    //Логирование
    public static final String LOG_OPEN_PAGE = "Открываем страницу ";
    public static final String LOG_VERIFY_PAGE = "Проверяем целостность страницы";
    public static final String LOG_VALUE_IS_NULL = "Значение равно null";
    public static final String LOGO_PRODUCT_LIST_IS_NOT_EMPTY = "Список продуктов отобразился";
    public static final String LOG_BORDER = "***************************************************";
    public static final String LOG_GEO_POPUP = "Закрываем popup окно подтверждения геолокации";
    public static final String LOG_PRODUCT_LIST_IS_CLEAR = "Проверяем пуст ли список продуктов";
    public static final String LOG_PRODUCT_LIST_IS_NOT_CLEAR = "Проверяем на месте ли список продуктов";
    public static final String LOG_GET_PRICE_RAGE = "Берем значение %s цены из plaсeholder'а";
    public static final String LOG_VALUE_IS = "Значение равно ";
    public static final String LOG_MAX_VALUE_IN_FILTER = "Максимальное значените цены в фильтре   = ";
    public static final String LOG_MIN_VALUE_IN_FILTER = "Минимальное значение цены в фильтре     = ";
    public static final String LOG_MAX_VALUER_IN_PRODUCT_LIST = "Максимальное значение цены в продуктах  = ";
    public static final String LOG_MIN_VALUE_IN_PRODUCT_LIST = "Минимальное значение цены в продуктах   = ";
    public static final String LOG_CLEAR_VALUE_PRICE = "Сбрасываем значение %s цены";
    public static final String LOG_VERIFY_HEADER = "Проверяем целостность header";
    public static final String LOG_VERIFY_FOOTER = "Проверяем целостность footer";
    public static final String LOG_GET_CURRENT_VALUE = "Берем реальное значение %s цены из value объекта";
    public static final String LOG_CLEAR_FILTER_VALUE = "Предварительно чистим поле %s цены";
    public static final String LOG_INPUT_VALUE_TO_FILTER = "вводим в поле %s цены значение ";
    public static final String LOG_CHECK_SORT_ASCENDING = "Проверяем сортировку цен по возрастанию";
    public static final String LOG_CHECK_SORT_ASCENDING_REVERS = "Проверяем сортировку цен по убыванию";
    public static final String LOG_CHECK_BRAND_FILTER = "Проверяем фильтров брэндов";
    public static final String LOG_GET_RANDOM_BRAND = "Возмем случайный бренд из списка доступных";
    public static final Object LOG_BRAND_COUNT = "Удалим все лишнее из названий позиций и сравним с нашим брэндом ";
    public static final String LOG_BRANDS_CHECK = "Количество позиций бренда %s в списке навно %s";
}