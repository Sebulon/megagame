package com.chalmersmegagame.game.space.services;

import java.util.ArrayList;
import java.util.Random;

public class DiceService {

    ArrayList <Die> dice = new ArrayList<>();

    private class Die{

        private int type;

        public Die (int type){
            this.type = type;
        }

        public int roll(){
            Random random = new Random();
            return random.nextInt(type + 1);
        }
    }

    public Die die (int type){
        return new Die(type);
    }

    public ArrayList<Die> intArrayToDice (int[] array){
        ArrayList<Die> dice = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            dice.add(new Die(array[i]));
        }
        return dice;
    }

    public int rollSum(ArrayList<Die> dice){
        int sum = 0;
        for (Die die : dice){
            sum += die.roll();
        }
        return sum;
    }

    public int rollKeepHighest(ArrayList<Die> dice){
        int returnInt = 0;
        for (Die die : dice){
            if (returnInt < die.roll()){
                returnInt = die.roll();
            }
        }
        return returnInt;
    }
}


