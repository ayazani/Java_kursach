package Lab3;//Дана строка.
//Разделить строку на фрагменты по три подряд идущих символа
//В каждом фаргменте заменить средний символ на случайный символ, не равный соседним.
//Вывести все фаргменты, упорядоченные по алфавиту.

import java.util.Arrays;
import java.util.Scanner;


public class Lab3 {
    private String line = "some text text";
    private String endText = "";
    private String endSortText = "";

    public void setText(String text) {
        this.line = text;
    }

    public String getEndSortText() {
        return endSortText;
    }

    public String getEndText() {
        return endText;
    }

    public void work() {
        line = line.toLowerCase();

        //Проверка, возможно ли разбиение строки по три элемента
        if (line.length() % 3 == 1)
            line += "..";
        else if(line.length() % 3 == 2)
            line += ".";


        String[] stringArray = new String[line.length()/3];
        String middle, left, right;

        //Выборка по 3 значения в 3 переменнные
        for (int i = 0, j = 0; i < line.length(); i = i + 3, j++) {
            middle = line.substring(i + 1, i + 2);
            left = line.substring(i, i + 1);
            right = line.substring(i + 2, i + 3);

            do {
                middle = String.valueOf((char) ((Math.random() * 126) + 32));
            } while (middle.equals(left) || middle.equals(right));

            stringArray[j] = "" + left + middle + right;
            endText += stringArray[j] + "\n";
        }

        //Сортировка массива символов
        Arrays.sort(stringArray);

        //Вывод массива троек на экран
        for (String s : stringArray) {
            endSortText += s + "\n";
        }
    }
}