package com.tuesdayhat.gmhelper;

import android.util.Log;

import org.junit.Test;

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
}