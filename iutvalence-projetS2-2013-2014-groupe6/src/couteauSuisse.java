import java.util.HashSet;
import java.util.Scanner;

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

	/**
	 * Accede à l'application
	 */
	public void utiliserLeCouteauSuisse()
	{
		Boolean application = true;

		System.out.println("Le couteau suisse de l'étudiant :\n\n");

		while (application)
		{
			Scanner sc = new Scanner(System.in);

			System.out.println("Menu principal : \n\n 1-Module Frigo, \n\nAutre-Quitter.");

			System.out.println("Veuillez saisir votre choix :");

			switch (sc.nextInt())
			{
			case 1:
				this.optionDuModuleFrigo();
				break;
			default:
				try
				{
					throw new choixIncorrectException();
				}
				catch (choixIncorrectException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * Permet d'acceder au module Frigo
	 */
	private void optionDuModuleFrigo()
	{
		System.out.println("Module Gestion de frigo : \n 1-Inserer un aliment au frigo, \n2-Supprimer un aliment du frigo, \n3-Supprimer les alimentsPerimées, \n4-Affihcer le frigo");

	}

}
