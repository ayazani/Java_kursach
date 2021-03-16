package Lab8;//Написать аннотацию с целочисленным параметром.
//Создать класс, содержащий только приватные методы (3-4шт),
//аннотировать любые из них.
//Вызвать из другого класса все аннотированные методы столько раз,
//сколько указано в параметре аннотации.

import java.lang.reflect.Method;

public class Lab8 {
    String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void work() {
        Annotation annotationClass = new Annotation();
        annotationClass.setText(text);
        text = "";
        Class<?> c = annotationClass.getClass();
        for (Method m : c.getDeclaredMethods()){
            if (m.isAnnotationPresent(IAnnotation.class)){ //проверка на аннатируемость метода
                m.setAccessible(true); //насильно устанавливаем доступность
                for (int i = 0; i < m.getAnnotation(IAnnotation.class).annotationValue(); i++){
                    try {
                        text += m.invoke(annotationClass);//вызов метод у аннотируемого класса
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}