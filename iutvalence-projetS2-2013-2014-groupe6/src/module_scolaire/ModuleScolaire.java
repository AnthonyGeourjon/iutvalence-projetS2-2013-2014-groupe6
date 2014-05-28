package module_scolaire;

import java.util.Hashtable;

import exception.MatiereNonPresenteException;
import exception.UEDejaPresenteException;

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

	// TODO INSERER UNE NOTE, SUP UNE NOTE
}
