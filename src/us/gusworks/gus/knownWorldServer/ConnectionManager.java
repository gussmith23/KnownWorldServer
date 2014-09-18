package us.gusworks.gus.knownWorldServer;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ConnectionManager {

	public ConnectionManager(Socket socket) {
		// TODO Auto-generated constructor stub
		
		KnownWorldServer.logger.info("Connection from " + socket.getInetAddress().toString() + " recieved!");
		
	}
	
		
	
	
	
}
