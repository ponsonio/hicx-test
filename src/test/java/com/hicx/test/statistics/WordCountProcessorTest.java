package com.hicx.test.statistics;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountProcessorTest {

  private WordCountProcessor testee = new WordCountProcessor();

  private static String TREE_WORDS = "one two tree";
  private static String TREE_WORDS_WITH_PUNCTUATION_MARKS = "one, two; tree";
  private static String TREE_WORDS_WITH_NEW_LINE = "one two \n tree";


  @Test
  public void assertThatTittle_Corresponds() throws Exception {
      //Arrange
      List<String> data  = new ArrayList<String>();
      //Act
      Stat resp = testee.getStat(data);
      //Assert
      assertEquals(WordCountProcessor.STAT_TITLE,resp.getName());
  }

  //one test per concern
  @Test
  public void assertThatCountWords() throws Exception {
    //Arrange
    List<String> data  = new ArrayList<String>();
    data.add(TREE_WORDS);
    //Act
    Stat resp = testee.getStat(data);
    int count = resp.getValues().get(WordCountProcessor.STAT_ITEM);
    //Assert
    assertEquals(3,count);
  }

  @Test
  public void assertThatCountWordsWithPunctuation() throws Exception {
    //Arrange
    List<String> data  = new ArrayList<String>();
    data.add(TREE_WORDS_WITH_PUNCTUATION_MARKS);
    //Act
    Stat resp = testee.getStat(data);
    int count = resp.getValues().get(WordCountProcessor.STAT_ITEM);
    //Assert
    assertEquals(3,count);
  }

  @Test
  public void assertThatCountWordsWithNewLine() throws Exception {
    //Arrange
    List<String> data  = new ArrayList<String>();
    data.add(TREE_WORDS_WITH_NEW_LINE);
    //Act
    Stat resp = testee.getStat(data);
    int count = resp.getValues().get(WordCountProcessor.STAT_ITEM);
    //Assert
    assertEquals(3,count);
  }

  @Test
  public void assertThatCountZeroWithNoLines() throws Exception {
    //Arrange
    List<String> data  = new ArrayList<String>();
    //Act
    Stat resp = testee.getStat(data);
    int count = resp.getValues().get(WordCountProcessor.STAT_ITEM);
    //Assert
    assertEquals(0,count);
  }

  @Test
  public void assertThatSumsLines() throws Exception {
    //Arrange
    List<String> data  = new ArrayList<String>();
    data.add(TREE_WORDS);
    data.add(TREE_WORDS_WITH_NEW_LINE);
    data.add(TREE_WORDS_WITH_PUNCTUATION_MARKS);
    //Act
    Stat resp = testee.getStat(data);
    int count = resp.getValues().get(WordCountProcessor.STAT_ITEM);
    //Assert
    assertEquals(9,count);
  }

}
