import View.UserInterface;

import javax.swing.*;
// Done with this for now
public class Main
{
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}
