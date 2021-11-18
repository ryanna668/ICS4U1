package animation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;


public class EndlessBall implements ActionListener {
	public static void main(String[] args) {
		new EndlessBall();
	}

	static final int PANW = 800;
	static final int PANH = 700;
	DrawingPanel panel = new DrawingPanel();
	Ball ball = new Ball(300,100,40,40);


	class Ball {
		//only add this line in if you do NOT extend Rectangle
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

	EndlessBall(){
		//setup Jframe
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );				

		frame.add(panel);

		frame.pack(); //let panel set the size
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);

		Timer timer = new Timer(10,this);
		timer.start();
	}

	void moveBall() {
		ball.x += ball.vx;
		//ball.y ++;

		if (ball.x+ball.width > PANW) {
			ball.x = 0;
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
		panel.repaint();


	}
}