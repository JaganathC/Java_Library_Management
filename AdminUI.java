package Library;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI extends JFrame {
	
	static String[] adminActions = {"Issue Book", "Return Book", "View BookList", "Add Book", "Delete Book", "Search a Book", "View User Details", "Log Out"};
	
	public AdminUI() {

        // Create a panel to hold the heading label
        JPanel headingPanel = new JPanel();
        
        // Create a label for the heading
        JLabel headingLabel = new JLabel("Admin Page");
        headingLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        EmptyBorder padding = new EmptyBorder(15,0,30,0);
        headingLabel.setBorder(padding);
        
        // Add the heading label to the panel
        headingPanel.add(headingLabel);

        // Create a panel for the grid layout
        JPanel gridPanel = new JPanel(new GridLayout(4, 2));
        
        // Create and add the buttons to the grid panel
        for (int i = 0; i < 8; i++) {
        	final int actionIndex = i;
            JButton button = new JButton(adminActions[i]);
            button.setFont(new Font("Segoe UI", Font.BOLD, 20));
            button.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		navigate(actionIndex);
            	}
            });
            gridPanel.add(button);
        }
        
        
        // Set the layout manager of the frame to BorderLayout
        setLayout(new BorderLayout());
        
        // Add the heading panel to the top of the frame
        add(headingPanel, BorderLayout.NORTH);
        
        // Add the grid panel to the center of the frame
        add(gridPanel, BorderLayout.CENTER);
        
        // Set the size and behavior of the frame
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
    public static void navigate(int actionIndex) {
    	switch(actionIndex) {
    	case 0:
    		//call
    		System.out.println(actionIndex + " pressed");
    		
    		break;
    	case 1:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	case 2:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	case 3:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	case 4:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	case 5:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	case 6:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	case 7:
    		//call
    		System.out.println(actionIndex + " pressed");
    		break;
    	}
    }
}