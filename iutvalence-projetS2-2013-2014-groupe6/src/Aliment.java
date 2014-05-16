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

	private String nom;

	private Integer quantite;

	private Date datePeremption;

	private Integer prix;

	public Aliment(String nomAliment, Date datePeremption, Integer quantiteInitiale, Integer prix)
	{
		this.datePeremption = datePeremption;
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;
		this.prix= prix;

		

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