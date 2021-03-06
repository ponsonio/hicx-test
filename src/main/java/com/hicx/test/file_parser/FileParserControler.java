package com.hicx.test.file_parser;

import com.hicx.test.FileUtils;
import java.io.File;

public class FileParserControler {

    //this shoudl return a parser accordingly
    //we add new file parsers here when we support more
    public FileParser getFileProcessor(File f) throws IllegalStateException{
        //improve this!!!!!!
        if (FileUtils.getFileExt(f).equalsIgnoreCase(
            SupportedFilesEnum.valueOf("TXT").toString()
        )) {
            return new TextFileParser();
        }
        //Should be a Custom exception
        throw new IllegalStateException("No processor for files "+ f.getName());
    }

}
