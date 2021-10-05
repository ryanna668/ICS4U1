/* Ryanna Luo 
 * Oct 4 2021
 * 1. check if all are green. If all 6 buttons are green display "All Systems Go!"
 * 2. check if there is one or more red. If any light is red, then display "Danger Error!"
 */

package general;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SystemCheck extends JFrame {
	static final int N = 10; // number of buttons

	//The main class just calls the constructor
	public static void main(String[] args) {
		new SystemCheck();
	}

	//label to indicate status
	JLabel lblStatus;
	//button to test status
	JButton btnTest;
	//array of buttons to display
	JButton[] btns = new JButton[N];
	// integer array to control status of each light.
	//0= green, 1 = orange, 2 = red
	int[] status = new int[N];

	/** sets up JFrame and JButtons
calls inner class ButtonListener.<br>
The ButtonListener is added to btnTest as well as btns[] */
	SystemCheck() {
		this.setTitle("System Check ...");
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel(new GridLayout(1,6,3,2));
		panel.setBackground(Color.pink);

		ButtonListener bl = new ButtonListener();
		for (int i=0; i < N; i++) {
			btns[i] = new JButton(""+i);
			btns[i].addActionListener(bl);
			setButtons("" + i);
			panel.add(btns[i]);
		}

		JPanel panel2 = new JPanel();
		btnTest = new JButton("TEST");
		btnTest.addActionListener(bl);
		lblStatus = new JLabel("nothing to report");
		lblStatus.setBackground(Color.WHITE);
		lblStatus.setOpaque(true);
		panel2.add(btnTest);
		panel2.add(lblStatus);
		this.add(panel,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/** inner class to implement ActionListener */
	private class ButtonListener implements ActionListener {

		/** method to handle button clicking.
  Calls: testButtons(), setButtons()
  @param e the actionEvent created when any button is clicked */
		public void actionPerformed (ActionEvent e) {
			if (e.getSource() == btnTest) {
				testButtons();
			} else {
				setButtons(e.getActionCommand());
			}		
		}
	}
	/**
Purpose: Changes the colours of the buttons based on the value of status[].
    Status[] is incremented each time that that button is clikced.
Called from: actionPerformed
@param  cmd The number on the button
	 */
	void setButtons(String cmd){
		int n = Integer.parseInt(cmd);
		status[n]++;
		if (status[n] > 2) status[n] = 0;
		switch (status[n]){
		case 0:
			btns[n].setBackground(Color.GREEN);
			break;
		case 1:
			btns[n].setBackground(Color.ORANGE);
			break;
		case 2:
			btns[n].setBackground(Color.RED);
			break;
			// default: 
			// 	status[n] = 0;
			// 	btns[n].setBackground(Color.GREEN);
		}		
		// testButtons();
	}

	/** TODO: 
	 * This is the method that needs to be written to test <br>
(a) if all the buttons are green (say "All systems go!")<br>
(b) if there are one or more reds (say "Danger error!")<br>
The code should be done by checking the value of status.
Do your best to use a FOR LOOP intead of having to check 6 individual buttons.
What if here were 200 buttons to check?

Called from: actionPerformed()	*/
	void testButtons(){
		lblStatus.setText("Waiting ...."); //this is the default message

		//1. check if all are green
		//If all 6 buttons are green display "All Systems Go!"
		for (int i=0; i< N; i++){
			if (status [i]==0){
				lblStatus.setText("All System Go!!");
			}
		}

		for (int i=0; i< N; i++){
			if (status [i]==1){
				lblStatus.setText("Waiting");
			}
		}
		//2. check if there is one or more red
		//If any light is red, then display "Danger Error!"
		for (int i=0; i< N; i++){
			if (status [i]==2){
				lblStatus.setText("Danger Error!");
			}
		}

	}
}
/* I didn't really understand any of this. It was all new to me. After many YouTube videos, friends helping and self study, I understand what is happening. 

Specific things I still don't really understand:
- a lot of the syntax (do we need to memorize it?)
- what exactly is boolean and do we need it for this?
- don't really understand the setButtons part */
