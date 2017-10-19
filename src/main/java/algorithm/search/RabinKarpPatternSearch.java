package algorithm.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RabinKarpPatternSearch {

    private Logger logger = LogManager.getLogger(RabinKarpPatternSearch.class);

    /**
     * Rabin-Karp uses rolling hash values and compares that first, if it matches the actual string is compared
     * Time complexity: For best case it is O(m+n) => O(m), but for worst case it is O(mn)
     * @param text
     * @param pattern
     * @return
     */
    public int getFirstOccurrence(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHashValue = 0;
        int textHashValue = 0;
        int h = 1;
        int d = 256;
        int primeNumber = 97;
        int i, j;

        //h would be pow(d, patternLength-1) % primeNumber
        for (i = 0; i < patternLength - 1; i++) {
            h = (h * d) % primeNumber;
        }
        logger.info(h);

        for (i = 0; i < patternLength; i++) {
            patternHashValue = (d * patternHashValue + pattern.charAt(i)) % primeNumber;
            textHashValue = (d * textHashValue + text.charAt(i)) % primeNumber;
        }
        for (i = 0; i < textLength - patternLength + 1; i++) {
            if (patternHashValue == textHashValue) {
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i+j) != pattern.charAt(j))
                        break;
                }
                if (j == patternLength)
                    return i;
            } else {
                textHashValue = (d * (textHashValue - text.charAt(i) * h) + text.charAt(i + patternLength)) % primeNumber;
                if (textHashValue < 0)
                    textHashValue = (textHashValue + primeNumber);
            }
        }
        return -1;
    }
}
