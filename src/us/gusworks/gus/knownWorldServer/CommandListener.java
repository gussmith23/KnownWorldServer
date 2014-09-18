package us.gusworks.gus.knownWorldServer;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandListener extends Thread {
	
	private BufferedReader in;
	

	public CommandListener(BufferedReader in){
		
		this.in = in;
		
		
	}
	
	public void run(){
		
		
		
		while(KnownWorldServer.running){
		
			
			try {
				command(in.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}

	private void command(String command) {
		// TODO Auto-generated method stub
		
		if(command.equalsIgnoreCase("kill")){
			KnownWorldServer.running = false;
			KnownWorldServer.cl.interrupt();
			try {
				ConnectionListener.server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
