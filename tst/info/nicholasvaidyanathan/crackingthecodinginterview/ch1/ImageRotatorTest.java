package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImageRotatorTest {
    Image image;
    private static final int DIMS = 3;
    static int[][] imageData = new int[DIMS][DIMS];

    @BeforeClass
    public static void initData() {
        for (int i = 0; i < DIMS; i++) {
            for (int j =0; j < DIMS; j++) {
                imageData[i][j] = i*j;
            }
        }
    }

    @Before
    public void setup() {
        image = new RGBImage(imageData);
    }

    @Test
    public void canGetWidth() {
        assertEquals(DIMS, image.getWidth());
    }

    @Test
    public void canGetHeight() {
        assertEquals(DIMS, image.getHeight());
    }

    @Test
    public void canGetAsBytes() {
        int[][] result = ((RGBImage)image).asArray();
        assertArrayEquals(result, imageData);
    }

    @Test
    public void canRotate90Degrees() {
        System.out.println("before rotation ");
        for (int i =0; i < imageData.length; i++) {
            System.out.println(Arrays.toString(imageData[i]));
        }
        System.out.println("expected rotation ");
        final int[][] expected = expectedRotated();
        for (int i =0; i < expected.length; i++) {
            System.out.println(Arrays.toString(expected[i]));
        }

        final RGBImage rotated = (RGBImage) image;
        System.out.println("before rotation ");
        int[][] previous = ((RGBImage) image).asArray();
        for (int i =0; i < previous.length; i++) {
            System.out.println(Arrays.toString(previous[i]));
        }
        rotated.rotate(90);
        System.out.println("after rotation ");
        int[][] after = ((RGBImage) image).asArray();
        for (int i =0; i < after.length; i++) {
            System.out.println(Arrays.toString(after[i]));
        }
        assertArrayEquals(expected, rotated.asArray());
    }

    private int[][] expectedRotated() {
        final int[][] result = new int[DIMS][DIMS];
        for (int i = 0; i < DIMS; i++) {
            for (int j = 0; j < DIMS; j++) {
                result[i][j] = imageData[j][i];
            }
        }

        for(int i =0, k = result.length -1 ; i < k; i++, k--) {
            int[] row = result[i];
            result[i] = result[k];
            result[k] = row;
        }
        return result;
    }
}
