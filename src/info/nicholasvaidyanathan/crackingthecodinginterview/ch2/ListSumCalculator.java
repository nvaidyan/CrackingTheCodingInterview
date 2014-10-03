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
}
