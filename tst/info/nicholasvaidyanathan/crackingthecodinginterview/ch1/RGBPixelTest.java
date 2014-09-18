package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RGBPixelTest {
    RGBPixel toTest;

    @Before
    public void setup() {
        toTest = new RGBPixel(1547702036);
    }

    @Test
    public void canGetRed() { assertEquals(92, toTest.getRed()); }

    @Test
    public void canGetGreen() {
        assertEquals(64, toTest.getGreen());
    }

    @Test
    public void canGetBlue() {
        assertEquals(15, toTest.getBlue());
    }

    @Test
    public void canGetAlpha() { assertEquals(20, toTest.getAlpha()); }

    @Test
    public void combinationEqualsOriginalNumber() {
        assertEquals(1547702036, toTest.asInt());
    }

    @Test
    public void canGetByteArray() {
        assertArrayEquals(new byte[]{toTest.getRed(), toTest.getGreen(), toTest.getBlue(), toTest.getAlpha()}, toTest.asByteArray());
    }
}
