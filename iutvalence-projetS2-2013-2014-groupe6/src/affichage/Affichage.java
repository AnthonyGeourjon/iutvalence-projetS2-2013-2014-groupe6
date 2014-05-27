package affichage;

import java.util.Hashtable;

import module_alimentation.Frigo;
import module_alimentation.Recette;

/**
 * @author geourjoa
 *
 */
public interface Affichage
{
	
	/**
	 * Afficher le menu
	 */
	public abstract void afficherMenuAlimentation();
	
	/**
	 * Demander un choix numérique
	 */
	public abstract void demanderUnChoix();
	
	/**
	 * Afficher le nom de l'application
	 */
	public abstract void afficherLeNomDeLApplication();
	
	/**
	 * Demander un aliment
	 */
	public abstract void demanderUnAliment();

	/**
	 * Demander une recette
	 */
	public abstract void demanderUneRecette();

	/**
	 * Demander un nom
	 */
	public abstract void demanderUnNom();

	/**
	 * Dire � l'utilisateur qu'une fonction n'est pas disponible
	 */
	public abstract void messageDErreur();
	
	/**
	 * Afficher le menu principal
	 */
	public abstract void afficherMenuPrincipal();

	/**
	 * @param leFrigo Le frigo qui sera affich�
	 */
	public abstract void afficherUnFrigo(Frigo leFrigo);
	
	/**
	 * Montrer � l'utilisateur que l'action s'est bien d�roul�e
	 */
	public abstract void notifierActionReussie();

	/**
	 * @param recette affiche les recettes fournies en param�tres
	 */
	public abstract void afficherDesRecettes(Hashtable<String, Recette> recette);

	/**
	 * Demander � l'utilisateur un evenement
	 */
	public abstract void demanderUnEvenement();
	
	

	
}
