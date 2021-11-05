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
import java.util.Iterator;

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


	final static Color COLOURGRID = (Color.decode("#ffffff"));	
	final static Color COLOURBACK = (Color.pink);

	final static int XX = 1;
	final static int OO = -1;
	final static int EMPTY = 0;

	//GLOBAL VARIABLES
	final static int WINW = 600;
	final static int WINH = 600;

	int [][]board = new int [GRID][GRID];
	JFrame frame = new JFrame();

	boolean turnX = true;




	public static void main(String[] args) {
		new TicTacToe();
	}

	TicTacToe() {	
		initGame();		
		createAndShowGUI();


	}


	//This will reset the board if you want to play again.
	//It will be called from the method that checks if you win. If the game is over, reset and then play again
	void initGame() {		
		//TBA		
	}

	void createAndShowGUI() {
		frame = new JFrame("Welcome to TicTacToe! Have Fun!");			
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
			g2.setStroke(new BasicStroke(2));

			for(int i=1; i < GRID; i++) {
				//horizontal
				g2.drawLine(i*boxW, 0, i*boxW, jpanH);

				//vertical
				g2.drawLine(0, i*boxH, jpanW, i*boxH);
			}



			//TODO draw all X and Os



			//Check every square in board[][] and draw an X or O there.
			//Try and resize the window while playing. Everything works. 
			g2.setStroke(new BasicStroke(4));
			g2.setColor(Color.decode("#ffffff"));

			for (int row = 0; row<GRID;row++) {
				for (int col = 0; col<GRID;col++) {
					if( (board[row][col]==XX)) {
						//draw an X
						g2.drawLine((col*boxW)+30,(row*boxH)+30,((col+1)*boxW)-30,(row+1)*boxH-30);
						g2.drawLine((col*boxW)+30, (row+1)*boxH-30, ((col+1)*boxW)-30, (row*boxH)+30);

						//g2.drawLine(((col+1)*boxW),row*boxH,col*boxW,(row+1)*boxH);

					}
					//draw O
					if( (board[row][col]==OO)) {
						//for drawing x is first, x is column

						g2.drawOval(col*boxW+25,row*boxH+25, boxW-50, boxH-50);
					}
				}
			}





		}



		//FIXME why does it take two clicks?

		//******************* MouseListener methods *****************//
		@Override
		public void mouseClicked(MouseEvent e) {

			int x = e.getX();
			int y = e.getY();
			
			boolean restart = true;
			int filled = 0;
			boolean keepwinning = true;
			boolean changetitle = true;



			//calculate which square you clicked on
			int col = x/boxW;
			int row = y/boxH;

			//TODO display mouse coords and grid square in title.
			if(changetitle) {
				frame.setTitle(x+ "," + y
						+ "  ("+ row + "," + col + ")"

						);
			}
			//how to check if click right mouse button
			//right click restarts the game
			if (e.getButton() == MouseEvent.BUTTON3) {
				//restart the game
				for(int p = 0; p<GRID; p++) {
					for(int q = 0; q<GRID; q++) {
						board[p][q]=0;
					}
				}

				frame.setTitle("Welcome to TicTacToe! Have fun!");
				keepwinning = true;
				changetitle = true;
<<<<<<< HEAD
				restart = true;
			}
			
			if(restart) {
				restart = false;
=======
				filled = 0;
>>>>>>> master
			}

			/*** put these in methods, maybe one master method ***/

final static playgame() { //what am i supposed to put here?
			//TODO Check if the square is empty
			if (board[row][col] != EMPTY)return;


			//TODO update board
			if(changetitle) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					if(turnX) {
						board[row][col] = XX;
					}
					else {
						board[row][col] = OO;

					}
					turnX=!turnX;
				}
			}

			//printBoard(); //debug

			//TODO check for the winner

			//check rows
			if(keepwinning) {
				for(int i = 0; i < 3; i++) {
					if(board[i][0]+ board[i][1] + board[i][2] == 3 || //rows
							board[0][i] + board[1][i] + board[2][i] == 3 || //columns
							board[0][0] + board[1][1]+ board[2][2] == 3 || // diagonal
							board[2][0] + board [1][1] + board[0][2] == 3) //diagonal
					{
						frame.setTitle("X wins!! Right click to restart :)");
						keepwinning = false;
<<<<<<< HEAD
						changetitle = false;
=======
						changetitle= false;
>>>>>>> master

					}
					else if(board[i][0] + board[i][1] + board[i][2] == -3 || 
							board[0][i] + board[1][i] + board[2][i] == - 3 ||
							board[0][0] + board[1][1]+ board[2][2] == -3 ||
							board[2][0] + board [1][1] + board[0][2] == -3) {
						frame.setTitle("O wins!! Right click to restart :)");
						keepwinning = false;
<<<<<<< HEAD
						changetitle = false;
=======
						changetitle= false;
>>>>>>> master
					}
				}

			}



			//TODO check for tie

			for (int r = 0; r<GRID;r++) {
				for (int c = 0; c<GRID; c++) {
					if (board[r][c] != EMPTY) {
						filled++;
					}
				}
			}
<<<<<<< HEAD
=======

			//frame.setTitle("#" + filled); //debugging
			if(changetitle) {
				if(filled == 45) {
					frame.setTitle("Tie!! Right click to restart :)");
					changetitle = false;
				}
			}
>>>>>>> master

			//frame.setTitle("#" + filled); //debug
				if(filled == 45) {
					frame.setTitle("Tie!! Right click to restart :)");
					changetitle = false;
				}
			
			//TODO change turn



			this.repaint();
			printBoard();

		}
		}



<<<<<<< HEAD
=======

>>>>>>> master
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