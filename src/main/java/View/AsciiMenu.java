package View;

import javax.swing.*;

public class AsciiMenu
{
    private JMenuBar menuBar;
    private JMenu file, view;

    public AsciiMenu()
    {
        menuBar = new JMenuBar();

        file = new JMenu("File");
        view = new JMenu("View");

        menuBar.add(file);
        menuBar.add(view);


    }

    public JMenuBar getMenuBar()
    {
        return menuBar;
    }
}
