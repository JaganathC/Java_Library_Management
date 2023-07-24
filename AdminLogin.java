package Library;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField unameField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminLogin() {
		setForeground(new Color(255, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Admin Username");
		lblNewLabel.setForeground(new Color(204, 204, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(200, 282, 200, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(204, 204, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(206, 410, 135, 24);
		contentPane.add(lblNewLabel_1);
		
		unameField = new JTextField();
		unameField.setBounds(394, 282, 236, 39);
		unameField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		contentPane.add(unameField);
		unameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(394, 395, 236, 39);
		passwordField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		contentPane.add(passwordField);
		
		lblNewLabel_2 = new JLabel("***** WELCOME TO ABCE LIBRARY *****");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26));
		lblNewLabel_2.setBounds(115, 50, 610, 39);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ADMIN LOGIN");
		lblNewLabel_3.setForeground(new Color(255, 255, 51));
		lblNewLabel_3.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26));
		lblNewLabel_3.setBounds(288, 160, 242, 33);
		contentPane.add(lblNewLabel_3);
		
		JButton Login = new JButton("LOGIN");
		Login.setForeground(new Color(0, 0, 0));
		Login.setBackground(new Color(255, 204, 204));
		Login.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Extract username and password here
				String username = unameField.getText();
				char[] pw = passwordField.getPassword();
				String password = new String(pw);
				
				//Validate username and password
				LibraryManagement lib = new LibraryManagement();
				boolean validate = lib.adminLogin(username, password);
				if(validate) {
					AdminUI Obj=new AdminUI();
					JOptionPane.showMessageDialog(null,"You have successfully logged in");
					Obj.setVisible(true);
					dispose();
					
				}
				else {
					System.out.println("Unsuccesful login!");
					JOptionPane.showMessageDialog(null,"Unsuccessful Login!!!");
					AdminLogin Obj=new AdminLogin();
					Obj.setVisible(true);
					dispose(); 
				}
			
			
			}
		});
		Login.setBounds(309, 525, 181, 57);
		contentPane.add(Login);
	}
}