package com.tuesdayhat.gmhelper;


import java.util.Arrays;
import java.util.Random;

public class DiceRoller {

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
        int[] nums = dice;

        switch(type){
            case "k":
                Arrays.sort(nums);
                result = Arrays.copyOfRange(nums, nums.length-limit, nums.length);
                break;

            case "kl":
                Arrays.sort(nums);
                result = Arrays.copyOfRange(nums, 0, limit);
                break;
        }

        return result;
    }

    public int[] unique(int rolls, int size){
        //rolls a number of unique results from a random table
        int[] result = new int[rolls];
        int[] table = buildTable(size);

        for (int i = 0;i < result.length; i++) {
            int roll = dice(1, table.length)[0];
            result[i] = table[roll-1];

            table[roll-1] = table[table.length-1];
            table = Arrays.copyOf(table, table.length-1);
        }

        return result;
    }

    private int[] buildTable(int size){
        //fills up an array with numbers up to the length
        int[] result = new int[size];
        for(int i = 1; i <= size; i++){
            result[i-1] = i;
        }
        return result;
    }

}
