package general;

import interaction.Interaction;
import affichage.Affichage;


/**
 * @author Anthony
 *
 */
public interface Module
{
	/**
	 * @param affichageUtilise affichage utilis� pour le module
	 * @param interactionUtilise interaction utilis� pour le module
	 */
	public abstract void utiliserModule(Affichage affichageUtilise, Interaction interactionUtilise);
	
	
	//TODO Sauvegarde de l'application
	
	//public abstract void sauvegarderUnModule();
	
	//public abstract void chargerUnModule(Utilisateur utilisateurDuModuleSauvegarde );
	
	
		
}
