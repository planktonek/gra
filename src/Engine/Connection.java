/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author Pawel
 */
public class Connection implements Runnable {

    /**
     * @param args the command line arguments
     */
    Socket gniazdo;
    ObjectOutputStream pisarz;
    ObjectInputStream input;

    public Connection(String ip) {
	try {
	    gniazdo = new Socket(ip, 5000);

	    pisarz = new ObjectOutputStream(gniazdo.getOutputStream());
	    System.out.println("obsługa sieci gotowa do użycia");
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }

    @Override
    public void run() {
	    while(true){
		//odbieranie pakietów aleluja alleluja  
	    }
    }
    public void SayHello(){
	
	
    }
    void Send(Object a) throws IOException {

	pisarz.writeObject(a);
	pisarz.flush();
    }
}
