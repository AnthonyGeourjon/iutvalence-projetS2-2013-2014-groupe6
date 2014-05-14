import java.util.HashSet;
import java.util.Scanner;

public class couteauSuisse
{
	// ****** Attribut(s) ******

	private Interaction interaction;

	private Affichage affichage;

	/**
	 * Frigo associé à l'application
	 */
	private Frigo leFrigo;

	// ****** Constructeur(s) ******

	public couteauSuisse(Interaction interaction, Affichage affichage, Frigo frigo)
	{
		this.affichage = affichage;
		this.interaction = interaction;
		this.leFrigo = frigo;
	}

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
		catch (AlimentsInexistantException e)
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

		this.affichage.afficherLeNomDeLApplication();

		while (application)
		{
			this.affichage.afficherLeMenu();

			switch (this.interaction.choixNumerique())
			{
			case 1:
				this.affichage.afficherSousMenu();
				this.affichage.demanderUnChoix();
				this.executerChoixSousMenuFrigo(this.interaction.choixNumerique());
				break;
			case 0:
				application = false;
				break;

			default:
				try
				{
					throw new ChoixIncorrectException();

				}
				catch (ChoixIncorrectException e)
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
	private void executerChoixSousMenuFrigo(int choix)
	{
		switch (choix)
		{
		case 1:
			this.affichage.demanderUnAliment();
			this.insererAliment(this.interaction.saisirUnAliment());;
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
				throw new ChoixIncorrectException();
			}
			catch (ChoixIncorrectException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
