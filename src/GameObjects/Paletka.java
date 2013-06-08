package GameObjects;

import java.awt.Point;
import java.awt.image.BufferedImage;


public class Paletka extends GameObiect{
    int side;
    public Paletka(BufferedImage image, Point position,int side) {
	super(image, position);
	if(side==3||side==1){
	    
	}
    }

 
    
    public void moveme(int value){
	
      if(side==0||side==2){
	  this.position.translate(0,value);	  
      }
      else 
	  this.position.translate(value, 0);
    }

    
    

}