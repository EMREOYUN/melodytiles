import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


class Tiles{
	public int x, y;

	public boolean black;

	public Tiles(int x, int y, boolean black) { //constructor
		this.x = x;
		this.y = y;
		this.black = black;
	}
	public int play;//piyano akış sağlamak için

	public boolean pointInTile(int x, int y) {
		int width = 0;
		int height = 0;

		return x > this.x * width && x < this.x * width + width && y > this.y * height && y < this.y * height + height;
	}
}

public class PianoFunctions implements ActionListener, KeyListener {
	
	public static PianoFunctions pf;

	public final static int tileWidth = 100, tileHeight = 300, column = 4, row = 3;

	public ArrayList<Tiles> tiles; //objects

	public Random random;
	
	public Render renderer; //to visualize

	public int score, delay;

	public boolean gameOver;

	public PianoFunctions()
	{
		JFrame frame = new JFrame();
		Timer timer = new Timer(20, this);

		renderer = new Render();
		random = new Random(); //Random random?

		frame.setSize(tileWidth * column, tileHeight * row);
		frame.add(renderer);
		frame.setVisible(true); //to be visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //to close the frame
		frame.addKeyListener(this);
		frame.setResizable(false);

		start();

		timer.start();
	}

	public void start()
	{
		score = 0;
		gameOver = false;
		tiles = new ArrayList<Tiles>();

		for (int x = 0; x < column; x++)
		{
			for (int y = 0; y < row; y++)
			{
				boolean beBlack = true;

				for (Tiles tile : tiles)
				{
					if (tile.y == y && tile.black)
					{
						beBlack = false;
					}
				}

				if (!beBlack)
				{
					tiles.add(new Tiles(x, y, false));
				}
				else
				{
					tiles.add(new Tiles(x, y, random.nextInt(2) == 0 || x == 2));
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) //timer
	{
		renderer.repaint();

		for (int i = 0; i < tiles.size(); i++)
		{
			Tiles tile = tiles.get(i);

			if (tile.play < 0)
			{
				tile.play += tileHeight / 5;
			}
		}

		delay++;
	}

	public void render(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, tileWidth * column, tileHeight * row);

		g.setFont(new Font("Arial Bold", 1, 100));

		if (!gameOver)
		{
			for (Tiles tile : tiles) //foreach loop
			{
				g.setColor(tile.black ? Color.BLACK : Color.WHITE); //ternary operation
				g.fillRect(tile.x * tileWidth, tile.y * tileHeight + tile.play, tileWidth, tileHeight);
				g.setColor(tile.black ? Color.WHITE : Color.BLACK);
				g.drawRect(tile.x * tileWidth, tile.y * tileHeight + tile.play, tileWidth, tileHeight);
			}	
		}
	}
	
	@SuppressWarnings("serial")
	class Render extends JPanel {//java.awt.Graphics, javax.swing.JPanel

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

		
				PianoFunctions.pf.render(g);
		}

	}
	

	public static void main(String[] args)
	{
		pf = new PianoFunctions();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}