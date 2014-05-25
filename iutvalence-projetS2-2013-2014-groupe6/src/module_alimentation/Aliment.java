package module_alimentation;

import java.util.Date;
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * @author geourjoa
 * 
 */
public class Aliment
{

	/**
	 * Nom de l'aliment.
	 */
	private String nom;

	/**
	 * QuantitÃ© que l'on rajoute dans le frigo.
	 */
	private Integer quantite;

	// TODO Suppression des dates de peremption car trop compliqué. Pour pouvoir
	// le mettre en oeuvre, il faudrait faire des colections de collections ou
	// la clé de la premiere, la seconde la clé est la date

	// /**
	// * Date de pÃ©remption de l'aliment.
	// */
	// private Date datePeremption;

	/**
	 * @param nomAliment
	 *            nom de l'aliment
	 * @param quantiteInitiale
	 *            quantite du produit
	 */
	public Aliment(String nomAliment, Integer quantiteInitiale)
	{
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;
	}

	/**
	 * @return nom
	 */
	public String obtenirNom()
	{
		return this.nom;
	}

	// /**
	// * @return date de peremption
	// */
	// public Date obtenirDateDePeremption()
	// {
	// return this.datePeremption;
	// }

	/**
	 * @param variation
	 *            change la quantitÃ© de l'aliment
	 */
	public void changerQuantite(Integer variation)
	{
		this.quantite += variation;
	}

	public String toString()
	{
		return (this.nom + "(" + this.quantite + " unitï¿½(s)");
	}

	public Integer obtenirQuantite()
	{
		return quantite;
	}
}