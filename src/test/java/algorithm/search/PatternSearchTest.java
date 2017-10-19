package algorithm.search;

import algorithm.search.PatternSearch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatternSearchTest {

    private PatternSearch patternSearch = null;

    String text = "ABCDABCXABXABCDABCDABCY";
    String pattern = "ABCDABCY";

    @Before
    public void setup() {
        patternSearch = new PatternSearch();
    }

    @Test
    public void testPatternSearchUsingRabinKarpAlgorithm() {
        int firstOccurrence = patternSearch.getFirstOccurrence(text, pattern, PatternSearch.PatternSearchAlgorithm.RABIN_KARP);
        Assert.assertEquals(15, firstOccurrence);
    }

    @Test
    public void testPatternSearchUsingKnuthMorrisPrattAlgorithm() {
        int firstOccurrence = patternSearch.getFirstOccurrence(text, pattern, PatternSearch.PatternSearchAlgorithm.KNUTH_MORRIS_PRATT);
        Assert.assertEquals(15, firstOccurrence);
    }
}
