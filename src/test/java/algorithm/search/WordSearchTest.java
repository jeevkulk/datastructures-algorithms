package algorithm.search;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordSearchTest {

    private WordSearch wordSearch;

    @Before
    public void setup() {
        wordSearch = new WordSearch();
    }

    @Test
    public void testExecute() {
        wordSearch.execute();
        Mockito.times(1);
    }
}
