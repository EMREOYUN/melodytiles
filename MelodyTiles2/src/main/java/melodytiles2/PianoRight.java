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
        if (enabled) {
            int k = getTileList().get(0).getBulunduğusütun();
            if (k == 1){
                if (a == KeyEvent.VK_LEFT){
                    correct();
                } else if (a == KeyEvent.VK_DOWN || a == KeyEvent.VK_RIGHT) {
                    wrong();
                }
            }
            if (k == 2){
                if (a == KeyEvent.VK_DOWN){
                    correct();
                } else if (a == KeyEvent.VK_LEFT || a == KeyEvent.VK_RIGHT) {
                    wrong();
                }
            }
            if (k == 3){
                if (a == KeyEvent.VK_RIGHT){
                    correct();
                } else if (a == KeyEvent.VK_LEFT || a == KeyEvent.VK_DOWN) {
                    wrong();
                }
            }
        }
    }
    @Override
    protected void rpscontrol(int a){
        switch (a) {
            case KeyEvent.VK_A:
                selection = 1;
                break;
            case KeyEvent.VK_S:
                selection = 2;
                break;
            case KeyEvent.VK_D:
                selection = 3;
                break;
            default:
                break;
        }
    }
}
