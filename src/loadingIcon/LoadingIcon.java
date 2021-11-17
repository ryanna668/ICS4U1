/*
 * Ryanna Luo
 * Nov 17, 2021
 * Welcome to my loading icon. 
 * The boxes rotate and then collapse into each other.
 * The colour and window title change.
 */

package loadingIcon;

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

	int rw = 100;
	int rh = 100;

	Box rect1 = new Box(SIZE/4,SIZE/4,rw, rh);
	Box rect2 = new Box(SIZE*3/4,SIZE/4,rw, rh);
	Box rect3 = new Box(SIZE/4,SIZE*3/4,rw, rh);
	Box rect4 = new Box(SIZE*3/4,SIZE*3/4,rw, rh);

	int lineX = 200;
	int lineY = 200;

	int rand = (int) (Math.random()*5);
	String colors[] = new String [9];

	//Window stuff
	JFrame window = new JFrame();
	
	static final int SIZE = 600; //constant for size of JFrame
	DrawingPanel mainPanel = new DrawingPanel(); //drawing panel object that does all graphics

	//Timer stuff
	Timer timer;
	private int t_speed = 7; //speed of timer repeats (ms)
	int t_pause = 1000;  //initial delay (ms)
	int time;       //just to display elapsed time. This should be compared with System.currentTimeMillis()

	double angle = Math.toRadians(0);

	/*****************************************
	 *   Set up the window (JFrame)           *
	 *   and initialize whatever you need to  *
	 *****************************************/
	LoadingIcon() {

		//all window stuff
		window = new JFrame("Loading...");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(mainPanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.addKeyListener(this);
		window.setVisible(true);

		//colours
		//I set my own array of "random" colours because the completely auto generated random colours were really ugly
		colors[0]="#ffadad";
		colors[1]="#ffd6a5";
		colors[2]="#fdffb6";
		colors[3]="#caffbf";
		colors[4]="#9bf6ff";
		colors[5]="#a0c4ff";
		colors[6]="#bdb2ff";
		colors[7]="#ffc6ff";
		colors[8]="fffffc";

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
			double degree = Math.toDegrees(angle);
			if(degree<360) {
				angle = angle + Math.toRadians(1.0); 
			}
			//line.rotate(angle);
			mainPanel.repaint();

			if(degree>360) {

				move();
			}
		}
	}


	public void move() {

		//going in
		if(time<510) {

			rect1.x++;
			rect1.y++;

			rect2.x--;
			rect2.y++;

			rect3.x++;
			rect3.y--;

			rect4.x--;
			rect4.y--;
			
			window.setTitle("Loaded! What's the next colour going to be?");

		}

		//going out
		if(time>510 && time<660) {

			rect1.x--;
			rect1.y--;

			rect2.x++;
			rect2.y--;

			rect3.x--;
			rect3.y++;

			rect4.x++;
			rect4.y++;

		}

		//reset
		if(time>660) {

			time=0;
			angle=0;
			rand = (int) (Math.random()*5);
			window.setTitle("Loading...");
		}
	}

	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {

			this.setBackground(new Color (20,20,20,20));
			this.setPreferredSize(new Dimension(SIZE, SIZE));
		}

		@Override
		public void paintComponent(Graphics g) { 

			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 

			//for looking at angle and time if needed
			//g.drawString("ANGLE: " +angle, 10, 10);
			//g.drawString("TIME1=" + time*t_speed, 50,50);

			g2.rotate(angle, SIZE/2 , SIZE/2);  

			g2.setColor(Color.decode(colors[rand])); 
			
			g2.fillRect(rect1.x,rect1.y, rect1.width, rect1.height);
			g2.fillRect(rect2.x,rect2.y, rect2.width, rect2.height);
			g2.fillRect(rect3.x,rect3.y, rect3.width, rect3.height);
			g2.fillRect(rect4.x,rect4.y, rect4.width, rect4.height);

			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(rect1.x+rect1.height,rect1.y+rect1.width,rect4.x,rect4.y);
			g2.drawLine(rect2.x,rect2.y+rect3.height,rect3.x+rect3.width,rect3.y);

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

