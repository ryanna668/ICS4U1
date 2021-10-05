package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderLayoutExample {

	public static void main(String[] args) {

		new BorderLayoutExample();

	}
	BorderLayoutExample(){
		//setup JFrame
		JFrame window = new JFrame ("Border Layout Example");
		window.setSize(900,700);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//west panel
		JPanel panelW = new JPanel();
		panelW.setBackground(Color.pink);
		panelW.add(new JLabel("WEST PANEL"));
		window.add(panelW, BorderLayout.WEST);

		//North panel
		JPanel panelN = new JPanel();
		panelN.setBackground(Color.cyan);
		panelN.add(new JLabel("NORTH PANEL"));
		window.add(panelN, BorderLayout.NORTH);

		//East panel
		JPanel panelE = new JPanel();
		panelE.setBackground(Color.blue);
		panelE.add(new JLabel("EAST PANEL"));
		window.add(panelE, BorderLayout.EAST);

		//South panel
		JPanel panelS = new JPanel();
		panelS.setBackground(Color.YELLOW);
		panelS.add(new JLabel("SOUTH PANEL"));
		window.add(panelS, BorderLayout.SOUTH);

		//Center panel
		JPanel panelC = new JPanel();
		panelC.setBackground(Color.GRAY);
		//panelC.add(new JLabel("CENTER PANEL"));
		window.add(panelC, BorderLayout.CENTER);
		
		AddButtons(panelC);

		window.setVisible(true);
	}
	
	static void AddButtons(JPanel panelC){
		panelC.setLayout(new GridLayout(3,2,50,50));

		for(int i = 0; i<6; i++){
			panelC.add(new JButton("Hello"));

		}
	}
}
