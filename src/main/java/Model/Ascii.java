package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ascii
{
    BufferedImage image;
    public BrightnessMatrix brightnessMatrix;
    public AsciiMatrix asciiMatrix;

    public Ascii(File file)
    {
        try
        {
            image = ImageIO.read(file);

            BufferedImage smallerImage = resizeImage(image);

            brightnessMatrix = new BrightnessMatrix(smallerImage);
            asciiMatrix = new AsciiMatrix(brightnessMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage resizeImage(BufferedImage image)
    {
        int scaledWidth = (int) (image.getWidth()*0.5);
        int scaledHeight = (int) (image.getHeight()*0.5);

        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, image.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(image,0,0,scaledWidth,scaledHeight,null);
        g2d.dispose();
        return resizedImage;
    }


}
