package View;

import Model.Ascii;

import javax.swing.*;
import java.awt.*;

public class AsciiPane extends JPanel
{
    private Ascii ascii;

    public AsciiPane(Ascii ascii)
    {
      super(new GridLayout(1,1));
      this.ascii = ascii;

      JTextArea textArea = new JTextArea();
      textArea.setBackground(Color.BLACK);
      Font terminalFont = new Font("Ubuntu Mono",Font.PLAIN,5);
      textArea.setFont(terminalFont);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);

      for (char[] row : ascii.asciiMatrix.getAsciiMatrix())
      {
          String[] expandedAsciiRow = new String[row.length];
          int count=0;
          for (char cell : row)
          {
              expandedAsciiRow[count] = String.valueOf(cell) + String.valueOf(cell) + String.valueOf(cell);
              count++;
          }
          textArea.append(String.join("",expandedAsciiRow)+ '\n');
      }

      add(scrollPane);
    }
}
