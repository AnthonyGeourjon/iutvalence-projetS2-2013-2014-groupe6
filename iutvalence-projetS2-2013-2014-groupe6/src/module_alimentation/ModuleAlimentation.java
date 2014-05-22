package module_alimentation;

import interaction.Interaction;
import affichage.Affichage;
import general.CouteauSuisse;
import general.Module;
import Exception.ChoixIncorrectException;

/**
 * @author geourjoa
 * 
 */
public class ModuleAlimentation implements Module
{
	/**
	 * Frigo associé au module
	 */
	private Frigo leFrigo;

	/**
	 * @param affichageUtilise
	 *            affichage que l'on utilise
	 * @param interactionUtilise
	 *            interaction que l'on utilise
	 */
	public void utiliserModule(Affichage affichageUtilise, Interaction interactionUtilise)
	{
		Boolean application = true;

		while (application)
		{
			affichageUtilise.afficherLeMenu();

			switch (interactionUtilise.choixNumerique())
			{
			case 0:
				application = false;
				break;
			case 1:
				affichageUtilise.demanderUnAliment();
				this.leFrigo.insererAliment(interactionUtilise.saisirUnAliment());
				;
				break;
			case 2:
				// this.interaction.demanderUnNom();
				// this.supprimerAliment(alimentASupprimer);
				break;
			case 3:
				// TODO Pas encore passé en tableau

				for (Aliment alimentCourant : ((Aliment[]) this.leFrigo.alimentsPerimes().toArray()))
					System.out.println(alimentCourant);
				break;
			case 4:
				// TODO Pas encore passé en tableau

				// this.supprimerAlimentsPerimes();
				break;
			case 5:
				System.out.println(this.leFrigo);
				break;
			case 6:
				affichageUtilise.demanderUneRecette();
				interactionUtilise.demanderUneRecette();
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
