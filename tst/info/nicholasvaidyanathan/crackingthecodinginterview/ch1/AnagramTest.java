package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
    @Test
    public void successfullyIdentifiesNonAnagrams() {
        assertFalse(Anagram.areAnagrams("foo", "bar"));
    }

    @Test
    public void successfullyIdentifiesAnagrams() {
        assertTrue(Anagram.areAnagrams("foo", "oof"));
    }

    @Test
    public void successfullyIdentifiesPalindromesAsAnagrams() {
        assertTrue(Anagram.areAnagrams("able was I ere I saw elba", "elba saw I ere I was able"));
    }

    @Test
    public void successfullyIdentifiesLongAnagrams() {
        assertTrue(Anagram.areAnagrams("parliament", "partial men"));
        assertTrue(Anagram.areAnagrams("Clint Eastwood", "Old West Action"));
    }
}
