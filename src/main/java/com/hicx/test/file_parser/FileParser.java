package com.hicx.test.file_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface FileParser {

    //to add a new parse, we implement this interface
    List<String> processFile(File file) throws FileNotFoundException;

}
