package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CStringReverseTest {
    CString toTest;

    @Test(expected=IllegalArgumentException.class)
    public void handlesNullCorrectly() {
        toTest = new CString(null);
    }

    @Test
    public void handlesEmptyCorrectly() {
        toTest = new CString("");
        assertEquals("\0", toTest.toString());
    }

    @Test
    public void addsNullTerminator() {
        toTest = new CString("foo");
        assertEquals("foo\0", toTest.toString());
    }

    @Test
    public void canReverseSmall() {
        toTest = new CString("foo");
        final String result = toTest.reverse();
        assertEquals("oof\0", result);
    }

    @Test
    public void canReverseBig() {
        toTest = new CString("abcdefghijklmnopqrstuvwxyz");
        final String result = toTest.reverse();
        assertEquals("zyxwvutsrqponmlkjihgfedcba\0", result);
    }
}
