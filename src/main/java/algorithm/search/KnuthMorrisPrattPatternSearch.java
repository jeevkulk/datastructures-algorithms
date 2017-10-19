package algorithm.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KnuthMorrisPrattPatternSearch {

    private Logger logger = LogManager.getLogger(KnuthMorrisPrattPatternSearch.class);

    /**
     * Pattern search using Knuth-Morris-Pratt string pattern search algorithm
     * has a time complexity of O(N) and space complexity of O(N)
     * @param text
     * @param pattern
     * @return
     */
    public int getFirstOccurrence(String text, String pattern) {
        int firstOccurrence = -1;
        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();

        int[] properSuffixMatchingPrefixArr = getProperSuffixMatchingPrefixArr(pattern);
        System.out.println("Text:");
        for (char ch : textCharArray)
            System.out.print(ch+",");
        System.out.println("");
        System.out.println("Pattern:");
        for (char ch : patternCharArray)
            System.out.print(ch+",");
        System.out.println("");
        System.out.println("properSuffixMatchingPrefixArr:");
        for (int i : properSuffixMatchingPrefixArr)
            System.out.print(i+",");
        System.out.println("");

        int j = 0;
        for (int i = 0; i < textCharArray.length; i++) {
            logger.info(patternCharArray[j] +"<==>"+ textCharArray[i]);
            if (patternCharArray[j] == textCharArray[i]) {
                if (j == patternCharArray.length - 1) {
                    firstOccurrence = i - patternCharArray.length + 1;
                    break;
                }
                j++;
            } else {
                if (j > 0 && properSuffixMatchingPrefixArr[j - 1] != 0) {
                    j =  properSuffixMatchingPrefixArr[j - 1];
                    i--;
                } else {
                    j = 0;
                }
            }
        }
        return firstOccurrence;
    }

    /**
     * This method returns prefix-suffix position array of the pattern which
     * facilitates pattern searching using KMP algorithm.
     * Example: Array returned for abcdabcxyabc pattern will be {0,0,0,0,1,2,3,0,0,1,2,3}
     * @param pattern
     * @return
     */
    private int[] getProperSuffixMatchingPrefixArr(String pattern) {
        char[] ch = pattern.toCharArray();
        int[] properSuffixMatchingPrefixArr = new int[ch.length];
        int j = 0;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[j]) {
                properSuffixMatchingPrefixArr[i] = j + 1;
                j++;
            } else {
                if (j > 0)
                    j = properSuffixMatchingPrefixArr[j - 1];
                while (j > 0 && ch[i] != ch[j]) {
                    j--;
                }
                if (ch[i] == ch[j]) {
                    properSuffixMatchingPrefixArr[i] = j + 1;
                    j++;
                } else {
                    properSuffixMatchingPrefixArr[i] = j;
                }
            }
        }
        return properSuffixMatchingPrefixArr;
    }
}
