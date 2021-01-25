import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame Mainframe = new JFrame("Network Guide Tool");
        Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Mainframe.setBounds(350, 50, 600, 600);

        JPanel TitlePanel = new JPanel();
        JLabel title_label = new JLabel("<html> Hello there Network Admin! <br/> In order to help you, please select any of the following options: </html>", SwingConstants.CENTER);
        TitlePanel.add(title_label);

        JPanel BodyPanel = new JPanel(new BorderLayout());
        BodyPanel.setBorder(new EmptyBorder(2, 3, 2, 3));

        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel btnPanel = new JPanel(new GridLayout(10, 1, 10, 5));

        JButton subnetcal_button = new JButton("[1] Subnet Calculator");
        JButton addressclass_button = new JButton("[2] Check Address Class");
        JButton addresstype_button = new JButton("[3] Check Address Type");
        JButton exit_button = new JButton("[4] Exit");
        btnPanel.add(subnetcal_button);
        btnPanel.add(addressclass_button);
        btnPanel.add(addresstype_button);
        btnPanel.add(exit_button);

        layout.add(btnPanel);
        BodyPanel.add(layout, BorderLayout.CENTER);

        Mainframe.getContentPane().add(BorderLayout.NORTH, TitlePanel);
        Mainframe.getContentPane().add(BorderLayout.CENTER, BodyPanel);
        Mainframe.setVisible(true);
    }
}
