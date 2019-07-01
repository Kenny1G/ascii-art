package Model;

import javax.imageio.ImageIO;
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
        try
        {
            image = ImageIO.read(new File("//home/kenny/Documents/asciiArt/src/main/resources/images/ascii-pineapple.jpg"));
            brightnessMatrix = new BrightnessMatrix(image);
            asciiMatrix = new AsciiMatrix(brightnessMatrix);
            for (char[] row : asciiMatrix.getAsciiMatrix())
            {
                String[] expandedAsciiRow = new String[row.length];
                int count=0;
                for (char cell : row)
                {
                    expandedAsciiRow[count] = String.valueOf(cell);// + String.valueOf(cell) + String.valueOf(cell);
                    count++;
                }
                System.out.println(String.join("",expandedAsciiRow));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
