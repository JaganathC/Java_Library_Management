package Library;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchBookUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public SearchBookUI() {
        super("Book Search and Display");

        // Initialize components
        searchField = new JTextField(30);
        searchButton = new JButton("Search");
        dataTable = new JTable();

        // Create table model with column names and no initial data
        String[] columnNames = {"Book ID", "Title", "Author"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable.setModel(tableModel);

        // Set custom border for the table
        Border tableBorder = BorderFactory.createLineBorder(Color.BLACK);
        dataTable.setBorder(tableBorder);

        // Set custom intercell spacing for the table
        int horizontalSpacing = 20;
        int verticalSpacing = 10;
        dataTable.setRowHeight(30);
        dataTable.setIntercellSpacing(new Dimension(horizontalSpacing, verticalSpacing));

        // Set custom styling for components
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        searchButton.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));
        searchButton.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));
        searchButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        searchButton.setBackground(new Color(59, 89, 182));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder(2, 10, 5, 10));
        
        Font headerFont = new Font("Arial", Font.BOLD, 30);
        JTableHeader tableHeader = dataTable.getTableHeader();

        dataTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tableHeader.setFont(headerFont);

        // Center align table header text
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        dataTable.getTableHeader().setDefaultRenderer(headerRenderer);
        

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Set up ActionListener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchField.getText();
                ArrayList<Book> foundbooks = Book.searchBook(searchQuery);
                Object[][] data = new Object[foundbooks.size()][3];
                for(int i = 0; i<foundbooks.size(); i++)
                {
                	Book b = foundbooks.get(i);
                	data[i][0] = b.getId();
                	data[i][1] = b.getBookName();
                	data[i][2] = b.getAuthor();
                }
                
                updateTableData(data);
            }
        });


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Update the table data with new data
    private void updateTableData(Object[][] data) {
        // Clear existing data
        tableModel.setRowCount(0);

        // Add new data to the table
        for (Object[] rowData : data) {
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchBookUI();
            }
        });
    }
}