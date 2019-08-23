package comm.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class MyFrame2 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private RS2XMLCConfig config=null;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MyFrame2() throws SQLException {
		config=new RS2XMLCConfig();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 12, 335, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs=config.getAllEmployee();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnLoadData.setBounds(49, 208, 117, 25);
		contentPane.add(btnLoadData);
		setVisible(true);
	}
}
