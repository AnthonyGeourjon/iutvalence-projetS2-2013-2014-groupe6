package module_budget;

import exception.ChoixIncorrectException;
import general.Module;
import interaction.Interaction;
import affichage.Affichage;

import java.util.Date;
import java.util.Hashtable;


public class ModuleBudget implements Module {
	
	private Budget soldeDuBudget ;
	
	
	public ModuleBudget()
	{
		this.soldeDuBudget = new Budget(0, Etat.vide)  ;
	}

		
		@Override
		public void utiliserModule(Affichage affichageUtilise, Interaction interactionUtilise)
		{
			//TODO personalier le message d'erreur en fonction de l'erreur
			
			Boolean application = true;

			while (application)
			{
				affichageUtilise.afficherMenuBudget();

				switch (interactionUtilise.demanderUnInt())
				{
				case 0:
					application = false;
					break;
				case 1:
					affichageUtilise.demanderSommeDArgent();
					this.soldeDuBudget.ajouterDeLArgent(interactionUtilise.demanderUnFloat());
					
					break;
				case 2:
					affichageUtilise.afficherLeSoldeDuBudget(this.soldeDuBudget.getSolde());
					break;
				case 3:
					affichageUtilise.afficherDemandeAjoutArgent();
					this.soldeDuBudget.ajouterDeLArgent(interactionUtilise.demanderUnFloat());
					
					break;
				case 4 :
					affichageUtilise.afficherDemandeRetraitArgent();
					this.soldeDuBudget.soustraireDeLArgent(interactionUtilise.demanderUnFloat());
				
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


		private float initialiserLeBudget(float SommeDArgent) {
			return SommeDArgent ;
		}


		
		
	

}
