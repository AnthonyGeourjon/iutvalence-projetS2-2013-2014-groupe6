package module_agenda;

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

	public Heure(int heure, int minute)
	{
		this.heure = heure;
		this.minute = minute;
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
