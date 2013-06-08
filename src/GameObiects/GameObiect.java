package GameObiects;

import java.awt.Image;

/**
 *
 * @author Plankton
 */
public abstract class GameObiect {
    Image kulka;

    public GameObiect(Image kulka) {
	this.kulka = kulka;
    }
    
    abstract void paintMe();
}
