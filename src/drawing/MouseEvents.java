package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEvents implements MouseListener, MouseMotionListener {

	public static void main(String[] args) {
		new MouseEvents();
	}

	//Global variables
	DrawingPanel panel;
	int panW = 800, panH = 800;
	Rectangle box = new Rectangle(100,100,50,50);
	int mx, my; //mouse location

	MouseEvents(){
		//setup JFrame
		JFrame window = new JFrame("Drawing on JPanel");		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new DrawingPanel();

		//1. Begin to get mouse moving
		//2. Let MouseEvents implement MouseListener <- bottom choice

		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);

		window.add(panel);
		window.pack(); 		//sets optimum size
		window.setLocationRelativeTo(null);  //centre on screen
		window.setVisible(true);
	}

	class DrawingPanel extends JPanel {

		DrawingPanel() {
			//this controls the size ***
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.black);
		}

		//all drawing goes in here
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clear and set BGcolor
			g.setColor(Color.decode("#FFE6F2"));

			g.fillRect(box.x, box.y, box.width, box.height);

			g.setColor(Color.white);
			((Graphics2D) g).setStroke(new BasicStroke(2));
			g.drawLine(panW/2, panH/2, mx, my);

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//if you click inside the mouse
		if(box.contains(e.getPoint())) {
			panel.setBackground(Color.black);
			box.x=(int)(Math.random()*700+1);
			box.y=(int)(Math.random()*700+1);
			panel.repaint(); //DO NOT FORGET THIS!!
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		panel.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {}	

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}	
}