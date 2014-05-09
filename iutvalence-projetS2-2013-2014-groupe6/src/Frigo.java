import java.util.HashSet;
import java.util.Date;

public class Frigo
{

	/**
	 * Ensemble des aliments du frigo
	 */
	private HashSet<Aliment> alimentsDuFrigo;
	
	/**
	 * Ensemble des recettes pouvant etre réalisé avec le frigo en l'état
	 */
	private HashSet<Recette> recettesDisponibles;

	/**
	 * Constructeur
	 */
	public Frigo()
	{
		this.alimentsDuFrigo = new HashSet<>();
	}

	/**
	 * @param alimentAAjouter aliment qui sera ajouté au frigo
	 */
	public void insererAliment(Aliment alimentAAjouter)
	{
		this.alimentsDuFrigo.add(alimentAAjouter);
		mAJRecettePossible();
	}

	/**
	 * @param alimentASupprimer aliment qui sera retiré du frigo
	 * @throws alimentsInexistantException levé si l'aliment n'est pas dans le frigo 
	 */
	public void supprimerAliment(Aliment alimentASupprimer) throws alimentsInexistantException
	{
		if (!this.alimentsDuFrigo.remove(alimentASupprimer))
			throw new alimentsInexistantException();
		mAJRecettePossible();
	}
	
	public void supprimerAlimentsPerimes()
	{
		for ( Aliment alimentASupprimer : this.alimentsPerimes())
		{
			try
			{
				this.supprimerAliment(alimentASupprimer);
			}
			
			//Inutile ici car l'aliment est forcément dans le frigo si il est périmé
			catch (alimentsInexistantException e)
			{
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
		Recette[] recettesDisponibles = (Recette[])Recette.obtenirToutesLesRecettesDisponibles().toArray();
		Boolean recetteValide;
		
		for ( Recette recetteCourante: recettesDisponibles)
		{
			recetteValide=true;
			
			for ( Aliment alimentCourant : recetteCourante.obtenirAlimentNecessaire())
			{
				if(!this.alimentsDuFrigo.contains(alimentCourant))
				{
					recetteValide=false;
				}
			}
			
			if(recetteValide)
				this.recettesDisponibles.add(recetteCourante);
		}
		
		
	}

	/**
	 * @return les éléments du frigo
	 */
	public HashSet<Aliment> obtenirAlimenstDuFrigo()
	{
		return this.alimentsDuFrigo;
	}

}