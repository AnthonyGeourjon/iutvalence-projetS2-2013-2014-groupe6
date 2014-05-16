
/**
 * @author geourjoa
 *
 */
public interface Affichage
{
	/**
	 * Afficher le menu
	 */
	public abstract void afficherLeMenu();
	
	/**
	 * demander un choix numérique
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
}
