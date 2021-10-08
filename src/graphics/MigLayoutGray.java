package graphics;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class MigLayoutGray{

	public static void main(String[] args) {
		new MigLayoutGray();
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
	
		

	public MigLayoutGray() {
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
		panel.setBackground(Color.decode("#EBEBEB"));
		
		panel.add(titleLab, "span, center");
		panel.add(infoLab, "span, center, gapbottom 15");
		panel.add(nameLab, "align label, wrap");
		panel.add(fNameField, "split");

		//wrap keyword starts a new row (after this element)
		panel.add(lNameField, "wrap");

		//align label triggers platform-specific label alignment
		panel.add(cityLab, "align label, wrap");
		panel.add(cityField, "wrap");

		panel.add(emailLab,"align label, wrap");
		panel.add(emailField, "span"); //span keyword lets emailField use the rest of the row

		panel.add(provinceLab, "align label, wrap");
		panel.add(provinceField, "span");

		panel.add(applyLab, "align label, wrap");
		panel.add(applyField, "gapbottom 20, span");
		 
		panel.add(termsLab,"align left");
		
		ButtonGroup G = new ButtonGroup();
		G.add(j1);
		G.add(j2);
		
		panel.add(j1);
		panel.add(j2, "wrap, gapbottom 30");
		
	
		//sizegroups set all members to the size of the biggest member
		panel.add(helpBttn, "align left, span");
		panel.add(cancelBttn);
		
		
		//tag identifies the type of button
				panel.add(submitBttn, "align right, span");


	}


}

