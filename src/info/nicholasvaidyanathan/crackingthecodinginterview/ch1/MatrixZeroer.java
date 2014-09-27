package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

public class MatrixZeroer {
    public static void zeroRowAndColumnWhere0(final int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isZero = matrix[i][j] == 0;
                if (isZero) {
                    zeroOutRow(matrix, i);
                    zeroOutColumn(matrix, j);
                }
            }
        }
    }

    private static void zeroOutRow(int[][] matrix, int rowIndex) {
        for(int j = 0; j < matrix[rowIndex].length; j++) {
            matrix[rowIndex][j] = 0;
        }
    }

    private static void zeroOutColumn(int[][] matrix, int columnIndex) {
        for(int j = 0; j < matrix.length; j++) {
            matrix[j][columnIndex] = 0;
        }
    }
}
