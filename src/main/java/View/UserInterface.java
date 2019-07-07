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
        frame.setPreferredSize(new Dimension(700,800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        AsciiMenu menu = new AsciiMenu();
        frame.setJMenuBar(menu.getMenuBar());

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
// todo: add way for user to pick file https://www.mkyong.com/swing/java-swing-jfilechooser-example/
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
