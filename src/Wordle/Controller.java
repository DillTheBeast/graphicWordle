package Wordle;

import java.lang.reflect.Array;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

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
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    @FXML
    private TextField field11;
    @FXML
    private TextField field12;
    @FXML
    private TextField field13;
    @FXML
    private TextField field14;
    @FXML
    private TextField field15;
    @FXML
    private TextField field21;
    @FXML
    private TextField field22;
    @FXML
    private TextField field23;
    @FXML
    private TextField field24;
    @FXML
    private TextField field25;
    @FXML
    private TextField field31;
    @FXML
    private TextField field32;
    @FXML
    private TextField field33;
    @FXML
    private TextField field34;
    @FXML
    private TextField field35;
    @FXML
    private TextField field41;
    @FXML
    private TextField field42;
    @FXML
    private TextField field43;
    @FXML
    private TextField field44;
    @FXML
    private TextField field45;
    @FXML
    private TextField field51;
    @FXML
    private TextField field52;
    @FXML
    private TextField field53;
    @FXML
    private TextField field54;
    @FXML
    private TextField field55;

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
    TextField[] firstfield;
    TextField[] secondfield;
    TextField[] thirdfield;
    TextField[] fourthfield;
    TextField[] fifthfield;
    TextField[] sixthfield;
    int idx;
    int f;
    int y;
    String inputWord;
    WordGenerator wordGenerator;
    String currentLetter;
    TextField currentField;
    TextField currentFieldOn;
    TextField curSpot;

    public void initialize() {
        
        grid[0] = grid1;
        grid[1] = grid2;
        grid[2] = grid3;
        grid[3] = grid4;
        grid[4] = grid5;
        grid[5] = grid6;

        firstfield[0] = field2;
        firstfield[1] = field3;
        firstfield[2] = field4;
        firstfield[3] = field5;

        secondfield[0] = field11;
        secondfield[1] = field12;
        secondfield[2] = field13;
        secondfield[3] = field14;
        secondfield[4] = field15;

        thirdfield[0] = field21;
        thirdfield[1] = field22;
        thirdfield[2] = field23;
        thirdfield[3] = field24;
        thirdfield[4] = field25;

        fourthfield[0] = field31;
        fourthfield[1] = field32;
        fourthfield[2] = field33;
        fourthfield[3] = field34;
        fourthfield[4] = field35;

        fifthfield[0] = field41;
        fifthfield[1] = field42;
        fifthfield[2] = field43;
        fifthfield[3] = field44;
        fifthfield[4] = field45;

        sixthfield[0] = field51;
        sixthfield[1] = field52;
        sixthfield[2] = field53;
        sixthfield[3] = field54;
        sixthfield[4] = field55;
        
        field1.requestFocus();
    }

    public Controller() {

        inputWord = "";
        idx = 0;
        f = 0;
        y = 1;
        wordGenerator = new WordGenerator();
        secretWord = wordGenerator.getRandomWord();
        System.out.println(secretWord);

        multiLetters = new Alert(AlertType.ERROR);
        multiLetters.setHeaderText("Invalid letter amount.");
        multiLetters.setContentText("There should be one letter in each box.");

        invalidInput = new Alert(AlertType.ERROR);
        invalidInput.setHeaderText("Invalid input");
        invalidInput.setContentText("There should only be a letter in each box. No numbers or non-english characters.");

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
        firstfield = new TextField[4]; 
        secondfield = new TextField[5];
        thirdfield = new TextField[5];
        fourthfield = new TextField[5];
        fifthfield = new TextField[5];
        sixthfield = new TextField[5];
    }

    @FXML
    void letterTyped(KeyEvent event) {
        if(event.getCode() == KeyCode.BACK_SPACE) {
            System.out.println("Test");
            if(y == 1) {
                if(firstfield[f].contains(null)) {
                    f--;
                    firstfield[f].requestFocus();
                }
            }
            else if(y == 2) {
                if(secondfield[f].contains(null)) {
                    f--;
                    secondfield[f].requestFocus();
                }
            }
            else if(y == 3) {
                if(thirdfield[f].contains(null)) {
                    f--;
                    thirdfield[f].requestFocus();
                }
            }
            else if(y == 4) {
                if(fourthfield[f].contains(null)) {
                    f--;
                    fourthfield[f].requestFocus();
                }
            }
            else if(y == 5) {
                if(fifthfield[f].contains(null)) {
                    f--;
                    fifthfield[f].requestFocus();
                }
            }
            else if(y == 6) {
                if(sixthfield[f].contains(null)) {
                    f--;
                    sixthfield[f].requestFocus();
                }
            }

        }
        else if(y == 1) {
            if(f == 4) {
            y++;
            f = 0;
            }
            else {
                firstfield[f].requestFocus();
                f++;
            }
        }
        else if(y == 2) {
            if(f == 5) {
                y++;
                f = 0;
            }
            else {
                secondfield[f].requestFocus();
                f++;
            }
        }
        else if(y == 3) {
            if(f == 5) {
                y++;
                f = 0;
            }
            else {
                thirdfield[f].requestFocus();
                f++;
            }
        }
        else if(y == 4) {
            if(f == 5) {
                y++;
                f = 0;
            }
            else {
                fourthfield[f].requestFocus();
                f++;
            }
        }
        else if(y == 5) {
            if(f == 5) {
                y++;
                f = 0;
            }
            else {
                fifthfield[f].requestFocus();
                f++;
            }
        }
        else if(y == 6) {
            if(f == 5) {
                y++;
                f = 0;
            }
            else {
                sixthfield[f].requestFocus();
                f++;
            }
        }
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
                    f = 0;
                    y = 0;
                    resetBoard();
                }
                
                else if(idx == 5) {
                    youLose.showAndWait();
                    f = 0;
                    y = 0;
                    resetBoard();
                }
    
                else {
                    idx++;
                    grid[idx].setDisable(false);
                    grid[idx-1].setDisable(true);         
                }
                
            }
            else {
                noWord.show();
                clearRow();
                f = 0;
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
        for(int i = 0; i < 5; i++) {
            try {
                TextField currentSpot = ((TextField)grid[idx].getChildren().get(i));
                String curLetter = currentSpot.getText();
                if(curLetter.charAt(0) == secretWord.charAt(i)) {
                    currentSpot.setBackground(backFillGreen);
                }
                
                else if(secretWord.contains(curLetter)) {
                    currentSpot.setBackground(backFillYellow);  
                }
                
                else {
                }

            } catch (Exception e) {

            }

        }
    }

    public void clearRow() {
        
        for (int i = 0; i < 5; i++) {   
            try {
                TextField curSpot = ((TextField)grid[idx].getChildren().get(i));
                //String curLetter = curSpot.getText();
                curSpot.setText("");
                curSpot.setBackground(resetBackground);
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
        youLose.setContentText("You lost. The word was " + secretWord);
    }
}