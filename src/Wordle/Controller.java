package Wordle;

import java.util.ArrayList;

import javax.swing.plaf.multi.MultiMenuBarUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
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
    Alert youWon;
    Alert youLose;
    Alert noWord;
    String secretWord;
    Background backFillGreen;
    Background backFillYellow;
    Background backFillGrey;
    Background resetBackground;
    GridPane[] grid;
    int idx = 0;
    String inputWord = "";
    Object WordGenerator;

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
        youWon = new Alert(AlertType.CONFIRMATION);
        youWon.setHeaderText("YOU WON");
        youWon.setContentText("You have guessed the word.");
        youLose = new Alert(AlertType.CONFIRMATION);
        youLose.setHeaderText("YOU LOST");
        youLose.setContentText("You have lost. The word was " + secretWord);
        noWord = new Alert(AlertType.ERROR);
        noWord.setHeaderText("Not and a real word");
        noWord.setContentText("This is not a word in the english dictionary");
        backFillGreen = new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY));
        backFillYellow = new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY));
        backFillGrey = new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY));
        resetBackground = new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY));
        //Making gridpane array = to something
        grid = new GridPane[6];
        WordGenerator = new Object();
        
        
    }
    @FXML
    void onEnterClick(ActionEvent event) {
            for(int i = 0; i < 5; i++) {
                TextField currentField = ((TextField)grid[idx].getChildren().get(i));
                String currentLetter = currentField.getText();
                inputWord += currentLetter;

                
                if(currentLetter.length() != 1) {
                    multiLetters.showAndWait();
                    return;
                }
                
                if((currentLetter.charAt(0) >= 65 && currentLetter.charAt(0) <= 90) || (currentLetter.charAt(0) >= 97 && currentLetter.charAt(0) <= 122)) {
                    if(currentLetter.toLowerCase().charAt(0) == secretWord.toLowerCase().charAt(i)) {
                        System.out.println(currentLetter + " is in the right spot");
                        currentField.setBackground(backFillGreen);
                    }

                    else if(secretWord.contains(currentLetter)) {
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
            }
            if(secretWord.toLowerCase().equals(inputWord.toLowerCase())) {
                youWon.showAndWait();
                resetBoard();
            }
            idx++;
            if(idx == 6) {
                youLose.showAndWait();
                resetBoard();
            }
            
        
    } 
    public void resetBoard() {
        
        for (GridPane gridPane : grid) {
            for (Node currentNode: gridPane.getChildren()) {
                ((TextField)currentNode).setText("");
                ((TextField)currentNode).setBackground(resetBackground);
            }
        }
    }
}