import java.util.Date;
import java.util.HashSet;

public class Aliment
{
	private static HashSet<Aliment> ensembleDesAlimentsConnus;

	private String nom;

	private Integer quantite;

	private Date datePeremption;

	private Integer prix;

	public Aliment(Date datePeremption, String nomAliment, Integer quantiteInitiale, Integer prix)
	{
		this.datePeremption = datePeremption;
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;

		Aliment.ensembleDesAlimentsConnus.add(this);

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
		return (this.nom + "(" + this.quantite + " unité(s)");
	}

}