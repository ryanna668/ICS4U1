/*
 * Ryanna Luo
 * Nov 18, 2021
 * Graphics Test
 * 
 * Display a ball (filled circle) on the screen   [10]
Make the ball move horizontally from left to right [10]
When it goes off the right side of the screen, bring the ball back on on the left side [5]
Add another JPanel at the bottom of the JFrame and make it have a different background colour [5]
Add two buttons to this JPanel labelled "Pause" and "Reverse" [10]
When you click Pause: [15]
 the movement of the ball is paused
and the label on the button changes to "Resume"
When you click it again, the movement of the ball resumes
and the label is changed so that it says "Pause" again.
When you click "Reverse" [15]
the direction that the ball is moving reverses.
This means that when the ball goes off of the left edge, it reappears on the right edge of the screen.
Pause and resume should work no matter which direction the ball is moving.
Good form, variables, indenting, comments, efficient programming  [10
 */

package animation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class GraphicsTest implements ActionListener {
	public static void main(String[] args) {
		new GraphicsTest();
	}

	//global variables here
	static final int PANW = 500;
	static final int PANH = 300;
	DrawingPanel mainPanel = new DrawingPanel();
	Ball ball = new Ball(300,100,40,40);

	JButton buttonP;
	JButton buttonR;

	boolean move = true;

	class Ball {
		int x, y, width, height;
		int vx = 3;
		int vy = 2;

		Ball(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			width=w;
			height = h;
		}
	}

	GraphicsTest(){
		//setup Jframe
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );				

		frame.setTitle("Welcome To Ryanna's Endless Ball Program!");
		frame.add(mainPanel);

		//set up bottom panel
		JPanel panelB = new JPanel();
		panelB.setBackground(Color.pink);
		panelB.add(new JLabel("Click here! >>>"));
		frame.add(panelB, BorderLayout.SOUTH);

		//buttons
		buttonP = new JButton("Pause");
		buttonP.addActionListener(new MyAL());
		panelB.add(buttonP);

		JButton buttonR = new JButton("Reverse");
		buttonR.addActionListener(new MyAL2());
		panelB.add(buttonR);

		//timer
		Timer timer = new Timer(10,this);
		timer.start();

		frame.pack(); //let panel set the size
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
	}

	void moveBall() {

		if (move) {
			ball.x += ball.vx;


			if (ball.vx > 0 && ball.x > PANW) {
				ball.x = 0-ball.width; //-ball.width for smoother playback here (the ball does not flash to the other side)
			}

			else if (ball.vx < 0 && ball.x+ball.width < 0) {
				ball.x = PANW-ball.width; //-ball.width or it glitches here
			}
		}
	}


	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setPreferredSize(new Dimension (PANW, PANH));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(ball.x, ball.y, ball.width, ball.height);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		moveBall();
		mainPanel.repaint();
	}

	class MyAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Pause")) {
				buttonP.setText("Resume");
				move = false;

			}
			else if (e.getActionCommand().equals("Resume")) {
				ball.x += ball.vx;
				buttonP.setText("Pause");		
				move = true;
			}

		}
	}

	class MyAL2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			ball.vx = -ball.vx; //reverse direction

		}
	}
}


