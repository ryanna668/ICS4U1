/*
 * Ryanna Luo
 * Oct 7, 2021
 * Two buttons that use two different ActionListeners
 */

package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event1 {
	public static void main(String[] args) {

		new Event1();

	}
	//global variables here
	JFrame window;
	JPanel panel;
	int numClicks = 0;

	Event1(){
		//make JFrame...
		window = new JFrame("Event Demo");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set up panel
		panel = new JPanel();
		JButton button = new JButton("Yes");
		button.addActionListener(new MyAL()); //step 1 and 3

		JButton button2 = new JButton("Exit \u2996");
		button2.setActionCommand("Exit");
		button2.addActionListener(new MyAL2());

		panel.add(button);
		panel.add(button2);
		window.add(panel);

		//make visible
		window.setVisible(true);
	}

	//inner class
	//step 2 - "Implements" means "use the interface..."
	class MyAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// change background colour
			panel.setBackground(Color.decode("#FFE6F2"));

			// title change to # clicks

			numClicks++;
			window.setTitle("You have clicked the button: " + numClicks + " times!");

		}

	}

	class MyAL2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals("Exit")) {
				window.dispose();

			}
		}

	}
}
