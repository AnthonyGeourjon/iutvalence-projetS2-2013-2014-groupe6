package module_scolaire;

import java.util.Date;
import java.util.Hashtable;

import exception.MatiereDejaPresenteException;
import exception.MatiereNonPresenteException;
import exception.NoteDejaPresenteException;
import exception.NoteNonPresenteException;

/**
 * @author Anthony
 * 
 */
public class UE
{

	/**
	 * Moyenne de l'ue
	 */
	private float moyenneDeLUE;

	/**
	 * Nom de l'ue
	 */
	private String nom;

	/**
	 * Coefficient de l'ue
	 */
	private float coeffient;

	/**
	 * Ensemble des matieres
	 */
	private Hashtable<String, Matiere> lesMatieresDeLUE;

	/**
	 * @param nom
	 *            nom de l'Ue
	 * @param coefficient
	 *            coefficient de l'ue
	 */
	public UE(String nom, float coefficient)
	{
		super();
		this.moyenneDeLUE = 0;
		this.nom = nom;
		this.coeffient = coefficient;
		this.lesMatieresDeLUE = new Hashtable<>();

	}

	/**
	 * @return la moyenne de l'ue
	 */
	public float obtenirMoyenneDeLUE()
	{
		this.mettreAJourLaMoyenne();
		return this.moyenneDeLUE;
	}

	/**
	 * @return le nom de l'ue
	 */
	public String obtenirNom()
	{
		return this.nom;
	}

	/**
	 * @return le coefficient de l'ue
	 */
	public float obtenirCoefficient()
	{
		return this.coeffient;
	}

	/**
	 * @param matiereAAjouter
	 *            matiere qui sera ajoutï¿½
	 * @throws MatiereDejaPresenteException
	 *             levÃ© si la matiere est deja en memoire
	 */
	public void insererUneMatiere(Matiere matiereAAjouter) throws MatiereDejaPresenteException
	{
		if (this.lesMatieresDeLUE.containsKey(matiereAAjouter.obtenirNomMatiere()))
			throw new MatiereDejaPresenteException();
		else
			this.lesMatieresDeLUE.put(matiereAAjouter.obtenirNomMatiere(), matiereAAjouter);
	}

	/**
	 * @param nomDeLaMatiereAAjouter
	 *            nom de la matiere ï¿½ ajouter
	 * @throws MatiereNonPresenteException
	 *             Levï¿½e si la matiere n'est pas enregistrï¿½
	 */
	public void supprimerUneMatiere(String nomDeLaMatiereAAjouter) throws MatiereNonPresenteException
	{
		if (this.lesMatieresDeLUE.remove(nomDeLaMatiereAAjouter) == null)
			throw new MatiereNonPresenteException();
	}

	/**
	 * Met ï¿½ jour la moyenne de l'ue
	 */
	private void mettreAJourLaMoyenne()
	{
		float moyenne = 0;
		float sommeDesCoefficients = 0;
		int nombreMatiereInvalide = 0;

		for (Matiere matiere : this.lesMatieresDeLUE.values())
		{

			if (matiere.obtenirMoyenne() != -1)
			{
				moyenne += matiere.obtenirMoyenne() * matiere.obtenirCoefficient();
				sommeDesCoefficients += matiere.obtenirCoefficient();
			}
			else
				nombreMatiereInvalide++;

		}

		if (moyenne == 0)
			this.moyenneDeLUE = -1;
		else
			this.moyenneDeLUE = (moyenne / sommeDesCoefficients)
					/ (this.lesMatieresDeLUE.size() - nombreMatiereInvalide);
	}

	/**
	 * @param nomDeLaMatiere
	 *            nom de la matiere auquel sera ajouté la note
	 * @param noteAAjouter
	 *            note a ajouté
	 * @throws NoteDejaPresenteException
	 *             lévé si la note est deja presente
	 */
	public void insererUneNote(String nomDeLaMatiere, Note noteAAjouter) throws NoteDejaPresenteException
	{
		this.lesMatieresDeLUE.get(nomDeLaMatiere).insererUneNote(noteAAjouter);
	}

	/**
	 * @param nomDeLaMatiere
	 *            nom de la matiere auquelle la note sera retiré
	 * @param dateDeLaNote
	 *            date de la note a supprimer
	 * @throws NoteNonPresenteException
	 *             levé si la note n'est pas trouvé
	 */
	public void supprimerUneNote(String nomDeLaMatiere, Date dateDeLaNote) throws NoteNonPresenteException
	{
		this.lesMatieresDeLUE.get(nomDeLaMatiere).supprimerUneNote(dateDeLaNote);
	}

	/**
	 * @return toutes les matieres de l'UE
	 */
	public Hashtable<String, Matiere> obtenirLesMatieresDeLUE()
	{
		return this.lesMatieresDeLUE;
	}
	
	

}
