package comm.example.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comm.exp.MyFrame3;
import src.comm.example.model.Employee;
import src.comm.example.service.EmployeeService;
import src.comm.example.service.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.Action;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame2 frame = new MyFrame2();
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
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Employee Details");
		lblWelcomeToThe.setBounds(5, 5, 424, 14);
		contentPane.add(lblWelcomeToThe);
		
		JLabel lblEmployeeId = new JLabel("Employee id");
		lblEmployeeId.setBounds(5, 41, 82, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(5, 79, 70, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last  Name");
		lblLastName.setBounds(5, 122, 70, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(5, 161, 46, 14);
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(109, 38, 145, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 76, 145, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 119, 145, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 158, 145, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setAction(action);
		btnAdd.setBounds(22, 207, 116, 23);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(148, 207, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setAction(action_1);
		btnDelete.setBounds(280, 30, 116, 23);
		contentPane.add(btnDelete);
		
		JButton btnDisplayEmployees = new JButton("Display Employees");
		btnDisplayEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisplayEmployees.setAction(action_2);
		btnDisplayEmployees.setBounds(253, 207, 129, 23);
		contentPane.add(btnDisplayEmployees);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add Employee");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				EmployeeServiceImpl emp= new EmployeeServiceImpl();
				emp.createEmployee(new Employee(Integer.parseInt(textField.getText().toString()),textField_1.getText().toString(),textField_2.getText().toString(),textField_3.getText().toString()));
				JOptionPane.showMessageDialog(contentPane,this,"added ",0);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Delete Employee");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				EmployeeServiceImpl emp1= new EmployeeServiceImpl();
				emp1.deletebyid(Integer.parseInt(textField.getText().toString()));
				JOptionPane.showMessageDialog(contentPane,this,"delete ",0);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Display Data");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				new MyFrame3();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
