package presentations;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.*;
java.net.*;

public class MyServer {

	try {
		
		ServerSocket ss = new ServerSocket(6666);
		Socket s=ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		
		String str = (String)dis.readUTF();
		
		System.out.println("Message " + str);
		
		System.out.println(new Date().toString());
		ss.close();
	}
	
	catch(Exception e) {System.out.print(e);}
}
	

