package module_agenda;

/**
 * 
 * @author Valentin
 *
 */

import java.util.Date;

import exception.HeureIncorrecteException;

public abstract class SeanceSport extends Evenement
{

	public SeanceSport(Date date, String commentaire, Heure heureDebut, Heure heureFin) throws HeureIncorrecteException
	{
		super(date, commentaire, heureDebut, heureFin);
		// TODO Auto-generated constructor stub
	}

}
