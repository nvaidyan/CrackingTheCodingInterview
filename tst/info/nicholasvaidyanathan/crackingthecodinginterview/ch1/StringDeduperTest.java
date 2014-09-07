package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringDeduperTest {
    StringDecorator toTest;

    @Test
    public void canRemoveDuplicateCharactersFromSimpleWord() {
        toTest = new StringDecorator("apple");
        assertEquals("aple", toTest.removeDuplicateCharacters());
    }

    @Test
    public void canRemoveDuplicateCharactersFromLongSentence() {
        toTest = new StringDecorator("the quick brown fox jumped over the lazy dog");
        assertEquals("the quickbrownfxjmpdvlazyg", toTest.removeDuplicateCharacters());
    }
}
