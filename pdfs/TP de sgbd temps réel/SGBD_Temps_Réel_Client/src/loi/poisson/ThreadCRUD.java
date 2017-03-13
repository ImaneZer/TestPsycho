

package loi.poisson;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.net.Socket;

import java.net.UnknownHostException;

public class ThreadCRUD extends Thread {  
	//private static final int PortNumber = 3001;	
   private int id;   
   private String req;  
   String hostName ;
   int portNumber ;//3210   
   //Socket MyClient;
   ThreadCRUD a, b = null;
   public static Socket socket;   
   
   public ThreadCRUD (int id, String req) throws UnknownHostException, IOException 
   {
   this.id=id;
   this.req=req;
   hostName = "localhost";   
   portNumber = 10000;//3210   
   
   if(socket==null)
   	{
   socket = new Socket(hostName, portNumber);   
   	}
   // MyClient = new Socket("127.0.0.1", PortNumber);
   }
   
   ThreadCRUD (int id, ThreadCRUD a) {this.id=id;this.a=a;}
   ThreadCRUD (int id, ThreadCRUD a, ThreadCRUD b) {
      this.id=id;this.a=a;this.b=b;}
   
   
   public void run() {
	 
	   
	   
	   try {
    	            	
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			//BufferedReader in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));				
			
			out.println("------>"+req);					
			
			out.flush();			
			
    	    } 
         
	   
         catch (IOException e) {
				// TODO Auto-generated catch block			
    	    	e.printStackTrace();
			
    	    }
      
    	  
    	  
       //  System.out.println("---type--->"+req);
        // System.out.println("--------fin du requette--------");

         
      
      System.out.println(Thread.currentThread().getName()+id);
      // simule un traitement.... sleep ?
   }
}
