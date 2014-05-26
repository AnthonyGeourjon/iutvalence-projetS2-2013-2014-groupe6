package module_alimentation;

import java.util.Hashtable;
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
		return this.nom;
	}

	public static void initialiserCollection()
	{
		Recette.toutesLesRecettesConnues=new Hashtable<>();
		
	}

}