package us.gusworks.gus.knownWorldServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class KnownWorldServer {


	static ConnectionListener cl;
	static int port = 2324;
	static Logger logger;
	static boolean running = true;
	static CommandListener commListener;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		commListener = new CommandListener(new BufferedReader(new InputStreamReader(System.in)));
		commListener.start();
		
		logger = Logger.getLogger(KnownWorldServer.class.getName());
		
		cl = new ConnectionListener(port);
		cl.start();

	}

}
