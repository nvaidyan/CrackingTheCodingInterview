package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsVisitorTest {
    LinkedNode<Integer> nodes;
    ContainsVisitor<Integer> toTest;

    @Before
    public void setup() {
        nodes = new SinglyLinkedNode<>(7);
        toTest = new ContainsVisitor<>(7);
    }

    @Test
    public void doesNotFindWhatIsNotContained() {
        toTest = new ContainsVisitor<>(5);
        nodes.accept(toTest);
        assertFalse(toTest.isContained());
    }

    @Test
    public void findsWhatIsContained() {
        nodes.accept(toTest);
        assertTrue(toTest.isContained());
    }

    @Test
    public void findsInMoreComplicatedCase() {
        nodes.append(new SinglyLinkedNode<Integer>(9));
        nodes.append(new SinglyLinkedNode<Integer>(2));
        nodes.append(new SinglyLinkedNode<Integer>(7));
        toTest = new ContainsVisitor<>(2);
        nodes.accept(toTest);
        assertTrue(toTest.isContained());
    }

    @Test
    public void findsNullWhenAsked() {
        nodes.append(new SinglyLinkedNode<Integer>(null));
        toTest = new ContainsVisitor<>(null);
        nodes.accept(toTest);
        assertTrue(toTest.isContained());
    }
}
