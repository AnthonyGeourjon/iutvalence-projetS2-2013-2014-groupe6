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
	 * @param hashSet aliments n�cessaires à sa confection 
	 * @param nom de la recette 
	 */
	public Recette(HashSet<Aliment> aliments, String nom)

	{
		this.nom = nom;
		this.alimentsNecessaires = aliments;

		

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
	
	/**
	 * @return l'ensemble des aliment nécessaires.
	 */
	public HashSet<Aliment> obtenirAlimentNecessaire()
	{
		return this.alimentsNecessaires;
	}
	
	/**
	 * @return le nom de la recette
	 */
	public String toString()
	{
		return this.nom;
	}
	
	/**
	 * Méthode utilisée pour ajouter la recette
	 */
	public static void ajouterUneRecette(Recette recetteAAjouter)
	{
		Recette.toutesLesRecettesDisponibles.add(recetteAAjouter);
	}

}