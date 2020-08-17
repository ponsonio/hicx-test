package com.hicx.test.statistics;

import java.util.ArrayList;
import java.util.List;

public class StatsProcesorController {

    //we add new stast processors here
    public List<IStatsGather> getAvailableStats() {
        List<IStatsGather> availableStats = new ArrayList<IStatsGather>();
        availableStats.add(new WordCountProcessor());
        availableStats.add(new DotCountProcessor());
        availableStats.add(new MostCommonWordProcessor());
        return availableStats;
    }

}
