package interaction;
import java.util.Date;

import exception.HeureIncorrecteException;
import exception.MatiereSaisieIncorrecteException;
import exception.NoteSaisieIncorrecteException;
import module_agenda.Evenement;
import module_agenda.Heure;
import module_alimentation.Aliment;
import module_alimentation.Recette;
import module_scolaire.Matiere;
import module_scolaire.Note;
import module_scolaire.UE;


/**
 * @author Anthony
 * Dans cette classe, je compte mettre tout nos moyens d'interaction par la console avec l'utilisateur
 */
public interface Interaction
{
	//TODO VÃ©riier que toutes les infos renvoyÃ© soient cohÃ©rente
	
	/**
	 * @return Demande un nombre Ã  l'utilisateur (De 0 Ã  X) 
	 */
	public abstract int demanderUnInt();
	
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
	public abstract String demanderUneChaineDeCaractere();

	/**
	 * @return un evenement saisie par l'utilisateur
	 * @throws HeureIncorrecteException 
	 */
	public abstract Evenement demanderUnEvenement() throws HeureIncorrecteException;
	
	/**
	 * @return une date saisie par l'utilisateur
	 */
	public abstract Date demanderUneDate();
	
	/**
	 * @return une date saisie par l'utilisateur
	 * @throws HeureIncorrecteException levé si l'heure est incorrecte
	 */
	public abstract Heure demanderUneHeure() throws HeureIncorrecteException;

	/**
	 * @return une heure saisie par l'utilisateur
	 */
	public abstract UE demanderUneUE();
	
	/**
	 * @return un flottant saisie par l'utilisateur
	 */
	public float demanderUnFloat();

	/**
	 * @return une matiere saisie par l'utilisateur
	 * @throws MatiereSaisieIncorrecteException levé si les données saisies sont incorrectes
	 */
	public abstract Matiere demanderUneMatiere() throws MatiereSaisieIncorrecteException;

	/**
	 * @return une note saisie par l'utilisateur
	 * @throws NoteSaisieIncorrecteException levée si les données saisies sont incorrectes
	 */
	public abstract Note demanderUneNote() throws NoteSaisieIncorrecteException;

	
	
	
	
	
}
