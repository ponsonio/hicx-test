package com.hicx.test.statistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MostCommonWordProcessorTest {

  private MostCommonWordProcessor testee = new MostCommonWordProcessor();

  private static String TREE_WORDS = "one one one one one";
  private static String TREE_WORDS_WITH_PUNCTUATION_MARKS = "two, two; one";
  private static String TREE_WORDS_WITH_NEW_LINE = "two two \n tree";


  @Test
  public void assertThatTittle_Corresponds() throws Exception {
      //Arrange
      List<String> data  = new ArrayList<String>();
      //Act
      Stat resp = testee.getStat(data);
      //Assert
      assertEquals(MostCommonWordProcessor.STAT_TITLE,resp.getName());
  }

  //one test per concern
  @Test
  public void assertThatCountWords() throws Exception {
    //Arrange
    List<String> data  = new ArrayList<String>();
    data.add(TREE_WORDS);
    data.add(TREE_WORDS_WITH_PUNCTUATION_MARKS);
    data.add(TREE_WORDS_WITH_NEW_LINE);
    //Act
    Stat resp = testee.getStat(data);
    //improve this
    int count = resp.getValues().get(MostCommonWordProcessor.STAT_ITEM+ "one" + ":" );
    //Assert
    assertEquals(5,count);
  }


}
