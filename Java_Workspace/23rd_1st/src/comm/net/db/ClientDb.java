package comm.net.db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.Action;
import javax.swing.JTextArea;

public class ClientDb extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JTextField textField_1;
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientDb frame = new ClientDb();
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
	public ClientDb() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterId = new JLabel("Enter Id");
		lblEnterId.setBounds(43, 58, 46, 14);
		contentPane.add(lblEnterId);
		
		textField = new JTextField();
		textField.setBounds(163, 55, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(43, 109, 46, 14);
		contentPane.add(lblEmployee);
		
		JButton btnLoadEmp = new JButton("Load Emp");
		btnLoadEmp.setAction(action);
		btnLoadEmp.setBounds(102, 197, 106, 23);
		contentPane.add(btnLoadEmp);
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setBounds(119, 11, 116, 14);
		contentPane.add(lblEmployeeDetails);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 106, 223, 48);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save Employee");
		btnSave.setAction(action_1);
		btnSave.setBounds(220, 197, 116, 23);
		contentPane.add(btnSave);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME,"Load Emp");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
	         Socket client = null;
		        
		        // Default port number we are going to use
		        int portnumber = 3456;
		        
		        
		        for (int i=0; i <10; i++) {
		            try {
		                int numb;
		                
		                // Create a client socket
		                
		                client = new Socket(InetAddress.getLocalHost(), portnumber);
		                System.out.println("Client socket is created " + client);
		                
		                // Create an output stream of the client socket
		                OutputStream clientOut = client.getOutputStream();
		                PrintWriter pw = new PrintWriter(clientOut, true);
		                
		                // Create an input stream of the client socket
		                InputStream clientIn = client.getInputStream();
		                BufferedReader br = new BufferedReader(new
		                        InputStreamReader(clientIn));
		                
		                // Create BufferedReader for a standard input
		                BufferedReader stdIn = new BufferedReader(new
		                        InputStreamReader(System.in));
		                
		                //System.out.println("Enter your name. Type Bye to exit. ");
		                
		                // Read data from standard input device and write it
		                // to the output stream of the client socket.
		                numb = Integer.parseInt(textField.getText());
		                pw.println(numb);
		                
		                // Read data from the input stream of the client socket.
		                textField_1.setText(br.readLine());
		                
		                pw.close();
		                br.close();
		                client.close();
		                
		                // Stop the operation
		                if (numb==0) {
		                    break;
		                }
		                
		            } catch (IOException ie) {
		                System.out.println("I/O error - Start server and turn off Firewall" + ie);
		            }	                

		}
	}
}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Save Action");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
	         Socket client = null;
		        
		        // Default port number we are going to use
		        int portnumber = 3456;
		        
		        
		        for (int i=0; i <10; i++) {
		            try {
		                int numb;
		                
		                // Create a client socket
		                
		                client = new Socket(InetAddress.getLocalHost(), portnumber);
		                System.out.println("Client socket is created " + client);
		                
		                // Create an output stream of the client socket
		                OutputStream clientOut = client.getOutputStream();
		                PrintWriter pw = new PrintWriter(clientOut, true);
		                
		                // Create an input stream of the client socket
		                InputStream clientIn = client.getInputStream();
		                BufferedReader br = new BufferedReader(new
		                        InputStreamReader(clientIn));
		                
		                // Create BufferedReader for a standard input
		                BufferedReader stdIn = new BufferedReader(new
		                        InputStreamReader(System.in));
		                
		                //System.out.println("Enter your name. Type Bye to exit. ");
		                
		                // Read data from standard input device and write it
		                // to the output stream of the client socket.
		                numb = Integer.parseInt(textField.getText());
		                pw.println(numb);
		                
		                // Read data from the input stream of the client socket.
		                textField_1.setText(br.readLine());
		                
		                pw.close();
		                br.close();
		                client.close();
		                
		                // Stop the operation
		                if (numb==0) {
		                    break;
		                }
		                
		            } catch (IOException ie) {
		                System.out.println("I/O error - Start server and turn off Firewall" + ie);
		            }	                

		}
		
		}
		
		
	}
}