/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package melodytiles2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;


/**
 *
 * @author Ahmet Engin
 */
public class Game extends javax.swing.JPanel {
    private MainScreen mainScreen ;
    private Timer timer;
    private Timer tick;
    private DecimalFormat dFormat ;
    private int second, minute;
    private String ddSecond, ddMinute;
    private ImageIcon Rock;
    private ImageIcon Paper;
    private ImageIcon Scissor;

    public Piano getPiano1() {
        return piano1;
    }

    public Piano getPiano2() {
        return piano2;
    }

    //private Renderer renderer = new Renderer();
   private  Piano piano1 =new PianoLeft();
   private Piano piano2  = new PianoRight();
   private ProgressBars pb = new ProgressBars();
    
    
    public Game(MainScreen mainScreen) {
        setBackground(Color.WHITE);
        this.setFocusable(true);
        this.requestFocus();
        Image reScaledIMage1 = new ImageIcon("Rock.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Rock = new ImageIcon(reScaledIMage1);
        Image reScaledIMage2 = new ImageIcon("paper.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Paper = new ImageIcon(reScaledIMage2);
        Image reScaledIMage3 = new ImageIcon("scissor.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        Scissor = new ImageIcon(reScaledIMage3);
        piano2.repaint();
        initComponents();
        this.mainScreen = mainScreen;
    }
   
    public void initTimer(){
          dFormat = new DecimalFormat("00"); // see 00:00 instade of 0:0
          JTimer.setBounds(800, 100, 200, 100); // x, y, width, height (where it's gonna stay)
	  JTimer.setHorizontalAlignment(JLabel.CENTER); // Default is left, we want at center
          
        JTimer.setText("05:00");
        minute = 5;
        second = 0;
        piano1.reset();
        piano2.reset();
        piano1.enabled = true;
        piano2.enabled = true;
        timer = new Timer(1000, new ActionListener() { // 1000 -> for one(1) second
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				
				JTimer.setText(ddMinute + ":" + ddSecond);
				Skor1Label.setText(piano1.getSkor()+"");
                Skorlabel2.setText(piano2.getSkor()+"");
                pb.setSkor(piano1.getSkor(),piano2.getSkor());
                pb.repaint();

				if(second == -1) { //don't want to 0
					second = 59;
					minute--;
					
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
											
					JTimer.setText(ddMinute + ":" + ddSecond);
                    Skor1Label.setText(""+piano1.getSkor());
				}
				if(minute == 0 && second == 0) {
                    if (piano1.getSkor() > piano2.getSkor()){
                        JOptionPane.showMessageDialog(null, "Player 1 won!");
                    }
                    else if (piano1.getSkor() < piano2.getSkor()){
                        JOptionPane.showMessageDialog(null, "Player 2 won!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Draw!");
                    }
                    returnMainMenu();
				}
			}
		});
        tick = new Timer(8, new ActionListener() { //125 ticks per second
            @Override
            public void actionPerformed(ActionEvent e) {
                Skor1Label.setText(piano1.getSkor()+"");
                Skorlabel2.setText(piano2.getSkor()+"");
                pb.setSkor(piano1.getSkor(),piano2.getSkor());
                pb.repaint();
                if (piano1.getSkor() + piano2.getSkor() == 10){
                    String timertext = JTimer.getText();
                    timer.stop();
                    //tick.stop();
                    piano1.enabled = false;
                    piano2.enabled = false;
                    JTimer.setText("<html>Rock<br>Paper<br>Scissors</html>");
                    waitForSelection();
                }
            }
        });
        timer.start();
        tick.start();
    }

    private void waitForSelection(){
        if (piano1.selection == 0 || piano2.selection == 0){
        }
        else if (rockPaperScissorsResult(piano1.selection, piano2.selection) == 0){
            piano1.selection = 0;
            piano2.selection = 0;
        } else {
            piano1.selection = 0;
            piano2.selection = 0;
            timer.start();
            //tick.start();
            piano1.enabled = true;
            piano2.enabled = true;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Piona1 = piano1;
        Piano2 = piano2;
        jPanel1 = pb;
        JTimer = new javax.swing.JLabel();
        Skorlabel2 = new javax.swing.JLabel();
        Skor1Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Rock1 = new javax.swing.JLabel();
        Paper1 = new javax.swing.JLabel();
        Scissor1 = new javax.swing.JLabel();
        Rock2 = new javax.swing.JLabel();
        Paper2 = new javax.swing.JLabel();
        Scissor2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(665, 479));

        JTimer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTimer.setText("jLabel1");
        JTimer.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                JTimerComponentAdded(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Skor1Label.setText("0");
        Piona1.setPreferredSize(new java.awt.Dimension(180, 291));


        javax.swing.GroupLayout Piona1Layout = new javax.swing.GroupLayout(Piona1);
        Piona1.setLayout(Piona1Layout);
        Piona1Layout.setHorizontalGroup(
            Piona1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        Piona1Layout.setVerticalGroup(
            Piona1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        Piano2.setPreferredSize(new java.awt.Dimension(180, 291));


        javax.swing.GroupLayout Piano2Layout = new javax.swing.GroupLayout(Piano2);
        Piano2.setLayout(Piano2Layout);
        Piano2Layout.setHorizontalGroup(
            Piano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        Piano2Layout.setVerticalGroup(
            Piano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );
        Skorlabel2.setText("0");
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        JTimer.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTimer.setText("jLabel1");
        JTimer.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                JTimerComponentAdded(evt);
            }
        });

        Skorlabel2.setText("jLabel1");

        Skor1Label.setText("jLabel1");

        jLabel1.setText("A");

        jLabel2.setText("S");

        jLabel3.setText("D");

        jLabel4.setText("◀");

        jLabel5.setText("▼");

        jLabel6.setText("▶");

        Rock1.setIcon(Rock);
        //Rock1.setText("jLabel7");

        Paper1.setIcon(Paper);
        //Paper1.setText("jLabel7");

        Scissor1.setIcon(Scissor);
        //Scissor1.setText("jLabel7");

        Rock2.setIcon(Rock);
        //Rock2.setText("jLabel7");

        Paper2.setIcon(Paper);
        //Paper2.setText("jLabel7");

        Scissor2.setIcon(Scissor);
        //Scissor2.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(Skor1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Skorlabel2)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Rock1)
                                .addGap(37, 37, 37)
                                .addComponent(Paper1)
                                .addGap(40, 40, 40)
                                .addComponent(Scissor1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Piona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(JTimer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jButton1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Piano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Rock2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(Paper2)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Scissor2)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Skor1Label)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Skorlabel2)
                                .addGap(11, 11, 11)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Piona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(JTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Scissor1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                    .addComponent(Paper1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Rock1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Piano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Scissor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rock2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(Paper2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTimerComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_JTimerComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_JTimerComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        returnMainMenu();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void returnMainMenu() {
        mainScreen.invalidate();
        mainScreen.setContentPane(mainScreen.getMainMenu());
        mainScreen.validate();
        timer.stop();
        tick.stop();
        mainScreen.getMainMenu().setBackgroundMusic();
    }

    private int rockPaperScissorsResult(int p1, int p2) {
        if (p1 == p2) {
            return 0;
        } else {
            if ((p1 == 1 && p2 == 2) || (p1 == 2 && p2 == 3) || (p1 == 3 && p2 == 1)) {
                piano1.skor = 0;
                return 1;
            } else {
                piano2.skor = 0;
                return 1;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTimer;
    private javax.swing.JLabel Paper1;
    private javax.swing.JLabel Paper2;
    private javax.swing.JPanel Piano2;
    private javax.swing.JPanel Piona1;
    private javax.swing.JLabel Rock1;
    private javax.swing.JLabel Rock2;
    private javax.swing.JLabel Scissor1;
    private javax.swing.JLabel Scissor2;
    private javax.swing.JLabel Skor1Label;
    private javax.swing.JLabel Skorlabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
