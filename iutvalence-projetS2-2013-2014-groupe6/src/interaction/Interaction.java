package interaction;
import java.util.Date;

import exception.HeureIncorrecteException;
import exception.MatiereSaisieIncorrecteException;
import exception.NoteSaisieIncorrecteException;
import exception.RecetteDejaEnMemoireException;
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
	 * @return Demande un nombre Ã  l'utilisateur 
	 */
	public abstract int demanderUnInt();
	
	/**
	 * @return un flottant saisie par l'utilisateur
	 */
	public float demanderUnFloat();
	
	/**
	 * @return Un nom demande par la saisie
	 */
	public abstract String demanderUneChaineDeCaractere();
	
	/**
	 * @return Un aliment saisie par l'utilisateur
	 */
	public abstract Aliment demanderUnAliment();

	/**
	 * @return Une recette saisie par l'utilisateur
	 * @throws RecetteDejaEnMemoireException levé si la recette à déja été saisie
	 */
	public abstract Recette demanderUneRecette() throws RecetteDejaEnMemoireException;

	/**
	 * @return un evenement saisie par l'utilisateur
	 * @throws HeureIncorrecteException Levé si l'heure est impossible
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
	 * @return une matiere saisie par l'utilisateur
	 * @throws MatiereSaisieIncorrecteException levé si les données saisies sont incorrectes
	 */
	public abstract Matiere demanderUneMatiere() throws MatiereSaisieIncorrecteException;

	/**
	 * @return une note saisie par l'utilisateur
	 * @throws NoteSaisieIncorrecteException levée si les données saisies sont incorrectes
	 */
	public abstract Note demanderUneNote() throws NoteSaisieIncorrecteException;

	/**
	 * @return un aliment mais sans demander un prix, il est mis à 0.
	 */
	public abstract Aliment demanderUnAlimentPourUneRecette();

	
	
	
	
	
}
