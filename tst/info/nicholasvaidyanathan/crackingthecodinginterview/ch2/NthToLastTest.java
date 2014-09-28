package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NthToLastTest {
    LinkedNode<String> toTest;

    @Before
    public void setup() {
        toTest = new SinglyLinkedNode<>("foo");
        toTest.append(new SinglyLinkedNode<String>("bar"));
        toTest.append(new SinglyLinkedNode<String>("baz"));
        toTest.append(new SinglyLinkedNode<String>("booze"));
    }

    @Test
    public void canFind2ndToLast() {
        NthToLastVisitor visitor = new NthToLastVisitor(2);
        toTest.accept(visitor);
        assertEquals("baz", visitor.getFound());
    }

    @Test
    public void canFind3rdToLast() {
        NthToLastVisitor visitor = new NthToLastVisitor(3);
        toTest.accept(visitor);
        assertEquals("bar", visitor.getFound());
    }

    @Test
    public void canFindLast() {
        NthToLastVisitor visitor = new NthToLastVisitor(0);
        toTest.accept(visitor);
        assertEquals("booze", visitor.getFound());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenAskedForNGreaterThanList() {
        NthToLastVisitor visitor = new NthToLastVisitor(5);
        toTest.accept(visitor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenAskedForNegativeN() {
        NthToLastVisitor visitor = new NthToLastVisitor(-1);
        toTest.accept(visitor);
    }
}
