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
    private DecimalFormat dFormat ;
    private int second, minute;
    private String ddSecond, ddMinute;

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

        this.setFocusable(true);
        this.requestFocus();

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
					timer.stop();
				}
			}
		});
        timer.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTimer = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Skor1Label = new javax.swing.JLabel();
        Piona1 = piano1;
        Piano2 = piano2;
        Skorlabel2 = new javax.swing.JLabel();
        jPanel1 = pb;

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

        Skor1Label.setText("jLabel1");

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

        Skorlabel2.setText("jLabel1");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(Skor1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(Skorlabel2)
                        .addGap(125, 125, 125))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Piano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(Piona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Skor1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Skorlabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Piano2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(73, 73, 73))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(128, Short.MAX_VALUE)
                    .addComponent(Piona1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTimerComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_JTimerComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_JTimerComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       mainScreen.setContentPane(mainScreen.getMainMenu());
       mainScreen.invalidate();
       mainScreen.validate();
       timer.stop();
       mainScreen.getMainMenu().setBackgroundMusic();
       
       
       
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTimer;
    private javax.swing.JPanel Piano2;
    private javax.swing.JPanel Piona1;
    private javax.swing.JLabel Skor1Label;
    private javax.swing.JLabel Skorlabel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
