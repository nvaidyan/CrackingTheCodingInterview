package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListDepthSumTest {
    List<NestedInteger> input;
    ListSumCalculator toTest;

    @Before
    public void setup() {
        toTest = new ListSumCalculator();
    }

    @Test
    public void correctlyCalculatesListOne() {
        // given the list {{1,1},2,{1,1}}
        NestedInteger first =new ListInteger(1);
        NestedInteger second = new ListInteger(1);
        NestedInteger list1 = new ListInteger(Lists.newArrayList(first, second));
        NestedInteger list2 = new ListInteger(2);
        NestedInteger list3 = new ListInteger(Lists.newArrayList(first,second));
        input = Lists.newArrayList(list1, list2, list3);
        // when I call calculate depthSum
        final int sum = toTest.depthSum(input);
        // then function should return 10 (four 1's at depth 2, one 2 at depth 1)
        assertEquals(10, sum);
    }

    @Test
    public void correctlyCalculatesListTwo() {
        // Given the list {1,{4,{6}}}
        NestedInteger list1 = new ListInteger(1);
        List<NestedInteger> secondLevel = Lists.newArrayList();
        secondLevel.add(new ListInteger(4));
        NestedInteger list2 = new ListInteger(secondLevel);
        NestedInteger six = new ListInteger(6);
        NestedInteger level3 = new ListInteger(Lists.newArrayList(six));
        NestedInteger level2 = new ListInteger(Lists.newArrayList(level3));
        input = Lists.newArrayList(list1, list2, level2);
        // when I call calculate depthSum
        final int sum = toTest.depthSum(input);
        // function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
        assertEquals(27, sum);
    }

}
