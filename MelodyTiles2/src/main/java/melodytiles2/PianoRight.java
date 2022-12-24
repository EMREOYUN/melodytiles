package melodytiles2;

import java.awt.event.KeyEvent;

public class PianoRight extends Piano{
    int index = 0;
    public PianoRight() {
        super();
        update();
        update();
        update();
    }

    @Override
    public void control(int a) {
        int k = getTileList().get(0).getBulunduğusütun();
        if (k == 1){
            if (a == KeyEvent.VK_LEFT){
                skor++;
                sound();
                repaint();
                update();
            }
        }
        if (k == 2){
            if (a == KeyEvent.VK_DOWN){
                skor++;
                sound();
                repaint();
                update();
            }
        }
        if (k == 3){
            if (a == KeyEvent.VK_RIGHT){
                skor++;
                sound();
                repaint();
                update();
            }
        }

    }
}
