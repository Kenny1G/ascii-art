package Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ascii
{
    BufferedImage image;
    public BrightnessMatrix matrix;

    public Ascii()
    {
        try
        {
            image = ImageIO.read(new File("//home/kenny/Documents/asciiArt/src/main/resources/images/ascii-pineapple.jpg"));
            matrix = new BrightnessMatrix(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
