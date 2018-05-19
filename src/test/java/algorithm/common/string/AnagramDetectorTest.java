package algorithm.common.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnagramDetectorTest {

    private AnagramDetector anagramDetector;

    @Before
    public void setup() {
        anagramDetector = new AnagramDetector();
    }

    @Test
    public void TestIsAnagramExpectedTrue() {
        Assert.assertTrue(anagramDetector.isAnagram("asdfghjk", "kjhgfdsa"));
    }

    @Test
    public void TestIsAnagramExpectedFalse() {
        Assert.assertFalse(anagramDetector.isAnagram("qwerty", "uytrewq"));
    }
}
