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

	Color pink = Color.decode("#FFE6F2");
	
	Event4() {
		//make JFrame
		window = new JFrame("Slider Program Yay");
		window.setSize(300,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//make panel
		panel = new JPanel();
		panel.setBackground(Color.decode("#FFE6F2"));

		//make slider
		slider = new JSlider(0, 255, 100);
		slider.setMajorTickSpacing(40);
		//slider.setMinorTickSpacing(1);
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
		
		slider.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int v = ((JSlider)e.getSource()).getValue();
		 label1.setText("Value of the slider is: " + ((JSlider)e.getSource()).getValue()  );
		 Color c = new Color(Color.HSBtoRGB((227.0f/255), (v/255.0f), 1.0f));
		 panel.setBackground(c);
	}
}
	
	