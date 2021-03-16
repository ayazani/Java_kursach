package KursWork;

import Lab1.Lab1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Путь до Файла с разметкой
        URL url = new File("src/KursWork/Scene.fxml").toURI().toURL();
        //Загрузка FXMLLoader для разметки окна
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}