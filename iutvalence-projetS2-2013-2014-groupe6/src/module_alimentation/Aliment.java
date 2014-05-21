package module_alimentation;
import java.util.Date;
import java.util.HashSet;

/**
 * @author geourjoa
 *
 */
public class Aliment
{
	/**
	 * 
	 */
	private static HashSet<Aliment> ensembleDesAlimentsConnus;

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
	 * Prix unitaire de l'aliment
	 */
	private Integer prix;

	public Aliment(String nomAliment, Date datePeremption, Integer quantiteInitiale, Integer prix)
	{
		this.datePeremption = datePeremption;
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;
		this.prix= prix;

	
		//TODO Ajouter l'aliment à la bibliothèque des aliments connus

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

	public Integer obtenirPrix()
	{
		return this.prix;
	}

	public String toString()
	{
		return (this.nom + "(" + this.quantite + " unit�(s)");
	}

}