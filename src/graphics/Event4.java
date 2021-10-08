package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Event4 implements ChangeListener{

	JSlider slider;
	JFrame window;
	JPanel panel;
	JLabel label1;

	public static void main(String[] args) {
		new Event4();
	}

	Event4() {
		//make JFrame
		window = new JFrame("Slider Program Yay");
		window.setSize(500,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//make panel
		panel = new JPanel();
		panel.setBackground(Color.decode("#FFE6F2"));

		//make slider
		slider = new JSlider(0, 50, 0);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBackground(Color.decode("#FFE6F2"));
		
		//make label
		label1 = new JLabel("Slide!");
		
		//add stuff
		window.add(panel);
		
		panel.add(slider);
	
		
		//position stuff using border layout
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.decode("#FFE6F2"));
		panelN.add(label1);
		window.add(panelN, BorderLayout.NORTH);

		
		//set visibility
		window.setVisible(true);
		
		slider.addChangeListener(new ChangeListener() {
			
	            public void stateChanged(ChangeEvent e) {
	                label1.setText("Value of the slider is: " + ((JSlider)e.getSource()).getValue());
	            }
	        });
	}
}
	
	