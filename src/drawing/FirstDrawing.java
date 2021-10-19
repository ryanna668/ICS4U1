//Useful Drawing Code
//Useful Drawing Code
//As done in class, Monday 18 Oct
package drawing;
import java.awt.BasicStroke;
//	ICS4U1
/* showing how to draw using Swing */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstDrawing {

	public static void main(String[] args) {
		new FirstDrawing();
	}

	//Global variables
	int panW = 800, panH = 800;
	

	FirstDrawing(){
		//setup JFrame
		JFrame window = new JFrame("Welcome To My Pastel Palette :)");		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawingPanel panel = new DrawingPanel();
		window.add(panel);
		window.pack(); 		//sets optimum size
		window.setLocationRelativeTo(null);  //center on screen
		window.setVisible(true);
	}

	class DrawingPanel extends JPanel {

		DrawingPanel() {
			//this controls the size ***
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.decode("#F4F4F4"));
		}

		//all drawing goes in here
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); //clear and set BGcolor

			//turn on antialias
			Graphics2D g2 = (Graphics2D) g; 
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			//dark green
			g2.setColor(Color.decode("#557571"));
			g2.drawRect (0, 600, 800, 100);
			g2.fillRect (0, 600, 800, 100);

			g2.drawOval(725, 20, 50,50);

			g2.setStroke(new BasicStroke(4));
			g2.drawOval(725, 100, 50,50);

			g2.fillOval(725, 180, 50,50);

			//clay colour
			g2.setColor(Color.decode("#D49A89"));
			g2.drawRect (0, 500, 800, 100);
			g2.fillRect (0, 500, 800, 100);

			g2.setStroke(new BasicStroke(1));
			g2.drawOval(650, 20, 50,50);

			g2.setStroke(new BasicStroke(4));
			g2.drawOval(650, 100, 50,50);

			g2.fillOval(650, 180, 50,50);

			//peach colour
			g.setColor(Color.decode("#F7D1BA"));
			g2.drawRect (0, 400, 800, 100);
			g2.fillRect (0, 400, 800, 100);

			g2.setStroke(new BasicStroke(1));
			g2.drawOval(575, 20, 50,50);

			g2.setStroke(new BasicStroke(4));
			g2.drawOval(575, 100, 50,50);

			g2.fillOval(575, 180, 50,50);
			
			g.setColor(Color.decode("#F7D1BA"));
			g2.fillOval(10, 10, 50,50);
			
			g.setColor(new Color(212, 154, 137,70));
			g2.fillOval(35, 10, 50,50);
				

			//lines
			g2.setColor(Color.decode("#F7D1BA"));
			g2.setStroke(new BasicStroke(3));
			g2.drawLine(0,380,600,380);
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(0,360,500,360);
			g2.setStroke(new BasicStroke(1));
			g2.drawLine(0,340,400,340);

			//strings
			g2.setFont(new Font("Helvetica", Font.BOLD, 18));
			g.setColor(Color.decode("#D49A89"));
			g2.drawString( "That looks like a pastel version of the mastercard logo", 10,90);

			g2.setColor(Color.decode("#F7D1BA"));
			g2.drawString( "Have a great day", 10,120);

			g2.setColor(Color.decode("#557571"));
			g2.drawString( "I hope you enjoy my colour palette", 10,150);
			
	
			
			
		}

	}	
}
