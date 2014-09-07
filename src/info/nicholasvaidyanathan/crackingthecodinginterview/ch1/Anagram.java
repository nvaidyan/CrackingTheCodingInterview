package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean areAnagrams(String foo, String bar) {
        final Map<Character, Integer> word1 = makeHistogram(foo);
        final Map<Character, Integer> word2 = makeHistogram(bar);
        return compareFrequencies(word1, word2);
    }

    private static Map<Character, Integer> makeHistogram(String foo) {
        final Map<Character, Integer> result = new HashMap<>();
        for (Character aChar : foo.toLowerCase().toCharArray()) {
            if (!result.containsKey(aChar)) {
                result.put(aChar, 1);
            } else {
                Integer stored = result.get(aChar);
                result.put(aChar, stored++);
            }
        }
        return result;
    }

    private static boolean compareFrequencies(Map<Character, Integer> word1, Map<Character, Integer> word2) {
        final Character space = ' ';
        if (word1.containsKey(space) || word2.containsKey(space)) {
            final Map<Character, Integer> sub1 = new HashMap<>(word1);
            sub1.remove(space);
            final Map<Character, Integer> sub2 = new HashMap<>(word2);
            sub2.remove(space);
            return sub1.equals(sub2);
        } else {
            return word1.equals(word2);
        }
    }
}
