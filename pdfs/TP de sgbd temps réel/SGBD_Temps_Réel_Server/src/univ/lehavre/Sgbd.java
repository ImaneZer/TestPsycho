package univ.lehavre;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.InputStream;

import java.net.ServerSocket;

import java.net.Socket;


//import org.omg.CORBA.portable.InputStream;

import j2mex.realtime.RealtimeThread;

public class Sgbd extends RealtimeThread {
	
int num;

static ServerSocket server;

static Socket client;

public static void main(String [ ] args) throws InterruptedException {
	
int i = 1;	
long val=3;
	int portnumber=10000;
	 try {
		 
		 	
		//client.close();
		 System.out.println("Attente des requettes...sur localhost:"+portnumber);
		 server = new ServerSocket(portnumber);
		 client=server.accept();
		// System.out.println("resultat...");
		//server
				
		 	
		 	
		 	
		 	
			while (true) 
			{					
			
			//client = server.accept();
			
			//server;			
			
			//client = server.accept();
			
			InputStream is = (InputStream) client.getInputStream();
            
			InputStreamReader isr = new InputStreamReader(is);
            
			BufferedReader br = new BufferedReader(isr);
            
			String line = br.readLine();						
			
			if(line!=null)
				{
				System.out.println(line);			
			
			
				val=(int) (Math.random()*val);
			
				sleep((long) val * 300);
					
				System.out.println("----Requette exécuter----");
				}
				i++;				
			
				}			
			
		// server.close();
		// client.close();			
			
	 	} 
	 
	 	catch (IOException e) 
	 	{
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 	
	 	}
	
	


}

}
