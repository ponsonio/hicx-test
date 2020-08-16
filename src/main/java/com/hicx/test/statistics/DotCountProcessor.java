package com.hicx.test.statistics;


import java.util.List;
import org.apache.commons.lang3.StringUtils;


public class DotCountProcessor implements IStatsGather{


    public static String STAT_ITEM= "Number of Dots:";
    public static String STAT_TITLE = "Dot Count";


    //not using static methods/class to make easy test cases
    public Stat getStat(final List<String> lines) {

        Stat s = new Stat();
        s.setName(STAT_TITLE);

        int i = 0;
        for (String line : lines) {
            //we could probably use regex and conf to make this found another chars
            i+= StringUtils.countMatches(line,".");
        }

        s.addStat(this.STAT_ITEM, i);

        return s;
    }

}
