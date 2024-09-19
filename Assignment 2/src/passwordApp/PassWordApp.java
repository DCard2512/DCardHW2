package passwordApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PassWordApp {

	private JFrame frame;
	private JTextField input;
	private JButton pswrdBtn;
	private JTextArea passOutput;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassWordApp window = new PassWordApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PassWordApp() {
		initialize();
		outputBtn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel passwordLabel = new JLabel("Type Password");
		passwordLabel.setBounds(171, 45, 93, 16);
		frame.getContentPane().add(passwordLabel);
		
		input = new JTextField();
		input.setBounds(68, 73, 309, 26);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		pswrdBtn = new JButton("Check Password");
		pswrdBtn.setBounds(150, 111, 132, 29);
		frame.getContentPane().add(pswrdBtn);
		
		JLabel title = new JLabel("Password Strength");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(150, 6, 132, 16);
		frame.getContentPane().add(title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 182, 438, 67);
		frame.getContentPane().add(scrollPane);
		
		passOutput = new JTextArea();
		scrollPane.setViewportView(passOutput);
	}
	
	//Gets called when the button and calls buildPassword to give an output of information
	private void outputBtn(){
		pswrdBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				buildPassword();
			}
		});
		
	}
	
	private void buildPassword() {
		Password pass = new Password(input.getText());
		
		
		//The two if statements check if password is within character parameters or has no spaces
		if(!(pass.isLength())) {
			passOutput.setText("Error! Password must have 8 to 12 characters!");
			return;
		}
		if(pass.hasSpace()) {
			passOutput.setText("Error! Password must not have any spaces!");
			return;
		}
			

		//Checks if the password is weak or decent enough
		int maxBlock = pass.largestBlock();
		if(maxBlock <= 2) {
			passOutput.setText("The largest block in the password is " + maxBlock + ".\nThis is a decent password");
		}	
		else {
			passOutput.setText("The largest block in the password is " + maxBlock + ".\nThis passward can be made stronger by"
					+ " reducing this block by " + (maxBlock - 2) + ".");	
		}
				
				
	}
}
