package com.example.miniprojet1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class ScrambleApplication extends Application {
    private static Scanner scanner;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ScrambleApplication.class.getResource("ScrambleChoice.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 220, 100);
        stage.setTitle("ScrambleChoice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
            launch();
    }
}