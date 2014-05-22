import interaction.Interaction;

import java.util.HashSet;
import java.util.Scanner;

import Exception.AlimentsInexistantException;
import Exception.ChoixIncorrectException;
import affichage.Affichage;
import module_alimentation.Aliment;
import module_alimentation.Frigo;
import module_alimentation.Recette;
import module_scolaire.ModuleScolaire;

public class CouteauSuisse
{
	// ****** Attribut(s) ******

	private Interaction interaction;

	private Affichage affichage;

	/**
	 * Frigo associé à l'application
	 */
	private Frigo leFrigo;

	/**
	 * Scolarit� de l'�tudiant
	 */
	private ModuleScolaire moduleScolaire;

	// ****** Constructeur(s) ******

	public CouteauSuisse(Interaction interaction, Affichage affichage, Frigo frigo)
	{
		this.affichage = affichage;
		this.interaction = interaction;
		this.leFrigo = frigo;
		this.moduleScolaire = new ModuleScolaire();
	}

	// ****** Méthode(s) ******

	/**
	 * Méthode qui ajoute un aliment dans le frigo.
	 */
	private void insererAliment(Aliment alimentAAjouter)
	{
		this.leFrigo.insererAliment(alimentAAjouter);
	}

	/**
	 * Méthode qui supprime un aliment du frigo. On lève une exception si ca ne
	 * fonctionnne pas.
	 */
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

	/**
	 * Méthode qui supprime un aliment périmé du frigo.
	 */
	private void supprimerAlimentsPerimes()
	{
		this.leFrigo.supprimerAlimentsPerimes();
	}

	/**
	 * Méthode qui affiche les aliments périmés du frigo.
	 */
	private HashSet<Aliment> obtenirAlimentsPerimes()
	{
		return this.leFrigo.alimentsPerimes();
	}

	/**
	 * Méthode qui affiche tout les aliments présents dans le frigo.
	 */
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
			case 0:
				application = false;
				break;
			case 1:
				this.affichage.demanderUnAliment();
				this.insererAliment(this.interaction.saisirUnAliment());
				;
				break;
			case 2:
				// this.interaction.demanderUnNom();
				// this.supprimerAliment(alimentASupprimer);
				break;
			case 3:
				for (Aliment alimentCourant : ((Aliment[]) this.obtenirAlimentsPerimes().toArray()))
					System.out.println(alimentCourant);
				break;
			case 4:
				this.supprimerAlimentsPerimes();
				break;
			case 5:
				System.out.println(this.leFrigo);
				break;
			case 6:
				this.affichage.demanderUneRecette();
				this.interaction.demanderUneRecette();
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

}
