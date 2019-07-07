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
        this.ascii = new Ascii(new File("//home/kenny/Pictures/cropped-1920-1080-1021182.jpg"));
    }

    @Override
    public void run()
    {
        frame = new JFrame("ASCII Art");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        AsciiMenu menu = new AsciiMenu(this);
        frame.setJMenuBar(menu.getMenuBar());

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container)
    {
        //container.removeAll();
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
