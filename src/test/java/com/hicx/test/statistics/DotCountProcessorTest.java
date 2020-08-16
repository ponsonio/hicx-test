package com.hicx.test.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DotCountProcessorTest {

    private static String TREE_DOTS_AND_WORDS_WITH_NEW_LINE = "one. two. \n tree.";

    DotCountProcessor testee = new DotCountProcessor();


    @Test
    public void assertThatTittle_Corresponds() throws Exception {
        //Arrange
        List<String> data  = new ArrayList<String>();
        //Act
        Stat resp = testee.getStat(data);
        //Assert
        assertEquals(DotCountProcessor.STAT_TITLE,resp.getName());
    }

    //one test per concern
    @Test
    public void assertThatCountWords() throws Exception {
        //Arrange
        List<String> data  = new ArrayList<String>();
        data.add(TREE_DOTS_AND_WORDS_WITH_NEW_LINE);
        //Act
        Stat resp = testee.getStat(data);
        int count = resp.getValues().get(DotCountProcessor.STAT_ITEM);
        //Assert
        assertEquals(3,count);
    }


} 
