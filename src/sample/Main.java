package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Generate text");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
//    привет мир, давай дружить!
//static String latin = " q w e r t y u i o p a s d f g h j k l z x c v b n m ";


    public static void main(String[] args) {
        launch(args);

    }




}
