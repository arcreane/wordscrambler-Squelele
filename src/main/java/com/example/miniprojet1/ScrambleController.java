package com.example.miniprojet1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ScrambleController {
    @FXML
    private Label ScrambleWord;
    @FXML
    private Button ButtonValid;
    @FXML
    private Button ButtonReload;
    private Label EnterField;

    @FXML
    protected void onValidButtonClick() {

        ScrambleWord.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onStartButtonClick() {
        ScrambleWord.setText("Welcome to JavaFX Application!");
    }
}