//Kırmızı önde olduğu için mavinin üzerine çıkıyor.
package melodytiles2;

import java.awt.*;
import javax.swing.JPanel;


public class ProgressBars extends JPanel{
    private int skor1 = 0;
    private int skor2=0;

    public ProgressBars(){

    }
    public void setSkor(int skor1 ,int skor2){
        this.skor2 = skor2;
        this.skor1 = skor1;

    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(0,0,skor1/5,50);
        g.setColor(Color.BLUE);
        g.fillRect(200-skor2/5,0,skor2/5,50);

    }
}