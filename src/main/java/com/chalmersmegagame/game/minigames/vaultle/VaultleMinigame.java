package com.chalmersmegagame.game.minigames.vaultle;

import com.chalmersmegagame.game.ships.PlayerShip;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@Entity
@Data
public class VaultleMinigame {

    @Id
    String ship;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "ship")
    @MapsId
    private PlayerShip playerShip;


    private int wordLength;
    private String theWord;
    @ElementCollection
    @OrderColumn
    private char[] theWordArray;
    @ElementCollection
    @OrderColumn
    private static String[] dict;
    private int numOfGuesses;
    private int maxNumOfGuesses = 6;
    private Boolean win = false;
    @ElementCollection
    @OrderColumn
    private int[] testArray = new int[]{0,0,0,0,0};

    public VaultleMinigame() {
        dict = new String[]{"flake", "eagle", "squat", "apple", "pears"};
        theWord = randomWord();
        theWordArray = theWord.toUpperCase().toCharArray();
        wordLength = theWord.length();
        numOfGuesses = 0;
    }

    public static String randomWord(){
        Random wordGenerator = new Random();
        int wordIndex = wordGenerator.nextInt(dict.length);
        return dict[wordIndex];
    }

    public int[] guess(String newGuess){
        int guessResult[]= new int[wordLength];
        char[] guessArray = newGuess.toUpperCase().toCharArray();
        if(newGuess==null || newGuess.length()!= wordLength){
            return new int[]{0,0,0,0,0};
        }else if(Arrays.equals(guessArray, theWordArray)){
            win = true;
            return new int[]{2,2,2,2,2};
        }else{
            //First we check where the letters are the same
            for(int i = 0; i < wordLength; i++){
                if(guessArray[i] == theWordArray[i]){
                    guessResult[i] = 2;
                }else{
                    guessResult[i] = 0;
                }
            }
            for(int i = 0; i < wordLength; i++){
                if(guessResult[i] == 2){
                    continue;
                }else{
                    compareElements(guessResult, guessArray, i);
                }
            }
            System.out.println(Arrays.toString(guessResult));
        }
        numOfGuesses++;
        return guessResult;
    }

    private void compareElements(int[] guessResult, char[] guessArray, int i) {
        char compChar;
        compChar = theWordArray[i];
        for(int j = 0; j < wordLength; j++){
            if(guessResult[j] != 0){
                continue;
            }else if(compChar == guessArray[j]){
                guessResult[j] = 1;
                break;
            }
        }
    }
    /*
    void game() {
        Scanner sc = new Scanner(System.in);
        while (!win && numOfGuesses < maxNumOfGuesses) {
            System.out.println("The random word is: " + theWord);
            System.out.println("Guess a word: ");
            String str = sc.nextLine();
            testArray = guess(str);
            System.out.println("The answer is: " + Arrays.toString(testArray));
            System.out.println(str);
        }
        if (numOfGuesses >= maxNumOfGuesses) {
            System.out.println("Too many guesses!");
        }
        sc.close();
    }
     */


}
