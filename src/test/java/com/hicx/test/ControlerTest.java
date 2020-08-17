package com.hicx.test;

import static org.junit.jupiter.api.Assertions.*;

import com.hicx.test.file_parser.FileParserControler;
import com.hicx.test.statistics.Stat;
import com.hicx.test.statistics.StatsProcesorController;
import java.io.File;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.ArgumentMatchers.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControlerTest {

    //This tests aren't complete, it was added to gie an idea on how the design allow easy mocking
    //and test in isolation every method

    Controler testee;

    private static String dir = "";

    @Mock
    FileUtils fileUtils;

    @Mock
    FileParserControler fileParserControler;

    @Mock
    StatsProcesorController statsProcesorController;


    public void setMocks() throws Exception{

        File[] files = new File[0];

        Mockito.when(
            fileUtils.getFilesToProcess(ArgumentMatchers.any(File.class),
                ArgumentMatchers.any(String[].class))
        ).thenReturn(files);


        testee = new Controler(dir, fileUtils, fileParserControler, statsProcesorController);
    }

    @Test
    public void assertThatProcessTextFiles_NumberWords() throws Exception {
        //Arrange
        setMocks();
        List<String> data  = new ArrayList<String>();
        //Act
        List<Stat> resp = testee.process();
        //Assert - this assert should assert more qualities
        assertEquals(0, resp.size());
    }


}