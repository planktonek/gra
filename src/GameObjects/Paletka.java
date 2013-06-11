package GameObjects;

import java.awt.Point;
import java.awt.image.BufferedImage;


public class Paletka extends GameObiect{
    int side;
    public Paletka(BufferedImage image, Point position,int side) {
	super(image, position);
	this.side=side;
	if(side==3||side==1){
	    
	}
    }

 
    
    public void moveme(Point value){
		  
      if(side==0||side==2){
	  this.position.move(value.x, this.position.y);
      }
      else 
	  this.position.move(this.position.x,value.y);
    }

    
    

}