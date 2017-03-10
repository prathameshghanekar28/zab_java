package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer implements Runnable {

	private int port;

	public TcpServer(int port) {
		this.port = port;

	}

	public void run() {
		ServerSocket serverSocket = null;
		BufferedReader in;
		PrintWriter out;
		try {
			serverSocket = new ServerSocket( port );
			while (true) {
				
				Socket socket = serverSocket.accept();
				new Thread(new TcpRequestHandler(socket)).start();
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			// TODO Auto-generated finally block
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String processRequest(String input) {
		return "Wow!! Received "+input;
		
	}

}