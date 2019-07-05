package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class BrightnessMatrix
{
    private BufferedImage image;
    private int width, height;
    private PixelData[][] pixelMatrix;
    private int[][] brightnessMatrix;

    public BrightnessMatrix(BufferedImage image)
    {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixelMatrix = loadImagePixelData(this.image,this.width,this.height);
        this.brightnessMatrix = convertPixelMatrixToBrightnessMatrix(this.pixelMatrix);
    }

    private PixelData[][] loadImagePixelData(BufferedImage image, int width, int height)
    {
        PixelData[][] gridOfPixelData = new PixelData[height][];
        for(int y=0; y<height; y++)
        {
            PixelData[] rowOfPixelData = new PixelData[width];

            for (int x=0; x<width; x++)
            {
                Color c = new Color(image.getRGB(x,y));
                PixelData pixelData = new PixelData(c);

                rowOfPixelData[x] = pixelData;
            }
            gridOfPixelData[y] = rowOfPixelData;
        }

        return gridOfPixelData;
    }

    private int[][] convertPixelMatrixToBrightnessMatrix(PixelData[][] pixelMatrix)
    {
        int[][] brightnessMatrix = new int[pixelMatrix.length][];
        int rowCount = 0;
        for(PixelData[] row: this.pixelMatrix)
        {
            int[] brightnessRow = new int[row.length];
            int cellCount = 0;
            for (PixelData cell : row)
            {
                brightnessRow[cellCount] = cell.convertToBrightnessNumber();
                cellCount++;
            }
            brightnessMatrix[rowCount] = brightnessRow;
            rowCount++;
        }
        return brightnessMatrix;
    }


    public int[][] getBrightnessMatrix() {
        return brightnessMatrix;
    }

    public void test2()
    {
        System.out.println("Successfully constructed pixel brightnessMatrix");
        System.out.println("Pixel brightnessMatrix size:" + this.width + "x" + this.height);
        System.out.println("Iterating through pixel contents:");
        for (int[] row : this.brightnessMatrix)
        {
            for(int cell : row)
            {
                System.out.println(cell);
            }
        }
    }
}
