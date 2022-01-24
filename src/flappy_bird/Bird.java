package flappy_bird;

import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import image_practice.ImagePractice;

class Bird {

	int x, y, width, height;
	double vyDrop = 1;
	
	Image imgAirplane;
;
	
	Bird(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		
		imgAirplane = loadImage("Airplane_PNG_Clipart.png");
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

	public void paint(Graphics g) {
		//g.fillOval(x, y, width, height);
		g.drawImage(imgAirplane, x, y, width, height, null);
	}
}
