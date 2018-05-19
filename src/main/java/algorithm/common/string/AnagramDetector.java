package algorithm.common.string;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;


public class AnagramDetector {

    private Logger logger = LogManager.getLogger(AnagramDetector.class);

    private final int MAX_VALUE = 1000;

    public boolean isAnagram(String inputStr1, String inputStr2) {

        if (inputStr1 == null || inputStr2 == null) {
            logger.info("Input strings cannot be null");
        }

        Supplier<Long[]> start = () -> {
            Long[] a = new Long[MAX_VALUE];
            Arrays.fill(a, 0L);
            return a;
        };

        ObjIntConsumer<Long[]> accumulator = (map, number) -> {
            map[number]++;
        };

        BiConsumer<Long[],Long[]> combiner = (map1, map2) -> {
        };

        return Arrays.equals(inputStr1.chars().collect(start, accumulator, combiner),
                inputStr2.chars().collect(start, accumulator, combiner));
    }
}
