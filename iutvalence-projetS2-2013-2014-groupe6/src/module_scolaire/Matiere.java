package module_scolaire;

import java.util.Date;
import java.util.Hashtable;
import exception.MatiereSaisieIncorrecteException;
import exception.NoteDejaPresenteException;
import exception.NoteNonPresenteException;
import exception.NoteSaisieIncorrecteException;

/**
 * @author Anthony
 * 
 */
public class Matiere
{
	/**
	 * moyenne dans cette matiere
	 */
	private float moyenne;

	/**
	 * ensemble des notes
	 */
	private Hashtable<Date, Note> lesNotes;

	/**
	 * nom de la matiere
	 */
	private String nomMatiere;

	/**
	 * coeff de la matiere
	 */
	private float coeffient;

	/**
	 * @param nomMatiere
	 *            nom de la matiere
	 * @param coeff
	 *            coeff de la matiere
	 * @throws MatiereSaisieIncorrecteException
	 *             lev� si le coefficient est incorrecte
	 */
	public Matiere(String nomMatiere, float coeff) throws MatiereSaisieIncorrecteException
	{
		if (coeff < 0)
			throw new MatiereSaisieIncorrecteException();
		this.lesNotes = new Hashtable<>();
		this.nomMatiere = nomMatiere;

		if (coeff > 0)
			this.coeffient = coeff;
		else
			this.coeffient = 1;
		this.moyenne = 0;
	}

	/**
	 * @param date
	 *            date de la note à inserer
	 * @param valeur
	 *            valeur de la note à inserer
	 * @param coeff
	 *            coeff de la note à inserer
	 * @param commentaire
	 *            de la note à inserer
	 * @throws NoteDejaPresenteException
	 *             levé si une note est deja rentré à la meme date
	 */
	public void insererUneNote(Date date, float valeur, float coeff, String commentaire)
			throws NoteDejaPresenteException
	{
		if (this.lesNotes.containsKey(date))
			throw new NoteDejaPresenteException();
		else
		{
			try
			{
				this.lesNotes.put(date, new Note(date, valeur, coeff, commentaire));
			}
			catch (NoteSaisieIncorrecteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.mettreAJourLaMoyenne();
		}

	}

	/**
	 * @param date
	 *            date de la note a trouver
	 * @throws NoteNonPresenteException
	 *             levé si la note n'est pas trouvé
	 */
	public void supprimerUneNote(Date date) throws NoteNonPresenteException
	{
		if (this.lesNotes.remove(date) == null)
			throw new NoteNonPresenteException();
		else
			this.mettreAJourLaMoyenne();
	}

	/**
	 * Mettre à jour la moyenne
	 */
	private void mettreAJourLaMoyenne()
	{
		float moyenne = 0;
		float sommeDesCoefficients = 0;

		for (Note noteCourante : this.lesNotes.values())
		{
			moyenne += noteCourante.obtenirValeur() * noteCourante.obtenirCoefficient();
			sommeDesCoefficients += noteCourante.obtenirCoefficient();
		}

		this.moyenne = (moyenne / sommeDesCoefficients) / this.lesNotes.size();

	}

	/**
	 * @return la moyenne dans la matiere
	 */
	public float obtenirMoyenne()
	{
		return moyenne;
	}

	/**
	 * @return le nom de la matiere
	 */
	public String obtenirNomMatiere()
	{
		return nomMatiere;
	}

	/**
	 * @return le coefficient
	 */
	public float obtenirCoefficient()
	{
		return coeffient;
	}
}
