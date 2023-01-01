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
    private GridPane lettersGrid;

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

    @FXML
    private Text aText;
    @FXML
    private Text bText;
    @FXML
    private Text cText;
    @FXML
    private Text dText;
    @FXML
    private Text eText;
    @FXML
    private Text fText;
    @FXML
    private Text gText;
    @FXML
    private Text hText;
    @FXML
    private Text iText;
    @FXML
    private Text jText;
    @FXML
    private Text kText;
    @FXML
    private Text lText;
    @FXML
    private Text mText;
    @FXML
    private Text nText;
    @FXML
    private Text oText;
    @FXML
    private Text pText;
    @FXML
    private Text qText;
    @FXML
    private Text rText;
    @FXML
    private Text sText;
    @FXML
    private Text tText;
    @FXML
    private Text uText;
    @FXML
    private Text vText;
    @FXML
    private Text wText;
    @FXML
    private Text xText;
    @FXML
    private Text yText;
    @FXML
    private Text zText;

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
        //Setting all of the arrays to what they need to be set to
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

        //Declaring all of the alerts

        //Incase there are 2 letters in one box
        multiLetters = new Alert(AlertType.ERROR);
        multiLetters.setHeaderText("Invalid letter amount.");
        multiLetters.setContentText("There should be one letter in each box.");

        //Incase there is a character that is not a letter in one of the boxes 
        invalidInput = new Alert(AlertType.ERROR);
        invalidInput.setHeaderText("Invalid input");
        invalidInput.setContentText("There should only be a letter in each box. No numbers or non-english characters.");

        //If the player won
        youWon = new Alert(AlertType.CONFIRMATION);
        youWon.setHeaderText("YOU WON");
        youWon.setContentText("You have guessed the word.");
         
        //If the player lost
        youLose = new Alert(AlertType.CONFIRMATION);
        youLose.setHeaderText("YOU LOST");
        youLose.setContentText("You have lost. The word was " + secretWord);

        //If the word is not real
        noWord = new Alert(AlertType.ERROR);
        noWord.setHeaderText("Not and a real word");
        noWord.setContentText("This is not a word in the english dictionary");

        //Declaring all of the backgrounds to see if the letter is correct or not
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

    //Once you click a key this will run
    @FXML
    void letterTyped(KeyEvent event) {
        if(event.getCode() == KeyCode.BACK_SPACE) {
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

    //Once the enter button is clicked this will run
    @FXML
    void onEnterClick(ActionEvent event) {
        inputWord = "";

        //Making sure that all the letters are correct by running the valid letter checker method
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
        
        //Making sure that the word is a real world by checking the file full of all of the 5 letter words
        //If the word is ok then it will run the color fill method
        if(wordGenerator.isWord(inputWord)) {
            setColors();
            
            //If the secret word is guessed, then it resets the variables, the board, and the you won message pops up
            if(secretWord.equals(inputWord.toLowerCase())) {
                youWon.showAndWait();
                f = 0;
                y = 0;
                resetBoard();
            }
            
            //If the secret word is not guessed, and all of the lines are full, then reset the variables, the board, and the you lose message pops up 
            else if(idx == 5) {
                youLose.showAndWait();
                f = 0;
                y = 0;
                resetBoard();
            }

            //If none of that is true, then go to the next grid 
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

    //Checks to make sure that the input is all letters
    public boolean isValidLetter(String currentLetter) {
        
        //Making sure that each box has only 1 letter and if it doesn't then there will be an error
        if(currentLetter.length() != 1) {
            multiLetters.showAndWait();
            return false;
        }

        //Making sure that each input is a letter
        else if((currentLetter.charAt(0) >= 65 && currentLetter.charAt(0) <= 90) || (currentLetter.charAt(0) >= 97 && currentLetter.charAt(0) <= 122)) {
            return true;
        }

        //If it is not a letter, then the method will return false
        else {
            return false;
        }
        
    }

    //Sets the backgrounds to the letters that are correct
    public void setColors() {

        //Goes through each box of the row, setting all of the boxes to whatever color they are 1 by 1
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

    //Clears the row after you make an invalid word
    public void clearRow() {
        
        //Goes through the whole row, clearing each box 1 by 1
        for (int i = 0; i < 5; i++) {   
            try {
                TextField curSpot = ((TextField)grid[idx].getChildren().get(i));
                //String curLetter = curSpot.getText();
                curSpot.setText("");
                curSpot.setBackground(resetBackground);
            } catch (Exception e) {
                
            }
            f = 0;
                
        }
            
    }

    //Clears the board after you reset the game
    public void resetBoard() {

        //Generates a random word
        secretWord = wordGenerator.getRandomWord();
        System.out.println(secretWord);

        //Goes through all of the grids and gridpanes, clearing each of the boxes background and setting the box to empty one by one
        for (GridPane gridPane : grid) {
            for (Node currentNode: gridPane.getChildren()) {
                try {
                    ((TextField) currentNode).setBackground(resetBackground);
                    ((TextField)currentNode).setText("");
                } catch (Exception e) {

                }
                
            }
        }

        //Reseting everything
        grid[idx].setDisable(true);
        idx = 0;
        f = 0;
        y = 0;
        grid[idx].setDisable(false);
        youLose.setContentText("You lost. The word was " + secretWord);
    }
}