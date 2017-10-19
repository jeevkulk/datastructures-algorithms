package algorithm.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatternSearch {

    private Logger logger = LogManager.getLogger(PatternSearch.class);

    public int getFirstOccurrence(String text, String pattern, PatternSearchAlgorithm patternSearchAlgorithm) {
        int firstOccurrence = -1;
        if (patternSearchAlgorithm == PatternSearchAlgorithm.RABIN_KARP) {
            RabinKarpPatternSearch rabinKarpPatternSearch = new RabinKarpPatternSearch();
            firstOccurrence = rabinKarpPatternSearch.getFirstOccurrence(text, pattern);
        } else if (patternSearchAlgorithm == PatternSearchAlgorithm.KNUTH_MORRIS_PRATT) {
            KnuthMorrisPrattPatternSearch knuthMorrisPrattPatternSearch = new KnuthMorrisPrattPatternSearch();
            firstOccurrence = knuthMorrisPrattPatternSearch.getFirstOccurrence(text, pattern);
        } else {
            firstOccurrence = getFirstOccurrenceUsingAhoCorasick(text, pattern);
        }
        return firstOccurrence;
    }

    private int getFirstOccurrenceUsingAhoCorasick(String text, String pattern) {
        int firstOccurrence = -1;

        return firstOccurrence;
    }

    enum PatternSearchAlgorithm {
        BRUTE_FORCE,
        RABIN_KARP,
        BOYER_MOORE,
        KNUTH_MORRIS_PRATT,
        AHO_CORASICK
    }
}
