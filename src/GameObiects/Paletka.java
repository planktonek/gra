package GameObiects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


public class Paletka extends GameObiect{
    int side;
    public Paletka(Image image, Point position) {
	super(image, position);
    }

 
    
    public void moveme(int value){
	
      if(side==0){
	  this.position.translate(0,value);	  
      }
      else 
	  this.position.translate(value, 0);
    }

    
    

}