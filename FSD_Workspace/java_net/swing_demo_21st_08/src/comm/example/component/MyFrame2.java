package comm.example.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JLabel lblPassword;
	private JPasswordField passwordField1;

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
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(12, 23, 109, 20);
		contentPane.add(lblUserName);
		
		textField1 = new JTextField();
		textField1.setToolTipText("user name here");
		textField1.setBounds(139, 24, 114, 19);
		contentPane.add(textField1);
		textField1.setColumns(25);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 85, 70, 15);
		contentPane.add(lblPassword);
		
		passwordField1 = new JPasswordField();
		passwordField1.setEchoChar('*');
		passwordField1.setColumns(15);
		passwordField1.setBounds(149, 83, 117, 20);
		contentPane.add(passwordField1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "sucess"+textField1.getText().toString());
			}
		});
		btnLogin.setBounds(4, 160, 117, 25);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				passwordField1.setText("");
			}
		});
		btnReset.setBounds(149, 160, 117, 25);
		contentPane.add(btnReset);
	}
}
