
package melodytiles2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

public class Options extends javax.swing.JPanel {
    private MainScreen mainScreen ;

    /**
     * Creates new form Options
     */
    public Options(MainScreen mainScreen) {
        initComponents();
        this.mainScreen = mainScreen;

    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        MusicSlider = new javax.swing.JSlider();
        MuteSounds = new javax.swing.JCheckBox();
        BackButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(665, 479));

        jTextField1.setEditable(false);
        jTextField1.setText("Music");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        MusicSlider.setMajorTickSpacing(25);
        MusicSlider.setMaximum(6);
        MusicSlider.setMinimum(-80);
        MusicSlider.setMinorTickSpacing(15);
        MusicSlider.setPaintLabels(true);
        MusicSlider.setPaintTicks(true);
        MusicSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MusicSliderStateChanged(evt);
            }
        });

        MuteSounds.setText("Mute Sounds");
        MuteSounds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuteSoundsActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MuteSounds)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(MusicSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addGap(296, 296, 296))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MusicSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(MuteSounds)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void MusicSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MusicSliderStateChanged
        try {
            mainScreen.getMainMenu().ChangeVolumeMusic(MusicSlider.getValue());
            mainScreen.getMainMenu().setVolumeOfMusic(MusicSlider.getValue());
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }
      

        
    }//GEN-LAST:event_MusicSliderStateChanged

    private void MuteSoundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuteSoundsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MuteSoundsActionPerformed

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        // TODO add your handling code here:
       if(MuteSounds.isSelected()){
           mainScreen.getMainMenu().setIsOpen(false);
           
       } 
       mainScreen.setContentPane(mainScreen.getMainMenu());
       mainScreen.invalidate();
       mainScreen.validate();
       

    }//GEN-LAST:event_BackButtonMouseClicked

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BackButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JSlider MusicSlider;
    private javax.swing.JCheckBox MuteSounds;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
