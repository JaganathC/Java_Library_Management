package Library;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRegister frame = new NewRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewRegister() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 731);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*****WELCOME TO ABCS LIBRARY *****");
		lblNewLabel.setBounds(88, 48, 648, 43);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRATION DETAILS");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 51));
		lblNewLabel_1.setBounds(248, 123, 346, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter User name");
		lblNewLabel_1_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(88, 227, 316, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ENTER VALID CONTACT NUMBER");
		lblNewLabel_1_2.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(88, 342, 316, 51);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SET PASSWORD");
		lblNewLabel_1_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(88, 461, 316, 51);
		contentPane.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(429, 235, 258, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(429, 350, 258, 43);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(427, 469, 258, 43);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		btnNewButton.setBounds(303, 586, 168, 51);
		contentPane.add(btnNewButton);
	}

}