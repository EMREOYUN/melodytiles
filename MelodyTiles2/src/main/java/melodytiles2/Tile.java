package melodytiles2;

import java.util.Random;

public class Tile {
    private int bulunduğusütun;
    private int bulunduğusatır;
    public static int a = 1;

    public Tile() {
        Random random = new Random();
        bulunduğusütun = random.nextInt(3) + 1;
        bulunduğusatır = a;
        a++;
    }

    public int getBulunduğusatır() {
        return bulunduğusatır;
    }

    public void setBulunduğusatır(int bulunduğusatır) {
        this.bulunduğusatır = bulunduğusatır;
    }


    public int getBulunduğusütun() {
        return bulunduğusütun;
    }
}
