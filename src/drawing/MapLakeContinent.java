/*
 * Ryanna Luo
 * Nov 29, 2021
 * MapLakeContinent Program 
 * I finished all questions (#1-4)
 * Land is clumped into continents or completely random scattered land, lakes form when clicked, oceans form when clicked and it hits the edge of the screen.
 */


package drawing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Starting class for MapContinent program

public class MapLakeContinent
{
	public static void main(String[] args) {
		new MapLakeContinent();
	}

	//constants	
	final static int GRID = 35; //size of grid/board
	final static int SQSIZE = 20; // size of each square in pixels
	final static int NUM_LAND = (GRID * GRID /2); //number of land tiles

	//terrain
	final static int EMPTY = 0;		//constant for empty tile. This is the terrain that needs to be a specific value (since arrays are initialized to zero)
	final static int LAND = 1;		//contant for land tile
	final static int LAKE = 33;		//this is just any number used for LAKE and OCEAN
	final static int OCEAN = 89;

	//colours: you can change these
	final static Color COLOURBACK = new Color(242,242,242);	
	final static Color COLOUREMPTY = new Color(222,222,222);
	final static Color COLOURLAND = new Color(100,200,100);
	final static Color COLOURLAKE = new Color(100,100,255);
	final static Color COLOUROCEAN = new Color(10,10,130);

	//global variables
	int[][] board = new int[GRID][GRID];

	MapLakeContinent() {	//constructor
		initGame();
		createAndShowGUI();
	}

	//When half of the squares are land, the land is scattered quite a lot into little islands.
	//Make a random map that has the land in bigger chunks. (makeContinents)
	void initGame() {		
		//clear board
		for (int i=0;i<GRID;i++) {
			for (int j=0;j<GRID;j++) {
				board[i][j]=EMPTY;
			}
		}

		//pick and choose :)
		//makeRandomMap();
		makeContinents();
	}



	void makeRandomMap() {
		int i,j;
		i=j=0;
		//boolean done = false;
		//int landTiles = 0;

		//Make an equal number of land and water squares, but make sure that the land is randomly distributed.


		for (i = 0 ; i<GRID; i++) {
			for(j = 0; j <GRID; j++) {
				int rand = (int) (Math.random()*100+1);
				if(rand>50) {
					board[i][j] = LAND;
				}
			}
		}
	}
	void makeContinents(){

		int i,j;

		for (i = 0 ; i<GRID; i++) {
			for(j = 0; j <GRID; j++) {
				int rand = (int) (Math.random()*100+1);
				if(rand>80) {
					board[i][j] = LAND;
					Continents(i,j);
				}
			}
		}
	}

	void Continents(int x, int y) {
		int rand = (int) (Math.random()*100+1);

		if(rand>70) {
			if(board[x][y] == LAND) {

				//right
				if(x+1<GRID && board[x+1][y]==EMPTY) {
					board[x+1][y]=LAND;
					Continents(x+1, y);
				}

				//left
				if(x-1>=0 && board[x-1][y]==EMPTY ) {
					board[x-1][y]=LAND;
					Continents(x-1,y);
				}

				//down
				if( y+1 < GRID && board[x][y+1]==EMPTY) {
					board[x][y+1]=LAND;
					Continents(x,y+1);
				}

				//up
				if(y-1>=0 && board[x][y-1]==EMPTY) {
					board[x][y-1]=LAND;
					Continents(x,y-1);
				}
			}
		}
	}

	//Fix the function "findLakes()" so that it colours all empty squares that are adjacent to this one.
	//Once you have solved problem 2, now set things up so that if any part 
	//           of a lake touches the edge of the board it becomes an ocean.	
	void findLakes(int x, int y) {
		//call subroutine to colour in all contiguous lake squares

		// Edge check
		if (x == (GRID - 1) || x == 0 || y == (GRID - 1) || y == 0) {
			findOceans(x, y);
			return;
		}

		if (board[x][y] == EMPTY) {
			board[x][y] = LAKE;
		}

		if(board[x][y] == LAKE) {



			//right
			if(x+1<GRID && board[x+1][y]==EMPTY) {
				board[x+1][y]=LAKE;
				findLakes(x+1, y);
			}

			//left
			if(x-1>=0 && board[x-1][y]==EMPTY ) {
				board[x-1][y]=LAKE;
				findLakes(x-1,y);
			}

			//down
			if( y+1 < GRID && board[x][y+1]==EMPTY) {
				board[x][y+1]=LAKE;
				findLakes(x,y+1);
			}

			//up
			if(y-1>=0 && board[x][y-1]==EMPTY) {
				board[x][y-1]=LAKE;
				findLakes(x,y-1);
			}
		}
	}

