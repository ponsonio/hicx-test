package com.hicx.test.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//Stats for most common word
public class MostCommonWordProcessor implements IStatsGather{

    private HashMap<String, Integer> frecuency;

    public static String STAT_ITEM= "Most Used: ";
    public static String STAT_TITLE = "Most Used Word: ";


    //not using static methods/class to make easy test cases
    public Stat getStat(final List<String> lines) {

        frecuency = new HashMap<String, Integer>();

        Stat s = new Stat();
        s.setName(STAT_TITLE);

        int i = 0;
        for (String line : lines) {
            StringTokenizer tokens = new StringTokenizer(line);

            while(tokens.hasMoreElements()){
                String word = tokens.nextToken();
                word = word.replaceAll("[^A-Za-z0-9]", "");
                i = 0;
                if (frecuency.containsKey(word)) {
                     i = frecuency.get(word)+1;
                }
                frecuency.put(word,i);
            }

        }

        int max = 0;
        String mostUsed = "";

        for (Map.Entry<String, Integer> set : frecuency.entrySet()) {
          if ( set.getValue() > max) {
              max = set.getValue();
              mostUsed = set.getKey();
          }
        }

        s.addStat(this.STAT_ITEM + mostUsed + ":" , max);

        return s;
    }

}
