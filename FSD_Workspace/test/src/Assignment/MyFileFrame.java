package Assignment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Action;
import javax.swing.JTextField;

public class MyFileFrame extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField textField;
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFileFrame frame = new MyFileFrame();
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
	public MyFileFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWorkingWithInput = new JLabel("Working with Input and Output");
		lblWorkingWithInput.setBounds(5, 5, 424, 14);
	contentPane.add(lblWorkingWithInput);
		
		JButton btnSave = new JButton("Save");
		btnSave.setAction(action);
		btnSave.setBounds(35, 197, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnReload = new JButton("Reload");
		btnReload.setAction(action_1);
		btnReload.setBounds(134, 197, 89, 23);
		contentPane.add(btnReload);
		
		textField = new JTextField();
		textField.setBounds(38, 45, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e)   {
			String data=textField.getText();
			FileWriter out;
			try {
				out = new FileWriter(new File("outagain.txt") );
				PrintWriter outputstream = new PrintWriter(out);
				 outputstream.println(data);
				 
				 out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Reload");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			FileReader in;
			try {
				in = new FileReader(new File("outagain.txt"));
				BufferedReader inputstream= new BufferedReader(in);
				String l;
				while((l=inputstream.readLine())!=null) {
					System.out.println(l);
					textField.setText(l);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
	

