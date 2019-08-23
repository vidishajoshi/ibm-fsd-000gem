package comm.example.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class DemiFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemiFrame frame = new DemiFrame();
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
	public DemiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(54, 13, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setBounds(173, 15, 76, 15);
		contentPane.add(lblYourName);
		
		JButton btnSayhello = new JButton("sayHello");
		btnSayhello.setBounds(61, 67, 95, 25);
		btnSayhello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				//JOptionPane.showMessageDialog(this, this, "hello"+textField.getText(), defaultCloseOperation);
				lblResult.setText(textField.getText().toString());
			}
		});
		
		lblResult = new JLabel("result");
		lblResult.setBounds(254, 15, 42, 15);
		contentPane.add(lblResult);
		contentPane.add(btnSayhello);
	}

}
