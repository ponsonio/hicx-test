package com.hicx.test;


import com.hicx.test.file_parser.FileParserControler;
import com.hicx.test.statistics.Stat;
import com.hicx.test.statistics.StatsProcesorController;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class Processor {

    final static Logger logger = Logger.getLogger(Processor.class);

    //Entry point, we instantiate and call the process on a loop with a pause
    public static void main(String[] args) {

      try{
        FileUtils fileUtils = new FileUtils();
        FileParserControler fileParserControler = new FileParserControler();
          StatsProcesorController statsProcesorController = new StatsProcesorController();

        Controler c = new Controler(args[0], fileUtils, fileParserControler,
            statsProcesorController);

        while (true) {
            printStats(c.process());
            Thread.sleep(4000);
        }


      } catch (Exception e){
          e.printStackTrace();
       }
    }

    //print the results
    private static void printStats(List<Stat> data) {

        for (Stat s: data ) {
            logger.info("Stat Tittle:"+s.getName());
            for (Map.Entry<String, Integer> set : s.getValues().entrySet()) {
                System.out.println(set.getKey() + " = " + set.getValue());
            }
            logger.info("========End==========");
        }
    }

}
