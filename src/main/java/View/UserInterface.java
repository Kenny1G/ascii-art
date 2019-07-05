package View;

import Model.Ascii;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable
{
    private JFrame frame;
    private Ascii ascii;

    public UserInterface()
    {
        this.ascii = new Ascii();
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

        AsciiPane asciiGoesHere = new AsciiPane(ascii);

        container.add(asciiGoesHere);
    }

    public JFrame getFrame()
    {
        return frame;
    }

}
