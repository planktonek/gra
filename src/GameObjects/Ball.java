package GameObjects;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Ball extends GameObiect{

    public Ball(BufferedImage image, Point position) {
	super(image, position);
    }

    public void setPosition(Point position) {
	this.position = position;
    }
    
    
    
}