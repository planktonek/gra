/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import defaultowaPaczka.Wiadomosc;
import java.awt.Point;

/**
 *
 * @author Plankton
 */
public interface ConnectionListener {
    public void onElo(int id);
    public void onBall(Point poin);
    public void onPlayer(Wiadomosc point);
    public void onStart();
    public void onEnd();
}
