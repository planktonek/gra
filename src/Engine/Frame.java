package Engine;

import GameObjects.GameObiect;
import GameObjects.Paletka;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame extends JFrame{
    List<GameObiect> obj=new ArrayList<>();
    public Frame() throws HeadlessException {
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    BufferedImage paletka=null;
	try {
	    paletka = ImageIO.read(new File("C:/Users/Plankton/Documents/NetBeansProjects/pong4/img/paletka.jpg"));
	} catch (IOException ex) {
	    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
	}
    this.obj.add(new Paletka(paletka,new Point(0,0),2));
    }

    
        
    
    
    
    @Override
        public void paint(Graphics g)
        {
            BufferedImage buffer = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_ARGB);
            Graphics buf_g = buffer.createGraphics();
            buf_g.setColor(Color.white);
            buf_g.fillRect(0,0, 1024,768);
            buf_g.setColor(Color.black);
           // buf_g.fillRect(Magazyn.odleglosc_pola_gry_od_rogu_szerokosc, Magazyn.odleglosc_pola_gry_od_rogu_wysokosc, Magazyn.szerokosc_pola_gry, Magazyn.wysokosc_pola_gry);
           // if (menu.isMenu()) 
              //  menu.paint(buf_g);
           //  else
           //   paintgame(buf_g);
            for(GameObiect a:this.obj)
	    {
		a.paintMe(buf_g);		
	    }
            buffer.flush();
            g.drawImage(buffer, 0, 0, null);
	}
    
}