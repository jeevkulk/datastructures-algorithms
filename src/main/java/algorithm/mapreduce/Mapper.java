package algorithm.mapreduce;

import java.io.FileInputStream;
import java.util.Scanner;

public class Mapper {

    public void mapInput(String filename) {
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNext()) {
                String inputStr = scanner.next();
                int hashIndex = getHash(inputStr);
                AbstractFactory abstractFactory = FactoryProvider.getAggregatorFactory();
                abstractFactory.getAggregator(hashIndex).addKey(inputStr);;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Hash function that will distribute the words into three aggregators
     * @param inputStr
     * @return
     */
    private int getHash(String inputStr) {
        int hashValue = 0;
        char[] chars = inputStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hashValue = hashValue + ((i + 1) * chars[i]);
        }
        return hashValue % Constant.numberOfAggregators;
    }
}
