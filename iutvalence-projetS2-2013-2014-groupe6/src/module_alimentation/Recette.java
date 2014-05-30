package module_alimentation;

import java.util.Hashtable;

import exception.RecetteDejaEnMemoireException;
import exception.RecetteInconnueException;

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
	private static Hashtable<String, Recette> toutesLesRecettesConnues;

	// *********************
	// ATTRIBUT :
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
	// CONSTRUCTEURS :
	// *********************

	/**
	 * @param aliments
	 *            aliments necessaires
	 * @param nom
	 *            de la recette
	 * @throws RecetteDejaEnMemoireException
	 *             levé si la recette est deja en mémoire
	 */
	public Recette(Hashtable<String, Aliment> aliments, String nom) throws RecetteDejaEnMemoireException

	{
		
		if (Recette.toutesLesRecettesConnues.containsKey(nom))
			throw new RecetteDejaEnMemoireException();
		else
		{
			this.nom = nom;
			this.alimentsNecessaires = aliments;
			Recette.toutesLesRecettesConnues.put(nom, this);
		}

	}

	// *********************
	// METHODES :
	// *********************

	/**
	 * @return l'ensemble des recettes disponibles
	 */
	public static Hashtable<String, Recette> obtenirToutesLesRecettesConnues()
	{
		return Recette.toutesLesRecettesConnues;
	}

	/**
	 * @return le nom de la recette
	 */
	public String obtenirNom()
	{
		return this.nom;
	}

	/**
	 * @return l'ensemble des aliment nécessaires.
	 */
	public Hashtable<String, Aliment> obtenirAlimentNecessaire()
	{
		return this.alimentsNecessaires;
	}

	/**
	 * @return le nom de la recette
	 */
	public String toString()
	{
		String affichage = "";
	
		affichage+="La recette " + this.nom + " necessite : \n" ;
		for(Aliment alimentCourant : this.alimentsNecessaires.values())
		{
			affichage+= alimentCourant.obtenirQuantite() +" " + alimentCourant.obtenirNom() + "(s),";
		}
		
		return affichage +=".";
		
		//TODO Enlever la derniere virgule
	}
		
		

	/**
	 * Initialise la collection qui contient toutes les recettes connues
	 */
	public static void initialiserCollection()
	{
		Recette.toutesLesRecettesConnues=new Hashtable<>();
		
	}
	
	/**
	 * @param nomRecette nom de la recette � trouver
	 * @return la recette si elle est presente, null sion
	 * @throws RecetteInconnueException 
	 */
	public static Recette obtenirLaRecette(String nomRecette) throws RecetteInconnueException
	{
		if(Recette.toutesLesRecettesConnues.containsKey(nomRecette))
			return Recette.toutesLesRecettesConnues.get(nomRecette);
		else
			throw new RecetteInconnueException();
	}
	
}