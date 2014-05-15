import java.util.HashSet;

public class Recette
{

	// Ajouter des variables "Qualit�", "Auteur" et "difficult�"

	/**
	 * Ensemble des recettes enregistr�s.
	 */
	private static HashSet<Recette> toutesLesRecettesDisponibles;

	/**
	 * Nom de la recette 
	 */
	private String nom;

	/**
	 * Ensemble des aliments n�cessaires � sa confection 
	 */
	private HashSet<Aliment> alimentsNecessaires;

	/**
	 * @param hashSet aliments n�cessaires � sa confection 
	 * @param nom nom de la recette 
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
	
	public HashSet<Aliment> obtenirAlimentNecessaire()
	{
		return this.alimentsNecessaires;
	}
	
	public String toString()
	{
		return this.nom;
	}
	
	public static void ajouterUneRecette(Recette recetteAAjouter)
	{
		Recette.toutesLesRecettesDisponibles.add(recetteAAjouter);
	}

}