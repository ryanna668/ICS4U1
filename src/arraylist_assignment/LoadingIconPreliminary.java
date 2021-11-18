package arraylist_assignment;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LoadingIconPreliminary implements ActionListener {

	int N = 5;
	int diameter = 18;
	double rotationRadius = (diameter/2)*5.5;
	double angle[] = new double[N];
	double xx[] = new double[N];
	double yy[] = new double[N];



	JFrame window;
	DrawingPanel panel;
	int panW = 600;
	int panH = panW;

	int laserLength = 40;
	double laserMovement = 0;

	Color colours[] = new Color []{
			Color.decode("#ff6161"), //new color
			Color.decode("#ffb359"), //new color
			Color.decode("#fbff6a"), //new color
			Color.decode("#8bff73"), //new color
			Color.decode("#4fefff"), //new color
			Color.decode("#5494ff"), //new color
			Color.decode("#7b66ff"), //new color
			Color.decode("#ff93ff"), //new color
	};

	Color dotColour;
	Timer timer;


	public static void main (String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoadingIconPreliminary();
			}
		});
	}



	public void generateStuff() {
		//calculate angles


		for (int i = 0; i < N; i++) {
			angle[i] = 360 - (360/N *i);
			//System.out.println(angle[i]);
		}
		System.out.println(" ");
		//calculate xx and yy
		for (int i = 0; i < N; i++) {
			xx[i] = panW/2 + rotationRadius*Math.sin(Math.toRadians(angle[i])) - (diameter/2); 
			//-(diameter/2) centres the system of dots on the screen

			yy[i] = panH/2 - rotationRadius*Math.cos(Math.toRadians(angle[i])) - (diameter/2);
		}

		dotColour = colours[(int)(Math.random()*colours.length)];

	}


	LoadingIconPreliminary() {

		window = new JFrame("Loading Icon");
		panel = new DrawingPanel();
		window.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		//rect[0].setFrame(xx[0],yy[0],diameter,diameter);

		generateStuff();

		//timer
		timer = new Timer (12, this);
		timer.start();


		window.pack();

		//window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);

	}

	class DrawingPanel extends JPanel {

		DrawingPanel() {
			this.setPreferredSize(new Dimension(panW,panH));
			this.setBackground(Color.decode("#2E2E2E"));
		}


		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON); 



			//draw lines

			g2.setColor(Color.white);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {	


					g2.drawLine((int)xx[i] + (diameter/2), (int)yy[i] + (diameter/2), (int)xx[j] + (diameter/2), (int)yy[j] + (diameter/2));

				}
			}


			/*
			g2.setColor(dotColour);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {	

					if (yy[j] - yy[i] < 0 && xx[j] - xx[i] > 0) {
						//System.out.println(Math.toDegrees((Math.atan( (yy[2] - yy[0]) / ((xx[2] - xx[0])))))	);
						g2.setStroke(new BasicStroke(4));
						g2.drawLine((int) (xx[i] + (diameter/2)), 
								(int) (yy[i] + (diameter/2)), 
								(int) (xx[i] + (50*Math.cos(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))), 
								(int) (yy[i] + (50*Math.sin(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))));
					}

					if (yy[j] - yy[i] > 0 && xx[j] - xx[i] < 0) {
						//System.out.println(Math.toDegrees((Math.atan( (yy[2] - yy[0]) / ((xx[2] - xx[0])))))	);
						g2.setStroke(new BasicStroke(4));
						g2.drawLine((int)xx[i] + (diameter/2), 
								(int)yy[i] + (diameter/2), 
								(int) (xx[i] + (50*-Math.cos(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))), 
								(int) (yy[i] + (50*-Math.sin(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))));
					}

					if (yy[j] - yy[i] > 0 && xx[j] - xx[i] > 0) {
						//System.out.println(Math.toDegrees((Math.atan( (yy[2] - yy[0]) / ((xx[2] - xx[0])))))	);
						g2.setStroke(new BasicStroke(4));
						g2.drawLine((int)xx[i] + (diameter/2), 
								(int)yy[i] + (diameter/2), 
								(int) (xx[i] + (50*Math.cos(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))), 
								(int) (yy[i] + (50*Math.sin(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))));
					}

					if (yy[j] - yy[i] < 0 && xx[j] - xx[i] < 0) {
						//System.out.println(Math.toDegrees((Math.atan( (yy[2] - yy[0]) / ((xx[2] - xx[0])))))	);
						g2.setStroke(new BasicStroke(4));
						g2.drawLine((int)xx[i] + (diameter/2), 
								(int)yy[i] + (diameter/2), 
								(int) (xx[i] + (50*-Math.cos(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))), 
								(int) (yy[i] + (50*-Math.sin(	(Math.atan( (yy[j] - yy[i]) / ((xx[j] - xx[i]))))	) + (diameter/2))));
					}

				}
			}
			 */

			//darw dot outlines
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(1));
			for (int i = 0; i < N; i++) {

				g2.fill(new Ellipse2D.Double(xx[i]-2, yy[i]-2, diameter+4, diameter+4));

				//g2.setColor(Color.white);

			}

			g2.setColor(dotColour);
			g2.setStroke(new BasicStroke(5)); 
			if (angle[0]<= 167) { //so lasers dont launch at very beginning of loop

			
				
				for (int i = 0; i < N; i++) {


					for (int j = 0; j < N; j++) {

						/**bottom left quadrant**/
						if (yy[j] - yy[i] < 0 && xx[j] - xx[i] > 0) {
						;
							if (yy[i]- Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) <= yy[j] + (diameter/2)) {


								if ((yy[i]) + (diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) <= yy[j]+(diameter/2)) {
									g2.drawLine((int) (xx[j]+(diameter/2)), 
											(int) (yy[j] +(diameter/2)), 
											(int) (xx[j]+(diameter/2)), 
											(int) (yy[j])+(diameter/2));
								}



							}

							else {
								g2.drawLine((int) (xx[i]+ Math.abs((laserLength*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) +(diameter/2)          + Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) ), 
										(int) (yy[i]- Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
										(int) (xx[i] + (diameter/2) + Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
										(int) ((yy[i]) + (diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))));
							}

						}


						/**top right quadrant**/


						if (yy[j] - yy[i] > 0 && xx[j] - xx[i] < 0) {


							if (yy[i] + Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) >= yy[j] + (diameter/2)) {


								if ((yy[i]) + (diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) >= yy[j]+(diameter/2)) {
									g2.drawLine((int) (xx[j]+(diameter/2)), 
											(int) (yy[j] +(diameter/2)), 
											(int) (xx[j]+(diameter/2)), 
											(int) (yy[j])+(diameter/2));
								}



							}

							else {
							g2.drawLine((int) (xx[i] - Math.abs((laserLength*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) +(diameter/2)          - Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) ), 
									(int) (yy[i] + Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
									(int) (xx[i] + (diameter/2) - Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
									(int) ((yy[i]) + (diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))));
							}



						}


						/**top left quadrant**/



						if (yy[j] - yy[i] > 0 && xx[j] - xx[i] > 0) {




							if (yy[i] + Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) >= yy[j] + (diameter/2)) {


								if ((yy[i]) + (diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) >= yy[j] +(diameter/2)) {
									g2.drawLine((int) (xx[j]+(diameter/2)), 
											(int) (yy[j] +(diameter/2)), 
											(int) (xx[j]+(diameter/2)), 
											(int) (yy[j])+(diameter/2));
								}



							}

							else {
							g2.drawLine((int) (xx[i]+ Math.abs((laserLength*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) +(diameter/2)          + Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) ), 
									(int) (yy[i]+ Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
									(int) (xx[i] + (diameter/2) + Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
									(int) ((yy[i]) + (diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))));

							}
						}





						/**bottom right**/


						if (yy[j] - yy[i] < 0 && xx[j] - xx[i] < 0) {






							if (yy[i]- Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) <= yy[j] + (diameter/2)) {


								if ((yy[i]) + (diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) <= yy[j]+(diameter/2)) {
									g2.drawLine((int) (xx[j]+(diameter/2)), 
											(int) (yy[j] +(diameter/2)), 
											(int) (xx[j]+(diameter/2)), 
											(int) (yy[j])+(diameter/2));
								}



							}

							else {
							g2.drawLine((int) (xx[i] - Math.abs((laserLength*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) ))) +(diameter/2)          - Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[0])/(xx[j]-xx[i]))) ))) ), 
									(int) (yy[i]- Math.abs((laserLength*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))+(diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
									(int) (xx[i] + (diameter/2) - Math.abs((laserMovement*Math.cos((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))), 
									(int) ((yy[i]) + (diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[j]-yy[i])/(xx[j]-xx[i]))) )))));
							}

						}

					}
				}


			}



			//draw dots
			for (int i = 0; i < N; i++) {

				g2.fill(new Ellipse2D.Double(xx[i], yy[i], diameter, diameter));
				//g2.setColor(Color.white);

			}

			//System.out.println(angle[0]);

			/*
			 * g2.drawLine (dot0 x position, dot0 y position, dot2
			 */

			//g2.drawLine((int)xx[0], (int)yy[0], (int)xx[0]+50, (int)yy[0] + 50);

			//angle of line
			// Math.atan( yy[2] - yy[0]/ (xx[2] - xx[0])

			//System.out.println(Math.toDegrees(Math.atan( (yy[2] - yy[0]) / ((xx[2] - xx[0])))));






			/*
				g2.setStroke(new BasicStroke(4));
				g2.drawLine((int)xx[0]+(diameter/2), (int)yy[0]+(diameter/2), (int)xx[2]+(diameter/2), (int)yy[2]+(diameter/2));
			 */










			//REFERENCE CODE

			/**bottom left quadrant**/

			/*

			if (yy[2] - yy[0] <= 0 && xx[2] - xx[0] >= 0) {


				g2.setStroke(new BasicStroke(4));
				g2.drawLine((int) (xx[0]+ Math.abs((50*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) +(diameter/2)          + Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) ), 
						(int) (yy[0]- Math.abs((50*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))+(diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) (xx[0] + (diameter/2) + Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) ((yy[0]) + (diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))));


			}
			 */

			/**top right quadrant**/

			/*
			if (yy[2] - yy[0] >= 0 && xx[2] - xx[0] <= 0) {


				g2.setStroke(new BasicStroke(4));
				g2.drawLine((int) (xx[0] - Math.abs((50*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) +(diameter/2)          - Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) ), 
						(int) (yy[0] + Math.abs((50*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))+(diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) (xx[0] + (diameter/2) - Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) ((yy[0]) + (diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))));



			}
			 */

			/**top left quadrant**/

			/*

			if (yy[2] - yy[0] >= 0 && xx[2] - xx[0] >= 0) {


				g2.setStroke(new BasicStroke(4));
				g2.drawLine((int) (xx[0]+ Math.abs((50*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) +(diameter/2)          + Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) ), 
						(int) (yy[0]+ Math.abs((50*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))+(diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) (xx[0] + (diameter/2) + Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) ((yy[0]) + (diameter/2) + Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))));

			}

			 */



			/**bottom right**/

			/*
			if (yy[2] - yy[0] <= 0 && xx[2] - xx[0] <= 0) {



				g2.setStroke(new BasicStroke(4));
				g2.drawLine((int) (xx[0] - Math.abs((50*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) +(diameter/2)          - Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) ))) ), 
						(int) (yy[0]- Math.abs((50*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))+(diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) (xx[0] + (diameter/2) - Math.abs((laserMovement*Math.cos((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))), 
						(int) ((yy[0]) + (diameter/2) - Math.abs((laserMovement*Math.sin((Math.atan((yy[2]-yy[0])/(xx[2]-xx[0]))) )))));

			}
			 */




			//System.out.println(    (xx[2] - xx[1])/Math.cos(Math.atan( (yy[2] - yy[0]) / ((xx[2] - xx[0])))));


			g2.setColor(Color.black);
			for (int i = 0; i < N; i++) {
				g2.drawString(""+(i+1), (int)xx[i]+7, (int)yy[i]+13);
			}

		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		//increase angle
		for (int i = 0; i < N; i++) {
			angle[i]--;
		}


		//update dot positions

		//alternate function transformations
		for (int i = 0; i < N-1; i++) {


			if (i%2 == 0) {
				xx[i] -= 2*Math.cos(Math.toRadians(angle[i]));
				yy[i] -= Math.sin(Math.toRadians(angle[i]));
			}
			else {
				xx[i] -= Math.cos(Math.toRadians(angle[i]));
				yy[i] -= 2*Math.sin(Math.toRadians(angle[i]));
			}


		}

		//make last one normal (for cooler effect)
		xx[N-1] -= 2*Math.cos(Math.toRadians(angle[N-1]));
		yy[N-1] -= 2*Math.sin(Math.toRadians(angle[N-1]));


		//change colour every rotation
		Color temp;
		if (angle[0]%360 == 0) {

			temp = dotColour;

			while (temp.equals(dotColour)) {
				dotColour = colours[(int)(Math.random()*colours.length)];
			}

		}

		if (angle[0] == 0) {
			for (int i = 0; i < N; i++) {
				angle[i] = 360 - (360/N *i);
				//System.out.println(angle[i]);
			}
		}


		laserMovement += 4;

		//make lasers fire multiple times
		if (angle[0]%167 == 0) {
			laserMovement = 0;
		}

		panel.repaint();

	}





}