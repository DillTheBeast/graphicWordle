package Wordle;

import java.util.ArrayList;

import javax.swing.plaf.multi.MultiMenuBarUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
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
    Alert invalidInput;
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
    WordGenerator wordGenerator;
    String currentLetter;
    TextField currentField;

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

        wordGenerator = new WordGenerator();
        secretWord = wordGenerator.getRandomWord();
        System.out.println(secretWord);

        multiLetters = new Alert(AlertType.ERROR);
        multiLetters.setHeaderText("Invalid letter amount.");
        multiLetters.setContentText("There should be one letter in each box.");

        invalidInput = new Alert(AlertType.ERROR);
        invalidInput.setHeaderText("Invalid input");
        invalidInput.setContentText("There should only be a letter in the box. No numbers or characters.");

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

        grid = new GridPane[6]; 
    }

    @FXML
    void onEnterClick(ActionEvent event) {
        inputWord = "";

            for(int i = 0; i < 5; i++) {
                currentField = ((TextField)grid[idx].getChildren().get(i));
                currentLetter = currentField.getText();
                if(isValidLetter(currentLetter)) {
                inputWord += currentLetter;
                }
                else {
                    invalidInput.showAndWait();
                    return;
                }
                
            }
            if(wordGenerator.isWord(inputWord)) {
                setColors();
                if(secretWord.equals(inputWord.toLowerCase())) {
                    youWon.showAndWait();
                    resetBoard();
                }
                
                else if(idx == 6) {
                    youLose.showAndWait();
                    resetBoard();
                }
    
                else {
                    grid[idx].setDisable(false);
                    idx++;
                    grid[idx-1].setDisable(true);
                }
                
            }
            else {
                noWord.showAndWait();
                clearRow();

            }
            
    } 

    public boolean isValidLetter(String currentLetter) {
        if(currentLetter.length() != 1) {
            multiLetters.showAndWait();
            return false;
        }

        else if((currentLetter.charAt(0) >= 65 && currentLetter.charAt(0) <= 90) || (currentLetter.charAt(0) >= 97 && currentLetter.charAt(0) <= 122)) {
            return true;
        }

        else {
            return false;
        }
        
    }
    public void setColors() {
        int spot = 0;
        for (Node currentNode : grid[idx].getChildren()) {
            try {
                TextField currentSpot = (TextField)currentNode;
                String curLetter = currentSpot.getText();
                if(curLetter.toLowerCase().charAt(0) == secretWord.toLowerCase().charAt(spot)) {
                    System.out.println(currentLetter + " is in the right spot");
                    currentField.setBackground(backFillGreen);
                }
                else if(secretWord.contains(curLetter)) {
                    System.out.println(currentLetter + " is in the word but placed in the wrong spot");
                    currentField.setBackground(backFillYellow);  
                }
                else {
                    System.out.println(currentLetter + " is not in the word");  
                }
                spot++;
            } catch (Exception e) {

            }

        }
    }

    public void clearRow() {
        for (Node currentNode : grid[idx].getChildren()) {
            try {
                ((TextField)currentNode).setText("");
            } catch (Exception e) {
                
            }
            
        }
    }

    public void resetBoard() {
        secretWord = wordGenerator.getRandomWord();
        System.out.println(secretWord);
        for (GridPane gridPane : grid) {
            for (Node currentNode: gridPane.getChildren()) {
                try {
                    ((TextField) currentNode).setBackground(resetBackground);
                    ((TextField)currentNode).setText("");
                } catch (Exception e) {

                }
                
            }
        }
        grid[idx].setDisable(true);
        idx = 0;
        grid[idx].setDisable(false);
    }
}