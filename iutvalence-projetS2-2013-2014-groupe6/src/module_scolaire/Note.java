//TODO On pourrait rajouter un attribut moyenne de classe.

package module_scolaire;
import java.util.Date;

import exception.NoteSaisieIncorrecteException;


/**
 * @author Anthony
 *
 */
public class Note
{
	/**
	 * Date ou a été effectué l'évaluation
	 */
	private Date date;
	
	/**
	 * La note en elle-meme
	 */
	private float valeur;
	
	/**
	 * Coefficient de la note
	 */
	private float coeff;
	
	/**
	 * Commentaire sur la  note
	 */
	private String commentaire;

	/**
	 * @param date date de la note
	 * @param valeur valeur de la note [0 - 20]
	 * @param coeff coefficient de la note
	 * @param commentaire commentaire de la note
	 * @throws NoteSaisieIncorrecteException levée si les valeurs en parametres sont incorrectes
	 */
	public Note(Date date, float valeur, float coeff, String commentaire) throws NoteSaisieIncorrecteException
	{
		
		if(valeur<0||valeur>20||coeff<0)
			throw new NoteSaisieIncorrecteException();
		this.date = date;
		this.valeur = valeur;
		this.coeff = coeff;
		this.commentaire = commentaire;
	}

	/**
	 * @return la date
	 */
	public Date obtenirDate()
	{
		return this.date;
	}

	/**
	 * @return le coefficient
	 */
	public float obtenirCoefficient()
	{
		return this.coeff;
	}

	/**
	 * @return la valeur de la note
	 */
	public float obtenirValeur()
	{
		return this.valeur;
	}
	
	/**
	 * @return le commentaire de la note
	 */
	public String obtenirCommentaire()
	{
		return this.commentaire;
	}
	
	
	
	
	
}
