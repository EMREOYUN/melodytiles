import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Main {

	JFrame window;
	JLabel counterLabel_fortimer;
	Font font_fortimer = new Font("Arial Bold", Font.PLAIN, 50);
	
	Timer timer;
	
	int second, minute;
	String ddSecond, ddMinute;
	
	DecimalFormat dFormat = new DecimalFormat("00"); // see 00:00 instade of 0:0
	
	public static void main(String[] args) {
		
		new Main(); // <- How you call in main
		
	}
	
	//---------------------------------------------------
	
	public Main() {
		
		window = new JFrame();
		window.setSize(1900,1000); //x, y
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //This is needed to close a window properly
		window.setLayout(null); //U can put component wherever u want
		
		counterLabel_fortimer = new JLabel("");
		counterLabel_fortimer.setBounds(800, 100, 200, 100); // x, y, width, height (where it's gonna stay)
		counterLabel_fortimer.setHorizontalAlignment(JLabel.CENTER); // Default is left, we want at center
		counterLabel_fortimer.setFont(font_fortimer);
		
		window.add(counterLabel_fortimer);
		window.setVisible(true); //true -> u can see this window
		
		counterLabel_fortimer.setText("05:00");
		minute = 5;
		Timer();
		timer.start(); // timer.start()	/ timer.stop()	
	}
	
	public void Timer() {
		timer = new Timer(1000, new ActionListener() { // 1000 -> for one(1) second
															@Override
															public void actionPerformed(ActionEvent e) {
				
																second--;
				
																ddSecond = dFormat.format(second);
																ddMinute = dFormat.format(minute);
				
																counterLabel_fortimer.setText(ddMinute + ":" + ddSecond);
				
																if(second == -1) { //don't want to 0
																	second = 59;
																	minute--;
					
																	ddSecond = dFormat.format(second);
																	ddMinute = dFormat.format(minute);
											
																	counterLabel_fortimer.setText(ddMinute + ":" + ddSecond);;
																}
																if(minute == 0 && second == 0) {
																	timer.stop();
																}
				
															}
													}
						);
		
	}
	
}
