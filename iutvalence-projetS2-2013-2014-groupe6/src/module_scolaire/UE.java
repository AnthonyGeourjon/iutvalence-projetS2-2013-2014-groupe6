package module_scolaire;

import java.util.Hashtable;
import exception.MatiereDejaPresenteException;
import exception.MatiereNonPresenteException;

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
	public float obtenirCoeffient()
	{
		return this.coeffient;
	}

	/**
	 * @param matiereAAjouter
	 *            matiere qui sera ajout�
	 * @throws MatiereDejaPresenteException levé si la matiere est deja en memoire
	 */
	public void insererUneMatiere(Matiere matiereAAjouter) throws MatiereDejaPresenteException
	{
		if (this.lesMatieresDeLUE.containsKey(matiereAAjouter.obtenirNomMatiere()))
			throw new MatiereDejaPresenteException();
		else
		{
			this.lesMatieresDeLUE.put(matiereAAjouter.obtenirNomMatiere(), matiereAAjouter);
			this.mettreAJourLaMoyenne();
		}
	}

	/**
	 * @param nomDeLaMatiereAAjouter
	 *            nom de la matiere � ajouter
	 * @throws MatiereNonPresenteException
	 *             Lev�e si la matiere n'est pas enregistr�
	 */
	public void supprimerUneMatiere(String nomDeLaMatiereAAjouter) throws MatiereNonPresenteException
	{
		if (this.lesMatieresDeLUE.remove(nomDeLaMatiereAAjouter) == null)
			throw new MatiereNonPresenteException();
		else
			this.mettreAJourLaMoyenne();
	}

	/**
	 * Met � jour la moyenne de l'ue
	 */
	private void mettreAJourLaMoyenne()
	{
		float moyenne = 0;
		float sommeDesCoefficients = 0;

		for (Matiere matiere : this.lesMatieresDeLUE.values())
		{
			moyenne += matiere.obtenirMoyenne() * matiere.obtenirCoefficient();
			sommeDesCoefficients += matiere.obtenirCoefficient();
		}

		this.moyenneDeLUE = (moyenne / sommeDesCoefficients) / this.lesMatieresDeLUE.size();
	}
	
	
	
}
