//Kırmızı önde olduğu için mavinin üzerine çıkıyor.

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBars{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 100);
        frame.getContentPane().setBackground(java.awt.Color.BLUE);
        JProgressBar pb = new JProgressBar();
        JProgressBar pb2 = new JProgressBar();
        pb.setOpaque(false);
        pb.setForeground(java.awt.Color.RED);
        pb.setBackground(java.awt.Color.PINK);;
        pb.setBounds(0,0,400,100);
        //pb.setBorder(new EmptyBorder(15, 15, 15, 15));
        pb2.setOpaque(false);
        //pb2.setForeground(new Color(0,0,0,0));
        pb2.setForeground(new Color(255,255,255,255));
        //pb2.setBorder(null);
        //pb2.setBounds(200,0,200,50);
        //pb2.setBorder(new EmptyBorder(15, 15, 15, 15));
        frame.add(pb);
        frame.add(pb2);
        frame.setVisible(true);
        int j;
        for (int i = 0; i <= 100; i++) {
            j = 100 - i;
            if (i == 100) {
                i = 0;
                j = 100;
            }
            pb.setValue(i);
            pb2.setValue(j);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}