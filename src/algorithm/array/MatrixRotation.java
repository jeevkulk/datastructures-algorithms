package algorithm.array;


public class MatrixRotation {

    public static void main(String[] args) {
        MatrixRotation matrixRotation = new MatrixRotation();
        int[][] matrix = {{2, 3, 4}, {5, 6, 7}, {8, 9, 1}};
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
    }

    private int[][] doMatrixRotation(int[][] matrix, MatrixRotationAlgorithms matrixRotationAlgorithms) {
        switch (matrixRotationAlgorithms) {
            case SWAP:
                return matrixRotationUsingSwap(matrix);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Time complexity: O(N^2)
     * Space complexity: O(1)
     */
    private int[][] matrixRotationUsingSwap(int[][] matrix) {
        int temp, k, l, m, n;
        m = (matrix.length % 2 == 0) ? (matrix.length / 2) : (matrix.length / 2) + 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.println("i="+i+" j="+j);
                k = matrix.length - i - 1;
                l = matrix.length - j - 1;
                System.out.println("k="+k+" l="+l);
                temp = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = matrix[k][l];
                matrix[k][l] = matrix[i][l];
                matrix[i][l] = temp;
            }
        }
        return matrix;
    }
}

enum MatrixRotationAlgorithms {
    SWAP
}

