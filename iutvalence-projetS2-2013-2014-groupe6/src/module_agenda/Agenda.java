package module_agenda;

import java.util.Date;
import java.util.Hashtable;

import exception.EvenementNonTrouveException;

/**
 * 
 * @author Valentin
 * 
 */

public class Agenda
{

	private Hashtable<String, Evenement> lesEvenements;

	public Agenda()
	{
		this.lesEvenements = new Hashtable<>();
	}

	public void insererEvenement(Evenement unEvenement)
	{
		// TODO Gerer si l'evenement est deja present

		this.lesEvenements.put(unEvenement.obtenirNom(), unEvenement);
	}

	public void supprimerUnEvenement(String nomEvenement) throws EvenementNonTrouveException
	{
		if (this.lesEvenements.remove(nomEvenement) == null)
			throw new EvenementNonTrouveException();

	}

	public void modifierDateDUnEvenement(String nomEvenementASupprimer, Date uneDate)
	{
		this.lesEvenements.get(nomEvenementASupprimer).
		
	}

}
