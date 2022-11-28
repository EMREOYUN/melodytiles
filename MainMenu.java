import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MainMenu extends JPanel implements ActionListener  {
    static protected JButton button;

    public MainMenu() {
        button = new JButton("Start Timer");
        button.setVerticalTextPosition(AbstractButton.BOTTOM);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setMnemonic(KeyEvent.VK_S);
        button.setActionCommand("startTimer");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(200, 100));
        button.setLocation(800, 100);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("startTimer")) {
            TimerFunction timer = new TimerFunction();
		    timer.TimerMain();
        }
    }

    private static void printUI() {
        JFrame frame = new JFrame("Main Menu");
        //frame.setSize(1900,1000);
        //frame.setPreferredSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.setResizable(false);
        MainMenu panel = new MainMenu();
        panel.setOpaque(true);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void printMainMenu() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                printUI(); 
            }
        });
    }
}
