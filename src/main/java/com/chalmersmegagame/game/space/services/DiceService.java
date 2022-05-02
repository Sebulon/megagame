package com.chalmersmegagame.game.space.services;

import java.util.ArrayList;
import java.util.Random;

public class DiceService {

    private final ArrayList<Die> dice = new ArrayList<>();

    public void addDie(int type) {
        dice.add(new Die(type));
    }

    public void clearDice(){
        dice.clear();
    }

    public ArrayList<Die> intArrayToDice(int[] array) {
        dice.clear();
        for (int i = 0; i < array.length; i++) {
            dice.add(new Die(array[i]));
        }
        return dice;
    }

    public int rollSum() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.roll();
        }
        return sum;
    }

    public int rollKeepHighest() {
        int returnInt = 0;
        for (Die die : dice) {
            if (returnInt < die.roll()) {
                returnInt = die.roll();
            }
        }
        return returnInt;
    }

    private class Die {

        private final int type;

        public Die(int type) {
            this.type = type;
        }

        public int roll() {
            Random random = new Random();
            return random.nextInt(type + 1);
        }
    }

}


