package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteMiddleNodeTest {
    LinkedNode<Double> list;
    LinkedNode<Double> end;
    LinkedNode<Double> toRemove;
    NodeRemovingVisitor toTest;

    @Before
    public void setup() {
        list = new SinglyLinkedNode<>(2.5);
        list.append(new SinglyLinkedNode<Double>(3.7));
        toRemove = new SinglyLinkedNode<>(4.6);
        list.append(toRemove);
        end = new SinglyLinkedNode<Double>(72.1);
        list.append(end);
        toTest = new NodeRemovingVisitor(toRemove);
    }

    @Test(expected=IllegalArgumentException.class)
    public void rejectsNull() {
        toTest = new NodeRemovingVisitor(null);
    }

    @Test(expected=UnsupportedOperationException.class)
    public void cannotRemoveFromEnd() {
        toTest = new NodeRemovingVisitor(end);
        toTest.visit(end);
    }

    @Test
    public void canRemoveTargetNode() {
        ContainsVisitor<Double> contained = new ContainsVisitor<>(toRemove.getData());
        toTest.visit(toRemove);
        contained.visit(list);
        assertFalse(contained.isContained());
    }
}
