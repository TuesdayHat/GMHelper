package com.tuesdayhat.gmhelper;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public abstract class RollParser extends DiceRoller {
    String nums = "[0-9]";

    public ArrayList<String> parse (String input){
        ArrayList<String> result = new ArrayList<>();

        String[] words = input.split("");
        for(int i =0;i < words.length;i++){ //testing -- show entire input with indexes
            String word = words[i];
            System.out.println(i + " -- " + word);
            if(i == words.length-1){
                System.out.println("------------------------");
            }
        }


        for(int i = 0; i<words.length;i++){ //main parser loop


            ArrayList<String> numSlice = new ArrayList<>();
            for(String cha:words){ //populates numSlice with
                if (cha.matches(nums) | cha.equals("d")){
                    numSlice.add(cha);
                } else {
                    break;
                }
            }

            boolean isDiceRoll = isDiceRoll(numSlice);
        }


        return result;
    }

    private Dice dieMaker(String[] letters){
        StringBuilder expression = new StringBuilder("");
        String rolls = "";
        String sides = "";
        String nums = "[0-9]";
        boolean rOrS = true; //true = rolls, false = sides

        for(String cha: letters){
            if(cha.matches(nums) | cha.equals("d")){
                expression.append(cha);
            } else {
                break;
            }
        }

        return new Dice(Integer.parseInt(rolls), Integer.parseInt(sides));
    }

    private boolean isDiceRoll(ArrayList<String> letters){
        //checks whether an arrayList of 1 character strings follows the format [number]d[number]



        return true;
    }

}
