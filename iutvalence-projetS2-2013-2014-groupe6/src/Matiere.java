import java.util.Date;

/**
 * @author Anthony
 * 
 */
public class Matiere
{
	/**
	 * Nombre de max de notes 
	 */
	private static final int NOMBRE_MAX_DE_NOTES = 20;

	/**
	 * moyenne dans cette matiere
	 */
	private float moyenne;

	/**
	 * ensemble des notes 
	 */
	private Note[] lesNotes;

	/**
	 * nom de la matiere
	 */
	private String nomMatiere;

	/**
	 * coeff de la matiere
	 */
	private float coeff;

	/**
	 * nombre de note 
	 */
	private int nombreDeNote;


	/**
	 * @param nomMatiere nom de la matiere
	 * @param coeff coeff de la matiere
	 */
	public Matiere(String nomMatiere, float coeff)
	{
		super();
		this.lesNotes = new Note[NOMBRE_MAX_DE_NOTES];
		this.nomMatiere = nomMatiere;
		
		if( coeff>0)
			this.coeff = coeff;
		else
			this.coeff=1.0;
		this.nombreDeNote = 0;
		this.moyenne=0;
	}

	/**
	 * @param date date de la note à inserer
	 * @param valeur valeur de la note à inserer
	 * @param coeff coeff de la note à inserer
	 * @param commentaire de la note à inserer
	 * @throws noteDejaPresenteException levé si une note est deja rentré à la meme date
	 */
	public void insererUneNote(Date date, float valeur, float coeff, String commentaire)
			throws noteDejaPresenteException
	{
		for (int elementCourant = 0; elementCourant < this.nombreDeNote; elementCourant++)
		{
			if (date == this.lesNotes[elementCourant].obtenirDate())
			{
				this.nombreDeNote++;
				this.lesNotes[this.nombreDeNote] = new Note(date, valeur, coeff, commentaire);
			}
			else
			{
				throw new noteDejaPresenteException();
			}
		}

		this.mettreAJourLaMoyenne();
	}

	/**
	 * @param date date de la note a trouver
	 * @throws noteNonPresenteException levé si la note n'est pas trouvé
	 */
	public void supprimerUneNote(Date date) throws noteNonPresenteException
	{
		boolean trouve = false;

		for (int indiceElementCourant = 0; indiceElementCourant < this.nombreDeNote; indiceElementCourant++)
		{
			if (date == this.lesNotes[indiceElementCourant].obtenirDate())
			{
				for (int emplacementNoteASupprimer = indiceElementCourant; emplacementNoteASupprimer < this.nombreDeNote; emplacementNoteASupprimer++)
				{
					this.lesNotes[emplacementNoteASupprimer] = this.lesNotes[emplacementNoteASupprimer + 1];
					trouve = true;
				}
			}

		}

		if (!trouve)
			throw new noteNonPresenteException();
		
		this.mettreAJourLaMoyenne();
	}

	/**
	 * Mettre à jour la moyenne
	 */
	private void mettreAJourLaMoyenne()
	{
		float somme = 0 , totalDesCoeff = 0;
		
		for (int indiceElementCourant = 0; indiceElementCourant < this.nombreDeNote; indiceElementCourant++)
		{
			somme+=this.lesNotes[indiceElementCourant].obtenirValeur()*this.lesNotes[indiceElementCourant].obtenirCoeff();
			totalDesCoeff+=this.lesNotes[indiceElementCourant].obtenirCoeff();
		}
		
		this.moyenne=(somme/totalDesCoeff)/this.nombreDeNote;

	}
}
