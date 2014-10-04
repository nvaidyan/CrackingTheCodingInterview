package info.nicholasvaidyanathan.crackingthecodinginterview.ch2;

import java.util.List;

public class ListSumCalculator {
    public int maxSum(List<Integer> input)
    {
        int max = 0;
        int result = 0;
        if (input == null) {
            return result;
        } else if (input.size() == 1) {
            return input.get(0);
        } else {
            for (int i =0; i < input.size(); i++) {
                // sum each number with the previous unless the sum would make the total negative.
                if (input.get(i) == Integer.MAX_VALUE) {
                    throw new IllegalArgumentException("Number too big!");
                }
                //if sum makes total negative, skip this entry.
                if(result + input.get(i) < 0) {
                    result = 0;
                    continue;
                } else if (result + input.get(i) > max) {
                    result = result + input.get(i);
                    max = result;
                } else {
                    result = result + input.get(i);
                }
            }
            // return sum
            return max;
        }
    }

    int findMaxContigous(int [] array)
    {

        int leftSum = 0;
        int rightSum = 0;
        int max = -9999;

        for(int leftIndex = 0; leftIndex < array.length; leftIndex++)
        {
            leftSum = leftSum + array[leftIndex];
            rightSum = 0;
            for(int rightIndex = leftIndex+1; rightIndex<array.length; rightIndex++)
            {
                rightSum = rightSum + array[rightIndex];
                if(rightSum > max)
                {
                    max = rightSum;
                }
            }
            if(leftSum > max)
            {
                max = leftSum;
            }

        }

        return max;


    }


    /**
     * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
     * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
     * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
     */
    //multiply numbers times depth
    public int depthSum (List<NestedInteger> input)
    {
        int result =0;
        if (input == null) {
            return 0;
        }
        result = result + depthSum(input, 1);
        return result;
    }

    private int depthSum(List<NestedInteger> input, int depth){
        int result =0;
        for (NestedInteger number : input) {
            if (!number.isInteger()) {
                result = result + depthSum(number.getList(), depth + 1);
            } else {
                result = result + number.getInteger() * depth;
            }
        }
        return result;
    }

}
