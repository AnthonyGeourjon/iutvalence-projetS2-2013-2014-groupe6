package module_alimentation;
import java.util.Hashtable;

import exception.NombreMaxDAlimentException;
import exception.RecetteDejaEnMemoireException;

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
	 * Ensemble des recettes enregistrés.
	 */
	private static Hashtable <String, Recette> TOUTES_LES_RECETTES_CONNUES;
	
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
	private Hashtable<String, Aliment> alimentsNecessaires;
	
	

	// *********************
	//    CONSTRUCTEURS :
	// *********************
		
	
	/**
	 * @param aliments aliments necessaires
	 * @param nombresDAliments nombre d'aliment necessaire à la recette
	 * @param nom de la recette 
	 * @throws RecetteDejaEnMemoireException 
	 * @throws NombreMaxDAlimentException levé si le tableau d'aliment est plein
	 */
	public Recette(Hashtable<String, Aliment> aliments, String nom) throws RecetteDejaEnMemoireException 

	{
		
		if(Recette.TOUTES_LES_RECETTES_CONNUES.containsKey(nom))
			throw new RecetteDejaEnMemoireException();
		else
		{
			this.nom=nom;
			this.alimentsNecessaires=aliments;
		}

	}
	
	// *********************
	//     METHODES :
	// *********************
		

	/**
	 * @return l'ensemble des recettes disponibles
	 */
	public static Hashtable<String, Recette> OBTENIR_TOUTES_LES_RECETETS_CONNUES()
	{
		return Recette.TOUTES_LES_RECETTES_CONNUES;
	}
	
	/**
	 * @return l'ensemble des aliment nécessaires.
	 */
	public Hashtable<String,Aliment> obtenirAlimentNecessaire()
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