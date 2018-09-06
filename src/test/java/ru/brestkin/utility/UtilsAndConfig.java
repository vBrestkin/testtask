package ru.brestkin.utility;

import org.openqa.selenium.WebDriver;
import ru.brestkin.data.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class UtilsAndConfig {

    public abstract WebDriver getWebDriver();

    public Integer getIntRandom(int min, int max){         {
        if (min >= max) {
            throw new IllegalArgumentException("Максимум должен быть больше минимума");
            }

            Random random = new Random();
            Integer rendomInt = random.nextInt((max - min) + 1) + min;
            System.out.println("Генерируем случайное число от " + min + " до " + max + ". Получаем: " + rendomInt);
            return rendomInt;
        }
    }

    public String getStrRandom(int length){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz";
        String randomStr = new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
        System.out.println("Генерируем случайную строку из буков. Получаем: " + randomStr);
        return randomStr;
    }

    public List<String> shortyList(List<String> list, String str){
        List<String> newList = new ArrayList<>();
        Integer sizeList = list.size();
        for(int i = 0; i < (sizeList); i++){
            newList.add(list.get(i).substring(0, str.length()));
        }
        return newList;
    }

}
