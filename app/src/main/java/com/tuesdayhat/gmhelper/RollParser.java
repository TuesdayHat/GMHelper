package com.tuesdayhat.gmhelper;


import java.util.ArrayList;
import java.util.regex.*;

public abstract class RollParser extends DiceRoller {
    public ArrayList<String> parse (String input){
        ArrayList<String> result = new ArrayList<>();

        String[] words = input.split("");
        for(int i =0;i < words.length;i++){
            String word = words[i];
            System.out.println(i + " -- " + word);
        }

        String numsRegex = "[0-9]";
        for(int i =0; i<words.length;i++){
            String cha = words[i];
            int goTo = 0;
            if(cha.matches(numsRegex)){
                String readRolls = "";
                for(int j = i; words[j].matches(numsRegex) && words[j+1].equals("d");j++){
                    readRolls += words[j];
                    goTo = j;
                }
                i = goTo;
            }

        }


        return result;
    }

}
