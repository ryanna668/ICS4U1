package image_practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ImagePractice extends JFrame{

	public static void main(String[] args) {
		new ImagePractice();
	}

	//This could be a BufferedImage
	Image imgBridge, imgAirplane;

	ImagePractice(){	

		this.setTitle("It's a plane!");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		JPanel grpanel = new GrPanel();
		grpanel.setBackground(new Color(20,50,100));

		String filename =  "bridge.jpeg"; //this is in a resource folder	
		String filename1 =  "Airplane_PNG_Clipart.png";
		imgBridge = loadImage(filename);
		imgAirplane = loadImage(filename1);

		this.add(grpanel,BorderLayout.CENTER);
		this.setVisible(true);
	}


	private class GrPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			if (imgBridge == null) return;
						

			//g.drawImage(imgFish, 0,0, null); //this would draw the fish at the top, left corner

			//Draw the fish at the right middle of the screen, normal size:
		

			//Flip the fish sideways:
			//if (image != null) g.drawImage(image, 100, 0, 0, 100,this); //does not work to flip the image

			//Only use the left half of the fish for the image
			//and flip it horizontally, and space it 15px from the top corner 	
			int spc = 15;
			g.drawImage(imgBridge, 0, 0, 600,400, null); 

			//Middle two fish. ABout half normal size. 
			//(1) upright				
			g.drawImage(imgAirplane, 200, 50, 200, 120, null); //y goes from 100 to 200 (half the size of the original)
	

		}
	}

	Image loadImage(String filename) {

		Image image = null;

		// Requires a / at the beginning of the filename
		URL imageURL = this.getClass().getResource("/" + filename); 

		// Filename must be relative (no / at beginning) 
		InputStream inputStr = ImagePractice.class.getClassLoader().getResourceAsStream(filename);

		//Method 1. URL using ImageIcon
		if (imageURL != null) {
			ImageIcon icon = new ImageIcon(imageURL);				
			image = icon.getImage();
		} else {
			JOptionPane.showMessageDialog(null, "An image failed to load: " + filename , "ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return image;
	}

}
