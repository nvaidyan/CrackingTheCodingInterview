package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

public class CString {
    private final char[] input;

    public CString(final CharSequence seq) {
        if (seq == null) {
            throw new IllegalArgumentException("don't accept null");
        }
        final int length = seq.length();
        input = new char[length + 1];
        for (int i = 0; i < length; i++) {
            input[i] = seq.charAt(i);
        }
        input[length] = '\0';
    }

    @Override
    public String toString() {
        return new String(input);
    }

    public String reverse() {
        final StringBuilder builder = new StringBuilder();
        for (int i = input.length - 2; i >= 0; i--) {
            builder.append(input[i]);
        }
        builder.append('\0');
        return builder.toString();
    }
}
