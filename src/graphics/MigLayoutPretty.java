package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

public class MigLayoutPretty {

	public static void main(String[] args) {
		new MigLayoutColour();
		new MigLayoutPretty();
	}

	JLabel titleLab = new JLabel("University Application");
	JLabel infoLab = new JLabel ("Please fill out the application below :)");
	JLabel nameLab = new JLabel("Name:");
	JLabel cityLab = new JLabel("City:");
	JLabel provinceLab = new JLabel ("Province/State: ");
	JLabel emailLab = new JLabel("Email:");
	JLabel applyLab = new JLabel("Why are you the best fit for our school?: ");

	JTextField fNameField = new JTextField(10);
	JTextField lNameField = new JTextField(15);
	JTextField cityField = new JTextField(10);
	JTextField provinceField = new JTextField(10);
	JTextField emailField = new JTextField(20);
	JTextField applyField = new JTextField(25);
	

	JPanel buttonPanel = new JPanel();
	
	JButton submitBttn = new JButton("Submit");
	JButton cancelBttn = new JButton("Cancel");
	JButton helpBttn = new JButton("Help");
	
	
	
	JRadioButton j1 = new JRadioButton("yes"); 
	JRadioButton j2 = new JRadioButton("no"); 
	
	
	JLabel termsLab = new JLabel("Do you agree with the Terms and Conditions?");
	
		

	MigLayoutPretty() {
		JFrame frame = new JFrame("UniverityApplication.com");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		frame.add(buildMigDashboard());		
		//frame.setSize(600, 500);
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.pack();
		frame.setVisible(true);
		
		
		submitBttn.setBackground(Color.decode("#E6BECF"));
		cancelBttn.setBackground(Color.decode("#FFD9E4"));
		helpBttn.setBackground(Color.decode("#FFD9E4"));
		
		j1.setBackground(Color.decode("#FFE6F2"));
		j2.setBackground(Color.decode("#FFE6F2"));
	
		
	}
	
	void MigLayoutColour() {
		JFrame frame = new JFrame("UniverityApplication.com");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		frame.add(buildMigDashboard());		
		//frame.setSize(600, 500);
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.pack();
		frame.setVisible(true);
		
		
		submitBttn.setBackground(Color.decode("#C0B3C7"));
		cancelBttn.setBackground(Color.decode("#D9CED9"));
		helpBttn.setBackground(Color.decode("#D9CED9"));
		
		j1.setBackground(Color.decode("#EBEBEB"));
		j2.setBackground(Color.decode("#EBEBEB"));
		
		
		
	}


	private JPanel buildMigDashboard() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		buildMiGForm(panel);
		return panel;
	}

	private void buildMiGForm(JPanel panel) {
		panel.setBackground(Color.decode("#FFE6F2"));
		
		panel.add(titleLab, "span, center");
		titleLab.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		panel.add(infoLab, "span, center, gapbottom 15");
		infoLab.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		
		panel.add(nameLab, "align label, wrap");
		panel.add(fNameField, "split");

		//wrap keyword starts a new row (after this element)
		panel.add(lNameField, "wrap");

		//align label triggers platform-specific label alignment
		panel.add(cityLab, "align label, wrap");
		panel.add(cityField, "wrap");
		cityLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		panel.add(emailLab,"align label, wrap");
		panel.add(emailField, "span"); //span keyword lets emailField use the rest of the row
		emailLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		panel.add(provinceLab, "align label, wrap");
		panel.add(provinceField, "span");
		provinceLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		panel.add(applyLab, "align label, wrap");
		panel.add(applyField, "gapbottom 20, span");
		applyLab.setFont(new Font("Times New Roman", Font.BOLD, 12)); 
		
		panel.add(termsLab,"align left");
		termsLab.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		ButtonGroup G = new ButtonGroup();
		G.add(j1);
		G.add(j2);
		
		j1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		panel.add(j1);
		panel.add(j2, "wrap, gapbottom 30");
		
	
		panel.add(helpBttn, "align left, span");
		panel.add(cancelBttn);
		panel.add(submitBttn, "align right, span");
		
		helpBttn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cancelBttn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		submitBttn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
			


	}


}

