package graphics;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridLayout1 {

	public static void main(String[] args) {
		new GridLayout1(); // this will run the constructor
	}

	JFrame window;

	GridLayout1(){
		window = new JFrame("Flow Layout");
		window.setSize(400,300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(); // create panel object
		panel.setBackground(Color.pink);
		
		panel.setLayout(new GridLayout(3,5));
		
		for(int i = 0; i<12; i++){
			panel.add(new JButton("Hello"));
		}
		
		window.add(panel);
		window.setVisible(true);
	}

}
