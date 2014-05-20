import java.util.Date;

/**
 * @author Anthony
 * 
 */
public class Matiere
{
	private static final int NOMBRE_MAX_DE_NOTES = 20;

	private float moyenne;

	private Note[] lesNotes;

	private String nomMatiere;

	private String coeff;

	private int nombreDeNote;

	public Matiere(float moyenne, String nomMatiere, String coeff, int nombreDeNote)
	{
		super();
		this.moyenne = moyenne;
		this.lesNotes = new Note[NOMBRE_MAX_DE_NOTES];
		this.nomMatiere = nomMatiere;
		this.coeff = coeff;
		this.nombreDeNote = nombreDeNote;
	}

	public void insererUneNote(Date date, float valeur, float coeff, String commentaire)
			throws noteDejaPresenteException
	{
		for (int elementCourant = 0; elementCourant < nombreDeNote; elementCourant++)
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

	public void supprimerUneNote(Date date) throws noteNonPresenteException
	{
		boolean trouve = false;

		for (int indiceElementCourant = 0; indiceElementCourant < nombreDeNote; indiceElementCourant++)
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
	}

	private void mettreAJourLaMoyenne()
	{
		float somme = 0 , totalDesCoeff = 0;
		
		for (int indiceElementCourant = 0; indiceElementCourant < nombreDeNote; indiceElementCourant++)
		{
			somme+=this.lesNotes[indiceElementCourant].obtenirValeur()*this.lesNotes[indiceElementCourant].obtenirCoeff();
			totalDesCoeff+=this.lesNotes[indiceElementCourant].obtenirCoeff();
		}
		
		this.moyenne=(somme/totalDesCoeff)/this.nombreDeNote;

	}
}
