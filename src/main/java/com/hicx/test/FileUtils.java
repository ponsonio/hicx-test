package com.hicx.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Utilities for file handle
 */
public class FileUtils {

    final static Logger logger = Logger.getLogger(FileUtils.class);


    public File[] getFilesToProcess(File processDir, String[] availableExtensions) throws IOException {

        File[] files = processDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                //we need to change this when support more files
                return name.toLowerCase().endsWith(availableExtensions[0]);
            }
        });
        logger.info("files to process :" + Arrays.toString(files));
        return files;
    }

    public void moveFiles(File[] files, File processcedDir) throws IOException {

        for (File file : files) {

            File dest = new File(processcedDir.toPath()+ "/" + file.getName());

            Files.move(file.toPath(), dest.toPath()
                , StandardCopyOption.REPLACE_EXISTING);
        }
        logger.info("files moved :" + Arrays.toString(files));
    }

    public static String getFileExt(File f) {
        String extension = "";

        int i = f.getName().lastIndexOf('.');
        if (i > 0) {
            extension = f.getName().substring(i+1);
        }
        return extension;

    }

}
