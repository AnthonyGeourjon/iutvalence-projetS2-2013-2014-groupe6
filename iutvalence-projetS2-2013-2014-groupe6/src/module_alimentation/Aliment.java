package module_alimentation;

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
	 * nombre d'exepmlaire de l'aliment
	 */
	private Integer quantite;

	// TODO Suppression des dates de peremption car trop compliqu�. Pour
	// pouvoir
	// le mettre en oeuvre, il faudrait faire des colections de collections ou
	// la cl� de la premiere, la seconde la cl� est la date

	// /**
	// * Date de péremption de l'aliment.
	// */
	// private Date datePeremption;

	/**
	 * Prix � l'unit� de l'aliment
	 */
	private Integer prix;

	/**
	 * @param nomAliment
	 *            nom de l'aliment
	 * @param quantiteInitiale
	 *            quantite du produit
	 * @param prix
	 *            prix de l'aliment
	 */
	public Aliment(String nomAliment, Integer quantiteInitiale, Integer prix)
	{
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;
		this.prix = prix;
	}

	/**
	 * @return le nom de l'alimentt
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
	 *            change la quantit� de l'aliment
	 */
	public void changerQuantite(Integer variation)
	{
		this.quantite += variation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return (this.nom + "(" + this.quantite + " unit�(s)");
	}

	/**
	 * @return la quantite de l'aliment
	 */
	public Integer obtenirQuantite()
	{
		return this.quantite;
	}

	/**
	 * @return la valeur des aliments
	 */
	public Integer obtenirValeurTotalDeLAliment()
	{
		return this.prix * this.quantite;
	}
}