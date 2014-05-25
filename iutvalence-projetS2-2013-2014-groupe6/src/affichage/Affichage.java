package affichage;

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
	 * Demander un choix num√©rique
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
	 * Dire ‡ l'utilisateur qu'une fonction n'est pas disponible
	 */
	public abstract void messageDErreur();
	
	/**
	 * Afficher le menu principal
	 */
	public abstract void afficherMenuPrincipal();
}
