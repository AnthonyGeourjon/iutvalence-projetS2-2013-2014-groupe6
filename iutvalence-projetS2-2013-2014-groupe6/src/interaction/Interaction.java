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
 *  M�thode d'interaction par la console avec l'utilisateur
 */
public interface Interaction
{
	/**
	 * @return Demande un nombre � l'utilisateur
	 */
	public abstract int demanderUnInt();

	/**
	 * @return un flotant saisie par l'utilisateur
	 */
	public float demanderUnFloat();

	/**
	 * @return une chaine de caractere
	 */
	public abstract String demanderUneChaineDeCaractere();

	/**
	 * @return Un aliment saisit par l'utilisateur
	 */
	public abstract Aliment demanderUnAliment();

	/**
	 * @return Une recette saisit par l'utilisateur
	 * @throws RecetteDejaEnMemoireException
	 *             lev�e si la recette � d�ja �t� saisie
	 */
	public abstract Recette demanderUneRecette() throws RecetteDejaEnMemoireException;

	/**
	 * @return un evenement saisie par l'utilisateur
	 * @throws HeureIncorrecteException
	 *             Lev�e si l'heure est impossible
	 */
	public abstract Evenement demanderUnEvenement() throws HeureIncorrecteException;

	/**
	 * @return une date saisie par l'utilisateur
	 */
	public abstract Date demanderUneDate();

	/**
	 * @return une date saisie par l'utilisateur
	 * @throws HeureIncorrecteException
	 *             lev�e si l'heure est incorrecte
	 */
	public abstract Heure demanderUneHeure() throws HeureIncorrecteException;

	/**
	 * @return une heure saisie par l'utilisateur
	 */
	public abstract UE demanderUneUE();

	/**
	 * @return une matiere saisie par l'utilisateur
	 * @throws MatiereSaisieIncorrecteException
	 *             lev�e si les donn�es saisies sont incorrectes
	 */
	public abstract Matiere demanderUneMatiere() throws MatiereSaisieIncorrecteException;

	/**
	 * @return une note saisie par l'utilisateur
	 * @throws NoteSaisieIncorrecteException
	 *             lev�e si les donn�es saisies sont incorrectes
	 */
	public abstract Note demanderUneNote() throws NoteSaisieIncorrecteException;

	/**
	 * @return un aliment mais sans demander un prix, il est mis � 0.
	 */
	public abstract Aliment demanderUnAlimentPourUneRecette();

}
