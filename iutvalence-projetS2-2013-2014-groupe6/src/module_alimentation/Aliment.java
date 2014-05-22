package module_alimentation;
import java.util.Date;
import java.util.HashSet;

import Exception.NombreMaxDAlimentAtteintException;

/**
 * @author geourjoa
 *
 */
public class Aliment
{
	/**
	 * Ensembles des aliments connus
	 */
	private static Aliment[] ensembleDesAlimentsConnus;
	
	/**
	 * Nombre d'aliments connus
	 */
	private static Integer nombresDALimentsConnus;
	
	/**
	 * Nombre par défaut d'emplacement dans le tableau d'aliments connus
	 */
	private static Integer NOMBRE_MAX_DALIMENTS;

	/**
	 * Nom de l'aliment.
	 */
	private String nom;

	/**
	 * Quantité que l'on rajoute dans le frigo.
	 */
	private Integer quantite;

	/**
	 * Date de péremption de l'aliment.
	 */
	private Date datePeremption;

	/**
	 * @param nomAliment nom de l'aliment
	 * @param datePeremption date de peremption de l'aliment* 
	 * @param quantiteInitiale quantite du produit 
	 * @throws NombreMaxDAlimentAtteintException levé si il n'y pas plus de place
	 */
	public Aliment(String nomAliment, Date datePeremption, Integer quantiteInitiale) throws NombreMaxDAlimentAtteintException
	{
		if(Aliment.nombresDALimentsConnus!=Aliment.NOMBRE_MAX_DALIMENTS)
		{
			this.datePeremption = datePeremption;
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;
		
		Aliment.ensembleDesAlimentsConnus[Aliment.nombresDALimentsConnus++]=this;
		
		//TODO Verifier que l'aliment n'est pas deja connu
		
		}
		else
			throw new NombreMaxDAlimentAtteintException();
	}

	public String obtenirNom()
	{
		return this.nom;
	}

	public Date obtenirDateDePeremption()
	{
		return this.datePeremption;
	}

	public void changerQuantite(Integer variation)
	{
		this.quantite += variation;
	}

	public String toString()
	{
		return (this.nom + "(" + this.quantite + " unit�(s)");
	}

	public static void initialiserTableauEnsembleDesAlimentsConnus()
	{
		Aliment.ensembleDesAlimentsConnus=new Aliment[Aliment.NOMBRE_MAX_DALIMENTS];
		
	}

}