package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This program demonstrates how to rotate a line ...
 * timers ...
 * @author tv30254
 * @date May 20, 2018
 * @version 1.1
 */

public class LoadingIcon implements KeyListener{

	/**
	 * main method that runs GUI in  Event-Dispatching thread for thread safety.
	 * <br> It makes a TimerRotate object. That's all. 
	 * 
	 */
	public static void main(String[] args) { 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LoadingIcon(); 
			}
		});
	}

	/****************
	 *  Variables   *
	 ****************/
	Rectangle rect = new Rectangle(200,200,100,100);
	int lineX = 200;
	int lineY = 200;
	//int panW = 800, panH = 700;
	
	//Window stuff
	/** constant for size of JFrame */
	static final int SIZE = 500;
	/** drawing panel object that does all graphics */
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer stuff
	Timer timer;
	private int t_speed = 5; //speed of timer repeats (ms)
	int t_pause = 1000;  //initial delay (ms)
	int time;       //just to display elapsed time. This should be compared with System.currentTimeMillis()

	//Other objects and variables
	Line line = new Line(100.0, 100.0, 300.0, 300.0); 

	double angle = Math.toRadians(0.005);


	/*****************************************
	 *   Set up the window (JFrame)           *
	 *   and initialize whatever you need to  *
	 *****************************************/
	LoadingIcon() {

		//all window stuff
		JFrame window = new JFrame("Loading...");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SIZE,SIZE);

		/***********************************************************
		 * This is how you get the monitor screen resolution size  *
		 * and make your program take up the whole screen.         *
		 ***********************************************************/
		// Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
		// window.setSize(fullScreen);

		window.setLocationRelativeTo(null);

		window.addKeyListener(this);
		window.add(mainPanel);
		window.setVisible(true);

		//all timer stuff (start after window is shown)
		timer = new Timer(t_speed, new TimerAL());
		timer.setInitialDelay(t_pause);
		timer.start();
		timer.setInitialDelay(0); //if we don't do this, then restarting the timer is delayed

	}

	/********************************************/
	/*  Inner class for Timer's ActionListener  */
	/********************************************/
	private class TimerAL implements ActionListener{

		/* Don't put a lot of code here. Instead call methods to do stuff */             
		@Override
		public void actionPerformed(ActionEvent e) {
			time++;
			angle = angle + Math.toRadians(1.0); 
			//line.rotate(angle);
			mainPanel.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			//put background colour here
			this.setBackground(Color.decode("#F4F4F4"));
		}

		// Draw object heres
		@Override
		public void paintComponent(Graphics g) {
			//super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			/******************/
			/* BEGIN ROTATING */
			/******************/
			
			// Rotating with a positive angle theta rotates points on the positive x axis toward the positive y axis,
			// exactly the same as in math, but here +y is down so the rotation goes in the opposite direction.
			g2.rotate(angle, line.cx, line.cy); 
			g2.setColor(Color.decode("#557571"));
			g2.setStroke(new BasicStroke(4));
			g2.drawLine(100,100,lineX,lineY );
			
			
			g2.setColor(new Color(212, 154, 137,70));
			g2.rotate(angle, line.cx, line.cy);  
			g2.fillRect(rect.x,rect.y, rect.width, rect.height);
			
			g2.drawLine(rect.x, rect.y, lineX,lineY);
			
			g2.drawLine(rect.x+rect.width, rect.y+rect.height, lineX,lineY);
			
			//g2.rotate(-angle, line.cx, line.cy);
			//g.drawString("TIME1=" + time*t_speed, 50,50);

			g2.dispose(); //only dispose of graphics objects that you have created
		}
	}

	//Event Listeners Here

	@Override
	public void keyPressed(KeyEvent e) {
		//Press any key to pause timer
		if (timer.isRunning()) {
			timer.stop();
		} else {
			timer.restart();
		}
	}

	@Override
	public void keyReleased (KeyEvent e) {}
	@Override
	public void keyTyped    (KeyEvent e) {}

}

