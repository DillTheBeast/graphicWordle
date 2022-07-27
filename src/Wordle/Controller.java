package Wordle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
    }
     
}