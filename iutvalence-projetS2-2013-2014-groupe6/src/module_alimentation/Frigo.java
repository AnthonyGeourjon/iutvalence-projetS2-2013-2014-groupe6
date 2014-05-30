package module_alimentation;

import java.util.Hashtable;

import exception.AlimentDejaPresentException;
import exception.AlimentsInexistantException;
import exception.RecetteInconnueException;

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
	 * Ensemble des recettes pouvant etre réalisées avec le frigo actuel
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
	 *            aliment qui sera ajouté au frigo
	 * @throws AlimentDejaPresentException levée si l'aliment est deja présent
	 */
	public void insererAliment(Aliment alimentAAjouter) throws AlimentDejaPresentException
	{

		if (this.alimentsDuFrigo.containsKey(alimentAAjouter.obtenirNom()))
		{
			throw new AlimentDejaPresentException();
		}
		else
			this.alimentsDuFrigo.put(alimentAAjouter.obtenirNom(), alimentAAjouter);

		this.mAJRecettePossible();
	}

	/**
	 * Met à jour la liste des recettes des aliments possibles
	 */
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
	 *            nom de l'aliment qui sera supprimé
	 * @throws AlimentsInexistantException
	 *             levée si l'aliment n'est pas dans le frigo
	 */
	public void supprimerAliment(String nomAlimentASupprimer) throws AlimentsInexistantException
	{
		if (this.alimentsDuFrigo.remove(nomAlimentASupprimer) == null)
			throw new AlimentsInexistantException();
	}	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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

	/**
	 * @return toutes les recettes disponibles
	 */
	public Hashtable<String, Recette> obtenirRecetteDisponible()
	{
		return this.recettesDisponibles;
	}

	/**
	 * @param nomAliment le nom de l'aliment auquel sera retiré la quantite
	 * @param quantiteARetirer la quantite a enlever
	 * @throws AlimentsInexistantException levé si l'aliment n'existe pas
	 */
	public void changerUneQuantiteDAliment(String nomAliment, int quantiteARetirer) throws AlimentsInexistantException
	{
		if(this.alimentsDuFrigo.containsKey(nomAliment))
		{
			this.alimentsDuFrigo.get(nomAliment).changerQuantite(quantiteARetirer);
			if(this.alimentsDuFrigo.get(nomAliment).obtenirQuantite()<=0)
				try
				{
					this.supprimerAliment(nomAliment);
				}
				catch (AlimentsInexistantException e)
				{
					// impossible la vérification est déja faite
					e.printStackTrace();
				}
		}
		else
			throw new AlimentsInexistantException();
		
		
	}

	/**
	 * @return le prix de l'ensemble des aliments du frigo
	 */
	public Integer prixDuFrigo()
	{
		Integer prixFrigo=0;
		
		for(Aliment alimentCourant : this.alimentsDuFrigo.values())
		{
			prixFrigo+=alimentCourant.obtenirValeurTotalDeLAliment();
		}
		
		return prixFrigo;
	}

	/**
	 * @param nomRecette nom de la recette à trouver
	 * @return la recette si elle est presente, null sion
	 * @throws RecetteInconnueException 
	 */
	public Recette obtenirLaRecette(String nomRecette) throws RecetteInconnueException
	{
		if(this.recettesDisponibles.containsKey(nomRecette))
			return this.recettesDisponibles.get(nomRecette);
		else
			throw new RecetteInconnueException();
	}
}