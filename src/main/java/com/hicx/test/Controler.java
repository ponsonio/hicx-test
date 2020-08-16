package com.hicx.test;

import com.hicx.test.file_parser.FileParser;
import com.hicx.test.file_parser.FileParserControler;
import com.hicx.test.file_parser.SupportedFilesEnum;
import com.hicx.test.statistics.IStatsGather;
import com.hicx.test.statistics.Stat;
import com.hicx.test.statistics.StatsProcesorController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

public class Controler {

    final static Logger logger = Logger.getLogger(Controler.class);

    private static String PROCESSED_DIR = "/processed";

    List<IStatsGather> availableStats;
    String[] availableExtensions;

    File processDir,processcedDir ;
    FileUtils fileUtils;
    FileParserControler fileParserControler;

    //Injecting dependencies to make easy to mock later
    public Controler(String dir, FileUtils fileUtils, FileParserControler fileParserControler
        , StatsProcesorController statsProcesorController) {

        this.fileParserControler = fileParserControler;
        this.fileUtils = fileUtils;
        processDir = new File(dir);
        processcedDir = new File(dir+PROCESSED_DIR);
        availableExtensions = SupportedFilesEnum.getSupportedFiles();
        availableStats = new ArrayList<IStatsGather>();

        //We add available processors, we can instantiate from a .props
        availableStats = statsProcesorController.getAvailableStats();

        logger.info("Directory to scan:"+ processDir);
        logger.info("Directory after proceesed:"+ processcedDir);
        logger.info("Supported files ext:"+ Arrays.toString(availableExtensions));
        logger.info("Supported Stats:"+ Arrays.toString(availableStats.toArray()));
    }

    public List<Stat> process() throws FileNotFoundException, IOException {

        List<Stat> resp = new ArrayList<Stat>();
        File[] files = fileUtils.getFilesToProcess(processDir, availableExtensions);

        //for every file
        for (File f : files) {
            //get the fp accordingly
            FileParser fp = fileParserControler.getFileProcessor(f);

            final List<String> lines =  fp.processFile(f);

            //for every available statGather
            for (IStatsGather s : availableStats){
                resp.add(s.getStat(lines));
            }

        }
        fileUtils.moveFiles(files,processcedDir);
        //
        return resp;
    }





}
