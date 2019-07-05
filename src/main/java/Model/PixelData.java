package Model;

import java.awt.*;

public class PixelData
{
    private int[] pixel;

    public PixelData(Color c)
    {
        this.pixel = new int[3];
        this.pixel[0] = c.getRed();
        this.pixel[1] = c.getGreen();
        this.pixel[2] = c.getBlue();
    }

    public int[] getPixel() {
        return this.pixel;
    }

    public int convertToBrightnessNumber()
    {
        double R = pixel[0] * 0.2126;
        double G = pixel[1] * 0.7152;
        double B = pixel[2] * 0.0722;

        return (int) (R +G + B);
    }
}
