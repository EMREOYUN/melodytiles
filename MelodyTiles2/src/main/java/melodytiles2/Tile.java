package melodytiles2;

import java.util.Random;

public class Tile {
    private int column; //sütün
    private int row; // satır
    public static int a = 1;

    public Tile() {
        Random random = new Random();
        column = random.nextInt(3) + 1;
        row = a;
        a++;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }
}
