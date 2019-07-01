package Model;

public class AsciiMatrix
{
    private final String ASCIICHARS  = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
    private char[][] asciiMatrix;

    public AsciiMatrix(BrightnessMatrix brightnessMatrix)
    {
        this.asciiMatrix = getAsciiMatrix(brightnessMatrix);
    }

    private char[][] getAsciiMatrix(BrightnessMatrix brightnessMatrix)
    {
        char[][] asciiMatrix = new char[brightnessMatrix.getBrightnessMatrix().length][];
        int rowCount = 0;
        for (int[] row : brightnessMatrix.getBrightnessMatrix())
        {
            char[] asciiRow = new char[row.length];
            int cellCount = 0;
            for (int cell : row)
            {
                asciiRow[cellCount] = convertToAscii(cell);
                cellCount++;
            }

            asciiMatrix[rowCount] = asciiRow;
            rowCount++;
        }
        return asciiMatrix;
    }

    private char convertToAscii(int brightnessValue)
    {
        char asciiValue;
        int asciiIndex;
        asciiIndex = (65 * brightnessValue) / 255;
        asciiValue = ASCIICHARS.charAt(asciiIndex);
        return asciiValue;
    }

    public char[][] getAsciiMatrix() {
        return asciiMatrix;
    }
}
