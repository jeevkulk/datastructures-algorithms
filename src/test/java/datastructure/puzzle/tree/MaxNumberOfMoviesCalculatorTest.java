package datastructure.puzzle.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MaxNumberOfMoviesCalculatorTest {

    private MaxNumberOfMoviesCalculator maxNumberOfMoviesCalculator;

    @Before
    public void setup() {
        maxNumberOfMoviesCalculator = new MaxNumberOfMoviesCalculator();
    }

    @Test
    public void testMaxMovieCalculator() {
        int[] startTime = new int[] {9, 11, 13, 15, 17};
        int[] endTime = new int[] {11, 13, 15, 17, 19};

        int maxNumberOfMovies = maxNumberOfMoviesCalculator.findMaxNumberOfMovies(startTime, endTime);
        Assert.assertEquals(5, maxNumberOfMovies);

        startTime = new int[] {9, 11, 13, 15, 17};
        endTime = new int[] {12, 13, 15, 17, 19};

        maxNumberOfMovies = maxNumberOfMoviesCalculator.findMaxNumberOfMovies(startTime, endTime);
        Assert.assertEquals(4, maxNumberOfMovies);
    }
}
