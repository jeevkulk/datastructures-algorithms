package algorithm.mapreduce;

import java.util.ArrayList;
import java.util.List;

public class AggregatorFactory extends AbstractFactory {

    private static List<Aggregator> listAggregator;

    @Override
    public Aggregator getAggregator(int aggregatorIndex) {
        if (listAggregator == null) {
            synchronized (this) {
                if (listAggregator == null) {
                    createAggregators();
                }
            }
        }
        return listAggregator.get(aggregatorIndex);
    }

    private void createAggregators() {
        listAggregator = new ArrayList<>(Constant.numberOfAggregators);
        for (int i = 0; i < Constant.numberOfAggregators; i++) {
            Aggregator aggregator = new Aggregator();
            listAggregator.add(aggregator);
        }
    }
}
