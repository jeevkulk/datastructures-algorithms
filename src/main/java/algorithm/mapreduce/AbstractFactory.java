package algorithm.mapreduce;

public abstract class AbstractFactory {
    abstract Aggregator getAggregator(int aggregatorIndex);
}
