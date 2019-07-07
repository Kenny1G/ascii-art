package View;

import Controller.openMenuListener;

import javax.swing.*;

public class AsciiMenu
{
    private JMenuBar menuBar;
    private JMenu file, view;
    private JMenuItem open,zoomIn, zoomOut;

    public AsciiMenu(UserInterface sire)
    {
        menuBar = new JMenuBar();

        file = new JMenu("File");
        view = new JMenu("View");

        open = new JMenuItem("Open");
        file.add(open);

        openMenuListener openListener = new openMenuListener(sire);
        open.addActionListener(openListener);

        menuBar.add(file);
        menuBar.add(view);


    }

    public JMenuBar getMenuBar()
    {
        return menuBar;
    }
}
