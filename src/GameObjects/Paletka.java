package GameObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


public class Paletka extends GameObiect{
    int side;
    public Paletka(Image image, Point position,int side) {
	super(image, position);
	if(side==3||side==1){
	    this.image.
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