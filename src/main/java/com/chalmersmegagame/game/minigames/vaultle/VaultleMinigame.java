package com.chalmersmegagame.game.minigames.vaultle;

import com.chalmersmegagame.game.ships.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    private static String[] dict = new String[]{"flake", "eagle", "squat", "apple", "pears","scare","bolts","poise","valve","nails","screw","cloth","query"};
    private int numOfGuesses;
    private int maxNumOfGuesses = 6;
    private Boolean win = false;
    @ElementCollection
    private List<String> previousGuesses = new ArrayList<String>();
    @ElementCollection
    private List<String> previousWords = new ArrayList<String>();


    public VaultleMinigame(){}

    public VaultleMinigame(PlayerShip playerShip){
        this.playerShip = playerShip;
    }
    //Randomises a new word and resets the proper values for a new game
    public void init() {
        System.out.println("Init start");
        previousGuesses.clear();
        win = false;
        newWord();
        theWordArray = theWord.toUpperCase().toCharArray();
        wordLength = theWord.length();
        numOfGuesses = 0;
        previousWords.add(theWord);
        System.out.println("Init finished");
    }
    //Function that ensures that the new word is not the same as an old one
    public void newWord(){
        theWord = randomWord();
        while(previousWords.contains(theWord)){
            theWord = randomWord();
        }
    }
    //Randomises a new word
    public static String randomWord(){
        Random wordGenerator = new Random();
        int wordIndex = wordGenerator.nextInt(dict.length);
        return dict[wordIndex];
    }

    /* Checks the value of the guess, how close it is to the answer
     * Returns an array of -1,0,1,2
     * An array of -1 = the player has already guessed the right word, or the player has reached the maximum number of
     *  guesses, or this guess is the same as an old guess, or the guess is null, or the length of the guess is not
     * the same as the length of the answer
     * An array of only 2 = correct guess (yay!)
     * Otherwise:
     * 2 = the letter is in the right spot
     * 1 = the letter is in the word but in another position
     * 0 = the letter is not in the word
     */

    public int[] guess(String newGuess){
        int guessResult[]= new int[wordLength];
        char[] guessArray = newGuess.toUpperCase().toCharArray();
        //First we check if the guess is valid
        if(win || numOfGuesses >= maxNumOfGuesses || alreadyGuessesThis(newGuess) || newGuess==null || newGuess.length()!= wordLength){
            System.out.println("You're not supposed to be here");
            return new int[]{-1,-1,-1,-1,-1};
        }
        //Then we check if the answer is correct
        if(Arrays.equals(guessArray, theWordArray)){
            System.out.println("Yay, it is the right word");
            win = true;
            return new int[]{2,2,2,2,2};
        }else{
            //Then, if the answer wasn't right, we check where the letters are the same.
            for(int i = 0; i < wordLength; i++){
                if(guessArray[i] == theWordArray[i]){
                    guessResult[i] = 2;
                }else{
                    guessResult[i] = 0;
                }
            }
            //When the 2s are in the right positions, we put the ones in the right positions
            for(int i = 0; i < wordLength; i++){
                if(guessResult[i] == 2){
                    continue;
                }else{
                    compareElements(guessResult, guessArray, i);
                }
            }
        }
        numOfGuesses++;
        previousGuesses.add(newGuess);
        return guessResult;
    }

    //Checks if a letter is in the word
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

    //Checks if this word has already been a guess
    private boolean alreadyGuessesThis(String guess){
        if(previousGuesses.contains(guess)){
            return true;
        }
        return false;
    }

}
