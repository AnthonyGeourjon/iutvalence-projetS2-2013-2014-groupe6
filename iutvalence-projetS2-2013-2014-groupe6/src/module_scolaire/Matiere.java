package module_scolaire;

import java.util.Date;
import java.util.Hashtable;
import exception.MatiereSaisieIncorrecteException;
import exception.NoteDejaPresenteException;
import exception.NoteNonPresenteException;

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
	 * coefficient de la matiere
	 */
	private float coeffient;

	/**
	 * @param nomMatiere
	 *            nom de la matiere
	 * @param coeff
	 *            coeff de la matiere
	 * @throws MatiereSaisieIncorrecteException
	 *             levée si le coefficient est incorrecte
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
		this.moyenne = -1;
	}

	
	/**
	 * @param noteAAjouter note ï¿½ ajouter ï¿½ la matiere
	 * @throws NoteDejaPresenteException levï¿½ si une note ï¿½ deja ï¿½tï¿½ rentrï¿½ ï¿½ ce jour lï¿½
	 */
	public void insererUneNote(Note noteAAjouter) throws NoteDejaPresenteException
	{
		if (this.lesNotes.containsKey(noteAAjouter.obtenirDate()))
			throw new NoteDejaPresenteException();
		else
			this.lesNotes.put(noteAAjouter.obtenirDate(), noteAAjouter);
	

	}

	/**
	 * @param date
	 *            date de la note à trouver
	 * @throws NoteNonPresenteException
	 *             levée si la note n'est pas trouvée
	 */
	public void supprimerUneNote(Date date) throws NoteNonPresenteException
	{
		if (this.lesNotes.remove(date) == null)
			throw new NoteNonPresenteException();
		if(this.lesNotes.size()==0)
			this.moyenne=-1;
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
		this.mettreAJourLaMoyenne();
		return this.moyenne;
	}

	/**
	 * @return le nom de la matiere
	 */
	public String obtenirNomMatiere()
	{
		return this.nomMatiere;
	}

	/**
	 * @return le coefficient
	 */
	public float obtenirCoefficient()
	{
		return this.coeffient;
	}
}
