import java.util.HashSet;
import java.util.Scanner;

public class couteauSuisse
{
	// ****** Variable(s) ******
	
	/**
	 * Frigo associé à l'application
	 */
	private Frigo leFrigo;

	// ****** Constructeur(s) ******
	
	// ****** Méthode(s) ******
	
	private void insererAliment(Aliment alimentAAjouter)
	{
		this.leFrigo.insererAliment(alimentAAjouter);
	}

	private void supprimerAliment(Aliment alimentASupprimer)
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

	private void supprimerAlimentsPerimes()
	{
		this.leFrigo.supprimerAlimentsPerimes();
	}

	private HashSet<Aliment> obtenirAlimentsPerimes()
	{
		return this.leFrigo.alimentsPerimes();
	}

	private HashSet<Aliment> obtenirAlimentsDuFrigo()
	{
		return this.leFrigo.obtenirAlimenstDuFrigo();
	}

	/**
	 * Acceder à l'application
	 */
	public void utiliserLeCouteauSuisse()
	{
		Boolean application = true;

		System.out.println("Le couteau suisse de l'étudiant :\n\n");

		while (application)
		{
			Scanner sc = new Scanner(System.in);

			System.out.println("Menu principal : \n\n1-Module Frigo, \n0-Quitter.\n");

			System.out.println("Veuillez saisir votre choix :");

			switch (sc.nextInt())
			{
			case 1:
				this.optionDuModuleFrigo();
				break;
			case 0:
				application=false;
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
	 * Permet d'acceder au module Frigo.
	 */
	private void optionDuModuleFrigo()
	{

		Scanner sc = new Scanner(System.in);

		System.out
				.println("Module Gestion de frigo : \n1-Inserer un aliment au frigo, \n2-Supprimer un aliment du frigo, \n3-Afficher les aliments périmés\n4-Supprimer les aliments perimés, \n5-Afficher le frigo\n0-Menu prinicpal");
		System.out.println("Veuillez saisir votre choix :");

		switch (sc.nextInt())
		{
		case 1:

			// Demander à l'utilisateur un aliment
			// this.insererAliment(alimentAAjouter);;
			break;
		case 2:
			// Demander à l'utilisateur un aliment
			// this.supprimerAliment(alimentASupprimer);
			break;
		case 3:
			for (Aliment alimentCourant : ((Aliment[]) this.obtenirAlimentsPerimes().toArray()))
			{
				System.out.println(alimentCourant);
			}
			break;
		case 4:
			this.supprimerAlimentsPerimes();
			break;
		case 5:
			System.out.println(this.leFrigo);
			break;
		case 0:
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
