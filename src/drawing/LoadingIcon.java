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


public class LoadingIcon implements KeyListener{

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
	//Rectangle rect[] = new Rectangle[4];

	int rw = 100;
	int rh = 100;

	Rectangle rect1 = new Rectangle(100,100, rw, rh);
	Rectangle rect2 = new Rectangle(300,100,rw, rh);
	Rectangle rect3 = new Rectangle(100,300,rw, rh);
	Rectangle rect4 = new Rectangle(300,300,rw, rh);


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
	private int t_speed = 10; //speed of timer repeats (ms)
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
			this.setBackground(new Color (20,20,20, 20));
		}





		@Override
<<<<<<< HEAD


		public void paintComponent(Graphics g) { 

=======
<<<<<<< HEAD
		public void paintComponent(Graphics g) {
=======
		public void paintComponent(Graphics g) { 
>>>>>>> master
>>>>>>> master
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			


			/******************/
			/* BEGIN ROTATING */
			/******************/

			// Rotating with a positive angle theta rotates points on the positive x axis toward the positive y axis,
			// exactly the same as in math, but here +y is down so the rotation goes in the opposite direction.
			//			//g2.rotate(angle, SIZE/2, SIZE/2); 
			//			g2.setColor(Color.decode("#557571"));
			//			g2.setStroke(new BasicStroke(4));
			//			g2.drawLine(100,100,lineX,lineY );


			//brown
			g2.setColor(Color.white);
			//g2.rotate(angle, rect1.width/2, rect1.height/2);
			g2.rotate(angle, 250 , 250);  
			g2.fillRect(rect1.x,rect1.y, rect1.width, rect1.height);

			//green
			//g2.setColor(new Color(100,255,100));
			//g2.rotate(angle, SIZE/2 , SIZE/2); 
			//g2.rotate(angle, 250 , 250);
			g2.fillRect(rect2.x,rect2.y, rect2.width, rect2.height);

			//pink
			//g2.setColor(new Color(255,100,100));
			//g2.rotate(angle, SIZE/2 , SIZE/2); 
			g2.fillRect(rect3.x,rect3.y, rect3.width, rect3.height);

			//grey
			//g2.setColor(new Color(100,100,100));
			//g2.rotate(angle, SIZE/2 , SIZE/2); 
			g2.fillRect(rect4.x,rect4.y, rect4.width, rect4.height);



			//g2.drawLine(rect.x, rect.y, lineX,lineY);

			//g2.drawLine(rect.x+rect.width, rect.y+rect.height, lineX,lineY);

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

