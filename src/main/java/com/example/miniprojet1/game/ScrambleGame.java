package com.example.miniprojet1.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ScrambleGame {
    private String correctWord;
    private String shuffledWord;
    private int choixDifficult;
    public long startTime;
    public long elapsedTime;

    public static final int MAX_DIF=26;
    public static final int MIN_DIF=3;

    public void setDifficulty(int dif){
        choixDifficult = dif;
    }

    public String selectWord(){
        List<String> wordList = new ArrayList<>();
        File file = new File("src/main/resources/words.txt");

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

        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        wordList.get(randomIndex);

        // Sélectionner un mot aléatoire et le mélanger
        correctWord = selectRandomWord(wordList);

        return correctWord;
    }
    private String selectRandomWord(List<String> wordList) {
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
    public String shuffleWord(){
        char[] charArray = correctWord.toCharArray();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index1 = random.nextInt(charArray.length);
            int index2 = random.nextInt(charArray.length);
            char temp = charArray[index1];
            charArray[index1] = charArray[index2];
            charArray[index2] = temp;
        }
        shuffledWord = new String(charArray);
        return shuffledWord;

    }

    public long TimerSet(){
        startTime = System.currentTimeMillis();
        return startTime;
    }
    public long TimerResult(){
        elapsedTime = (System.currentTimeMillis() - startTime)/1000;
        return elapsedTime;
    }
    public boolean testUserProposition(String input){
        if (input.toUpperCase().equals(correctWord)) {
            return true;
        }
        return false;
    }

}
