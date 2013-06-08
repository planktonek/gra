package GameObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author Plankton
 */
public abstract class GameObiect {
    protected Image image;
    protected Point position;
    
    public GameObiect(Image image, Point position) {
	this.image = image;
	this.position = position;
    }
    
  
    
    public void paintMe(Graphics g){
	g.drawImage(image, position.x,position.y, null);	
    }
}
