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

    
}
