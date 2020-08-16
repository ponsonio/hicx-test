package com.hicx.test.file_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public abstract interface FileParser {

    List<String> processFile(File file) throws FileNotFoundException;

}
