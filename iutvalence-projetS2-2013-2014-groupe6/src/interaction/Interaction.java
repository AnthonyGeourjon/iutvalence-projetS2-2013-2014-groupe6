package interaction;
import java.util.Date;

import module_agenda.Evenement;
import module_agenda.Heure;
import module_alimentation.Aliment;
import module_alimentation.Recette;


/**
 * @author Anthony
 * Dans cette classe, je compte mettre tout nos moyens d'interaction par la console avec l'utilisateur
 */
public interface Interaction
{
	//TODO Vériier que toutes les infos renvoyé soient cohérente
	
	/**
	 * @return Demande un nombre à l'utilisateur (De 0 à X) 
	 */
	public abstract int choixNumerique();
	
	/**
	 * @return Un aliment saisie par l'utilisateur
	 */
	public abstract Aliment saisirUnAliment();

	/**
	 * @return Une recette saisie par l'utilisateur
	 */
	public abstract Recette saisirUneRecette();

	/**
	 * @return Un nom demande par la saisie
	 */
	public abstract String demanderUnNom();

	/**
	 * @return un evenement saisie par l'utilisateur
	 */
	public abstract Evenement demanderUnEvenement();
	
	public abstract Date demanderUneDate();
	
	public abstract Heure demanderUneHeure();
	
	
	
	
}
