package algorithm.mapreduce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordFrequencyCounter {

    private String[] fileNames = new String[]{
            "E:\\technology_workspace\\data\\in\\bdepgp\\randomtext_1.txt",
            "E:\\technology_workspace\\data\\in\\bdepgp\\randomtext_2.txt"
    };

    public void doProcess() {
        mapData();
        printMappedData();
        aggregateData();
    }

    private void mapData() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnableTask1 = () -> {
            Mapper mapper = new Mapper();
            mapper.mapInput(fileNames[0]);
        };
        Runnable runnableTask2 = () -> {
            Mapper mapper = new Mapper();
            mapper.mapInput(fileNames[1]);
        };
        executorService.submit(runnableTask1);
        executorService.submit(runnableTask2);
        try {
            executorService.awaitTermination(1000000, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private void printMappedData() {
        AbstractFactory abstractFactory = FactoryProvider.getAggregatorFactory();
        abstractFactory.getAggregator(0).printData();
        abstractFactory.getAggregator(1).printData();
        abstractFactory.getAggregator(2).printData();
    }

    private void aggregateData() {

    }

    public static void main (String[] args) {
        WordFrequencyCounter wordFrequencyCounter = new WordFrequencyCounter();
        wordFrequencyCounter.doProcess();
    }
}
