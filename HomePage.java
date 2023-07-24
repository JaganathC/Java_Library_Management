package Library;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*** WELCOME TO ABCS LIBRARY ***");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(170, 36, 800, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose an Action");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(300, 106, 554, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton adminLoginBtn = new JButton("ADMIN LOGIN");
		adminLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin Obj=new AdminLogin();
				Obj.setVisible(true);
				dispose();
				
			}
		});
		adminLoginBtn.setFont(new Font("Segoe UI", Font.BOLD, 21));
		adminLoginBtn.setBounds(270, 197, 250, 65);
		contentPane.add(adminLoginBtn);
		
		JButton btnNewUser = new JButton("NEW USER");
		btnNewUser.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnNewUser.setBounds(270, 277, 250, 65);
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewRegister Obj=new NewRegister();
				Obj.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnNewUser);
		
		JButton btnMemberLogin = new JButton("USER LOGIN");
		btnMemberLogin.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnMemberLogin.setBounds(270, 357, 250, 65);
		btnMemberLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberLogin Obj=new MemberLogin();
				Obj.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnMemberLogin);
	}

}
