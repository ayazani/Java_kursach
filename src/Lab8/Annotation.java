package Lab8;

public class Annotation {
    //Аннотируемые методы

    String text;

    public void setText(String text) {
        this.text = text;
    }

    @IAnnotation(annotationValue = 4)
    private String printValue4(){
        return text + "\n";
    }
}