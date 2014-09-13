package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SpaceReplacerTest {
    StringDecorator toTest;

    @Before
    public void setup() {
        toTest = new StringDecorator("foo bar");
    }

    @Test
    public void gracefullyHandlesNull() {
        toTest = new StringDecorator(null);
        assertNull(toTest.htmlEscapeSpace());
    }

    @Test
    public void gracefullyHandlesEmpty() {
        toTest = new StringDecorator("");
        assertEquals("",toTest.htmlEscapeSpace());
    }

    @Test
    public void gracefullyHandlesNoSpaces() {
        toTest = new StringDecorator("fooze");
        assertEquals("fooze",toTest.htmlEscapeSpace());
    }

    @Test
    public void canReplaceSpaces() {
        assertEquals("foo%20bar", toTest.htmlEscapeSpace());
    }
}
