package com.tuesdayhat.gmhelper;


import java.util.Random;

public abstract class DiceRoller {

    //gives back an array of all natural results of dice rolls
    public int[] dice (int rolls, int sides){
        Random rand = new Random();
        int[] results = new int[rolls];
        for (int i=0;i<rolls; i++){
            results[i] = (rand.nextInt(sides)+1);
        }
        return results;
    }

    public int total (int[] dice, int bonus) {
        int result = 0;
        for (int i=0; i<dice.length;i++){
            result += dice[i];
        }
        return result + bonus;
    }

    public int countSuccesses (int[] dice, int limit){
        int result = 0;
        for (int i = 0; i<dice.length; i++){
            if (dice[i] >= limit){
                result++;
            }
        }
        return result;
    }

    public int[] keep(String type, int limit, int[] dice){ //will likely get refactored to handle all text parsing
        int[] result = new int[limit];

        switch(type){
            case "k":
                for(int i =0;i<dice.length;i++){
                }
                break;

            case "kl":
                for(int i =0;i<dice.length;i++){
                }
                break;
        }

        return result;
    }

}
