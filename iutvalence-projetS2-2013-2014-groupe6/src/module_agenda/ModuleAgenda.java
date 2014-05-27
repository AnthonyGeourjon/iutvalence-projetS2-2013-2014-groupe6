package module_agenda;

import exception.ChoixIncorrectException;
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
			affichageUtilise.afficherMenuAlimentation();

			switch (interactionUtilise.choixNumerique())
			{
			case 0:
				application = false;
				break;
			case 1:
				affichageUtilise.demanderUnEvenement();
				this.lAgenda.insererEvenementDansLAgenda(interactionUtilise.demanderUnEvenement());
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
