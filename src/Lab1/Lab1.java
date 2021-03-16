package Lab1;

import java.lang.reflect.Array;
import java.util.ArrayList;

//Дан массив без повторяющихся элементов.
//Пермешать его так, чтобы каждый элемент оказался на новом месте.
//Вывести изначальный и получившийся массивы.
public class Lab1 {

    //Массив для перемешивания
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    //Возвращает пермешанный массив как текст
    public  String getMassAsText(){
        String text = "";
        for (int x : numbers){
            text += x + " ";
        }
        return text;
    }

    public void work (){
        int rand, swap;
        //Перемешивание Фишера – Йетса
        for (int i = 0; i < numbers.length; i++){
            rand = (int) (Math.random() * i);
            swap = numbers[i];
            numbers[i] = numbers[rand];
            numbers[rand] = swap;
        }
    }
}
