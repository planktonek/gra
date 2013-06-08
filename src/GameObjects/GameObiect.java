package GameObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Plankton
 */
public abstract class GameObiect {
    protected BufferedImage image;
    protected Point position;
    
    public GameObiect(BufferedImage image, Point position) {
	this.image = image;
	this.position = position;
    }
    
  
    
    public void paintMe(Graphics g){
	g.drawImage(image, position.x,position.y, null);	
    }
}
