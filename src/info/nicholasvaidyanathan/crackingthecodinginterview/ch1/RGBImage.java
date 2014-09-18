package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import java.nio.ByteBuffer;

public class RGBImage implements Image {
    private static final PixelFactory<RGBPixel> rgbPix = new RGBPixelFactory();
    private final RGBPixel[][] data;

    public RGBImage(int[][] imageData) {
        data = new RGBPixel[imageData.length][imageData[0].length];
        for (int i = 0; i < imageData.length; i++) {
            for (int j = 0; j < imageData[i].length; j++) {
                data[i][j] = rgbPix.fromValue(imageData[i][j]);
            }
        }
    }

    @Override
    public int getWidth() {
        return data.length;
    }

    @Override
    public int getHeight() {
        return data[0].length;
    }

    public int[][] asArray() {
        final int[][] ints = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                final RGBPixel pete = data[i][j];
                final byte[] bytes = new byte[]{pete.getRed(), pete.getGreen(), pete.getBlue(), pete.getAlpha()};
                final int value = ByteBuffer.wrap(bytes).getInt();
                ints[i][j] = value;
            }
        }
        return ints;
    }

    public void rotate(final int degrees) {
        if (data.length == 2 && data[0].length == 2) {
            rotate2D(degrees);
        } else if (data.length == 3 && data[0].length == 3) {
            rotate3D(degrees);
        } else {
            rotateBrute(degrees);
        }
    }

    private void rotate2D(int degrees) {
        if (degrees == 90) {
            transposeAndSwapRows(2);
        }

    }

    private void transposeAndSwapRows(final int dims) {
        if (dims == 2) {
            transpose2D();
        } else if (dims == 3) {
            tranpose3D();
        }
        swapRows();
    }

    private void transpose2D() {
        RGBPixel zeroOne = data[0][1];
        data[0][1] = data[1][0];
        data[1][0] = zeroOne;
    }

    private void tranpose3D() {
        for (int i = 1; i < 2; i++) {
            RGBPixel leftOfDiagonal = data[i - 1][i];
            RGBPixel rightOfDiagonal = data[i][i - 1];
            data[i][i - 1] = leftOfDiagonal;
            data[i - 1][i] = rightOfDiagonal;
        }
    }

    private void swapRows() {
        for (int i = 0, k = data.length - 1; i < k; i++, k--) {
            RGBPixel[] row = data[i];
            data[i] = data[k];
            data[k] = row;
        }
    }


    private void rotate3D(int degrees) {
        if (degrees == 90) {
            transposeAndSwapRows(3);
        }
    }

    private void rotateBrute(int degrees) {
    }
}
