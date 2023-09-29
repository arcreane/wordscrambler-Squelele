package com.example.miniprojet1.console;

import com.example.miniprojet1.game.ScrambleGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleInterface {
    private ScrambleGame game;
    public void ConsoleStart() {
        Scanner scanner = new Scanner(System.in);
        game = new ScrambleGame();
        while (true){
            // Demander à l'utilisateur de choisir la difficulté
            System.out.print("Vous allez participer au jeu Scramble Word." +
                    "\nFacile: Entre 3 et 5," +
                    "\nMoyen: entre 6 et 7," +
                    "\nDificile: Entre 8 et 26" +
                    "\nChoississez votre difficulté : ");
            int choixDifficult = chooseDifficulty(scanner);

            // Charger les mots de la bonne difficulté depuis le fichier
            String wordList = game.selectWord();
            String shuffleword = game.shuffleWord();
            if (wordList.isEmpty()) {
                System.out.println("Aucun mot trouvé pour cette difficulté.");
                return;
            }
            game.shuffleWord();

            System.out.println("Voici la chaîne de caractères mélangée : " + shuffleword);

            // Demander à l'utilisateur de deviner le mot
            boolean success = playGameConsole(scanner);

            if (success) {
                System.out.println("Bravo, vous avez trouvé le mot !\n");
            } else {
                System.out.println("Dommage, le mot était : " + wordList);
            }
            ContinueConsoleGame(scanner);
        }
    }

    private void ContinueConsoleGame(Scanner scanner) {
        System.out.println("\nSouhaitez vous continuer ?\nyes no ?");
        String input = scanner.nextLine();
        if (input.equals("n")||input.equals("N")||input.equals("NO")||input.equals("no")||input.equals("non")||input.equals("NON")) {
            System.exit(1);
        }
    }

    private int chooseDifficulty(Scanner scanner) {
        int choixDifficult;
        do {
            choixDifficult = scanner.nextInt();
        } while (choixDifficult < ScrambleGame.MIN_DIF || choixDifficult > ScrambleGame.MAX_DIF);
        scanner.nextLine(); // Consommer la ligne restante
        game.setDifficulty(choixDifficult);
        return choixDifficult;
    }

    private boolean playGameConsole(Scanner scanner) {

        for (int i = 1; i <= 5; i++) {
            System.out.print("Essai n°" + i + ": ");
            String input = scanner.nextLine();
            if(game.testUserProposition(input)){
                return true;
            }
        }
        return false;
    }
}
