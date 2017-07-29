package algorithm.search;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShakespeareWordSearchTest {

    private ShakespeareWordSearch shakespeareWordSearch;

    @Before
    public void setup() {
        shakespeareWordSearch = new ShakespeareWordSearch();
    }

    @Test
    public void testExecute() {
        shakespeareWordSearch.execute();
        Mockito.times(1);
    }
}
