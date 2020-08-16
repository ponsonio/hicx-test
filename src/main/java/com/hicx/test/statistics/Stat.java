package com.hicx.test.statistics;

import java.util.HashMap;

public class Stat {

    private String name;

    public HashMap<String, Integer> getValues() {
        return values;
    }

    private HashMap<String, Integer> values;

    Stat(){
        values = new HashMap<String, Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStat(String statItem, Integer value ){
        values.put(statItem, value);
    }


}
