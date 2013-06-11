package Engine;

import GameObjects.Ball;
import GameObjects.GameObiect;
import GameObjects.Paletka;
import defaultowaPaczka.Wiadomosc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame extends JFrame implements MouseMotionListener, Runnable,ConnectionListener {

    List<GameObiect> obj = new ArrayList<>();
    Paletka mePaletka;
    private Thread gra;
    BufferedImage plan = null;
    Connection c;
    int me;
    Boolean start=false;    
    public void start(){
	gra.start();
    }
    public Frame() throws HeadlessException {
	this.setSize(600, 600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	this.addMouseMotionListener(this);
	this.setVisible(true);
	BufferedImage paletka = null,paletkar=null,ball=null;
	try {
	    paletka = ImageIO.read(new File("C:/Users/Plankton/Documents/NetBeansProjects/pong4/img/paletka.jpg"));
	    paletkar = ImageIO.read(new File("C:/Users/Plankton/Documents/NetBeansProjects/pong4/img/paletkar.jpg"));
	    plan = ImageIO.read(new File("C:/Users/Plankton/Documents/NetBeansProjects/pong4/img/pl.jpg"));
	    ball = ImageIO.read(new File("C:/Users/Plankton/Documents/NetBeansProjects/pong4/img/ball.jpg"));
	} catch (IOException ex) {
	    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	
	this.obj.add(new Paletka(paletkar, new Point(30, 30), 0));	
	this.obj.add(new Paletka(paletka, new Point(600-30, 300), 1));	
	this.obj.add(new Paletka(paletkar, new Point(300, 600-30), 2));	
	this.obj.add(new Paletka(paletka, new Point(30, 0), 3));
	
	this.obj.add(new Ball(ball, new Point(300, 300)));
	c=new Connection("", this);
	gra = new Thread(this);
	c.sayHello();
	//gra.run();
	this.onElo(1);
	
	this.onStart();
	this.repaint();
    }

    @Override
    public void paint(Graphics g) {
	BufferedImage buffer = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_ARGB);
	Graphics buf_g = buffer.createGraphics();
	buf_g.setColor(Color.black);
	buf_g.fillRect(0, 0, 600, 600);
	buf_g.setColor(Color.white);
	buf_g.drawImage(plan,0, 0, null);
	// buf_g.fillRect(Magazyn.odleglosc_pola_gry_od_rogu_szerokosc, Magazyn.odleglosc_pola_gry_od_rogu_wysokosc, Magazyn.szerokosc_pola_gry, Magazyn.wysokosc_pola_gry);
	// if (menu.isMenu()) 
	//  menu.paint(buf_g);
	//  else
	//   paintgame(buf_g);
	for (GameObiect a : this.obj) {
	    a.paintMe(buf_g);
	}
	buffer.flush();
	g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
	if(this.start){
	    mePaletka.moveme(e.getPoint());
	    this.c.move(((Paletka)mePaletka).getPosition(), me);
	}
    }

    @Override
    public void run() {
	while(true){
	    this.repaint();
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException ex) {
		Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    @Override
    public void onElo(int id) {
	this.mePaletka=(Paletka)obj.get(id);
	this.me=id;
	
    }

    @Override
    public void onBall(Point poin) {
	((Ball)obj.get(5)).setPosition(poin);
	
    }

    @Override
    public void onPlayer(Wiadomosc point) {
	if(point.getId()!=me){	    
	  ((Paletka)obj.get(point.getId())).moveme(point.getLocation());
	}
    }

    @Override
    public void onStart() {
	this.start=true;
    }

    @Override
    public void onEnd() {
	this.start=false;
    }
}
