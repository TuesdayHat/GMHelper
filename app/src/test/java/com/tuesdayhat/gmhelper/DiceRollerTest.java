package com.tuesdayhat.gmhelper;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DiceRollerTest extends DiceRoller {

    @Test
    public void DiceRoller_dice_rollsDice() throws Exception {
        int[] result = dice(2, 6);

        System.out.println(result[0] + ", " + result[1]);
        assertEquals(2, result.length);
    }

    @Test
    public void DiceRoller_total_rollsDiceAndAddsUpResults() throws Exception {
        int result;

        int[] rolls = dice(2,6);
        result = total(rolls, 0);

        System.out.println(result);
        assert(result >= 2 && result <= 12);
    }

    @Test
    public void DiceRoller_countSuccesses_TakeInRawDiceRollsAndListsHowManyAreAboveInput() throws Exception{
        int[] rolls = dice(15, 6);

        System.out.println(countSuccesses(rolls, 4));
        assert(2 < countSuccesses(rolls, 4));
    }

    @Test
    public void DiceRoller_keep_keepsHighestOrLowestXDice() throws Exception{
        int[] rolls = {6, 4, 2, 1, 5, 8, 3, 10, 9, 7, 2, 1, 6, 6, 8, 3, 2};
        int[] keepHigh = keep("k", 4, rolls);
        int[] keepLow = keep("kl", 3, rolls);

        int[] expHigh = {8, 8, 9, 10};
        int[] expLow = {1, 1, 2};

        System.out.println(String.format("High: %s %s %s %s", keepHigh[0], keepHigh[1], keepHigh[2], keepHigh[3]));
        assert(Arrays.equals(expHigh, keepHigh));
        assert(Arrays.equals(expLow, keepLow));
    }

    @Test
    public void DiceRoller_unique_getsUniqueResultsFromTable() throws Exception{
        int[] result = unique(5, 6);
        boolean unique = true;
        System.out.println(String.format("Unique: %s, %s, %s, %s, %s", result[0], result[1], result[2], result[3], result[4]));
        for(int i = 0; i < result.length; i++){
            int check = result[i];
            for(int j = i+1; j<result.length;j++){
                if(check == result[j]){
                    unique = false;
                }
            }
        }

        assert(unique);
    }

//    @Test
//    public void rawOutput() throws Exception{
//        //System.out.println(parse("10d6"));
//        System.out.println(showTest());
//    }
}