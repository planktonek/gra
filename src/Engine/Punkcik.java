/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Point;
/**
 *
 * @author Pawel
 */
public class Punkcik extends Point
{

	public Punkcik(int x, int y, int owner)
	{
		this.x=x;
		this.y=y;
	}

    public Punkcik(int owner, Point p) {
	super(p);
	this.owner = owner;
    }

	private int owner;


	public int getOwner()
	{
		return owner;
	}

	public void setOwner(int owner)
	{
		this.owner = owner;
	}

}
