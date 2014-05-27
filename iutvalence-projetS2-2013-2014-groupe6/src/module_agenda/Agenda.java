package module_agenda;

import java.util.Date;
import java.util.Hashtable;

/**
 * 
 * @author Valentin
 * 
 */

public abstract class Agenda
{

	private Hashtable<String, Evenement> lesEvenements;

	public Agenda()
	{
		this.lesEvenements = new Hashtable<>();
	}

	public void insererEvenementDansLAgenda(Evenement unEvenement)
	{
		//TODO Gerer si l'evenement est deja present
		
		this.lesEvenements.put(unEvenement.obtenirNom(), unEvenement);
	}

	public void modifierEvenementDate(Date dateARechercher, int annee, int mois, int jour)
	{
		for (int i = 0; i < nombreDEvenements; i++)
		{

			if (this.ensembleEvenements[i].dateEvenement == dateARechercher)
			{

				this.ensembleEvenements[i].dateEvenement.setYear(annee);
				this.ensembleEvenements[i].dateEvenement.setMonth(mois);
				this.ensembleEvenements[i].dateEvenement.setDate(jour);

			}
		}
	}

	public void modifierEvenementHeure(Date dateARechercher, int heure, int minute)
	{
		for (int i = 0; i < nombreDEvenements; i++)
		{

			if (this.ensembleEvenements[i].dateEvenement == dateARechercher)
			{
				this.ensembleEvenements[i].heureEvenement.modifierHeure(heure);
				this.ensembleEvenements[i].heureEvenement.modifierMinute(minute);
			}
		}
	}

	public void modifierEvenementCommentaire(Date dateARechercher, String commentaireAModifier)
	{
		for (int i = 0; i < nombreDEvenements; i++)
		{

			if (this.ensembleEvenements[i].dateEvenement == dateARechercher)
			{
				this.ensembleEvenements[i].setCommentaireEvenement(commentaireAModifier);
			}
		}
	}

}
