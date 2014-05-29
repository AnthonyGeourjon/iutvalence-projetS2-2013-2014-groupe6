package module_agenda;

import exception.ChoixIncorrectException;
import exception.EvenementNonTrouveException;
import exception.HeureIncorrecteException;
import general.Module;
import interaction.Interaction;
import affichage.Affichage;

public class ModuleAgenda implements Module
{

	private Agenda lAgenda;

	public ModuleAgenda()
	{
		this.lAgenda = new Agenda();
	}

	@Override
	public void utiliserModule(Affichage affichageUtilise, Interaction interactionUtilise)
	{
		Boolean application = true;

		while (application)
		{
			affichageUtilise.afficherMenuAgenda();

			switch (interactionUtilise.demanderUnInt())
			{
			case 0:
				application = false;
				break;
			case 1:
				affichageUtilise.demanderUnEvenement();
				try
				{
					this.lAgenda.insererEvenement(interactionUtilise.demanderUnEvenement());
				}
				catch (HeureIncorrecteException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2 :
				affichageUtilise.demanderUneChaineDeCaractere();
				affichageUtilise.demanderUnEvenement();
				try
				{
					this.lAgenda.supprimerUnEvenement(interactionUtilise.demanderUneChaineDeCaractere());
				}
				catch (EvenementNonTrouveException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				affichageUtilise.demanderUneChaineDeCaractere();
				affichageUtilise.demanderUneDate();
				this.lAgenda.modifierDateDUnEvenement(interactionUtilise.demanderUneChaineDeCaractere(), interactionUtilise.demanderUneDate());
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
