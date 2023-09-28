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
        FXMLLoader fxmlLoader = new FXMLLoader(ScrambleApplication.class.getResource("Scramble-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 320);
        stage.setTitle("ScrambleGame!");
        stage.setScene(scene);
        stage.show();

        //stage.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Launch console by taping 'console' in the console or else");
        String input;
        input = scanner.nextLine();
        if(input.equals("console")){
            ScrambleGame cg = new ScrambleGame();
            cg.ConsoleStart();

        } else {
            launch();
        }

    }
}