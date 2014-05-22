package module_alimentation;
import java.util.HashSet;

import Exception.NombreMaxDAlimentException;

/**
 * @author geourjoa
 *
 */
public class Recette
{
	// *********************
	// VARIABLE DE CLASSES :
	// *********************

	/**
	 * Nombre max d'aliments par recette
	 */
	public static final Integer NOMBRE_MAX_DALIMENT_PAR_RECETTE=10;
	
	/**
	 * Nombre max de recettes stockable
	 */
	public static final Integer NOMBRE_MAX_DE_RECETTES=500;
	
	
	/**
	 * Ensemble des recettes enregistrés.
	 */
	private static Recette[] TOUTES_LES_RECETTES_CONNUES;

	/**
	 * Nombre de recette connues
	 */
	private static Integer NOMBRE_RECETTE_CONNUES;
	
	// *********************
	//     ATTRIBUT :
	// *********************
	
	/**
	 * Nom de la recette 
	 */
	private String nom;

	/**
	 * Ensemble des aliments nécessaires à sa confection 
	 */
	private Aliment[] alimentsNecessaires;
	
	/**
	 * Nombre d'aliment necessaire à la recette
	 */
	private Integer nombresDAlimentsDeLaRecette;
	

	// *********************
	//    CONSTRUCTEURS :
	// *********************
		
	
	/**
	 * @param aliments aliments necessaires
	 * @param nombresDAliments nombre d'aliment necessaire à la recette
	 * @param nom de la recette 
	 * @throws NombreMaxDAlimentException levé si le tableau d'aliment est plein
	 */
	public Recette(Aliment[] aliments, Integer nombresDAliments, String nom) throws NombreMaxDAlimentException

	{
		if(Recette.NOMBRE_MAX_DE_RECETTES<nombresDAliments)
			throw new NombreMaxDAlimentException();
		
		//TODO Verrifier si la recette n'est pas presente
		
		this.nom = nom;
		this.alimentsNecessaires = aliments;
		this.nombresDAlimentsDeLaRecette=nombresDAliments;

		

		// TODO Verifier si la recette n'est pas deja presente

	}
	
	// *********************
	//     METHODES :
	// *********************
		

	/**
	 * @return l'ensemble des recettes disponibles
	 */
	public static Recette[] OBTENIR_TOUTES_LES_RECETETS_DISPONIBLES()
	{
		return Recette.TOUTES_LES_RECETTES_CONNUES;
	}
	
	/**
	 * @return l'ensemble des aliment nécessaires.
	 */
	public Aliment[] obtenirAlimentNecessaire()
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
	
}