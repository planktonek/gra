/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author Pawel
 */
public class KlientTestowy implements Runnable
{
	/**
	 * @param args the command line arguments
	 */
	Socket gniazdo;
ObjectOutputStream pisarz;
	@Override
	public void run()
	{
		try
		{
			gniazdo = new Socket("127.0.0.1", 5000);

			 pisarz = new ObjectOutputStream(gniazdo.getOutputStream());
			System.out.println("obsługa sieci gotowa do użycia");
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		Punkcik p=new Punkcik(0,0,0);


		while (true)
		{
			p.x++;
			p.y--;
			try
			{
				pisarz.writeObject(p.x);
				pisarz.flush();
				System.out.println(p.toString());
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException ex)
				{
					Logger.getLogger(KlientTestowy.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			catch (IOException ex)
			{
				Logger.getLogger(KlientTestowy.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	public static void main(String[] args)
	{
new KlientTestowy().run();

	}
}
