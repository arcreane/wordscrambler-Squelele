package com.example.miniprojet1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ScrambleController {
    public TextField Field;
    public Label Timer;
    public Label TimerField;
    public Label StaticField;
    public Button ButtonValid;
    public Button ButtonReload;
    @FXML
    private Label ScrambleWord;

    @FXML
    protected void onValidButtonClick() {

        ScrambleWord.setText("Welcome to JavaFX Application!");
        Field.getText();
        ButtonValid.

    }
    @FXML
    protected void onStartButtonClick() {
        ScrambleWord.setText("Welcome to JavaFX Application!");
    }

    public void changerDeMot(ActionEvent actionEvent) {
    }
}