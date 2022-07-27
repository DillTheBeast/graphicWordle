package Wordle;

import javax.swing.plaf.multi.MultiMenuBarUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private GridPane grid1;

    @FXML
    private GridPane grid2;

    @FXML
    private GridPane grid3;

    @FXML
    private GridPane grid4;

    @FXML
    private GridPane grid5;

    @FXML
    private GridPane grid6;

    @FXML
    private Button enterButton;

    Alert multiLetters;
    Alert number;
    String secretWord = "ratio";
    Background backFillGreen;
    Background backFillYellow;
    GridPane[] grid;
    int idx = 0;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        
        grid[0] = grid1;
        grid[1] = grid2;
        grid[2] = grid3;
        grid[3] = grid4;
        grid[4] = grid5;
        grid[5] = grid6;  
    }

    public Controller() {
        multiLetters = new Alert(AlertType.ERROR);
        multiLetters.setHeaderText("Invalid letter amount.");
        multiLetters.setContentText("There should be one letter in each box.");
        number = new Alert(AlertType.ERROR);
        number.setHeaderText("Invalid input");
        number.setContentText("There should only be a letter in the box. No numbers or characters.");
        backFillGreen = new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY));
        backFillYellow = new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY));
        //Making gridpane array = to something
        grid = new GridPane[6];
    }
    @FXML
    void onEnterClick(ActionEvent event) {
            for(int i = 0; i < 5; i++) {
                TextField currentField = ((TextField)grid[idx].getChildren().get(i));
                String currentLetter = currentField.getText();
                
                if(currentLetter.length() != 1) {
                    multiLetters.showAndWait();
                    return;
                }
                if(currentLetter.charAt(0) > 65 & currentLetter.charAt(0) < 90||currentLetter.charAt(0) > 97 & currentLetter.charAt(0) < 122) {
                    if(currentLetter.charAt(0) == secretWord.charAt(i)) {
                        System.out.println(currentLetter + " is in the right spot");
                        currentField.setBackground(backFillGreen);
                    }
                    //If currentLetter is somewhere inside of secretWord
                    else if(secretWord.contains(currentLetter)){
                        System.out.println(currentLetter + " is in the word but placed in the wrong spot");
                        currentField.setBackground(backFillYellow); 
                    }
                    else {
                        System.out.println(currentLetter + " is not in the word");
                    }
                }
                else {
                    number.showAndWait();
                    return;
                }
                idx++;
                
            }
        
    } 
}