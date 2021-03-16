package KursWork;

import Lab4.Lab4;
import Lab6.Lab6;
import Lab7.Lab7;
import Lab1.Lab1;
import Lab2.Lab2;
import Lab3.Lab3;
import Lab5.Lab5;
import Lab8.Lab8;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SceneController {
    @FXML
    private TextField lab1Input;
    @FXML
    private TextArea lab1Output;
    @FXML
    private TextField lab2Input;
    @FXML
    private TextArea lab2OutputForOriginalMatrix;
    @FXML
    private TextArea lab2OutputForChangedMatrix;
    @FXML
    private TextField lab3Input;
    @FXML
    private TextArea lab3Output;
    @FXML
    private TextArea lab3SortedOutput;
    @FXML
    private TextField firstX;
    @FXML
    private TextField firstY;
    @FXML
    private TextField secondX;
    @FXML
    private TextField secondY;
    @FXML
    private TextField thirdX;
    @FXML
    private TextField thirdY;
    @FXML
    private TextArea lab4Output;
    @FXML
    private TextField lab7InputAVG;
    @FXML
    private TextField lab7OutputAVG;
    @FXML
    private TextField lab7InputUppCase;
    @FXML
    private TextField lab7OutputUppCase;
    @FXML
    private TextField lab7InputSquare;
    @FXML
    private TextField lab7OutputSquare;
    @FXML
    private TextArea lab8Output;
    @FXML
    private TextField lab8Input;
    @FXML
    private TextField lab5Input;
    @FXML
    private TextField lab5Output;
    @FXML
    private TextField lab6InputText;
    @FXML
    private TextField lab6InputPathOrFile;
    @FXML
    private TextArea lab6Output;


    private final Lab6 lab6 = new Lab6();

    public void labFirstWork(){
        Lab1 lab1 = new Lab1();
        lab1Input.setText(lab1.getMassAsText());
        lab1.work();
        lab1Output.setText(lab1.getMassAsText());

    }
    public void labSecondWork(){
        Lab2 lab2 = new Lab2();
        if (lab2Input.getText() != null){
            String textNumber = lab2Input.getText();
            try {
                int number = Integer.parseInt(textNumber);
                if (number < 2 || number > 10){
                    lab2Input.setText("Invalid number");
                }
                else {
                    lab2.setX(number);
                    lab2.work();
                    lab2OutputForOriginalMatrix.setText(lab2.getMatrixBefore());
                    lab2OutputForChangedMatrix.setText(lab2.getMatrixAfter());
                    lab2Input.clear();
                }
            }
            catch (Exception e){
                lab2Input.setText("Error!");
            }
        }
        else{
            lab2Input.setText("Empty field!");
        }
    }

    public void labThirdWork(){

        Lab3 lab3 = new Lab3();
        String text = lab3Input.getText();
        if (text != null){
            lab3.setText(text);
        }
        lab3.work();
        lab3Output.setText(lab3.getEndText());
        lab3SortedOutput.setText(lab3.getEndSortText());
        lab3Input.clear();

    }

    public void labFourWork(){
        Lab4 lab4 = new Lab4();
        String aX = firstX.getText();
        String aY = firstY.getText();
        String bX = secondX.getText();
        String bY = secondY.getText();
        String cX = thirdX.getText();
        String cY = thirdY.getText();

        try {
            lab4.setAx(Integer.parseInt(aX));
            lab4.setAy(Integer.parseInt(aY));
            lab4.setBx(Integer.parseInt(bX));
            lab4.setBy(Integer.parseInt(bY));
            lab4.setCx(Integer.parseInt(cX));
            lab4.setCy(Integer.parseInt(cY));
            lab4.work();
            lab4Output.setText(lab4.getInfo());
        }
        catch (Exception e) {
            lab4Output.setText("Error!");
        }
    }

    public void labFiveWork(){
        Lab5 lab5 = new Lab5();
        ArrayList<Integer> allNumbers = new ArrayList<>();
        String allNumbersS = lab5Input.getText();
        allNumbersS += " ";
        boolean hasLetters = false;
        char[] line = allNumbersS.toCharArray();
        for (char s : line) {
            if (Character.isAlphabetic(s)&& s != ' '){
                hasLetters = true;
                break;
            }
        }
        if (!hasLetters) {
            String textNumber = "";
            for (int i = 0; i < allNumbersS.length(); i++) {
                char x = allNumbersS.charAt(i);
                if (x != ' ') {
                    textNumber += x;
                } else {
                    try {
                        int number = Integer.parseInt(textNumber);
                        allNumbers.add(number);
                        textNumber = "";
                    } catch (Exception e) {
                        lab5Output.setText("Error!");
                        break;
                    }
                }
            }
            if (lab5Output.getText() != "Error!") {
                lab5.setAllNumbers(allNumbers);
                lab5.work();
                lab5Output.setText(lab5.getReverseNumbers());
            }
        }
        else {
            lab5Output.setText("Invalid input! There should be no letters!");
        }
    }

    public void labSixls(){
        try {
            lab6.ls();
            lab6Output.setText(lab6.getText());
        }
        catch (Exception e){
            lab6Output.setText(e.getMessage());
        }
    }

    public void labSixrm(){
        String file = lab6InputPathOrFile.getText();
        String message = lab6.rm(file);
        lab6InputPathOrFile.clear();
        lab6Output.setText(message);
    }

    public void labSixtouch(){
        String file = lab6InputPathOrFile.getText();
        String message = lab6.touch(file);
        lab6InputPathOrFile.clear();
        lab6Output.setText(message);
    }

    public void labSixcat(){
        String file = lab6InputPathOrFile.getText();
        try {
            lab6.cat(file);
            lab6Output.setText(lab6.getText());
        } catch (IOException e) {
            lab6Output.setText(e.getMessage());
        }
        lab6InputPathOrFile.clear();
    }

    public void labSixecho(){
        String file = lab6InputPathOrFile.getText();
        String text = lab6InputText.getText();
        try {
            lab6.echo(file,text,false);
            lab6Output.setText("Text was added.");
        } catch (IOException e) {
            lab6Output.setText(e.getMessage());
        }
        lab6InputText.clear();
        lab6InputPathOrFile.clear();
    }

    public void labSixcd(){
        String path = lab6InputPathOrFile.getText();
        try {
            lab6.cd(path);
        }
        catch (Exception e){
            lab6Output.setText(e.getMessage());
        }
    }

    public void labSixechoA(){
        String file = lab6InputPathOrFile.getText();
        String text = lab6InputText.getText();
        try {
            lab6.echo(file,text,true);
            lab6Output.setText("Text was added.");
        } catch (IOException e) {
            lab6Output.setText(e.getMessage());
        }
        lab6InputText.clear();
        lab6InputPathOrFile.clear();
    }

    public void labSevenWork(){
        Lab7 lab7 = new Lab7();
        String textA1 = lab7InputAVG.getText() + " ";;
        String textB1 = lab7InputUppCase.getText() + " ";
        String textC1 = lab7InputSquare.getText() + " ";
        boolean check1 = true;
        boolean check2 = true;

        List<Integer> firstIntegerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Integer> secondIntegerList = new ArrayList<>();

        String textNumber = "";
        for (int i = 0; i < textA1.length(); i++){
            char x = textA1.charAt(i);
            if (x != ' '){
                textNumber += x;
            }
            else{
                try{
                    int numb = Integer.parseInt(textNumber);
                    firstIntegerList.add(numb);
                    textNumber = "";
                }
                catch (Exception e){
                    lab7OutputAVG.setText("Error!");
                    check1 = false;
                    break;
                }
            }
        }
        for (int i = 0; i < textB1.length(); i++){
            char x = textB1.charAt(i);
            if (x != ' '){
                textNumber += x;
            }
            else{
                stringList.add(textNumber);
                textNumber = "";
            }
        }
        for (int i = 0; i < textC1.length(); i++){
            char x = textC1.charAt(i);
            if (x != ' '){
                textNumber += x;
            }
            else{
                try{
                    int numb = Integer.parseInt(textNumber);
                    secondIntegerList.add(numb);
                    textNumber = "";
                }
                catch (Exception e){
                    lab7OutputSquare.setText("Error!");
                    check2 = false;
                    break;
                }
            }
        }

        if (check1 && check2){
            lab7.setFirstIntegerList(firstIntegerList);
            lab7.setStringList(stringList);
            lab7.setSecondIntegerList(secondIntegerList);
            lab7.work();

            lab7OutputAVG.setText("" + lab7.getNumber());
            lab7OutputUppCase.setText(lab7.getStringList());
            lab7OutputSquare.setText(lab7.getSecondIntegerList());
        }

    }
    
    public void labEightWork(){
        Lab8 lab8 = new Lab8();
        String text = lab8Input.getText();
        lab8.setText(text);
        lab8.work();
        lab8Output.setText(lab8.getText());
    }
}
