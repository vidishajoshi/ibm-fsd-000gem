package comm.example.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkingServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server=null;
		Socket client;
		
		//default port no we are going to use
		int portNumber=2345;
		
		//create server side socket
		try {
			server=new ServerSocket(portNumber);
			
		}catch(IOException ie) {
			System.out.println("Cannot open socket." +ie);
			System.exit(1);
		}
		System.out.println("server socket is created "+server);

		//wait for the data from the client and reply
		while(true) {
			//Listen for a connection to be made to this socket and accept it.
			System.out.println("Waiting for connect request!!");
			client= server.accept();
			System.out.println("Connect request is accepted!!");
			String clientHost=client.getInetAddress().getHostAddress();
			int clientPort = client.getPort();
			System.out.println("client host : "+clientHost + " client port: "+clientPort);
			
			//read data from client
			InputStream ClientIn = client.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(ClientIn));
			String msgFromClient = br.readLine();
            System.out.println("Message received from client = " + msgFromClient);
            
            // Send response to the client
            if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {
                int num = Integer.parseInt(msgFromClient);
                int result = fact(num);
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                pw.println(result);
            }
            
            // Close sockets
            if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {
                server.close();
                client.close();
                break;
            }
			
		}
	}

	public static int fact(int val) {
		if(val==1) {
			return 1;
		}
		else {
			return val*fact(val-1);
		}
	}
}
