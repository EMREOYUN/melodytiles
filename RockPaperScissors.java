import javax.swing.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setSize(1200, 80);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        ButtonHandler b = new ButtonHandler();
        b.printButtons(panel);
        frame.setVisible(true);
    }
}