package module_alimentation;

import exception.AlimentsInexistantException;
import exception.ChoixIncorrectException;
import interaction.Interaction;
import affichage.Affichage;
import general.Module;

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
	 * Constructeur par d�faut
	 */
	public ModuleAlimentation()
	{
		this.leFrigo = new Frigo();
		Recette.initialiserCollection();
	}

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
			affichageUtilise.afficherMenuAlimentation();

			switch (interactionUtilise.choixNumerique())
			{
			case 0:
				application = false;
				break;
			case 1:
				affichageUtilise.demanderUnAliment();
				this.leFrigo.insererAliment(interactionUtilise.saisirUnAliment());
				break;
			case 2:
				affichageUtilise.demanderUneChaineDeCaractere();
				try
				{
					this.leFrigo.supprimerAliment(interactionUtilise.demanderUneChaineDeCaractere());
				}
				catch (AlimentsInexistantException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				// TODO Completer

				affichageUtilise.messageDErreur();

				// for (Aliment alimentCourant : ((Aliment[])
				// this.leFrigo.alimentsPerimes().toArray()))
				// System.out.println(alimentCourant);

				break;
			case 4:
				// TODO Completer

				affichageUtilise.messageDErreur();

				// this.supprimerAlimentsPerimes();
				break;
			case 5:
				affichageUtilise.afficherUnFrigo(this.leFrigo);
				break;
			case 6:
				affichageUtilise.afficherDesRecettes(this.leFrigo.obtenirRecetteDisponible());
				break;
			case 7:
				affichageUtilise.afficherDesRecettes(Recette.obtenirToutesLesRecettesConnues());
				break;
			case 8:
				affichageUtilise.demanderUneRecette();
				interactionUtilise.saisirUneRecette();
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
