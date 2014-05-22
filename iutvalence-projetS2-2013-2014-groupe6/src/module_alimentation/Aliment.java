package module_alimentation;

import java.util.Date;
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
	private static Aliment[] ENSEMBLE_DES_ALIMENTS_CONNUS;

	/**
	 * Nombre d'aliments connus
	 */
	private static Integer NOMBRE_D_ALIMENT_CONNUS;

	/**
	 * Nombre par défaut d'emplacement dans le tableau d'aliments connus
	 */
	private static final Integer NOMBRE_MAX_DALIMENTS=100;

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
	 * @param nomAliment
	 *            nom de l'aliment
	 * @param datePeremption
	 *            date de peremption de l'aliment*
	 * @param quantiteInitiale
	 *            quantite du produit
	 * @throws NombreMaxDAlimentAtteintException
	 *             levé si il n'y pas plus de place
	 */
	public Aliment(String nomAliment, Date datePeremption, Integer quantiteInitiale)
			throws NombreMaxDAlimentAtteintException
	{
		if (Aliment.NOMBRE_D_ALIMENT_CONNUS != Aliment.NOMBRE_MAX_DALIMENTS)
		{
			this.datePeremption = datePeremption;
			this.nom = nomAliment;
			this.quantite = quantiteInitiale;

			Aliment.ENSEMBLE_DES_ALIMENTS_CONNUS[Aliment.NOMBRE_D_ALIMENT_CONNUS++] = this;

			// TODO Verifier que l'aliment n'est pas deja connu

		}
		else
			throw new NombreMaxDAlimentAtteintException();
	}

	/**
	 * @return nom
	 */
	public String obtenirNom()
	{
		return this.nom;
	}

	/**
	 * @return date de peremption
	 */
	public Date obtenirDateDePeremption()
	{
		return this.datePeremption;
	}

	/**
	 * @param variation change la quantité de l'aliment
	 */
	public void changerQuantite(Integer variation)
	{
		this.quantite += variation;
	}

	public String toString()
	{
		return (this.nom + "(" + this.quantite + " unit�(s)");
	}

	/**
	 * Initialise le tableau qui contient tout les aliments connus
	 */
	public static void initialiserTableauEnsembleDesAlimentsConnus()
	{
		Aliment.ENSEMBLE_DES_ALIMENTS_CONNUS = new Aliment[Aliment.NOMBRE_MAX_DALIMENTS];

	}

}