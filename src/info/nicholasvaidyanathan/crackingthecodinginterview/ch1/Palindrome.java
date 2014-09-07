package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

public class Palindrome {
    private final String original;

    public Palindrome(String foo) {
        if (foo == null) {
            throw new IllegalArgumentException("don't accept null");
        }
        original = foo;
    }

    public boolean is() {
        final String reversed = new StringBuilder(original).reverse().toString();
        return reversed.equalsIgnoreCase(original);
    }
}
