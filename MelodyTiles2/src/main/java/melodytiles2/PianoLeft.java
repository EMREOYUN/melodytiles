package melodytiles2;

import java.awt.event.KeyEvent;

public class PianoLeft extends Piano{
    public PianoLeft(){
        super();
    }

    @Override
    public void control(int a) {
        int k = getTileList().get(0).getBulunduğusütun();
        if (k == 1){
            if (a == KeyEvent.VK_A){
                skor++;
                sound();
                repaint();
                update();
            }
        }
        if (k == 2){
            if (a == KeyEvent.VK_S){
                skor++;
                sound();
                repaint();
                update();
            }
        }
        if (k == 3){
            if (a == KeyEvent.VK_D){
                skor++;
                sound();
                repaint();
                update();
            }
        }

    }
}
