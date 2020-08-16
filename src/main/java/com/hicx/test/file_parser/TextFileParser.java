package com.hicx.test.file_parser;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files


public class TextFileParser implements FileParser {

    public List<String>  processFile(File file) throws FileNotFoundException {

        List<String> lines = new ArrayList<String>();
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          lines.add(data);
        }
        myReader.close();
        return lines;
    }


}
