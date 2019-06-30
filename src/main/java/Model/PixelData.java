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
        int total = 0;
        for(int i : this.pixel)
        {
            total+=i;
        }
        return total/3;
    }
}
