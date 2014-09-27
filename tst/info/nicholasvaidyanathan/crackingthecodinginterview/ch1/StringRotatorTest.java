package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringRotatorTest {
    @Test
    public void correctlyIdentifiesRotatedStrings() {
        final StringRotator rot = new StringRotator("erbottlewat");
        assertTrue(rot.isRotationOf("waterbottle"));
    }

    @Test
    public void correctlyIdentifiesNonRotatedStringsWithNonOverlappingCharacters() {
        final StringRotator rot = new StringRotator("basketball");
        assertFalse(rot.isRotationOf("waterbottle"));
    }

    @Test
    public void correctlyIdentifiesNonRotatedStringsWithNonRotatedCharacters() {
        final StringRotator rot = new StringRotator("read");
        assertFalse(rot.isRotationOf("ader"));
        assertTrue(rot.isRotationOf("adre"));
    }
}
