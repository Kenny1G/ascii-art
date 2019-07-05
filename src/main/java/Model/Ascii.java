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

    public Ascii()
    {
        // todo: resize image https://www.codejava.net/java-se/graphics/how-to-resize-images-in-java
        try
        {
            //image = ImageIO.read(new File("//home/kenny/Documents/asciiArt/src/main/resources/images/ascii-pineapple.jpg"));
            //image = ImageIO.read(new File("//home/kenny/Documents/asciiArt/src/main/resources/images/xqc.jpeg"));
            image = ImageIO.read(new File("//home/kenny/Pictures/cropped-1920-1080-1021182.jpg"));

            BufferedImage smallerImage = resizeImage(image);

            brightnessMatrix = new BrightnessMatrix(smallerImage);
            asciiMatrix = new AsciiMatrix(brightnessMatrix);
            //printAscii(asciiMatrix);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void printAscii(AsciiMatrix asciiMatrix)
//    {
//        for (char[] row : asciiMatrix.getAsciiMatrix())
//        {
//            String[] expandedAsciiRow = new String[row.length];
//            int count=0;
//            for (char cell : row)
//            {
//                expandedAsciiRow[count] = String.valueOf(cell) + String.valueOf(cell) + String.valueOf(cell);
//                count++;
//            }
//            System.out.println(String.join("",expandedAsciiRow));
//        }
//    }

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
