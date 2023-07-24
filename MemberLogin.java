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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberLogin frame = new MemberLogin();
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
	public MemberLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 751);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("***** WELCOME TO ABCS LIBRARY *****");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
		lblNewLabel_1.setBounds(119, 44, 554, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("USER LOGIN PAGE");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 51));
		lblNewLabel_1_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(261, 121, 346, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setForeground(new Color(204, 204, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 246, 126, 49);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(371, 256, 236, 39);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(371, 389, 236, 39);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PASSWORD");
		lblNewLabel_1_2.setForeground(new Color(204, 204, 255));
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(150, 402, 135, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JButton Login = new JButton("LOGIN");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Login.setForeground(Color.BLACK);
		Login.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		Login.setBackground(new Color(255, 204, 204));
		Login.setBounds(271, 543, 181, 57);
		contentPane.add(Login);
	}

}