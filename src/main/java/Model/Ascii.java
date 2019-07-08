package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
            BufferedImage smallerImage = resizeImage(image,1);

            brightnessMatrix = new BrightnessMatrix(smallerImage);
            asciiMatrix = new AsciiMatrix(brightnessMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private BufferedImage resizeImage(BufferedImage image, double scale)
    {
        int scaledWidth = (int) (image.getWidth()*scale);
        int scaledHeight = (int) (image.getHeight()*scale);

        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, image.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(image,0,0,scaledWidth,scaledHeight,null);
        g2d.dispose();
        return resizedImage;
    }


}
