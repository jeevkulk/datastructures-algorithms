package algorithm.mapreduce;

public class FactoryProvider {

    private static AggregatorFactory aggregatorFactory;

    public static synchronized AbstractFactory getAggregatorFactory() {
        if (aggregatorFactory == null) {
            aggregatorFactory = new AggregatorFactory();
        }
        return aggregatorFactory;
    }
}