	void findOceans(int x, int y){


		if (board[x][y] == EMPTY || board[x][y] == LAKE) {
			board[x][y] = OCEAN;
		}

		if(board[x][y] == OCEAN) {

			//right
			if(x+1<GRID && (board[x+1][y]==EMPTY || board[x+1][y] == LAKE)){
				board[x+1][y]=OCEAN;
				findOceans(x+1, y);
			}

			//left
			if(x-1>=0 && (board[x-1][y]==EMPTY || board[x-1][y] == LAKE)) {
				board[x-1][y]=OCEAN;
				findOceans(x-1,y);
			}

			//down
			if( y+1 < GRID && (board[x][y+1]==EMPTY || board[x][y+1] == LAKE)) {
				board[x][y+1]=OCEAN;
				findOceans(x,y+1);
			}

			//up
			if(y-1>=0 && (board[x][y-1]==EMPTY || board[x][y-1] == LAKE)) {
				board[x][y-1]=OCEAN;
				findOceans(x,y-1);
			}

		}
	}



	void createAndShowGUI() {
		DrawingPanel panel = new DrawingPanel();

		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Minesweeper Problem #1-4");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		// content.setLayout(new BorderLayout(2,2));	
		content.add(panel, BorderLayout.CENTER);		
		//frame.setSize(SCRSIZE, SCRSIZE); //may not be needed since my JPanel has a preferred size
		frame.setResizable(false);		
		frame.pack();
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);

		//once the panel is visible, initialize the graphics. (Is this before paintComponent is run?)
		panel.initGraphics();

	}

	class DrawingPanel extends JPanel	//inner class
	{		
		int jpanW, jpanH;
		int blockX, blockY;		

		public DrawingPanel() {
			setBackground(COLOURBACK);
			//Because the panel size variables don't get initialized until the panel is displayed,
			//we can't do a lot of graphics initialization here in the constructor.
			this.setPreferredSize(new Dimension(GRID*SQSIZE,GRID*SQSIZE));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);			
		}

		//** Called by createGUI()
		void initGraphics() {
			jpanW = this.getSize().width;		
			jpanH = this.getSize().height;	
			blockX = (int)((jpanW/GRID)+0.5);
			blockY = (int)((jpanH/GRID)+0.5);
			// System.out.println("init");
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Draw white grid
			g.setColor(Color.WHITE);
			for (int i=0;i<GRID;i++) {
				g.drawLine(blockX*i,0,blockX*i,jpanH);
				g.drawLine(0,blockY*i,jpanW,blockY*i);
			}

			for (int i=0;i<GRID;i++) {
				for (int j=0;j<GRID;j++) {
					colourRect(i,j,g);						
				}
			}			
		}

		void colourRect(int i, int j, Graphics g) {

			int terrain = board[i][j];

			if (terrain == EMPTY) {
				g.setColor(COLOUREMPTY);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == LAND) {
				g.setColor(COLOURLAND);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
			if (terrain == LAKE) {
				g.setColor(COLOURLAKE);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}
			if (terrain == OCEAN) {
				g.setColor(COLOUROCEAN);
				g.fillRect(blockX*i+1, blockY*j+1, blockX-2, blockY-2);
			}			
		}		

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				//calculate which square you clicked on
				int i = (int)  x/blockX;
				int j = (int) y/blockY;	// blockY/y

				//allow the right mouse button to toggle/cycle the terrain
				if (e.getButton() != MouseEvent.BUTTON1) {
					switch (board[i][j]) {
					case LAND:
						board[i][j] = EMPTY;
						break;
					default:
						board[i][j] = LAND;
					}
					repaint();
					return;
				}

				findLakes(i,j);								
				repaint();
			}		
		} //end of MyMouseListener class

	} //end of DrawingPanel class

}