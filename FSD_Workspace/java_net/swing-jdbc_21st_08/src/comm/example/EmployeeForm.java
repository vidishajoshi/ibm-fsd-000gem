package comm.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comm.example.model.Employee;
import comm.example.service.EmployeeService;
import comm.example.service.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private EmployeeService service;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EmployeeForm() throws SQLException {
		service=new EmployeeServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(29, 23, 86, 19);
		contentPane.add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(150, 23, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(39, 60, 114, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(29, 90, 86, 19);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 64, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 99, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(45, 130, 70, 19);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(168, 175, 1, 15);
		contentPane.add(textArea);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 130, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.createEmployee(new Employee(Integer.parseInt(textField.getText().toString()),
						textField_1.getText().toString(),textField_2.getText().toString(),
						textField_3.getText().toString()));
				JOptionPane.showMessageDialog(contentPane, "added");
			}
		});
		btnAddEmployee.setBounds(29, 170, 140, 25);
		contentPane.add(btnAddEmployee);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(209, 170, 117, 25);
		contentPane.add(btnReset);
		
		JButton btnDisplayData = new JButton("Display Data");
		btnDisplayData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new MyFrame2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisplayData.setBounds(114, 202, 117, 25);
		contentPane.add(btnDisplayData);
	}
}
