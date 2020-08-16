package com.hicx.test.statistics;

import java.util.List;
import java.util.StringTokenizer;

public class WordCountProcessor implements IStatsGather{


    public static String STAT_ITEM= "Number of Words:";
    public static String STAT_TITLE = "Word Count";


    //not using static methods/class to make easy test cases
    public Stat getStat(final List<String> lines) {

        Stat s = new Stat();
        s.setName(STAT_TITLE);

        int i = 0;
        for (String line : lines) {
            StringTokenizer tokens = new StringTokenizer(line);
            i+= tokens.countTokens();
        }

        s.addStat(this.STAT_ITEM, i);

        return s;
    }

}
