package animation;


/** This program demonstrates a cool and unusual effect that is done by flowlayout
 *  where coloured labels are added to a flowlayout and wrap around. 
 *  
 *  Author: ?? 2020??.  Updated by M. Harwood, Sept 2021
 *  */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlowingColour implements ActionListener {
	public static void main(String[] args) {
		new FlowingColour();		
	}

	JFrame window = new JFrame("Flowing Colours");
	int winW = 350, winH = 500;
	Timer timer;
	
	FlowingColour() {
		
		window.setSize(winW,winH);
		//window.setLocationRelativeTo(null); // Always sets it to the middle of the screen
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		for (int i=0; i < 20000; i++) {
			pnl1.add(pnl1, new ColourLabel());
		}
	
		window.add(pnl1);// Last ever thing to do
		window.setVisible(true);
		
		timer = new Timer(5, this); //Timers use ActionListener
		timer.start();

	}

	class ColourLabel extends JLabel {		
		ColourLabel() {
			this.setText(" ");			
			this.setBackground(ColourRainbow.getNextColour());
			this.setOpaque(true);
			//this.setAlignmentX(0.5f);
		}
	}

	//Run by ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		winW += 1;
		window.setSize(winW, winH);
		window.repaint();
		
	}
}
