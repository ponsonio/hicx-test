package com.hicx.test.statistics;

import java.util.List;
import java.util.StringTokenizer;

public interface IStatsGather {

    //to add a new procesor, we implement this interface
    Stat getStat(final List<String> lines);

}
