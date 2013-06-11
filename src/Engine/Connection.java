/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import defaultowaPaczka.Wiadomosc;
import java.awt.Point;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    ObjectInputStream czytacz;
    ConnectionListener c;

    public Connection(String ip, ConnectionListener c) {
	try {
	    this.c = c;
	    gniazdo = new Socket("172.20.18.251", 5000);

	    pisarz = new ObjectOutputStream(gniazdo.getOutputStream());
	    czytacz = new ObjectInputStream(gniazdo.getInputStream());
	    System.out.println("obsługa sieci gotowa do użycia");
	    new Thread(this).start();
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }

    @Override
    public void run() {
	while (true) {
	    Wiadomosc pk=null;
	    try {
		pk = (Wiadomosc) czytacz.readObject();
	    } catch (IOException ex) {
		Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (ClassNotFoundException ex) {
		Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    switch (pk.getTekst()) {
		case "elo": c.onElo(pk.getId()); break;
		case "ball": c.onBall(pk.getLocation());break;
		case "move": c.onPlayer(pk);break;
		case "start":c.onStart();break;
		case "end":c.onEnd();break;

	    }
	}
    }

    public void sayHello() {
	Wiadomosc w = new Wiadomosc(0, new Point());
	w.setTekst("hello");
	send(w);
    }
    public void move(Point p,int id){
	Wiadomosc w = new Wiadomosc(id, p);
	w.setTekst("move");
	send(w);		
    }
    void send(Wiadomosc w) {
	try {
	    pisarz.writeObject(w);
	    pisarz.flush();
	    pisarz.reset();
	} catch (IOException ex) {
	    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
