package algorithm.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MatrixRotationTest {

    private MatrixRotation matrixRotation;

    @Before
    public void setup() {
        matrixRotation = new MatrixRotation();
    }

    @Test
    public void TestDoMatrixRotationSuccess() {
        int[][] matrix = {{2, 3, 4, 5}, {6, 7, 8, 9}, {1, 2, 3, 4}, {5, 6, 7, 8}};
        System.out.println("Input matrix");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print("    "+matrix[i][j]);
            }
            System.out.println("");
        }
        matrix = matrixRotation.doMatrixRotation(matrix, MatrixRotationAlgorithms.SWAP);
        System.out.println("Rotated matrix");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print("    "+matrix[i][j]);
            }
            System.out.println("");
        }
        Assert.assertTrue("Matrix rotation failed", matrix[0][0] == matrix[3][3]);
    }
}
