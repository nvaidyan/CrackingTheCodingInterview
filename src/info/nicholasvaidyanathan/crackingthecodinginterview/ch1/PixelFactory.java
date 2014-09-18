package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

public interface PixelFactory<T extends Pixel> {
    T fromValue(int value);
}
