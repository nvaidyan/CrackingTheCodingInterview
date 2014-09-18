package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import java.nio.ByteBuffer;

public class RGBPixel implements Pixel {
    private final static byte BIT_MASK = (byte) 0xFF;
    byte red;
    byte green;
    byte blue;
    byte alpha;

    public RGBPixel(int value) {
        int aByte = value;
        alpha = (byte) (aByte & BIT_MASK);
        aByte >>>= 8;
        blue = (byte) (aByte & BIT_MASK);
        aByte >>>= 8;
        green = (byte) (aByte & BIT_MASK);
        aByte >>>= 8;
        red = (byte) (aByte & BIT_MASK);
    }

    public byte getRed() {
        return red;
    }

    public byte getGreen() {
        return green;
    }

    public byte getBlue() {
        return blue;
    }

    public byte getAlpha() {
        return alpha;
    }

    public int asInt() {
        return ByteBuffer.wrap(asByteArray()).getInt();
    }

    public byte[] asByteArray() {
        return new byte[]{getRed(), getGreen(), getBlue(), getAlpha()};
    }
}
