package Lab8;

import java.lang.annotation.*;
//Аннотация только для методов и только во время выполнения программы
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IAnnotation {
    int annotationValue() default 0;
}