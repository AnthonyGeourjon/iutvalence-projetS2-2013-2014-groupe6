package general;

import interaction.Interaction;
import Exception.ChoixIncorrectException;
import affichage.Affichage;
import module_alimentation.Frigo;
import module_alimentation.ModuleAlimentation;
import module_scolaire.ModuleScolaire;

/**
 * @author geourjoa
 *
 */
public class CouteauSuisse
{
	// ****** Attribut(s) ******
	
	/**
	 * Interaction utilisée
	 */
	private Interaction interaction;

	
	/**
	 * Affichage utilisé
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

	// ****** Constructeur(s) ******

	/**
	 * @param interaction Interaction utilisée
	 * @param affichage Affichage utilisé
	 * @param frigo frigo du module
	 */
	public CouteauSuisse(Interaction interaction, Affichage affichage)
	{
		this.affichage = affichage;
		this.interaction = interaction;
		this.moduleScolaire = new ModuleScolaire();
		this.moduleAlimentation = new ModuleAlimentation();
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
