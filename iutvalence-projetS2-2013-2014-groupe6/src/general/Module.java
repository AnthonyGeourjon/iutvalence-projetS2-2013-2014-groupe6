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
	 * @param affichageUtilise affichage utilisé pour le module
	 * @param interactionUtilise interaction utilisé pour le module
	 */
	public abstract void utiliserModule(Affichage affichageUtilise, Interaction interactionUtilise);
		
}
