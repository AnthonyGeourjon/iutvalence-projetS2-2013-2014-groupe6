import java.util.HashSet;


public class couteauSuisse
{
	/**
	 * Frigo associé à l'application
	 */
	private Frigo leFrigo;
	
	public void insererAliment(Aliment alimentAAjouter)
	{
		this.leFrigo.insererAliment(alimentAAjouter);
	}
	
	public void supprimerAliment(Aliment alimentASupprimer)
	{
		try
		{
			this.leFrigo.supprimerAliment(alimentASupprimer);
		}
		catch (alimentsInexistantException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void supprimerAlimentsPerimes()
	{
		this.leFrigo.supprimerAlimentsPerimes();
	}
	
	public HashSet<Aliment> obtenirAlimentsPerimes()
	{
		return this.leFrigo.alimentsPerimes();
	}
	
	public HashSet<Aliment> obtenirAlimentsDuFrigo()
	{
		return this.leFrigo.obtenirAlimenstDuFrigo();
	}
	
	
}
