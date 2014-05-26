package module_alimentation;

import java.util.Hashtable;

import exception.AlimentsInexistantException;

/**
 * @author geourjoa
 * 
 */
public class Frigo
{

	/**
	 * Ensemble des aliments du frigo
	 */
	private Hashtable<String, Aliment> alimentsDuFrigo;

	/**
	 * Ensemble des recettes pouvant etre r�alis� avec le frigo en l'�tat
	 */
	private Hashtable<String, Recette> recettesDisponibles;

	/**
	 * Constructeur
	 */
	public Frigo()
	{
		this.alimentsDuFrigo = new Hashtable<>();
		this.recettesDisponibles = new Hashtable<>();
	}

	/**
	 * @param alimentAAjouter
	 *            aliment qui sera ajout� au frigo
	 */
	public void insererAliment(Aliment alimentAAjouter)
	{

		if (this.alimentsDuFrigo.containsKey(alimentAAjouter.obtenirNom()))
		{
			Aliment alimentDejaPresent = this.alimentsDuFrigo.get(alimentAAjouter.obtenirNom());
			this.alimentsDuFrigo.remove(alimentAAjouter.obtenirNom());
			this.alimentsDuFrigo.put(alimentAAjouter.obtenirNom(), new Aliment(alimentAAjouter.obtenirNom(),
					alimentAAjouter.obtenirQuantite() + alimentDejaPresent.obtenirQuantite()));
		}
		else
			this.alimentsDuFrigo.put(alimentAAjouter.obtenirNom(), alimentAAjouter);

		this.mAJRecettePossible();
	}

	private void mAJRecettePossible()
	{
		if (!Recette.obtenirToutesLesRecettesConnues().isEmpty())
			for (Recette recetteCourante : Recette.obtenirToutesLesRecettesConnues().values())
			{
				boolean recettePossible = true;

				for (Aliment alimentCourant : recetteCourante.obtenirAlimentNecessaire().values())
				{
					if (!this.alimentsDuFrigo.containsKey(alimentCourant.obtenirNom())
							|| this.alimentsDuFrigo.get(alimentCourant.obtenirNom()).obtenirQuantite() < alimentCourant
									.obtenirQuantite())
						recettePossible = false;
				}

				if (recettePossible)
					this.recettesDisponibles.put(recetteCourante.obtenirNom(), recetteCourante);
			}

	}

	/**
	 * @param nomAlimentASupprimer
	 *            nom de l'aliment qui sera supprime
	 * @throws AlimentsInexistantException
	 *             lev� si l'aliment n'est pas dans le frigo
	 */
	public void supprimerAliment(String nomAlimentASupprimer) throws AlimentsInexistantException
	{
		if (this.alimentsDuFrigo.remove(nomAlimentASupprimer) == null)
			throw new AlimentsInexistantException();
	}

	// /**
	// * Supprimer les aliments périmées
	// */
	// public void supprimerAlimentsPerimes()
	// {
	// //TODO Completer.
	// }
	//
	// /**
	// * @return la liste des aliments périmés
	// */
	// public Hashtable<String, Aliment> alimentsPerimes()
	// {
	// //TODO Completer.
	// }

	// /**
	// * Méthode qui met à jour les recettes possibles
	// */
	// private void mAJRecettePossible()
	// {
	// //TODO Completer.
	// }

	public String toString()
	{
		String affichage = "Les aliments du frigo : \n\n";

		if (this.alimentsDuFrigo.isEmpty())
			affichage += "Il n'y a pas d'aliment dans le frigo";
		else
			for (Aliment alimentCourant : this.alimentsDuFrigo.values())
				affichage += alimentCourant.toString() + ", ";

		affichage += ".\n \nLes recettes disponibles : \n\n";

		if (this.recettesDisponibles.isEmpty())
			affichage += "Il n'y a pas de recette disponible";
		else
			for (Recette recetteCourante : this.recettesDisponibles.values())
				affichage += recetteCourante.toString() + ", ";
		
		return affichage + ".\n";
	}

	public Hashtable<String, Recette> obtenirRecetteDisponible()
	{
		return this.recettesDisponibles;
	}
}