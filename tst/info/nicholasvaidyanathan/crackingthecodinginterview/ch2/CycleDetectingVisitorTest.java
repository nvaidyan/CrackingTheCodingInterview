package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CycleDetectingVisitorTest {
    LinkedNode<Character> list;
    LinkedNode<Character> cycleNode;
    CycleDetectingVisitor toTest;

    @Before
    public void setup() {
        list = new SinglyLinkedNode<Character>('a');
        list.append(new SinglyLinkedNode<Character>('b'));
        cycleNode = new SinglyLinkedNode<Character>('c');
        list.append(cycleNode);
        list.append(new SinglyLinkedNode<Character>('d'));
        list.append(new SinglyLinkedNode<Character>('e'));
        list.append(cycleNode);
        toTest = new CycleDetectingVisitor();
    }

    @Test
    public void canDetectCycles() {
        list.accept(toTest);
        assertTrue(toTest.containsCycle());
        assertEquals(cycleNode, toTest.getCycleNode());
    }
}
