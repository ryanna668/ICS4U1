/*
 * Jacky Li
 * 2021/11/02
 * This program creates a loading icon where six squares are moving up, down, left, and right
 * as well as rotating at different speed which creates a visual effect. The icon will eventually
 * rotate back to its original position and start the whole process again. Button space is used to
 * stop the timer, hence stop the icon.
 */
package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Jacky implements KeyListener{

	public static void main(String[] args) { 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Jacky(); 
			}
		});
	}

	//variables
	//Window stuff
	/** constant for size of JFrame */
	static final int SIZE = 700;
	/** drawing panel object that does all graphics */
	DrawingPanel mainPanel = new DrawingPanel();

	//Timer stuff
	Timer timer;
	private int t_speed = 6; //speed of timer repeats (ms)
	int t_pause = 1000;  //initial delay (ms)
	int time;       //just to display elapsed time. This should be compared with System.currentTimeMillis()

	//Other objects and variables
	Rect rect[] = new Rect[6];
	Rect rect1[] = new Rect[6];

	Line line[] = new Line[6];
	Line line1[] = new Line[6];
	Line line2[] = new Line[6];


	String load = new String ("Loading");

	double angle[] = new double[6];

	int dots = 0;

	int trans[] = new int[6];

	double squarex1 = 200.0;
	double squarey1 = 120.0;
	double squareW = 80.0;

	boolean lineAppear = false;
	int r = (int)(Math.random()*255+1);
	int gr = (int)(Math.random()*255+1);
	int b = (int)(Math.random()*255+1);

	int r1 = (int)(Math.random()*255+1);
	int gr1 = (int)(Math.random()*255+1);
	int b1 = (int)(Math.random()*255+1);


	/*****************************************
	 *   Set up the window (JFrame)           *
	 *   and initialize whatever you need to  *
	 *****************************************/
	Jacky() {

		//all window stuff
		JFrame window = new JFrame("Timers");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(SIZE,SIZE);

		//declare variables values

		for (int x = 0; x<rect.length ; x++) {
			rect[x] = new Rect(squarex1, squarey1, squareW, squareW);
		}

		for (int x = 0; x<rect1.length ; x++) {
			rect1[x] = new Rect(squarex1, squarey1, squareW, squareW);
		}


		for (int x = 0; x<line.length ; x++) {
			line[x] = new Line(squarex1+squareW-20, squarey1+squareW-20, squarex1, squarey1);
		}

		for (int x = 0; x<line1.length ; x++) {
			line1[x] = new Line(squarex1, squarey1+squareW, squarex1+squareW, squarey1);
		}

		for (int x = 0; x<line1.length ; x++) {
			line2[x] = new Line(squarex1, squarey1, squarex1+squareW, squarey1+squareW);
		}


		for (int x = 0; x<angle.length ; x++) {
			angle[x] = Math.toRadians(0.00);
		}

		for (int x = 0; x<trans.length ; x++) {
			trans[x] = 127;
		}



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

			//transfer radians to degree to measure the exact angle
			double degree = Math.toDegrees(angle[0]);
			double degree1 = Math.toDegrees(angle[1]);
			double degree2 = Math.toDegrees(angle[2]);
			double degree3 = Math.toDegrees(angle[3]);
			double degree4 = Math.toDegrees(angle[4]);
			double degree5 = Math.toDegrees(angle[5]);
			time++;

			//before 40, 4 squares separately move up, down, left, and right
			if(time < 40) {
				rect[0].y1++;
				rect[1].y1--;
				rect[2].x1++;
				rect[3].x1--;

				rect1[0].y1++;
				rect1[0].x1++;
				rect1[1].y1--;
				rect1[1].x1--;
				rect1[2].y1++;
				rect1[2].x1--;
				rect1[3].y1--;
				rect1[3].x1++;
			}

			//move 4 squares to its original position
			else if (time > 40 && time < 80) {
				rect[0].y1--;
				rect[1].y1++;
				rect[2].x1--;
				rect[3].x1++;

				rect1[0].y1--;
				rect1[0].x1--;
				rect1[1].y1++;
				rect1[1].x1++;
				rect1[2].y1--;
				rect1[2].x1++;
				rect1[3].y1++;
				rect1[3].x1--;
			}

			//the first square start rotating
			if(time > 100) {
				lineAppear = true;
				//before certain degree, the rate of angle changes is 4 degree per time
				if(degree<540)
					angle[0] = angle[0] + Math.toRadians(4.0);

				//after 540 and 720, slow down the speed
				if (degree>540 && degree<720)
					angle[0] = angle[0] + Math.toRadians(1.0);
			}

			//second square start rotating
			if(time > 115) {
				//4 degree per time
				if(degree1<540 && degree<540)
					angle[1] = angle[1] + Math.toRadians(4.0);

				//when the first square slows down, it also slows down
				//before it finished 720, it will keep rotating
				if (degree>540 && degree1<720)
					angle[1] = angle[1] + Math.toRadians(1.0);
			}

			//third square
			if (time>130) {
				//4 degree per time
				if(degree2<540 && degree<540)
					angle[2] = angle[2] + Math.toRadians(4.0);

				//keep rotating
				if (degree>540 && degree2<720)
					angle[2] = angle[2] + Math.toRadians(1.0);
			}

			//fourth
			if (time>145) {
				if(degree3<540 && degree<540)
					angle[3] = angle[3] + Math.toRadians(4.0);

				if (degree>540 && degree3<720)
					angle[3] = angle[3] + Math.toRadians(1.0);
			} 

			//fifth
			if (time>160) {
				if(degree4<540 && degree<540)
					angle[4] = angle[4] + Math.toRadians(4.0);

				if (degree>540 && degree4<720)
					angle[4] = angle[4] + Math.toRadians(1.0);
			}

			//sixth
			if (time>175) {
				if(degree5<540 && degree<540)
					angle[5] = angle[5] + Math.toRadians(4.0);

				if (degree>540 && degree5<720)
					angle[5] = angle[5] + Math.toRadians(1.0);

			}

			//when all the squares return to its original position, reset all values
			if(time>750) {
				time = 0;
				lineAppear = false;
				angle[0] = Math.toRadians(0.00);
				angle[1] = Math.toRadians(0.00);
				angle[2] = Math.toRadians(0.00);
				angle[3] = Math.toRadians(0.00);
				angle[4] = Math.toRadians(0.00);
				angle[5] = Math.toRadians(0.00);
				for (int x = 0; x<trans.length ; x++) {
					trans[x] = 127;
				}
				r = (int)(Math.random()*255+1);
				gr = (int)(Math.random()*255+1);
				b = (int)(Math.random()*255+1);

				r1 = (int)(Math.random()*255+1);
				gr1 = (int)(Math.random()*255+1);
				b1 = (int)(Math.random()*255+1);		

			}

			//change the rate of the dots within the loading text
			if(time%20==0) {
				if(dots<3) {
					load = load + ".";
					dots++;
				}
				else {
					load = "Loading";
					dots = 0;
				}
			}
			//line.rotate(angle);
			mainPanel.repaint();



			//line.rotate(angle);
			mainPanel.repaint();
		}
	}


	private class DrawingPanel extends JPanel {

		//constructor
		DrawingPanel() {
			//put background colour here
			this.setBackground(Color.black);
		}

		/***************************/
		/*  Draw all objects here  */
		/***************************/
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clears the screen and repaints it

			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			/******************/
			/* BEGIN ROTATING */
			/******************/

			// Rotating with a positive angle theta rotates points on the positive x axis toward the positive y axis,
			// exactly the same as in math, but here +y is down so the rotation goes in the opposite direction.




			g2.setStroke(new BasicStroke(4));
			g2.setColor(new Color(r,gr,b,127));

			//all squares rotating based on the same point

			for (int i = 0; i<rect1.length ; i++) {
				g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
				rect[i].paint(g);
				g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
			}


			//rect1[] group
			g2.setColor(new Color(r1,gr1,b1,127));
			for (int i = 0; i<rect1.length ; i++) {
				g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
				rect1[i].paint(g);
				g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
			}


			if (lineAppear) {
				for(int i = 0; i<line.length ; i++) {
					g2.setColor(new Color(r,gr,b,trans[i]));
					g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					line[i].paint(g);
					g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);

					g2.setColor(new Color(r1,gr1,b1,trans[i]));
					g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					line1[i].paint(g);
					g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					g2.rotate(angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
					line2[i].paint(g);
					g2.rotate(-angle[i], squarex1+squareW-squareW/4, squarey1+squareW-squareW/4);
				}
			}

			for (int i = 0 ; i<trans.length ; i++) {
				double check = Math.toDegrees(angle[i]);
				if(check>719) {
					trans[i] = 0;
				}
			}




			g.setColor(Color.white);
			g.drawString("TIME1=" + time*t_speed, 50,50);

			//print the loading text

			int loadx1 = (int)(squarex1);
			int loady1 = (int)(squarey1+2.5*squareW);

			g.setFont(new Font ("TimesRoman", Font.BOLD, 24));
			g.drawString(load, loadx1, loady1);

			/* OR: using an AffineTransform */

			//			AffineTransform transform = new AffineTransform();
			//			transform.rotate(angle, line.cx, line.cy);
			//			AffineTransform old = g2.getTransform();
			//			g2.transform(transform);
			//			line.paint(g);                        
			//			g2.setTransform(old);

			/******************/
			/*  END ROTATING  */
			/******************/





			g2.dispose(); //only dispose of graphics objects that you have created
		}
	}

	/****************************/
	/* All event listeners here */
	/****************************/

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