package Controller;

import Model.Ascii;
import View.UserInterface;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class openMenuListener implements ActionListener
{
    private UserInterface mainUI;

    public openMenuListener(UserInterface mainUI)
    {
        this.mainUI = mainUI;
    }

    public void actionPerformed(ActionEvent e)
    {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
        jfc.setDialogTitle("Select an Image");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG, JPG and JPEG images","png","jpg","jpeg");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            try {
                mainUI.setAscii(new Ascii(new FileInputStream(jfc.getSelectedFile())));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            mainUI.disposeFrame();
            mainUI.run();
        }
    }
}
