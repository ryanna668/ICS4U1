package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class MigLayout1 {

	public static void main(String[] args) {
		new MigLayout1();
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

	JButton submitBttn = new JButton("Submit");
	JButton cancelBttn = new JButton("Cancel");
	JButton helpBttn = new JButton("Help");



	MigLayout1() {
		JFrame frame = new JFrame("UniverityApplication.com");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		frame.add(buildMigDashboard());		
		frame.setSize(600, 500);
		frame.setBackground(Color.pink);
		frame.setResizable(true);
		frame.setLocationRelativeTo( null );
		frame.pack();
		frame.setVisible(true);

		submitBttn.setBackground(Color.yellow);
	}

	private JPanel buildMigDashboard() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		buildMiGForm(panel);
		return panel;
	}

	private void buildMiGForm(JPanel panel) {
		panel.add(titleLab, "span, center");
		panel.add(infoLab, "span, center, gapbottom 15");
		panel.add(nameLab, "align label");
		panel.add(fNameField);

		//wrap keyword starts a new row (after this element)
		panel.add(lNameField, "wrap");

		//align label triggers platform-specific label alignment
		panel.add(cityLab, "align label");
		panel.add(cityField, "wrap");

		panel.add(emailLab,"align label");
		panel.add(emailField, "span"); //span keyword lets emailField use the rest of the row

		panel.add(provinceLab, "align label");
		panel.add(provinceField, "span");

		panel.add(applyLab, "align label");
		panel.add(applyField, "span");

		//tag identifies the type of button
		panel.add(submitBttn, "span, split 3, sizegroup bttn");

		//sizegroups set all members to the size of the biggest member
		panel.add(cancelBttn, "sizegroup bttn");
		panel.add(helpBttn, "sizegroup bttn");


	}


}

