package module_alimentation;

import exception.AlimentDejaPresentException;
import exception.AlimentsInexistantException;
import exception.ChoixIncorrectException;
import exception.RecetteDejaEnMemoireException;
import exception.RecetteInconnueException;
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

			switch (interactionUtilise.demanderUnInt())
			{
			case 0:
				application = false;
				break;
			case 1:
				affichageUtilise.demanderUnAliment();
				try
				{
					this.leFrigo.insererAliment(interactionUtilise.demanderUnAliment());
					affichageUtilise.notifierActionReussie();
				}
				catch (AlimentDejaPresentException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
					affichageUtilise.notifierEchec();
				}
				break;
			case 2:
				affichageUtilise.demanderUneChaineDeCaractere();
				try
				{
					this.leFrigo.supprimerAliment(interactionUtilise.demanderUneChaineDeCaractere());
					affichageUtilise.notifierActionReussie();
				}
				catch (AlimentsInexistantException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					affichageUtilise.notifierEchec();
				}
				break;
			case 3:
				// TODO Completer
				affichageUtilise.messageDErreur();
				break;
			case 4:
				// TODO Completer
				affichageUtilise.messageDErreur();
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
				try
				{
					interactionUtilise.demanderUneRecette();
					affichageUtilise.notifierActionReussie();
				}
				catch (RecetteDejaEnMemoireException e2)
				{
					e2.printStackTrace();
					affichageUtilise.notifierEchec();
				}
				break;
			case 9:
				affichageUtilise.demanderUneQuantiteDAlimentAEnlever();
				try
				{
					this.leFrigo.changerUneQuantiteDAliment(interactionUtilise.demanderUneChaineDeCaractere(),
							interactionUtilise.demanderUnInt());
					affichageUtilise.notifierActionReussie();
				}
				catch (AlimentsInexistantException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
					affichageUtilise.notifierEchec();
				}
				break;
			case 10:
				affichageUtilise.afficherPrixDuFrigo(this.leFrigo.prixDuFrigo());
				break;
			case 11:
				affichageUtilise.demanderUnNomDeRecette();
				try
				{
					affichageUtilise.afficherUneRecette(Recette.obtenirLaRecette(interactionUtilise
							.demanderUneChaineDeCaractere()));
				}
				catch (RecetteInconnueException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			case 12:
				affichageUtilise.demanderUnNomDeRecette();
				try
				{
					affichageUtilise.afficherUneRecette(this.leFrigo.obtenirLaRecette(interactionUtilise
							.demanderUneChaineDeCaractere()));
				}
				catch (RecetteInconnueException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
