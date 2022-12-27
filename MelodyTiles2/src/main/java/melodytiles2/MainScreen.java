
package melodytiles2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainScreen extends javax.swing.JFrame implements KeyListener {
    private MainMenu mainMenu = new MainMenu(this);
    private Options op =new Options(this);
    private Game game = new Game(this) ;
    private final Set<Integer> pressedKeys = new HashSet<>();
    private Piano piano1 = game.getPiano1();
    private Piano piano2 = game.getPiano2();
    

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public Options getOp() {
        return op;
    }

    public Game getGame() {
        return game;
    }

    
   
    public MainScreen() {

        initComponents();
        add(mainMenu);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        setContentPane(mainMenu);
        this.setVisible(true);
        this.setTitle("MelodyTiles2");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(665, 510));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    @Override
    public synchronized void keyTyped(KeyEvent e) {
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
        if (!pressedKeys.isEmpty()) {
            for (Iterator<Integer> it = pressedKeys.iterator(); it.hasNext(); ) {
                int a = it.next();
                if (a == KeyEvent.VK_A || a == KeyEvent.VK_S || a == KeyEvent.VK_D) piano1.control(a);
                else if (a == KeyEvent.VK_LEFT || a == KeyEvent.VK_DOWN || a == KeyEvent.VK_RIGHT) piano2.control(a);
            }
        }
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}


















































































































































































































































/*
p6ShdXnNm/+nfqCHAhyue4Vqw4P9y6P9LPV0xoEEOfs=
 */