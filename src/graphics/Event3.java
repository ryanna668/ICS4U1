/*
 * Ryanna Luo
 * Oct 7, 2021
 * One button that uses two different ActionListeners
 */

package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event3 {
	public static void main(String[] args) {

		new Event3();

	}
	//global variables here
	JFrame window;
	JPanel panel;
	int numClicks = 0;

	Event3(){
		//make JFrame...
		window = new JFrame("Event Demo");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set up panel
		panel = new JPanel();
		JButton button = new JButton("Yes");
		button.addActionListener(new MyAL()); //step 1 and 3
		button.addActionListener(new MyAL2());

		panel.add(button);
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


		}

	}

	class MyAL2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// title change to # clicks
			numClicks++;
			window.setTitle("You have clicked the button: " + numClicks + " times!");

			}
		}

	}

