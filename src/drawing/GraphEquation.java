package drawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphEquation {
	
	int panW=900, panH=700;
	double xmin = -5.0;
	double xmax = 5.0;
	double ymin = -4.0;
	double ymax = 4.0;
	
	double xstep = (xmax-xmin)/panW;
	double ystep = (ymax-ymin)/panH;
	
	public static void main (String[]args) {
		new GraphEquation();
		
	}
	
	GraphEquation(){
		//set up JFrame
		JFrame window = new JFrame ("Graph Equations With Me :)");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		DrawingPanel panel = new DrawingPanel();
		
		window.add(panel);
		window.pack();
		
		window.setVisible(true);
	}
	
	
	
	class DrawingPanel extends JPanel{
		
		DrawingPanel(){
			
			//controls size
			this.setPreferredSize(new Dimension(panW,panH));
			this.setBackground(Color.pink);
		}
		
		@Override
		
		public void paintComponent(Graphics g) {
		
			super.paintComponent(g); //needed for background colour to paint
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			
			g.setColor(Color.white);
			
			int px=(int)(panW*(0-xmin)/(xmax-xmin));
			g.drawLine(px, 0, px, panH);
			
			int py=(int)(panH*(0-ymin)/(ymax-ymin));		
			py=panH-py;
			g.drawLine(0, py, panW, py);
			

				for(double x=xmin; x<xmax ; x+=xstep) {
					
					double y=x*x;
					g.setColor(Color.black);
					g2.setStroke(new BasicStroke(2));
					plotPt(x,y,g);
					
					y=x*x*x;
					g.setColor(Color.red);
					plotPt(x,y,g);
					
					y=Math.sin(x);
					g.setColor(Color.yellow);
					plotPt(x,y,g);
		
			}
			
		}
		
	}
	void plotPt(double x, double y, Graphics g) {
		//now convert x,y-pixels(px,py)
		
		int px = (int)(panW*(x-xmin)/(xmax-xmin));
		int py = (int)(panH*(y-ymin)/(ymax-ymin));
		
		py = panH - py;
		
		g.drawLine(px, py, px, py);
		
	}

}
