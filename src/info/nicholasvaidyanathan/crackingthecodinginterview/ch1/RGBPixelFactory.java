package info.nicholasvaidyanathan.crackingthecodinginterview.ch1;

public class RGBPixelFactory implements PixelFactory<RGBPixel> {
    @Override
    public RGBPixel fromValue(int value) {
        return new RGBPixel(value);
    }
}
