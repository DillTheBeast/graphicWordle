package Wordle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

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

    Alert multiNumbers;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
    }
    @FXML
    void onEnterClick(ActionEvent event) {
        try {
            grid1.getChildren();
        }
        catch(Exception e) {
        multiNumbers = new Alert(AlertType.ERROR);
        multiNumbers.setHeaderText("Multiple Numbers");
        multiNumbers.setContentText("You can only have one number in each box.");
        }
    }
     
}