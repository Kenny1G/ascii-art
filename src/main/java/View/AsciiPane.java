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
      Font terminalFont = new Font(Font.MONOSPACED,Font.BOLD,1);
      textArea.setFont(terminalFont);
      textArea.setForeground(Color.WHITE);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);

      if(ascii == null)
      {
          textArea.setFont(new Font(Font.MONOSPACED,Font.BOLD,60));
          textArea.setText("PLEASE OPEN AN IMAGE");
      }else
      {
          for (char[] row : ascii.asciiMatrix.getAsciiMatrix())
          {
              String[] expandedAsciiRow = new String[row.length];
              int count=0;
              for (char cell : row)
              {
                  expandedAsciiRow[count] = String.valueOf(cell) + String.valueOf(cell);
                  count++;
              }
              textArea.append(String.join("",expandedAsciiRow)+ '\n');
              System.out.println(String.join("",expandedAsciiRow)+ '\n');
          }
      }

      add(scrollPane);
    }
}
