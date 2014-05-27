package module_agenda;

import java.util.Date;

import exception.HeureIncorrecteException;

/**
 * 
 * @author Valentin
 * 
 */

public class Evenement
{

	protected Date dateEvenement;

	protected String commentaireEvenement;

	protected Heure heureDebut;

	protected Heure heureFin;

	protected String nom;

	public Evenement(Date date, String nom, String commentaire, Heure heureDebut, Heure heureFin) throws HeureIncorrecteException
	{

		if (heureDebut.avant(heureFin))
		{
			this.dateEvenement = date;
			this.commentaireEvenement = commentaire;
			this.heureDebut = heureDebut;
			this.heureFin = heureFin;
			this.nom=nom;
		}
		else
			throw new HeureIncorrecteException();

	}

	public String getCommentaireEvenement()
	{
		return commentaireEvenement;
	}

	public void setCommentaireEvenement(String commentaire)
	{
		this.commentaireEvenement = commentaire;
	}

	public String obtenirNom()
	{
		return this.nom;
	}

}
