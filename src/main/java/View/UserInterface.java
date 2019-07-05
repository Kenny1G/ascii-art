package View;

import Model.Ascii;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable
{
    private JFrame frame;
    private Ascii ascii;

    public UserInterface(Ascii ascii)
    {
        this.ascii = ascii;
    }

    @Override
    public void run()
    {
        frame = new JFrame("ASCII Art");
        frame.setPreferredSize(new Dimension(700,800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container)
    {
        GridLayout layout = new GridLayout(1,1);
        container.setLayout(layout);

        JTextArea asciiGoesHere = new JTextArea();
        asciiGoesHere.setBackground(Color.BLACK);
        Font terminalFont = new Font("Ubuntu Mono", Font.BOLD, 12);
        asciiGoesHere.setFont(terminalFont);

        JScrollPane scrollPaneForVisibility = new JScrollPane(asciiGoesHere);

        for (char[] row : ascii.asciiMatrix.getAsciiMatrix())
        {
            String[] expandedAsciiRow = new String[row.length];
            int count=0;
            for (char cell : row)
            {
                expandedAsciiRow[count] = String.valueOf(cell) + String.valueOf(cell) + String.valueOf(cell);
                count++;
            }
            asciiGoesHere.append(String.join("",expandedAsciiRow)+ '\n');
            System.out.println(String.join("",expandedAsciiRow));
        }

        container.add(scrollPaneForVisibility);

    }

    public JFrame getFrame()
    {
        return frame;
    }

}
