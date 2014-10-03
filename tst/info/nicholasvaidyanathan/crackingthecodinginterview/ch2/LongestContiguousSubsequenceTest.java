package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LongestContiguousSubsequenceTest {
    ListSumCalculator toTest;

    /**
     * Write a function that, given a list of integers (both positive and negative) returns the sum of the contiguous
     * subsequence with maximum sum. Thus, given the sequence (1, 2, -4, 1, 3, -2, 3, -1) it should return 5.
     */

    @Test
    public void testCanSumOfContiguousSubsequenceWithMaximum() {
        List<Integer> inputs = Lists.newArrayList(1,2,-4,1,3,-2,3,-1);
        toTest = new ListSumCalculator();
        assertEquals(5, toTest.maxSum(inputs));
    }

    @Test
    public void handlesNull() {
        List<Integer> inputs = null;
        toTest = new ListSumCalculator();
        assertEquals(0, toTest.maxSum(inputs));
    }

    @Test
    public void handles0() {
        List<Integer> inputs = Lists.newArrayList(0);
        toTest = new ListSumCalculator();
        assertEquals(0, toTest.maxSum(inputs));
    }

    @Test(expected=IllegalArgumentException.class)
    public void handlesMaxInt() {
        List<Integer> inputs = Lists.newArrayList(1,2,3, Integer.MAX_VALUE, 5);
        toTest = new ListSumCalculator();
        toTest.maxSum(inputs);
    }
}
