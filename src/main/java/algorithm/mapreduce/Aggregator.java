package algorithm.mapreduce;

import java.util.ArrayList;
import java.util.List;

public class Aggregator {

    private List<DataMap> listDataMap;

    public Aggregator() {
        listDataMap = new ArrayList<>();
    }

    public void addKey(String key) {
        DataMap dataMap = new DataMap();
        dataMap.setKey(key);
        dataMap.setValue(1);
        listDataMap.add(dataMap);
    }

    public void printData() {
        System.out.println("Count = "+listDataMap.size());
        listDataMap.stream().map(dataMap -> dataMap.getKey() + " ").forEach(System.out::print);
        System.out.println("");
    }
}
