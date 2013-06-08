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

	public Punkcik(int x, int y, String owner)
	{
		this.x=x;
		this.y=y;
	}
	
	private String owner;

  
	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

}
