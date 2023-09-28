package com.example.miniprojet1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ScrambleGame {
    public void ConsoleStart() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            // Demander à l'utilisateur de choisir la difficulté
            System.out.print("Vous allez participer au jeu Scramble Word." +
                    "\nFacile: Entre 3 et 5," +
                    "\nMoyen: entre 6 et 7," +
                    "\nDificile: Entre 8 et 26" +
                    "\nChoississez votre difficulté : ");
            int choixDifficult = chooseDifficulty(scanner);

            // Charger les mots de la bonne difficulté depuis le fichier
            List<String> wordList = loadWordsFromFileConsole("src/main/resources/words.txt", choixDifficult);
            if (wordList.isEmpty()) {
                System.out.println("Aucun mot trouvé pour cette difficulté.");
                return;
            }

            // Sélectionner un mot aléatoire et le mélanger
            String randomWord = selectRandomWord(wordList);
            String shuffledWord = shuffleWord(randomWord);

            System.out.println("Voici la chaîne de caractères mélangée : " + shuffledWord);

            // Demander à l'utilisateur de deviner le mot
            boolean success = playGameConsole(scanner, randomWord);

            if (success) {
                System.out.println("Bravo, vous avez trouvé le mot !\n");
            } else {
                System.out.println("Dommage, le mot était : " + randomWord+"");
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
        } while (choixDifficult < 3 || choixDifficult > 26);
        scanner.nextLine(); // Consommer la ligne restante
        return choixDifficult;
    }

    private List<String> loadWordsFromFileConsole(String filePath, int choixDifficult) {
        List<String> wordList = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Le fichier n'existe pas.");
            return wordList;
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.length() == choixDifficult) {
                    wordList.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite lors de la lecture du fichier : " + e.getMessage());
        }
        return wordList;
    }

    private String selectRandomWord(List<String> wordList) {
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

    private String shuffleWord(String word) {
        char[] charArray = word.toCharArray();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index1 = random.nextInt(charArray.length);
            int index2 = random.nextInt(charArray.length);
            char temp = charArray[index1];
            charArray[index1] = charArray[index2];
            charArray[index2] = temp;
        }
        return new String(charArray);
    }

    private boolean playGameConsole(Scanner scanner, String correctWord) {
        boolean success = false;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Essai n°" + i + ": ");
            String input = scanner.nextLine();
            if (input.equals(correctWord)) {
                success = true;
                break;
            }
        }
        return success;
    }
}
