package scrabbleApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScrabbleApp {

	private JFrame frame;
	private JButton generateBtn;
	private JTextField inputText;
	private JScrollPane scrollPane;
	private JTextArea outputText;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleApp window = new ScrabbleApp();
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
	public ScrabbleApp() {
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
		
		inputText = new JTextField();
		inputText.setBounds(90, 45, 303, 26);
		frame.getContentPane().add(inputText);
		inputText.setColumns(10);
		
		JLabel title = new JLabel("Scrabble App");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(163, 17, 131, 16);
		frame.getContentPane().add(title);
		
		generateBtn = new JButton("Scrabble the Text");
		generateBtn.setBounds(141, 88, 153, 29);
		frame.getContentPane().add(generateBtn);
		
		JLabel inpLabel = new JLabel("Input Word");
		inpLabel.setBounds(18, 50, 87, 16);
		frame.getContentPane().add(inpLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 131, 438, 135);
		frame.getContentPane().add(scrollPane);
		
		outputText = new JTextArea();
		scrollPane.setViewportView(outputText);
	}
	
	/*This method is called when the generateBtn is called which calls the buildScrabble method 
	to build the output text panel. */
	private void outputBtn() {
		generateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buildScrabble();
            }
        });
    }
	
	
	/* The buildScrabble method gets the text input from user and gives out the many permutations of arrangements of the text given.*/
	private void buildScrabble() {
        Letters letters = new Letters(inputText.getText());


        if (!letters.checkLength()) {
        	outputText.setText("Error! String must be 7 characters or less!");
            return;
        }
        
        if (!letters.hasLetters()) {
        	outputText.setText("Error! You must only have letters!");
            return;
        }

        List<String> scrabbled = letters.createArray();
        outputText.setText(String.join(" ", scrabbled));
    }

}
