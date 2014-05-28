package module_scolaire;

import java.util.Hashtable;

import exception.MatiereDejaPresenteException;
import exception.MatiereNonPresenteException;
import exception.UEDejaPresenteException;
import exception.UEInconnuException;

/**
 * @author Anthony Regroupe tout le module de gestion note
 */
public class ModuleScolaire
{
	/**
	 * Les UEs de l'étudiant
	 */
	private Hashtable<String, UE> lesUEs;

	/**
	 * Moyenne de l'etudiant
	 */
	private float moyenneDeLEtudiant;

	/**
	 * Constructeur
	 */
	public ModuleScolaire()
	{
		this.lesUEs = new Hashtable<>();
	}

	/**
	 * @param uEAAjouter
	 *            ue a ajouter
	 * @throws UEDejaPresenteException
	 *             Levé si l'UE est déja presente
	 */
	public void ajouterUneUE(UE uEAAjouter) throws UEDejaPresenteException
	{
		if (!this.lesUEs.containsKey(uEAAjouter.obtenirNom()))
			this.lesUEs.put(uEAAjouter.obtenirNom(), uEAAjouter);
		else
			throw new UEDejaPresenteException();
	}

	/**
	 * @param nomUEAsupprimer
	 *            nom de l'ue a supprimer
	 * @throws MatiereNonPresenteException
	 *             levé si la matiere n'est pas trouvée
	 */
	public void supprimerUneUE(String nomUEAsupprimer) throws MatiereNonPresenteException
	{
		if (this.lesUEs.remove(nomUEAsupprimer) == null)
			throw new MatiereNonPresenteException();
		else
			this.mettreAJourLaMoyenne();
	}

	private void mettreAJourLaMoyenne()
	{
		float moyenne = 0;
		float sommeDesCoefficients = 0;
		int nombreUEInvalide = 0;

		for (UE uECourante : this.lesUEs.values())
		{
			if (uECourante.obtenirMoyenneDeLUE() != -1)
			{
				moyenne += uECourante.obtenirMoyenneDeLUE() * uECourante.obtenirCoefficient();
				sommeDesCoefficients += uECourante.obtenirCoefficient();
			}
			else
				nombreUEInvalide++;
		}

		if (moyenne == 0)
			this.moyenneDeLEtudiant = -1;
		else
			this.moyenneDeLEtudiant = (moyenne / sommeDesCoefficients) / (this.lesUEs.size() - nombreUEInvalide);
	}

	/**
	 * @param nomUE
	 * @param matiereAAjouter
	 * @throws MatiereDejaPresenteException
	 * @throws UEInconnuException
	 */
	public void insererUneMatiere(String nomUE, Matiere matiereAAjouter) throws MatiereDejaPresenteException,
			UEInconnuException
	{
		if (this.lesUEs.get(nomUE) == null)
			throw new UEInconnuException();
		else
			this.lesUEs.get(nomUE).insererUneMatiere(matiereAAjouter);
	}

	/**
	 * @param nomMatiereASupprimer nom de la matiere a supprimer
	 * @param nomUE nom de l'UE qui contient la matiere
	 * @throws MatiereNonPresenteException Lévé si matiere non trouvé
	 * @throws UEInconnuException Levé si l'UE est inconnu
	 */
	public void supprimerUneMatiere(String nomMatiereASupprimer, String nomUE) throws MatiereNonPresenteException, UEInconnuException
	{
		if (this.lesUEs.containsKey(nomUE))
			this.lesUEs.get(nomUE).supprimerUneMatiere(nomMatiereASupprimer);
		else
			throw new UEInconnuException();
	}
	// TODO INSERER UNE NOTE, SUP UNE NOTE
}
