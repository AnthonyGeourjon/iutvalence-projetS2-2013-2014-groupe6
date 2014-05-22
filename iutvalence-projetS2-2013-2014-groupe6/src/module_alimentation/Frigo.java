package module_alimentation;

import java.util.HashSet;
import java.util.Date;

import Exception.AlimentsInexistantException;

/**
 * @author geourjoa
 * 
 */
public class Frigo
{

	/**
	 * Ensemble des aliments du frigo
	 */
	private Aliment[] alimentsDuFrigo;

	/**
	 * Ensemble des recettes pouvant etre r�alis� avec le frigo en l'�tat
	 */
	private Recette[] recettesDisponibles;

	/**
	 * nombre max d'aliments pouvant etre contenu
	 */
	private static final Integer NOMBRE_MAX_D_ALIMENT_DANS_LE_FRIGO = 100;

	private int nombreDAlimentDansLeFrigo;

	/**
	 * Constructeur
	 */
	public Frigo()
	{
		this.alimentsDuFrigo = new Aliment[Aliment.NOMBRE_MAX_DALIMENTS];
		this.recettesDisponibles = new Recette[Recette.NOMBRE_MAX_DE_RECETTES];
	}

	/**
	 * @param alimentAAjouter
	 *            aliment qui sera ajout� au frigo
	 */
	public void insererAliment(Aliment alimentAAjouter)
	{
		// TODO Verifier sil'aliment n'y est pas

		this.alimentsDuFrigo[this.nombreDAlimentDansLeFrigo] = alimentAAjouter;
		this.nombreDAlimentDansLeFrigo++;

		// TODO mAJRecettePossible();
	}

	/**
	 * @param alimentASupprimer
	 *            aliment qui sera retir� du frigo
	 * @throws AlimentsInexistantException
	 *             lev� si l'aliment n'est pas dans le frigo
	 */
	public void supprimerAliment(String nomAlimentASupprimer) throws AlimentsInexistantException
	{
		boolean trouve = false;
		int placeAlimentATrouver = 0;

		for (Aliment alimentCourant : this.alimentsDuFrigo)
		{
			if (nomAlimentASupprimer == alimentCourant.obtenirNom())
				trouve = true;
			else
				placeAlimentATrouver++;
		}

		if (trouve)
			throw new AlimentsInexistantException();
		else
		{
			for (int place = placeAlimentATrouver; place < this.nombreDAlimentDansLeFrigo; place++)
				this.alimentsDuFrigo[place] = this.alimentsDuFrigo[place + 1];
			this.nombreDAlimentDansLeFrigo--;
		}

	}

	/**
	 * Supprimer les aliments périmées
	 */
	public void supprimerAlimentsPerimes()
	{
		for (Aliment alimentASupprimer : this.alimentsPerimes())
		{
			

		}
	}

	/**
	 * @return la liste des aliments périmés
	 */
	public Aliment[] alimentsPerimes()
	{
		Aliment[] alimentsPerimes=new Aliment[Frigo.NOMBRE_MAX_D_ALIMENT_DANS_LE_FRIGO];
		
		int placeAlimentPerimes=0;

		for (Aliment alimentCourant : this.alimentsDuFrigo)
		{

			if (alimentCourant.obtenirDateDePeremption().before(new Date()))
			{
				for (int place = placeAlimentPerimes; place < this.nombreDAlimentDansLeFrigo; place++)
					this.alimentsDuFrigo[place] = this.alimentsDuFrigo[place + 1];
				this.nombreDAlimentDansLeFrigo--;
			}
			else
				placeAlimentPerimes++;
		}

		return alimentsPerimes;

	}

	/**
	 * Méthode qui met à jour les recettes possibles
	 */
	private void mAJRecettePossible()
	{
		if (!Recette.obtenirToutesLesRecettesDisponibles().isEmpty())
		{
			Recette[] recettesDisponibles = (Recette[]) Recette.obtenirToutesLesRecettesDisponibles().toArray();

			Boolean recetteValide;

			for (Recette recetteCourante : recettesDisponibles)
			{
				recetteValide = true;

				for (Aliment alimentCourant : recetteCourante.obtenirAlimentNecessaire())
				{
					if (!this.alimentsDuFrigo.contains(alimentCourant))
					{
						recetteValide = false;
					}
				}

				if (recetteValide)
					this.recettesDisponibles.add(recetteCourante);
			}
		}

	}

	/**
	 * @return les éléments du frigo
	 */
	public HashSet<Aliment> obtenirAlimenstDuFrigo()
	{
		return this.alimentsDuFrigo;
	}

	public String toString()
	{
		String affichage = "Les aliments du frigo : \n\n";

		for (Object alimentCourant : this.alimentsDuFrigo.toArray())
		{
			affichage += alimentCourant.toString() + ", ";
		}

		affichage += ".\n \nLes recettes disponibles : \n\n";

		for (Object recetteCourante : this.recettesDisponibles.toArray())
		{
			affichage += recetteCourante.toString() + ", ";
		}

		affichage += ".";

		return affichage;
	}

}