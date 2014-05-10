import java.util.HashSet;

public class Recette
{

	// Ajouter des variables "Qualité", "Auteur" et "difficulté"

	/**
	 * Ensemble des recettes enregistrés.
	 */
	private static HashSet<Recette> toutesLesRecettesDisponibles;

	/**
	 * Nom de la recette 
	 */
	private String nom;

	/**
	 * Ensemble des aliments nécessaires à sa confection 
	 */
	private HashSet<Aliment> alimentsNecessaires;

	/**
	 * @param alimentsNecessaires aliments nécessaires à sa confection 
	 * @param nom nom de la recette 
	 */
	public Recette(Aliment[] alimentsNecessaires, String nom)

	{
		this.nom = nom;
		this.alimentsNecessaires = new HashSet<>();

		for (Aliment alimentCourant : alimentsNecessaires)
		{
			this.alimentsNecessaires.add(alimentCourant);
		}

		Recette.toutesLesRecettesDisponibles.add(this);

		// TODO Verifier si la recette n'est pas deja presente

	}

	/**
	 * @return l'ensemble des recettes disponibles
	 */
	public static HashSet<Recette> obtenirToutesLesRecettesDisponibles()
	{
		return toutesLesRecettesDisponibles;
	}
	
	public HashSet<Aliment> obtenirAlimentNecessaire()
	{
		return this.alimentsNecessaires;
	}
	
	public String toString()
	{
		return this.nom;
	}

}