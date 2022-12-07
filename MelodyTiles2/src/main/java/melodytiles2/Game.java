/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package melodytiles2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.Timer;


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
  
    
    
    
    public Game(MainScreen mainScreen) {
        initComponents();
        this.mainScreen = mainScreen;
    }
   
    public void initTimer(){
          dFormat = new DecimalFormat("00"); // see 00:00 instade of 0:0
          JTimer.setBounds(800, 100, 200, 100); // x, y, width, height (where it's gonna stay)
	  JTimer.setHorizontalAlignment(JLabel.CENTER); // Default is left, we want at center
          
        JTimer.setText("05:00");
        minute = 5;
        timer = new Timer(1000, new ActionListener() { // 1000 -> for one(1) second
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				
				JTimer.setText(ddMinute + ":" + ddSecond);
				
				if(second == -1) { //don't want to 0
					second = 59;
					minute--;
					
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
											
					JTimer.setText(ddMinute + ":" + ddSecond);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(JTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(287, 287, 287))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(JTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(72, 72, 72))
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
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
