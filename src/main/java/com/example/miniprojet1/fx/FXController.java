package com.example.miniprojet1.fx;

import com.example.miniprojet1.game.ScrambleGame;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class FXController implements Initializable {
    public Label ScrambleWord;
    public TextField Field;
    public Button ButtonValid;
    public Button ButtonReload;
    public javafx.scene.control.TextArea TextArea;
    public Label DifField;
    public Slider SliderDif;
    public Button ButtonStart;
    public Label winField;
    ScrambleGame game;

    public int essai;
    public int dinWin=1;
    public String trueWord;

    public long elapsedTime;


    public FXController(){
        game = new ScrambleGame();
    }
    public void onStartButtonClick(ActionEvent actionEvent) {
        essai=1;
        game.setDifficulty((int)SliderDif.getValue());
        trueWord = game.selectWord();
        ScrambleWord.setOpacity(1);
        ButtonStart.setDisable(true);
        ButtonStart.setOpacity(0);
        ButtonValid.setDisable(false);
        ButtonReload.setDisable(false);
        ScrambleWord.setText(game.shuffleWord());
        this.TextArea.clear();
        game.TimerSet();
        //this.TextArea.appendText("Difficulté choisie : "+ ((int) SliderDif.getValue()));
    }
    @FXML
    public  void onValidButtonClick() {
        this.TextArea.appendText("Essai n°" + essai + ": " + Field.getText()+"\n");
        if (game.testUserProposition(Field.getText())) {
            this.TextArea.appendText("\nBravo, vous avez trouvé le mot !\nDinner Winner, tu as gagné "+ dinWin +" fois");
            this.TextArea.appendText("\nVous avez mis "+ game.TimerResult() +" secondes");
            ButtonValid.setDisable(true);
            this.winField.setText(""+dinWin);
            dinWin++;
        } else {
            essai++;
            if(essai>=6){
                this.TextArea.appendText("\nVous avez perdu! Le mot était : "+ trueWord);
                ButtonValid.setDisable(true);
                this.TextArea.appendText("\nVous avez mis "+ game.TimerResult() +" secondes");
            }
        }
        this.Field.clear();
    }


    @FXML
    public void changerDeMot(ActionEvent actionEvent) {
        game.setDifficulty((int)SliderDif.getValue());
        trueWord = game.selectWord();
        ScrambleWord.setText(game.shuffleWord());
        this.TextArea.clear();
        essai=1;
        ButtonValid.setDisable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {//bin du slide et du lable difficulté
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(DifField.textProperty(), SliderDif.valueProperty(), converter);
        //DifField.textProperty().bind( SliderDif.valueProperty());
        SliderDif.valueProperty().addListener((observable, oldValue, newValue) -> {
            int intValue = newValue.intValue();
            DifField.setText(String.valueOf(intValue));
        });
    }
}