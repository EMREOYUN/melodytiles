package melodytiles2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

public class Options extends javax.swing.JPanel {
    private MainScreen mainScreen ;
    public Options(MainScreen mainScreen) {
        initComponents();
        this.mainScreen = mainScreen;

    }

    //Componentleri dizer
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
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void MusicSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        try {
            mainScreen.getMainMenu().ChangeVolumeMusic(MusicSlider.getValue());
            mainScreen.getMainMenu().setVolumeOfMusic(MusicSlider.getValue());
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MuteSoundsActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {
        if(MuteSounds.isSelected()){
            mainScreen.getMainMenu().setIsOpen(false);
        } else {
            mainScreen.getMainMenu().setIsOpen(true);
        }
        mainScreen.setContentPane(mainScreen.getMainMenu());
        mainScreen.invalidate();
        mainScreen.validate();
        mainScreen.getMainMenu().setBackgroundMusic();
    }

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private javax.swing.JButton BackButton;
    private javax.swing.JSlider MusicSlider;
    private javax.swing.JCheckBox MuteSounds;
    private javax.swing.JTextField jTextField1;
}
