package drawing;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/***********************************************
 This is the skeleton for a TicTacToe game using Swing.

 Look over this and see if you have any questions so far.

 We're going to start with just the graphics part.
 But we're also going to store the data. The data will be stored as a grid 
 or 2D array of integers. 

 For TicTacToe, it make sense to have empty = 0, and then X and O be +/- 1
 We'll see why later.
 */

public class TicTacToe {

	//CONSTANTS
	final static int GRID = 3;		//size of board & grid
	/*** you can set this to any size, but the winning only works for the top 3x3 corner ***/


	final static Color COLOURGRID = new Color(140, 140,140);	
	final static Color COLOURBACK = new Color(240, 240, 240);

	final static int XX = 1;
	final static int OO = -1;

	//GLOBAL VARIABLES
	final static int WINW = 600;
	final static int WINH = 600;

	int [][]board = new int [GRID][GRID];
	JFrame frame = new JFrame();
	


	public static void main(String[] args) {
		new TicTacToe();
	}

	TicTacToe() {	
		initGame();		
		createAndShowGUI();
		
		board[0][0] = XX;
		board[1][1] = OO;
		board[1][0] = XX;
	
	}

	//This will reset the board if you want to play again.
	//It will be called from the method that checks if you win. If the game is over, reset and then play again
	void initGame() {		
		//TBA		
	}

	void createAndShowGUI() {
		frame = new JFrame("TicTacToe");			
		Container content = frame.getContentPane();
		content.setBackground(Color.BLUE);
		content.setLayout(new BorderLayout(2,2));

		//setup top label & panel						


		//make main panel
		DrawingPanel gridPanel = new DrawingPanel();
		content.add(gridPanel, BorderLayout.CENTER);

		//finish setting up the frame
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 450);		
		frame.setLocationRelativeTo(null);  //must be AFTER setSize		
		frame.setVisible(true);

		//Once the panel is visible, initialize the graphics. 
		//*** This is no longer needed here since it's at the beginning of paintComponent()
		//gridPanel.initGraphics();

	}

	void printBoard() {
		for(int row=0; row<GRID; row++) {
			for(int col=0; col<GRID; col++){
				System.out.printf("%3d", board[row][col]);
			}
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		for (int i = 0; i < GRID*3 +2; i++) System.out.print("=");System.out.println();		
	}

	private class DrawingPanel extends JPanel implements MouseListener{

		//instance variables
		int jpanW, jpanH;	//size of JPanel
		int boxW, boxH;	//size of each square		

		//** Because the panel size variables don't get initialized until the panel is displayed,
		//** we can't do a lot of graphics initialization here in the constructor.
		DrawingPanel() {
			this.addMouseListener(this);
			setBackground(COLOURBACK);
		}

		//** WAS called by createAndShowGUI(), now from paintComponent()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	

			//TODO Find the size of each box in pixels.  Set boxW, boxH
			boxW = jpanW/GRID;
			boxH = jpanH/GRID;

		}

		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g); //needed for background colour to paint
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			initGraphics(); //needed if the window is resized.

			//TODO Draw grid
			g.setColor(COLOURGRID);	

			for(int i=1; i < GRID; i++) {
				//horizontal
				g2.drawLine(i*boxW, 0, i*boxW, jpanH);

				//vertical
				g2.drawLine(0, i*boxH, jpanW, i*boxH);
			}



			//TODO draw all X and Os

			
	
			//Check every square in board[][] and draw an X or O there.
			//Try and resize the window while playing. Everything works. 
			g.setColor(Color.RED);
			for (int row = 0; row<GRID;row++) {
				for (int col = 0; col<GRID;col++) {
					if( (board[row][col]==XX)) {
						//draw an X
						g.drawLine(boxW, boxH, boxH*row, boxW*col);
						g.drawLine(boxW*row, boxH, boxW, boxW*col);
			
					}
					if( (board[row][col]==OO)) {
						//for drawing x is first, x is column
						g.drawOval(col*boxW,row*boxH, boxW, boxH);
					}
				}
			}
			




		}





		//******************* MouseListener methods *****************//
		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			//calculate which square you clicked on
			int i,j;

			//TODO display mouse coords and grid square in title.
			frame.setTitle(x+ "," + y
					//+ "  ("+ row + "," + col + ")"
					
					);

			//how to check if click right mouse button
			if (e.getButton() == MouseEvent.BUTTON3) {
				//do something
			}

			/*** put these in methods, maybe one master method ***/


			//TODO Check if the square is empty


			//TODO update board


			//TODO check for the winner

			//TODO check for tie

			//TODO change turn


			this.repaint();
			printBoard();
		}	

		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

	} //end of DrawingPanel class

}