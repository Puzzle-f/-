package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    String latin = "qwertyuiopasdfghjklzxcvbnm";
    String latinUpperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
    String symbolAll = "`~!@#№$%^&*()_-+=[]{}|/*-.;:,<>?'";
    @FXML
    public TextArea textArea;
    @FXML
    public TextArea textAreaDaemon;
    @FXML
    public Button button;
    static Random rand = new Random();

    public String strArray (String str){
      String[]  word = str.split(" ");
        for (int i = 0; i<word.length; i++) {
        String[] symbol = word[i].split("");
            for (int j = 0; j < symbol.length; j++) {
                if ((ifSymbol(symbolAll, symbol[j]))||(ifSymbol(latinUpperCase, symbol[j]))){
                    continue;
                }
                symbol[j] = random(latin);
            }
            Arrays.toString(symbol);
            String resultWord = String.join("", symbol);
            word[i] = resultWord;
                    System.out.println(resultWord);
        }
        Arrays.toString(word);
        String result = String.join(" ", word);
        System.out.println(result);
        return result;
    }

    public String random(String latin){
        String[] s = latin.split("");
        int random_number = rand.nextInt(latin.length());
        System.out.println(random_number);
        return s[random_number];
    }

    public boolean ifSymbol (String symbolAll, String s){
        boolean b = false;
        String[]  word = symbolAll.split("");
        for (String s1 : word) {
            if(s1.equals(s)){
                b = true;
            }
        }return b;
    }
//    public boolean ifUpperCase(String latinUpperCase, String s){
//        boolean b = false;
//        String[]  word = latinUpperCase.split("");
//        for (String s1 : word) {
//
//        }
//
//
//    }

public static void print(String[] strings){

}


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void generate(ActionEvent actionEvent) {
        textAreaDaemon.appendText(textArea.getText());
        textArea.clear();
        textArea.appendText(strArray(textAreaDaemon.getText()));
        textAreaDaemon.clear();
    }
}
