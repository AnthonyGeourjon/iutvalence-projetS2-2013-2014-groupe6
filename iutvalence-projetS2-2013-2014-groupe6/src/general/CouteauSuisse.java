package general;

import interaction.Interaction;

import java.util.HashSet;
import java.util.Scanner;

import Exception.AlimentsInexistantException;
import Exception.ChoixIncorrectException;
import affichage.Affichage;
import module_alimentation.Aliment;
import module_alimentation.Frigo;
import module_alimentation.ModuleAlimentation;
import module_alimentation.Recette;
import module_scolaire.ModuleScolaire;

public class CouteauSuisse
{
	// ****** Attribut(s) ******

	protected Interaction interaction;

	protected Affichage affichage;

	

	/**
	 * Scolarit� de l'�tudiant
	 */
	private ModuleScolaire moduleScolaire;
	
	/**
	 * Alimentation de l'�tudiant
	 */
	private ModuleAlimentation moduleAlimentation;

	// ****** Constructeur(s) ******

	public CouteauSuisse(Interaction interaction, Affichage affichage, Frigo frigo)
	{
		this.affichage = affichage;
		this.interaction = interaction;
		this.moduleScolaire = new ModuleScolaire();
	}

	// ****** Méthode(s) ******


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
				this.moduleAlimentation.utiliserModule(this.affichage, this.interaction);
				break;
			
				/* Rajouter l'utilisation des autres modules */
				
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
