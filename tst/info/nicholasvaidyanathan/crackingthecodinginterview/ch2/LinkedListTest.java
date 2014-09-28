package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedNode<Integer> nerd;
    @Before
    public void setup() {
        nerd = new SinglyLinkedNode(5);
    }

    @Test
    public void canMakeAList() {
        assertEquals(new Integer(5), nerd.getData());
        assertNull(nerd.getNext());
    }

    @Test
    public void canAddNodeToList() {
        LinkedNode<Integer> next = new SinglyLinkedNode<>(7);
        nerd.append(next);
        assertEquals(next, nerd.getNext());
    }

    @Test
    public void canMultipleNodesToList() {
        LinkedNode<Integer> next = new SinglyLinkedNode<>(7);
        nerd.append(next);
        LinkedNode<Integer> after = new SinglyLinkedNode<Integer>(8);
        nerd.append(after);
        assertEquals(next, nerd.getNext());
        assertEquals(after, next.getNext());
    }
}
