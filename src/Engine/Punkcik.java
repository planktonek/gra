/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Pawel
 */
public class Punkcik
{

	public Punkcik(int x, int y, String owner)
	{
		this.x = x;
		this.y = y;
		this.owner = owner;
	}
	private int x;
	private int y;
	private String owner;

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

}
