package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateNodeRemovalTest {
    FilterableLinkedNode<Integer> toTest;

    @Before
    public void setup() {
        toTest = new SinglyLinkedNode<Integer>(7);
    }

    @Test
    public void worksWellOnSingleListWithClumpedDupes() {
        toTest.append(new SinglyLinkedNode<Integer>(8));
        toTest.append(new SinglyLinkedNode<Integer>(8));
        toTest.append(new SinglyLinkedNode<Integer>(8));
        final FilterableLinkedNode<Integer> tail = new SinglyLinkedNode<Integer>(9);
        toTest.append(tail);
        toTest.removeDuplicates();
        assertEquals(tail, toTest.getNext().getNext());
    }

    @Test
    public void worksWellOnSingleListWithSporadicDupes() {
        toTest.append(new SinglyLinkedNode<Integer>(4));
        toTest.append(new SinglyLinkedNode<Integer>(7));
        toTest.append(new SinglyLinkedNode<Integer>(4));
        final FilterableLinkedNode<Integer> tail = new SinglyLinkedNode<Integer>(9);
        toTest.append(tail);
        toTest.removeDuplicates();
        assertEquals(tail, toTest.getNext().getNext());
    }

    @Test
    public void worksWellOnSingleListWithDupeAtEnd() {
        toTest.append(new SinglyLinkedNode<Integer>(4));
        toTest.append(new SinglyLinkedNode<Integer>(12));
        final FilterableLinkedNode<Integer> untrimmed = new SinglyLinkedNode<Integer>(7);
        toTest.append(untrimmed);
        final FilterableLinkedNode<Integer> tail = new SinglyLinkedNode<Integer>(12);
        toTest.append(tail);
        toTest.removeDuplicates();
        assertEquals(tail, toTest.getNext().getNext());
    }
}
