package algorithm.common.array;


public class MatrixRotation {

    public int[][] doMatrixRotation(int[][] matrix, MatrixRotationAlgorithms matrixRotationAlgorithms) {
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
        int temp, limit, lefti, leftj, righti, rightj, topi, topj, bottomi, bottomj;
        limit = (matrix.length / 2) + 1;
        for(int i = 0; i < limit; i++) {
            for(int j = 0; j <= i && j < (limit - i); j++) {
                lefti = i;
                leftj = j;
                bottomi = matrix.length - 1 - j;
                bottomj = i;
                righti = matrix.length - 1 - i;
                rightj = matrix.length - 1 - j;
                topi = j;
                topj = matrix.length - 1 - i;
                temp = matrix[lefti][leftj];
                matrix[lefti][leftj] = matrix[bottomi][bottomj];
                matrix[bottomi][bottomj] = matrix[righti][rightj];
                matrix[righti][rightj] = matrix[topi][topj];
                matrix[topi][topj] = temp;
            }
        }
        return matrix;
    }
}

enum MatrixRotationAlgorithms {
    SWAP
}

