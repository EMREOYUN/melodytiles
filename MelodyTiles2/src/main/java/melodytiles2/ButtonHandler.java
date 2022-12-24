package melodytiles2;

import java.awt.event.*;

import javax.swing.*;

public class ButtonHandler implements ActionListener {
    private String user = "";
    private String computer = "Rock";
    JTextArea text = new JTextArea("Welcome to Rock Paper Scissors!");
    public void printButtons(JPanel panel){
        JButton button = new JButton("Rock");
        panel.add(button);
        JButton button2 = new JButton("Paper");
        panel.add(button2);
        JButton button3 = new JButton("Scissors");
        panel.add(button3);
        JButton button4 = new JButton("Enemy Rock");
        panel.add(button4);
        JButton button5 = new JButton("Enemy Paper");
        panel.add(button5);
        JButton button6 = new JButton("Enemy Scissors");
        panel.add(button6);
        text.setEditable(false);
        panel.add(text);
        // Add button handler
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String button = e.getActionCommand();
        this.processResult(button);
    }
    public void processResult(String button) {
        if (button.equals("Enemy Rock") || button.equals("Enemy Paper") || button.equals("Enemy Scissors")) {
            computer = button.substring(6);
            return;
        } else {
            user = button;
        }
        if (user.equals(computer)) {
            text.setText("It's a tie!");
        } else {
            if ((user.equals("Rock") && computer.equals("Paper")) || (user.equals("Paper") && computer.equals("Scissors")) || (user.equals("Scissors") && computer.equals("Rock"))) {
                text.setText("You lose!");
            } else {
                text.setText("You win!");
            }
        }
    }
}