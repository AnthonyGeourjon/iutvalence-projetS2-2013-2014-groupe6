package module_agenda;

import exception.HeureIncorrecteException;

/**
 * 
 * @author Valentin
 * 
 */

public class Heure
{

	private int minute;

	private int heure;

	public int obtenirMinute()
	{
		return minute;
	}

	public void modifierMinute(int minute)
	{
		this.minute = minute;
	}

	public int obtenirHeure()
	{
		return heure;
	}

	public void modifierHeure(int heure)
	{
		this.heure = heure;
	}

	public Heure(int heure, int minute) throws HeureIncorrecteException
	{
		if(heure>=0&&heure<24&&minute>=0&&minute<60)
			{
			this.heure = heure;
			this.minute = minute;
			}
		else
			throw new HeureIncorrecteException();
			
	}

	public boolean avant(Heure heureFin)
	{
		if (this.heure > heureFin.heure)
			return false;
		else if (this.heure < heureFin.heure)
			return true;
		else
		{
			if (this.minute < heureFin.minute)
				return true;
			return true;
		}
	}

}
