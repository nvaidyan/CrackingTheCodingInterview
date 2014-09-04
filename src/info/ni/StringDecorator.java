package info.ni;

import java.util.ArrayList;
import java.util.List;

public class StringDecorator {
    private final String testo;

    public StringDecorator(String toTest) {
        testo = toTest;
    }

    public boolean hasUniqueCharacters() {
        if (testo == null) {
            return false;
        } else if ("".equalsIgnoreCase(testo)) {
            return true;
        } else {
            final List<Character> alreadySeen = new ArrayList<>();
            for (char aChar : testo.toCharArray()) {
                if (alreadySeen.contains(aChar)) {
                    return false;
                }
                alreadySeen.add(aChar);
            }
            return true;
        }
    }
}
