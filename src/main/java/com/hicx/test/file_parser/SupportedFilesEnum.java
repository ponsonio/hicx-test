package com.hicx.test.file_parser;

public enum SupportedFilesEnum {

    TXT("txt");

    public final String label;

    SupportedFilesEnum(String label) {
        this.label = label;
    }

    //this should iterate the enum values
    public static String[] getSupportedFiles(){
        return new String[] { "txt"};
    }
}
