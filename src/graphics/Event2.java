/*
 * Ryanna Luo
 * Oct 7, 2021
 * Two buttons that use the same ActionListeners
 */
package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Event2 implements ActionListener {

	//global variables here
	JFrame window;
	JPanel panel;
	JButton button;
	int numClicks = 0;

	public static void main(String[] args) {		
		new Event2();	
	}

	Event2(){
		//make JFrame...
		window = new JFrame("Event Demo");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set up panel
		panel = new JPanel();
		button = new JButton("Yes");
		button.addActionListener(this); //step 1 and 3

		JButton button2 = new JButton("Exit \u2996");
		button2.setActionCommand("Exit");
		button2.addActionListener(this);

		panel.add(button);
		panel.add(button2);
		window.add(panel);

		//make visible
		window.setVisible(true);
	}
	@Override

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("Exit")) {
			window.dispose();
		}

		if(e.getSource()==button) {
			// change background colour
			panel.setBackground(Color.decode("#FFE6F2"));

			// title change to # clicks
			numClicks++;
			window.setTitle("You have clicked the button: " + numClicks + " times!");
		}
	}
}

