package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixZeroesTest {
    int[][] matrix = new int[][] {
            new int[] { 1, 2, 3},
            new int[] { 4, 5, 6},
            new int[] { 7, 8, 0}
    };

    @Test
    public void canZeroRowAndColumnWhen0Found() {
        MatrixZeroer.zeroRowAndColumnWhere0(matrix);
        final int[][] expected = new int[][] {
                new int[] { 1, 2, 0},
                new int[] { 4, 5, 0},
                new int[] { 0, 0, 0}
        };
        assertArrayEquals(expected, matrix);
    }
}
