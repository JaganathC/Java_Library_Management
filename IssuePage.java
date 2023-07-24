package Library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class IssuePage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	protected Object correctdetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssuePage frame = new IssuePage();
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
	public IssuePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("-----Book Issue Portal-----");
		lblNewLabel.setBounds(266, 25, 401, 43);
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		contentPane.add(lblNewLabel);
		
		JLabel student = new JLabel("Enter Student Username");
		student.setForeground(new Color(255, 255, 255));
		student.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		student.setBounds(117, 158, 285, 36);
		contentPane.add(student);
		
		username = new JTextField();
		username.setBounds(409, 151, 307, 43);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel studentpwd = new JLabel("Enter Student Password");
		studentpwd.setForeground(Color.WHITE);
		studentpwd.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		studentpwd.setBounds(117, 251, 285, 36);
		contentPane.add(studentpwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(410, 244, 306, 43);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		btnNewButton.setBounds(341, 354, 154, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentname = username.getText();
				char[] pw = passwordField.getPassword();
				String password = new String(pw);
				LibraryManagement lib = new LibraryManagement();
				lib.userLogin(studentname,password);
				
				
			}
		});
		
		
	}
}
