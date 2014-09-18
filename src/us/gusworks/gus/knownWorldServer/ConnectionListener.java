package us.gusworks.gus.knownWorldServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.ClosedByInterruptException;
import java.util.logging.Logger;

public class ConnectionListener extends Thread {
	
	int port;
	public static ServerSocket server = null;
	private Logger log;
	
	public ConnectionListener(int port){
		
		this.port = port;
		log = KnownWorldServer.logger;
		
	}
	
	public void run(){
		
		//listening to a port
		
		try {
			server = new ServerSocket(port);
			KnownWorldServer.logger.info("Bound to port " + port + "!");
		} catch (IOException e1) {
			
			KnownWorldServer.logger.severe("Couldn't bind to port " + port + "!");
					
		}
		
		
		KnownWorldServer.logger.info("Waiting for a connection...");
		
		
		//main loop
		while(KnownWorldServer.running){

			try{
				
				Socket socket = server.accept();
				new ConnectionManager(socket);
				
			}catch (IOException e) {
				if(KnownWorldServer.running){
					e.printStackTrace();
				}
				else log.info("Killing socket listener.");	
			}
			
			
			
		}
		
	}

}
