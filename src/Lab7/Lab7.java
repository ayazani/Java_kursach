package Lab7;//С использованием streamAPI реализовать следующие методы:
//  a. метод, возвращающий среднее значение списка целых чисел
//  b. метод, приводящий все строки в списке в верхний регистр
//  c. метод возвращающий список квадратов всех уникальных элементов списка

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lab7 {
    private List<Integer> firstIntegerList;
    private List<String> stringList;
    private List<Integer> secondIntegerList;
    double number;

    public void setFirstIntegerList(List<Integer> integerList) {
        this.firstIntegerList = integerList;
    }

    public void setSecondIntegerList(List<Integer> integerList1) {
        this.secondIntegerList = integerList1;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public double getNumber() {
        return number;
    }

    public String getStringList() {
        String text = "";
        for (String i : stringList ){
            text += i + " ";
        }
        return text;
    }

    public String getSecondIntegerList() {
        String text = "";
        for (Integer i : secondIntegerList ){
            text += i + " ";
        }
        return text;
    }

    public void work() {
        //System.out.println(averageValuesFromIntList(firstIntegerList));
        //System.out.println();

        number = averageValuesFromIntList(firstIntegerList);

        stringList = stringListToUpperCase(stringList);

        secondIntegerList = UniqueSimbolsToSquare(secondIntegerList);
    }

    private static double averageValuesFromIntList(List<Integer> integerList){
        return integerList.stream().reduce((x,y) -> x+y).get() / (double) integerList.size();
    }

    private static List<String> stringListToUpperCase(List<String> stringList) {
        return stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    private static List<Integer> UniqueSimbolsToSquare(List<Integer> integerList) {
        //поиск элементов, которые повторяются только один раз
        return integerList.stream().filter(x -> Collections.frequency(integerList,x) == 1).map(x -> x*x).collect(Collectors.toList());
    }
}