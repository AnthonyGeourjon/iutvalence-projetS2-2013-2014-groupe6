import java.util.HashSet;
import java.util.Date;

/**
 * @author geourjoa
 *
 */
public class Frigo
{

	/**
	 * Ensemble des aliments du frigo
	 */
	private HashSet<Aliment> alimentsDuFrigo;

	/**
	 * Ensemble des recettes pouvant etre r�alis� avec le frigo en l'�tat
	 */
	private HashSet<Recette> recettesDisponibles;

	/**
	 * Constructeur
	 */
	public Frigo()
	{
		this.alimentsDuFrigo = new HashSet<>();
		this.recettesDisponibles = new HashSet<>();
	}

	/**
	 * @param alimentAAjouter
	 *            aliment qui sera ajout� au frigo
	 */
	public void insererAliment(Aliment alimentAAjouter)
	{
		//TODO Verifier sil'aliment n'y est pas 
		
		this.alimentsDuFrigo.add(alimentAAjouter);
		//TODO mAJRecettePossible();
	}

	/**
	 * @param alimentASupprimer
	 *            aliment qui sera retir� du frigo
	 * @throws AlimentsInexistantException
	 *             lev� si l'aliment n'est pas dans le frigo
	 */
	public void supprimerAliment(Aliment alimentASupprimer) throws AlimentsInexistantException
	{
		if (!this.alimentsDuFrigo.remove(alimentASupprimer))
			throw new AlimentsInexistantException();
		//TODO mAJRecettePossible();
	}

	/**
	 * Supprimer les aliments périmées
	 */
	public void supprimerAlimentsPerimes()
	{
		for (Aliment alimentASupprimer : this.alimentsPerimes())
		{
			try
			{
				this.supprimerAliment(alimentASupprimer);
			}

			catch (AlimentsInexistantException e)
			{
				// Inutile ici car l'aliment est forc�ment dans le frigo si il
				// est périmé
			}

		}
	}

	/**
	 * @return la liste des aliments périmés
	 */
	public HashSet<Aliment> alimentsPerimes()
	{
		HashSet<Aliment> alimentsPerimes = new HashSet<>();

		Object[] lesAliments = this.alimentsDuFrigo.toArray();

		for (Object alimentCourant : lesAliments)
		{

			if (((Aliment) alimentCourant).obtenirDateDePeremption().before(new Date()))
			{
				alimentsPerimes.add((Aliment) alimentCourant);
			}
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