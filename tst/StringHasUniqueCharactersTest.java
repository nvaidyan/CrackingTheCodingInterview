import info.ni.StringDecorator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Master on 9/4/2014.
 */
public class StringHasUniqueCharactersTest {
    @Test
    public void correctlyIdentifiesXfinity() {
        assertFalse(new StringDecorator("xfinity").hasUniqueCharacters());
    }

    @Test
    public void correctlyIdentifiesAsus() {
        assertFalse(new StringDecorator("asus").hasUniqueCharacters());
    }

    @Test
    public void correctlyIdentifiesApple() {
        assertFalse(new StringDecorator("apple").hasUniqueCharacters());
    }

    @Test
    public void correctlyIdentifiesHome() {
        assertTrue(new StringDecorator("home").hasUniqueCharacters());
    }

    @Test
    public void correctlyIdentifiesDora() {
        assertTrue(new StringDecorator("Dora").hasUniqueCharacters());
    }

    @Test
    public void correctlyIdentifiesMcDonalds() {
        assertTrue(new StringDecorator("McDonalds").hasUniqueCharacters());
    }
}
