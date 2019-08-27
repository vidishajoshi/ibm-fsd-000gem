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
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.Action;

public class MulticastChatServer extends JFrame {

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
					MulticastChatServer frame = new MulticastChatServer();
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
	public MulticastChatServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblServerSide = new JLabel("Server side");
		lblServerSide.setBounds(87, 11, 89, 14);
		contentPane.add(lblServerSide);
		
		JLabel lblPrint = new JLabel("Do you want to export or not?");
		lblPrint.setBounds(25, 118, 190, 14);
		contentPane.add(lblPrint);
		
		textField = new JTextField();
		textField.setBounds(229, 115, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.setAction(action);
		btnStart.setBounds(226, 44, 89, 23);
		contentPane.add(btnStart);
		
		JLabel lblStartServer = new JLabel("Start server!!");
		lblStartServer.setBounds(25, 48, 78, 14);
		contentPane.add(lblStartServer);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
					
				try {
					int portnumber = 1236;
				     
			        // Create a MulticastSocket
			        MulticastSocket serverMulticastSocket;
					serverMulticastSocket = new MulticastSocket(portnumber);
					 System.out.println("MulticastSocket is created...");
				        
				        // Determine the IP address of a host, given the host name
				        InetAddress group =
				                InetAddress.getByName("225.0.0.1");
				        
				        // getByName- returns IP address of given host
				        serverMulticastSocket.joinGroup(group);
				        System.out.println("joinGroup method is called...");
				        boolean infinite = true;
				        
				        // Continually receives data and prints them 
				        while(infinite) {
				            byte buf[] = new byte[1024];
				            DatagramPacket data =
				                    new DatagramPacket(buf, buf.length);
				            serverMulticastSocket.receive(data);
				            String msg =
				                    new String(data.getData()).trim();
				            System.out.println("Message received from client = " + msg);
				      
				            InetAddress ia=InetAddress.getByName("225.0.0.1");
				            String res = textField.getText();
				        if(res=="yes" || res=="Yes" ||res=="YES" ||res=="Y") {
				        	sendData(ia,msg);
				        }else {
				        	
				        }
				       
				        }
				        serverMulticastSocket.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       		}
	}

		
		public void sendData(InetAddress sender, String msg) throws IOException {
			InetAddress sen=sender;
			String message=msg;
			FileOutputStream fout=new FileOutputStream("log_chat.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			byte m[]=msg.getBytes();
			bout.write(m);
			bout.flush();
			bout.close();
			fout.close();
			System.out.println("done with log file creation!!");
		}
	}

