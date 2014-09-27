package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

public class StringRotator {
    final String given;

    public StringRotator(String input) {
        given = input;
    }

    public boolean isRotationOf(String possibleRotation) {
        final String appended = given + given;
        return given.length() == possibleRotation.length() && appended.contains(possibleRotation) ;
    }
}
