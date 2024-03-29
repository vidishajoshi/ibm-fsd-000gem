package comm.example.multi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.Action;

public class MulticastChatClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MulticastChatClient frame = new MulticastChatClient();
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
	public MulticastChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientSide = new JLabel("client side");
		lblClientSide.setBounds(128, 21, 97, 14);
		contentPane.add(lblClientSide);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(21, 67, 58, 14);
		contentPane.add(lblMessage);
		
		textField = new JTextField();
		textField.setBounds(128, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("send");
		btnSend.setAction(action);
		btnSend.setBounds(79, 138, 89, 23);
		contentPane.add(btnSend);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Send");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		
			try {
				// Default port number we are going to use
		        int portnumber = 1236;
		       
		        // Create a MulticastSocket
		        MulticastSocket chatMulticastSocket;
				
				chatMulticastSocket = new MulticastSocket(portnumber);

		        // Determine the IP address of a host, given the host name
		        InetAddress group =
		                InetAddress.getByName("225.0.0.1");
		        
		        // Joins a multicast group
		        chatMulticastSocket.joinGroup(group);
		        
		        // Prompt a user to enter a message
		        String msg = "";
		       //System.out.println("Type a message for the server:");
		        msg=textField.getText();
		       // BufferedReader br =
		        //        new BufferedReader(new InputStreamReader(msg));
		        //msg = br.readLine();
		        
		        // Send the message to Multicast address
		        DatagramPacket data = new
		                DatagramPacket(msg.getBytes(), 0,
		                msg.length(), group, portnumber);
		        chatMulticastSocket.send(data);
		        
		        // Close the socket
		        chatMulticastSocket.close();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
		}
		
	}
}
