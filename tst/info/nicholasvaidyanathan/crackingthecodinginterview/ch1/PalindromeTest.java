package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {
    Palindrome toTest;

    @Test(expected=IllegalArgumentException.class)
    public void rejectsNull() {
        toTest = new Palindrome(null);
    }

    @Test
    public void canDetermineThatStringsIsNotPalindrome() {
        toTest = new Palindrome("foo");
        assertFalse(toTest.is());
    }

    @Test
    public void canDetermineThatStringsIsPalindrome() {
        Palindrome elba = new Palindrome("able was I ere I saw elba");
        assertTrue(elba.is());
    }
}
