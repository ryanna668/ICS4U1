package graphics;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FirstGraphics {

	public static void main(String[] args) {
		new FirstGraphics(); // this will run the constructor
	}

	JFrame window;

	FirstGraphics(){
		window = new JFrame("Welcome");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(); // create panel object
		panel.setBackground(Color.pink);

		panel.add(new JLabel("Welcome"));
		JButton btn1 = new JButton("Okay");
		panel.add(btn1);

		window.add(panel);

		//the last thing you do normally
		window.setVisible(true);
	}
}
