import java.util.HashSet;

public class Recette
{

	private static HashSet<Recette> toutesLesRecettesDisponibles;

	private String nom;

	private HashSet<Aliment> alimentsNecessaires;

	public Recette(Aliment[] alimentsNecessaires, String nom)

	{
		this.nom = nom;
		this.alimentsNecessaires=new HashSet<>();
		
		for (Aliment alimentCourant : alimentsNecessaires)
		{
			this.alimentsNecessaires.add(alimentCourant);
		}
		
		this.toutesLesRecettesDisponibles.add(this);
	}

	public HashSet<Recette> obtenirToutesLesRecettesDisponibles()
	{
		return toutesLesRecettesDisponibles;
	}

}