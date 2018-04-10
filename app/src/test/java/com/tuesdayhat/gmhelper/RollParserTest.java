package com.tuesdayhat.gmhelper;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RollParserTest extends RollParser {
    @Test
    public void rawOutput() throws Exception{
        System.out.println(parse("10d6"));
    }

//    @Test
//    public void RollParser_parse_parseDiceRoll()throws Exception{
//        ArrayList<String> result = parse("4d6");
//        assert(Integer.parseInt(result.get(0)) >= 4 && Integer.parseInt(result.get(0)) <= 24);
//    }

}
