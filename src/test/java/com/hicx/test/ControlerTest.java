package com.hicx.test;

import static org.junit.jupiter.api.Assertions.*;

import com.hicx.test.file_parser.FileParserControler;
import com.hicx.test.statistics.Stat;
import com.hicx.test.statistics.StatsProcesorController;
import com.hicx.test.statistics.WordCountProcessor;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentMatchers.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControlerTest {

    /**
     *
     *

     The idea here was to test with mocks in isolation
     Controler testee;

    private static String dir = "";

    @Mock
    FileUtils fileUtils;

    @Mock
    FileParserControler fileParserControler;

    @Mock
    StatsProcesorController statsProcesorController;

    @BeforeAll
    public void setMocks(){

        Mockito.when(fileUtils.getFilesToProcess(),  )


        testee = new Controler(dir, fileUtils, fileParserControler, statsProcesorController);
    }

    @Test
    public void assertThatProcessTextFiles_NumberWords() throws Exception {
        //Arrange
        List<String> data  = new ArrayList<String>();
        //Act
        List<Stat> resp = testee.process();
        //Assert - this assert should assert more qualities
        assertEquals(1, resp.size());
    }
    **/

}