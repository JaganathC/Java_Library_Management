package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField Bookid;
	private JTextField studentid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Id");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(97, 113, 177, 47);
		contentPane.add(lblNewLabel);
		
		JLabel stulabel = new JLabel("Student Id");
		stulabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		stulabel.setBounds(97, 182, 177, 47);
		contentPane.add(stulabel);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIssueDate.setBounds(97, 246, 177, 47);
		contentPane.add(lblIssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDueDate.setBounds(97, 316, 177, 47);
		contentPane.add(lblDueDate);
		
		Bookid = new JTextField();
		Bookid.setBounds(253, 113, 213, 35);
		contentPane.add(Bookid);
		Bookid.setColumns(10);
		
		studentid = new JTextField();
		studentid.setColumns(10);
		studentid.setBounds(253, 182, 213, 35);
		contentPane.add(studentid);
		
		JDateChooser issuedate = new JDateChooser();
		issuedate.setBounds(253, 248, 213, 34);
		contentPane.add(issuedate);
		
		JDateChooser duedate = new JDateChooser();
		duedate.setBounds(253, 316, 213, 34);
		contentPane.add(duedate);
		
		JButton issuebtn = new JButton("Issue");
		issuebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-mm-yyyy");
				String bookId=Bookid.getText();
				String Studentid=studentid.getText();
				String IssueDate=dFormat.format(issuedate.getDate());
				String DueDate=dFormat.format(duedate.getDate());
				String returnBook="No";
				try {
					
							
				}
				catch(Exception ae){
					
				}
			}
		});
		issuebtn.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		issuebtn.setBounds(137, 396, 117, 35);
		contentPane.add(issuebtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closebtn.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		closebtn.setBounds(383, 396, 117, 35);
		contentPane.add(closebtn);
		
		JLabel lblNewLabel_1 = new JLabel("Book Issue Portal");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(193, 23, 255, 41);
		contentPane.add(lblNewLabel_1);
	}
}
