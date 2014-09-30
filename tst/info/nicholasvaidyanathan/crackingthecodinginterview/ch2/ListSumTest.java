package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListSumTest {
    LinkedNode<Number> num1;
    LinkedNode<Number> num2;
    ListSummer toTest;

    @Before
    public void setup(){
        num1 = new SinglyLinkedNode<Number>(new Integer(3));
        num1.append(new SinglyLinkedNode<Number>(new Integer(1)));
        num1.append(new SinglyLinkedNode<Number>(new Integer(5)));
        num2 = new SinglyLinkedNode<Number>(new Integer(5));
        num2.append(new SinglyLinkedNode<Number>(new Integer(9)));
        num2.append(new SinglyLinkedNode<Number>(new Integer(2)));
        toTest = new ListSummer();
    }

    @Test
    public void correctlyConvertsListToNumber() {
        assertEquals(513.0, toTest.toNumber(num1));
        assertEquals(295.0, toTest.toNumber(num2));
    }

    @Test
    public void correctlyConvertsNumberToList() {
        assertEquals(num1, toTest.toList(513.0));
        assertEquals(num2, toTest.toList(295.0));
    }

    @Test
    public void correctlyCalculatesSum() {
        final LinkedNode<Number> expected = new SinglyLinkedNode<Number>(new Integer(8));
        expected.append(new SinglyLinkedNode<Number>(new Integer(0)));
        expected.append(new SinglyLinkedNode<Number>(new Integer(8)));
        assertEquals(expected, toTest.sum(num1, num2));
    }
}
