package melodytiles2;

import java.awt.event.KeyEvent;

public class PianoLeft extends Piano{
    public PianoLeft(){
        super();
    }

    @Override
    public void control(int a) {
        if (enabled) {
            int k = getTileList().get(0).getBulunduğusütun();
            if (k == 1){
                if (a == KeyEvent.VK_A){
                    correct();
                } else if (a == KeyEvent.VK_S || a == KeyEvent.VK_D) {
                    wrong();
                }
            }
            if (k == 2){
                if (a == KeyEvent.VK_S){
                    correct();
                } else if (a == KeyEvent.VK_A || a == KeyEvent.VK_D) {
                    wrong();
                }
            }
            if (k == 3){
                if (a == KeyEvent.VK_D){
                    correct();
                } else if (a == KeyEvent.VK_A || a == KeyEvent.VK_S) {
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
