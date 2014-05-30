package general;

import exception.ChoixIncorrectException;
import interaction.Interaction;
import affichage.Affichage;
import module_agenda.ModuleAgenda;
import module_alimentation.ModuleAlimentation;
import module_scolaire.ModuleScolaire;
import module_budget.ModuleBudget;

/**
 * @author geourjoa
 * 
 */
public class CouteauSuisse
{
	// ****** Attribut(s) ******

	/**
	 * Interaction utilis�e
	 */
	private Interaction interaction;

	/**
	 * Affichage utilis�
	 */
	private Affichage affichage;

	/**
	 * Scolarit� de l'�tudiant
	 */
	private ModuleScolaire moduleScolaire;

	/**
	 * Alimentation de l'�tudiant
	 */
	private ModuleAlimentation moduleAlimentation;
	
	
	private ModuleAgenda moduleAgenda ;
	
	private ModuleBudget moduleBudget;

	// ****** Constructeur(s) ******

	/**
	 * @param interaction
	 *            Interaction utilis�
	 * @param affichage
	 *            Affichage utilis�
	 * @param frigo
	 *            frigo du module
	 */
	public CouteauSuisse(Interaction interaction, Affichage affichage)
	{
		this.affichage = affichage;
		this.interaction = interaction;
		this.moduleScolaire = new ModuleScolaire();
		this.moduleAlimentation = new ModuleAlimentation();
		this.moduleAgenda = new ModuleAgenda();
		this.moduleBudget = new ModuleBudget();
	}

	// ****** Méthode(s) ******

	/**
	 * Acceder � l'application
	 */
	public void utiliserLeCouteauSuisse()
	{
		Boolean application = true;

		this.affichage.afficherLeNomDeLApplication();

		while (application)
		{
			this.affichage.afficherMenuPrincipal();

			switch (this.interaction.demanderUnInt())
			{
			case 0:
				application = false;
				this.affichage.notifierArretApplication();
				break;
			case 1:
				this.moduleAlimentation.utiliserModule(this.affichage, this.interaction);
				break;
			case 2:
				this.moduleScolaire.utiliserModule(this.affichage, this.interaction);
				break;

				
			case 3:
				this.moduleAgenda.utiliserModule(this.affichage, this.interaction);
				break;
				
			case 4:
				this.moduleBudget.utiliserModule(this.affichage, this.interaction);

			/* TODO Rajouter l'utilisation des autres modules + affichage */


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
