package View;

import Model.Ascii;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UserInterface implements Runnable
{
    private JFrame frame;
    private Ascii ascii;

    public UserInterface()
    {
    }

    @Override
    public void run()
    {
        frame = new JFrame("ASCII Art");
        frame.setPreferredSize(new Dimension(1500,1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        AsciiMenu menu = new AsciiMenu(this);
        frame.setJMenuBar(menu.getMenuBar());

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container)
    {
        GridLayout layout = new GridLayout(1,1);
        container.setLayout(layout);

        AsciiPane asciiGoesHere = new AsciiPane(ascii);

        container.add(asciiGoesHere);
    }

    public void disposeFrame()
    {
        frame.dispose();
    }

    public void setAscii(Ascii ascii) {
        this.ascii = ascii;
    }
}
