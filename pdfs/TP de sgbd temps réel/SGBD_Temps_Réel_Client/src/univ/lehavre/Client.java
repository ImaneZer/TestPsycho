package univ.lehavre;


import java.io.IOException;

import java.net.UnknownHostException;

import j2mex.realtime.RealtimeThread;
import loi.poisson.Loidepoisson;

import loi.poisson.ThreadCRUD;


public class Client extends RealtimeThread {

static int num;

static ThreadCRUD t;

static Loidepoisson lp;

@SuppressWarnings("deprecation")
public  static void main(String [ ] args) throws UnknownHostException, IOException {

double lamda = 4;

double val;

double rand; 

String req;

lp = new Loidepoisson(lamda);

int i = 1;




while (true) 
{

val = lp.nextDouble();

rand=Math.random()*4;

if((rand>=0) && (rand<1) )
{
	req="CREATE TABLE enseignant (ID int PRIMARY KEY NOT NULL \n"+
	",NOM VARCHAR (15),\n"+
			"PRENOM VARCHAR (15) , \n"+
			"E-mail VARCHAR  (30) );";
	
	}
else if((rand>=1) && (rand<2))
{
	req="Select * From etudiant;";
	
	}
else if ((rand>=2) && (rand<3))
	{
	req="Delete From etudiant Where nom='jack' ;";
	}
else
	{

	req="UPDATE enseignant SET nom='Duvallet'\n"+
	"WHERE ID=12473 ;";

	
	}



try {	
	sleep((long) val * 250);		
	
	t=new ThreadCRUD(i,req);		
	
	t.run();
	
	
	// lancer le thread 
	
	//t.join();	
	
	//t.run();
	
	//t.socket.close();
	}


	catch (InterruptedException e) 
	{		
			
	// TODO Auto-generated catch block
	e.printStackTrace();
			
	}



// requette
// C= create
// R= read
// D= delete
// U= update


//	t.destroy();

//System.out.println("exemple  " + val);

System.out.print("Requette num=" + (num++));

i++;

}

}

}
