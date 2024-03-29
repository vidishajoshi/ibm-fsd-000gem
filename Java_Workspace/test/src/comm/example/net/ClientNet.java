package comm.example.net;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
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

public class ClientNet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientNet frame = new ClientNet();
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
	public ClientNet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(152, 57, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterValue = new JLabel("Enter value");
		lblEnterValue.setBounds(44, 60, 86, 14);
		contentPane.add(lblEnterValue);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 100, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(44, 103, 46, 14);
		contentPane.add(lblResult);
		
		JLabel lblFactorial = new JLabel("Factorial");
		lblFactorial.setBounds(111, 11, 46, 14);
		contentPane.add(lblFactorial);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setAction(action);
		btnCalculate.setBounds(85, 166, 89, 23);
		contentPane.add(btnCalculate);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Calculate");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
         Socket client = null;
	        
	        // Default port number we are going to use
	        int portnumber = 2345;
	        
	        
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
	                
	                System.out.println("Enter your name. Type Bye to exit. ");
	                
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

