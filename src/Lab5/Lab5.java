package Lab5;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

//Пользователь вводит некоторое число. Записать его цифры в стек.
//Вывести число, у которого цифры идут в обратном порядке.
//Предусмотреть возможность введения произвольного количества чисел.

public class Lab5 {
    private ArrayList<Integer> numbers;
    private String reverseNumbers = "";

    public void setAllNumbers(ArrayList<Integer> allNumbers) {
        this.numbers = allNumbers;
    }

    public String getReverseNumbers() {
        return reverseNumbers;
    }

    public void work() {

        //Основной стэк, содержит в себе стеки являющиеся числами, где каждый элемент это цифра числа
        Stack[] mainStack = new Stack[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
            //Добавление нового числа
            mainStack[i] = new Stack();
            //Превращаем число в массив символов
            for (char ch: numbers.get(i).toString().toCharArray()) {
                //Записываем в стек цифры превращенные обратно в integer
                mainStack[i].push(Character.getNumericValue(ch));
            }
        }

        for (Stack number : mainStack) {
            while(!number.isEmpty()) {
                //Вывод стека с конца и удаление элемента
                reverseNumbers += number.pop();
            }
            reverseNumbers += " ";
        }
    }
}