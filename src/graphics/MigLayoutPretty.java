package graphics;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import graphics.Event1.MyAL;
import net.miginfocom.swing.MigLayout;

public class MigLayoutPretty {

	JPanel mainPanel = new JPanel();

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

	JLabel Thanks = new JLabel("");

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

	JLabel termsLab = new JLabel("Do you agree with the Terms and Conditions?");

	MigLayoutPretty() {
		JFrame frame = new JFrame("UniverityApplication.com");
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
		mainPanel.add(fNameField, "split");

		//wrap keyword starts a new row (after this element)
		mainPanel.add(lNameField, "wrap");

		//align label triggers platform-specific label alignment
		mainPanel.add(cityLab, "align label, wrap");
		mainPanel.add(cityField, "wrap");
		cityLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		mainPanel.add(emailLab,"align label, wrap");
		mainPanel.add(emailField, "span"); //span keyword lets emailField use the rest of the row
		emailLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		mainPanel.add(provinceLab, "align label, wrap");
		mainPanel.add(provinceField, "span");
		provinceLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		mainPanel.add(applyLab, "align label, wrap");
		mainPanel.add(applyField, "gapbottom 20, span");
		applyLab.setFont(new Font("Times New Roman", Font.BOLD, 12)); 

		mainPanel.add(termsLab,"align left");
		termsLab.setFont(new Font("Times New Roman", Font.BOLD, 12));

		ButtonGroup G = new ButtonGroup();
		G.add(j1);
		G.add(j2);

		j1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		j2.setFont(new Font("Times New Roman", Font.BOLD, 12));

		mainPanel.add(j1);
		mainPanel.add(j2, "wrap, gapbottom 30");


		mainPanel.add(helpBttn, "align left, span");
		mainPanel.add(cancelBttn);
		mainPanel.add(submitBttn, "align right, span");

		helpBttn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cancelBttn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		submitBttn.setFont(new Font("Times New Roman", Font.BOLD, 12));

		mainPanel.add(Thanks);
		Thanks.setFont(new Font("Times New Roman", Font.ITALIC, 12));

		submitBttn.addActionListener(new MyAL()); 

	}

	class MyAL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// change background colour
			Thanks.setText("Thank you for filling out this application. Your response has been recorded.");


		}

	}


}






