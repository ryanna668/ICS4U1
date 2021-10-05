package graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingGraphics {

	public static void main(String[] args) {
		new SwingGraphics(); 
	}

	//Constants
	//set the size of the drawing panel
	final static int panW = 800;
	final static int panH = 700;

	//Global variables
	GraphicsPanel panel;

	SwingGraphics(){
		JFrame window = new JFrame("Drawing on a JPanel");
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new GraphicsPanel();
		window.add(panel);  //defaults to BorderLayout.CENTER

		window.pack(); //needed in order to use the GraphicsPanel's size to set the JFrame size
		window.setLocationRelativeTo(null); //centre the window, must be after pack()

		window.setVisible(true); 	
	}

	private class GraphicsPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		GraphicsPanel(){
			this.setBackground(Color.white);
			this.setPreferredSize(new Dimension(panW, panH));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Do all your drawing here
			//red dot
			g.setColor(Color.red);
			g.drawLine(100, 50, 100, 50);

			//red line
			for(int x=100; x<150; x++) {
				g.drawLine(x, 60, x, 60);
			}

			//green circles
			for(int x=0; x<panW; x++) {
				for(int y = 0; y <panW; y++) {
					g.setColor(new Color(0, (x*x+y*y)%256,0));	
					g.drawLine(x, y, x, y);
				}
			}

			//red checker board
			for(int x=0; x<panW; x++) {
				for(int y = 0; y <panW; y++) {
					g.setColor(new Color((x^y)%256,0,0));	
					g.drawLine(x, y, x, y);
				}
			}
		}
	}
}
