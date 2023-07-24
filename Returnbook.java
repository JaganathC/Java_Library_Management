package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Returnbook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Returnbook frame = new Returnbook();
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
	public Returnbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setForeground(new Color(51, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Id");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(111, 77, 89, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(new Color(255, 255, 255));
		lblStudentId.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblStudentId.setBounds(111, 136, 89, 42);
		contentPane.add(lblStudentId);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setForeground(new Color(255, 255, 255));
		lblIssueDate.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblIssueDate.setBounds(111, 188, 89, 42);
		contentPane.add(lblIssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setForeground(new Color(255, 255, 255));
		lblDueDate.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDueDate.setBounds(111, 240, 89, 42);
		contentPane.add(lblDueDate);
		
		textField = new JTextField();
		textField.setBounds(266, 77, 167, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 136, 167, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(266, 195, 167, 33);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(266, 247, 167, 33);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
		btnNewButton.setBounds(462, 136, 94, 34);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(204, 255, 102));
		btnReturn.setForeground(new Color(0, 0, 0));
		btnReturn.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
		btnReturn.setBounds(158, 325, 94, 34);
		contentPane.add(btnReturn);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 10));
		btnClose.setBounds(321, 325, 94, 34);
		contentPane.add(btnClose);
	}

}
