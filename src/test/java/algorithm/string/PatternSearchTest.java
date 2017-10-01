package algorithm.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatternSearchTest {

    private PatternSearch patternSearch = null;

    @Before
    public void setup() {
        patternSearch = new PatternSearch();
    }

    @Test
    public void testPatternSearchUsingKMPAlgorithm() {
        String text = "ABCDABCXABXABCDABCDABCY";
        String pattern = "ABCDABCY";
        int firstOccurrence = patternSearch.getFirstOccurrence(text, pattern, PatternSearch.PatternSearchAlgorithm.KnuthMorrisPratt);
        Assert.assertEquals(15, firstOccurrence);
    }
}
