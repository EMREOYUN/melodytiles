package melodytiles2;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;

public class MainMenu extends javax.swing.JPanel {
    private MainScreen mainScreen ;
            
    private AudioInputStream playButtonSound;
    private AudioInputStream OptionButtonSound;
    private AudioInputStream BackgrounSound;
    private ImageIcon MenuIcon;
    private Clip clip1;
    private Clip clip2;
    private Clip clip3;
    private boolean isOpen = true;
    private float volumeOfMusic = 6f;

    public MainMenu(MainScreen mainScreen) {
        setBackgroundMusic();
        initComponents();
        this.mainScreen = mainScreen;
        try {
             clip2 = AudioSystem.getClip();
             clip1 = AudioSystem.getClip();
        } catch (Exception e) {
            System.out.println("Hata var");
        }
        Image reScaledIMage = new ImageIcon("tree.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        MenuIcon = new ImageIcon(reScaledIMage);
        initComponents();
    }
    
    public void setBackgroundMusic(){
        try{
            if (isOpen) {
                //System.out.println(volumeOfMusic);
                BackgrounSound = AudioSystem.getAudioInputStream(new File("tree.wav"));
                clip3 = AudioSystem.getClip();
                clip3.open(BackgrounSound);
                clip3.start();
                clip3.loop(Clip.LOOP_CONTINUOUSLY);
                ChangeVolumeMusic(volumeOfMusic);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }
    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;//Bu müziği açık olup olmadığını kontrol etmek için kullandım
    }
    
    public void setVolumeOfMusic(float volumeOfMusic) {
        this.volumeOfMusic = volumeOfMusic;
    }
  
    
    public void ChangeVolumeMusic(float volume) throws LineUnavailableException, IOException{
        FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);  
        gainControl.setValue(volume);
    }

    private void initComponents() {
        Play = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Options = new javax.swing.JButton();
        Quit = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(665, 479));

        Play.setBackground(new java.awt.Color(0, 0, 0));
        Play.setForeground(new java.awt.Color(255, 255, 255));
        Play.setText("Play");
        Play.setAlignmentY(0.0F);
        Play.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Play.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Play.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PlayMouseEntered(evt);
            }
        });
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        jLabel2.setIcon(MenuIcon);
        jLabel2.setToolTipText("Eğer bilgisayarın varsa ve 25 yaşındaysan kesinlikle bu oyunu oynamalısın");

        Options.setText("Options");
        Options.setAlignmentY(0.0F);
        Options.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Options.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptionsMouseEntered(evt);
            }
        });
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });

        Quit.setBackground(new java.awt.Color(0, 0, 0));
        Quit.setForeground(new java.awt.Color(255, 255, 255));
        Quit.setText("Quit");
        Quit.setAlignmentY(0.0F);
        Quit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                QuitMousePressed(evt);
            }
        });
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Options)
                            .addComponent(Play)
                            .addComponent(Quit))))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Options, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }
    private void PlayMouseClicked(java.awt.event.MouseEvent evt) {
        clip3.close();
        mainScreen.setContentPane(mainScreen.getGame());
        mainScreen.invalidate();
        mainScreen.validate();
        mainScreen.getGame().initTimer();
    }

    private void PlayMouseEntered(java.awt.event.MouseEvent evt) {
        if(isOpen){
            try{
                playButtonSound =  AudioSystem.getAudioInputStream(new File("316899__jaz-the-man-2__do-stretched.wav").getAbsoluteFile());
                clip2 = AudioSystem.getClip();
                clip2.open(playButtonSound);
                clip2.start();
            } catch(Exception ex){
                System.out.println("Play Buttonunda hata meydana geldi");
                System.out.println(ex.getMessage());
            }
        }
    }

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void OptionsMouseEntered(java.awt.event.MouseEvent evt) {
        if(isOpen){
            try {
                OptionButtonSound =  AudioSystem.getAudioInputStream(new File("316903__jaz-the-man-2__la-stretched.wav").getAbsoluteFile());
                clip1 = AudioSystem.getClip();
                clip1.open(OptionButtonSound);
                clip1.start();

            } catch (Exception ex) {
                System.out.println("Option Buttonunda hata meydana geldi");
            }
        }

    }

    private void OptionsMouseClicked(java.awt.event.MouseEvent evt) {
        clip3.close();
        mainScreen.setContentPane(mainScreen.getOp());
        mainScreen.invalidate();
        mainScreen.validate();
    }

    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void QuitMousePressed(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private javax.swing.JButton Options;
    private javax.swing.JButton Play;
    private javax.swing.JButton Quit;
    private javax.swing.JLabel jLabel2;
}
