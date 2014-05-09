import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Aliment
{
	private static HashSet<Aliment> ensembleDesAlimentsConnus;

	private String nom;

	private Integer quantite;

	private Date datePeremption;

	private Integer nombreDExemplaire;

	private Integer prix;

	public Aliment(Date datePeremption, String nomAliment, Integer quantiteInitiale, Integer nombreDExemplaireInitial,
			Integer prix)
	{
		this.datePeremption = datePeremption;
		this.nom = nomAliment;
		this.quantite = quantiteInitiale;
		this.nombreDExemplaire = nombreDExemplaireInitial;

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

	public void changerNombreDExemplaire(Integer variation)
	{
		this.nombreDExemplaire += variation;
	}

	public Integer obtenirPrix()
	{
		return this.prix;
	}

}