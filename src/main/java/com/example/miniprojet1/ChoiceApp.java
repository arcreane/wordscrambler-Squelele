package com.example.miniprojet1;

import com.example.miniprojet1.console.ConsoleInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ScrambleChoice {
    public Button StartConsole;
    public Button StartFX;

    public void startConsole(ActionEvent actionEvent) {
        Stage thisStage = (Stage) StartConsole.getScene().getWindow();
        thisStage.close();
        ConsoleInterface cg = new ConsoleInterface();
        cg.ConsoleStart();
    }

    public void startFx(ActionEvent actionEvent) throws IOException {
        Stage thisStage = (Stage) StartFX.getScene().getWindow();
        thisStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(ScrambleApplication.class.getResource("Scramble-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 320);
        thisStage.setTitle("ScrambleGame!");
        thisStage.setScene(scene);
        thisStage.show();


    }
}
