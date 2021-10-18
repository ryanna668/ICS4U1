/*
 * Ryanna Luo
 * Oct 8, 2021
 * This program is a simple university application form. 
 * The fonts, colours and format are all customized.
 * There is a separate class called MigLayoutGray that has no customization of the fonts and colours.
 * The three buttons all work and have different actions.
 */
package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class MigLayoutPretty {

	JPanel mainPanel = new JPanel();
	JFrame frame = new JFrame();

	Font fontp = new Font("Times New Roman", Font.PLAIN, 12);
	Font fontb = new Font("Times New Roman", Font.BOLD, 12);;

	public static void main(String[] args) {
		new MigLayoutGray(); //separate class
		new MigLayoutPretty();
	}

	JLabel titleLab = new JLabel("University Application");
	JLabel infoLab = new JLabel ("Please fill out the application below :)");
	JLabel nameLab = new JLabel("Name:");
	JLabel cityLab = new JLabel("City:");
	JLabel provinceLab = new JLabel ("Province/State: ");
	JLabel emailLab = new JLabel("Email:");
	JLabel applyLab = new JLabel("Why are you the best fit for our school?: ");

	JLabel Thanks = new JLabel(" ");

	JTextField fNameField = new JTextField(10);
	JTextField lNameField = new JTextField(15);
	JTextField cityField = new JTextField(10);
	JTextField provinceField = new JTextField(10);
	JTextField emailField = new JTextField(20);
	JTextField applyField = new JTextField(25);

	JPanel buttonPanel = new JPanel();

	static JButton submitBttn = new JButton("SUBMIT");
	JButton cancelBttn = new JButton("Cancel");
	JButton helpBttn = new JButton("Help");

	JRadioButton j1 = new JRadioButton("yes"); 
	JRadioButton j2 = new JRadioButton("no"); 

	JLabel termsLab = new JLabel("Do you agree with our Terms and Conditions?");

	MigLayoutPretty() {
		frame = new JFrame("UniverityApplication.com");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		buildMigDashboard();
		frame.add(mainPanel);		
		//frame.setSize(600, 500);
		frame.setResizable(true);	
		frame.pack();
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);


		submitBttn.setBackground(Color.decode("#E6BECF"));
		cancelBttn.setBackground(Color.decode("#FFD9E4"));
		helpBttn.setBackground(Color.decode("#FFD9E4"));

		j1.setBackground(Color.decode("#FFE6F2"));
		j2.setBackground(Color.decode("#FFE6F2"));

	}

	private void buildMigDashboard() {
		mainPanel.setLayout(new MigLayout());

		mainPanel.setBackground(Color.decode("#FFE6F2"));

		mainPanel.add(titleLab, "span, center");
		titleLab.setFont(new Font("Times New Roman", Font.BOLD, 25));

		mainPanel.add(infoLab, "span, center, gapbottom 15");
		infoLab.setFont(new Font("Times New Roman", Font.ITALIC, 12));

		mainPanel.add(nameLab, "align label, wrap");
		nameLab.setFont(fontb);

		mainPanel.add(fNameField, "split");
		fNameField.setFont(fontp);

		//wrap keyword starts a new row (after this element)
		mainPanel.add(lNameField, "wrap");
		lNameField.setFont(fontp);

		//align label triggers platform-specific label alignment
		mainPanel.add(cityLab, "align label, wrap");
		mainPanel.add(cityField, "wrap");
		cityLab.setFont(fontb);
		cityField.setFont(fontp);

		mainPanel.add(emailLab,"align label, wrap");
		mainPanel.add(emailField, "span"); //span keyword lets emailField use the rest of the row
		emailLab.setFont(fontb);
		emailField.setFont(fontp);

		mainPanel.add(provinceLab, "align label, wrap");
		mainPanel.add(provinceField, "span");
		provinceLab.setFont(fontb);
		provinceField.setFont(fontp);

		mainPanel.add(applyLab, "align label, wrap");
		mainPanel.add(applyField, "gapbottom 20, span");
		applyLab.setFont(fontb);
		applyField.setFont(fontp);

		mainPanel.add(termsLab,"align left");
		termsLab.setFont(fontb);

		ButtonGroup G = new ButtonGroup();
		G.add(j1);
		G.add(j2);

		j1.setFont(fontb);
		j2.setFont(fontb);

		mainPanel.add(j1);
		mainPanel.add(j2, "wrap, gapbottom 30");


		mainPanel.add(helpBttn, "align left, span");
		mainPanel.add(cancelBttn);
		mainPanel.add(submitBttn, "span");

		helpBttn.setFont(fontp);
		cancelBttn.setFont(fontp);
		submitBttn.setFont(fontb);

		mainPanel.add(Thanks);
		Thanks.setFont(new Font("Times New Roman", Font.ITALIC, 12));

		submitBttn.addActionListener(new submitAL()); 
		cancelBttn.addActionListener(new cancelAL()); 
		helpBttn.addActionListener(new helpAL());
	}

	class submitAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Thanks.setText("Thank you. Your response has been recorded.");
		}

	}
	class cancelAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getActionCommand().equals("Cancel")) {
				frame.dispose();

			}
		}
	}
	class helpAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Thanks.setText("Please contact the school at university@gmail.com");

		}
	}

}

